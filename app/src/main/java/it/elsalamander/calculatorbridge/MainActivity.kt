package it.elsalamander.calculatorbridge

import android.content.ComponentName
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.*
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import androidx.navigation.ui.*
import androidx.recyclerview.widget.LinearLayoutManager
import it.elsalamander.calculatorbridge.databinding.ActivityMainBinding
import it.elsalamander.calculatorbridge.layout.DrawerAdapter
import it.elsalamander.calculatorbridge.layout.FragmentProva
import it.elsalamander.calculatorbridge.layout.FragmentProva2
import it.elsalamander.calculatorbridge.layout.MainFragment

class MainActivity : AppCompatActivity(), DrawerAdapter.DrawerAdapterCallback {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

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

        //Carica la lista della RecyclerView
        loadDrawerItems(arrayOf("Item 1", "Item 2", "Item 3"))


        //Modifica il NavigationController
        val navController = findNavController(R.id.nav_host_fragment)
        navController.graph.addAll( navController.createGraph(
            startDestination = nav_routes.home
        ) {
            fragment<FragmentProva>(nav_routes.home) {
                label = "prova2"//resources.getString(R.string.home_title)
            }

            //fragment<FragmentProva>(${nav_routes.plant_detail}/${nav_arguments.plant_id}) {
            fragment<FragmentProva2>(nav_routes.plant_detail)
            label = "prova1" //resources.getString(R.string.plant_detail_title)
            /*
            argument(nav_arguments.plant_id) {
                type = NavType.StringType
                defaultValue = "provadefualtValue1"
            }
            */
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) ||
                super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }

    /**
     * Carica gli item nella RecyclerView
     */
    private fun loadDrawerItems(items: Array<String>) {
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
        Log.d("DIREZIONE", value)
        var direction = NavGraphDirections.refreshMainFragment(value)
        if(value == "Item 2"){
            direction = NavGraphDirections.goToNewFragment()
        }
        if(value == "Item 3"){
            navController.navigate(nav_routes.plant_detail)
        }else{
            navController.navigate(direction)
        }

    }


}

object nav_routes {
    const val home = "home"
    const val plant_detail = "plant_detail"
}