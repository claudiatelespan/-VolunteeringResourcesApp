package eu.ase.ro.volunteeringresources;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import eu.ase.ro.volunteeringresources.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configNavigation();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(getItemSelectedEvent());
    }

    private NavigationView.OnNavigationItemSelectedListener getItemSelectedEvent() {
        return item -> {
            if(item.getItemId() == R.id.nav_events){
                Toast.makeText(getApplicationContext(), R.string.events_clicked,Toast.LENGTH_SHORT).show();
                //de facut implementare pt deschis activitatea respectiva
            }
            else  if(item.getItemId() == R.id.nav_feedback){
                Toast.makeText(getApplicationContext(), R.string.feedback_clicked,Toast.LENGTH_SHORT).show();
                //de facut implementare pt deschis activitatea respectiva
            }
            else  if(item.getItemId() == R.id.nav_resources){
                Toast.makeText(getApplicationContext(), R.string.resources_clicked,Toast.LENGTH_SHORT).show();
                //de facut implementare pt deschis activitatea respectiva
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        };
    }

    private void configNavigation() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        toggle.syncState();
    }
}