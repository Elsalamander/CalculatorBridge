package it.elsalamander.calculatorbridge

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import androidx.recyclerview.widget.LinearLayoutManager
import it.elsalamander.calculatorbridge.databinding.ActivityMainBinding
import it.elsalamander.calculatorbridge.layout.DrawerAdapter
import it.elsalamander.calculatorbridge.layout.ItemRecyclerView
import it.elsalamander.loaderclass.ManagerLoadExtentions


class MainActivity : AppCompatActivity(), DrawerAdapter.DrawerAdapterCallback {

    companion object{
        const val ADD_TITLE = "Aggiungi Estensione"
        const val ADD_DESCRIPTION = "Clicca per aggiungere una estensione"
    }

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var managerExtentions : ManagerLoadExtentions
    var extFrag : Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)

        //Drawer in che fragment mostrare le 3 lineette
        appBarConfiguration = AppBarConfiguration(setOf(R.id.mainFragment), binding.drawerLayout)

        //menu item click handle
        binding.navView.setupWithNavController(navController)

        //Imposta la action bar con il Nav controller
        setupActionBarWithNavController(navController, appBarConfiguration)

        //carica le attuali estensioni
        managerExtentions = ManagerLoadExtentions(this)

        //Carica la lista della RecyclerView
        this.loadItems()

        navController.addOnDestinationChangedListener { _, _, _ ->
            extFrag?.let {
                onBackPressed()
                extFrag = null
                invalidateMenu()
            }
        }



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) ||
                super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }

    override fun onResume() {
        this.loadItems()
        super.onResume()
    }

    /**
     * Carica la lista nella recyclerView
     */
    private fun loadItems() {
        val list = ArrayList<ItemRecyclerView>()
        managerExtentions.extentions.forEach {
            list.add(ItemRecyclerView(it.value.second, it.value.first))
        }
        list.add(ItemRecyclerView(ADD_TITLE, ADD_DESCRIPTION,
            BitmapFactory.decodeResource(resources, R.mipmap.addestensioneicon), null))
        //aggiorna la lista
        loadDrawerItems(list)
    }

    /**
     * Carica gli item nella RecyclerView
     */
    private fun loadDrawerItems(items: ArrayList<ItemRecyclerView>) {
        binding.rvDrawer.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = DrawerAdapter(items, this@MainActivity)
        }
    }

    /**
     * Evento chiamato quando viene premuto qualcosa nel Drawer
     * Evento lanciato quando viene premuto un elemento nella recyclerView
     * vedi nella classe DrawerAdapter->ViewHolder->onClick()
     */
    override fun onDrawerItemClick(value: String) {
        //chiudi la lista drawer
        binding.drawerLayout.closeDrawer(GravityCompat.START)

        if(value == ADD_TITLE){
            managerExtentions.loadNewExtension()
            this.loadItems()
        }else{
            val direction = NavGraphDirections.navigationMove(value)
            navController.navigate(direction)

            val fm: FragmentManager = supportFragmentManager
            val fragmentTransaction : FragmentTransaction = fm.beginTransaction()
            extFrag = managerExtentions.extentions[value]!!.second.getFragment(this)
            fragmentTransaction.add(R.id.nav_host_fragment,extFrag!!, null)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
    }

    /**
     * Rimuovi l'estensione
     */
    fun removeEstensione(value: String) {
        Log.d("RIMUOVI ESTENSIONE", "--------------------------------------")
        //esci dalla view dell'estensione
        onBackPressed()

        //elimina l'estensione
        managerExtentions.removeExtension(value)

        loadItems()
    }


}