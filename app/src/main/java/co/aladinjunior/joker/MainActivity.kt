package co.aladinjunior.joker


import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import co.aladinjunior.joker.model.Category
import co.aladinjunior.joker.view.CategoryItem
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

        private lateinit var navController: NavController
        private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment_container)


        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home,
                R.id.nav_joke_day,
                R.id.nav_about), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navigationView.setupWithNavController(navController)

        val list = mutableListOf(
            Category("Category 1", 0xFFFF0000),
            Category("Category 2", 0xFF00FF00),
            Category("Category 3", 0xFF0000FF),
            Category("Category 4", 0xFFFFFF00))

        for(x in list){
            Log.i("test", "${x.name}")
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}