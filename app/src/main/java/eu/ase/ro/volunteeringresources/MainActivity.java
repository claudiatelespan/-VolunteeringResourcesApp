package eu.ase.ro.volunteeringresources;


import android.content.Intent;

import android.content.Context;

import android.content.SharedPreferences;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
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
    SwitchCompat switchMode;
    boolean nightMode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    private NavigationView navigationView;
    private ListView listview;
    private List<EvenimentVoluntariat> evenimente;

    private FloatingActionButton fabSignUp;
    private ActivityResultLauncher<Intent> launcher;
    private List<Persoana> listaPersoane = new ArrayList<>();



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

        fabSignUp = findViewById(R.id.tascu_daniel_main_sign_up_fab);
        fabSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
            launcher.launch(intent);
        });
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),getSignUpCallBack());


        switchMode=findViewById(R.id.banciu_diana_switchDarkTheme);
        sharedPreferences= getSharedPreferences( "MODE", Context.MODE_PRIVATE);
        nightMode=sharedPreferences.getBoolean("nightMode",false);
        if (nightMode)
        {
            switchMode.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        switchMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nightMode){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor=sharedPreferences.edit();
                    editor.putBoolean("nightMode",false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor=sharedPreferences.edit();
                    editor.putBoolean("nightMode",true);
                }
                editor.apply();
            }
        });
    }//end onCreate

    private ActivityResultCallback<ActivityResult> getSignUpCallBack() {
        return result -> {
            if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                Persoana persoana = (Persoana) result.getData().getSerializableExtra(SignUpActivity.SIGN_UP_KEY);
                if (persoana != null) {
                    listaPersoane.add(persoana);
                    Log.i("mainactivity", "lista:" + listaPersoane);
                    Toast.makeText(getApplicationContext(), "Te-ai Inscris cu Succes", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("mainactivity", "Persoana returnata este null");
                }
            } else {
                Log.e("mainactivity", "Rezultatul sau datele sunt null");
            }
        };
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
                Intent intent = new Intent(this, FeedbackActivity.class);
                startActivity(intent);
            }
//            else  if(item.getItemId() == R.id.nav_resources){
//                Toast.makeText(getApplicationContext(), R.string.resources_clicked,Toast.LENGTH_SHORT).show();
//                //de facut implementare pt deschis activitatea respectiva
//            }
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