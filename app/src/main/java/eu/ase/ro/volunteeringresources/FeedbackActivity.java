package eu.ase.ro.volunteeringresources;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class FeedbackActivity extends AppCompatActivity {

    private DrawerLayout feedbackDrawerLayout;
    private NavigationView feedbackNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        //getLayoutInflater().inflate(R.layout.activity_feedback, findViewById(R.id.app_bar_main), true);
    // Set up the toolbar
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        // Set up the navigation drawer
//        feedbackDrawerLayout = findViewById(R.id.feedback_drawer_layout);
//        feedbackNavigationView = findViewById(R.id.feedback_nav_view);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this,
//                feedbackDrawerLayout,
//                toolbar,
//                R.string.navigation_drawer_open,
//                R.string.navigation_drawer_close);
//        feedbackDrawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        // Set the navigation item selected listener
//        feedbackNavigationView.setNavigationItemSelectedListener(item -> {
//            int id = item.getItemId();
//            if (id == R.id.nav_events) {
//                startActivity(new Intent(this, MainActivity.class));
//            } else if (id == R.id.nav_feedback) {
//                // Current activity, do nothing
//            }
//            //else if (id == R.id.nav_resources) {
//                // Add intent to open a resources activity
//           // }
//            feedbackDrawerLayout.closeDrawer(GravityCompat.START);
//            return true;
//        });
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            feedbackDrawerLayout.openDrawer(GravityCompat.START);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}