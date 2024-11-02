package eu.ase.ro.volunteeringresources;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;


import eu.ase.ro.volunteeringresources.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ListView listview;
    private List<EvenimentVoluntariat> evenimente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.tascu_daniel_lv_main_evenimente);

        initializareEvenimente();

        ArrayAdapter<EvenimentVoluntariat> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,evenimente);

        listview.setAdapter(adapter);

        configNavigation();
        navigationView = findViewById(R.id.tascu_daniel_nav_view);
        navigationView.setNavigationItemSelectedListener(getItemSelectedEvent());
    }

    private void initializareEvenimente() {
        evenimente = new ArrayList<>();

        evenimente.add(new EvenimentVoluntariat(
                "Romexpo",
                "Workshop Dezvoltare Personala interactiv",
                DateConverter.toDate("12-01-2024"),
                "VoluntaRO",
                "TopUp",
                1
        ));

        evenimente.add(new EvenimentVoluntariat(
                "Palatul Parlamentului",
                "Conferinta despre antreprenoriat social",
                DateConverter.toDate("15-01-2024"),
                "Asociatia Tinerilor Antreprenori",
                "Start Smart",
                2
        ));

        evenimente.add(new EvenimentVoluntariat(
                "Ateneu",
                "Concert caritabil pentru sustinerea educatiei",
                DateConverter.toDate("20-01-2024"),
                "Fundatia pentru Educatie",
                "EduConcert",
                3
        ));

        evenimente.add(new EvenimentVoluntariat(
                "Universitatea Politehnica",
                "Hackathon de solutii sustenabile",
                DateConverter.toDate("28-01-2024"),
                "GreenTech Romania",
                "Eco Hack",
                4
        ));

        evenimente.add(new EvenimentVoluntariat(
                "Parcul Herastrau",
                "Campanie de plantare copaci si educatie ecologica",
                DateConverter.toDate("05-02-2024"),
                "Asociatia Verde",
                "Plantare pentru Viitor",
                5
        ));



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
        Toolbar toolbar = findViewById(R.id.tascu_daniel_main_toolbar);
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