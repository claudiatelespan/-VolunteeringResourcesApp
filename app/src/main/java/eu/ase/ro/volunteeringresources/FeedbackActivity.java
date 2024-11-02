package eu.ase.ro.volunteeringresources;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import eu.ase.ro.volunteeringresources.domain.Feedback;

public class FeedbackActivity extends AppCompatActivity {

//    private DrawerLayout feedbackDrawerLayout;
//    private NavigationView feedbackNavigationView;

    private Button btn_add_feedback;
    private ListView lv_feedback;
    private ActivityResultLauncher<Intent> launcher;
    private ArrayAdapter<Feedback> feedback_adapter;

    List<Feedback> feedback_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        btn_add_feedback = findViewById(R.id.telespan_claudia_add_feedback_btn);
        lv_feedback = findViewById(R.id.telespan_claudia_feedback_lv);
        btn_add_feedback.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(),AddFeedbackActivity.class);
            launcher.launch(intent);
        });

        feedback_adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,feedback_list);
        lv_feedback.setAdapter(feedback_adapter);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                getAddFeedbackCallback());

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

    private ActivityResultCallback<ActivityResult> getAddFeedbackCallback() {

        return result -> {
            if(result.getResultCode() == RESULT_OK && result.getData() != null){
                Feedback feedback = (Feedback) result.getData().getSerializableExtra(AddFeedbackActivity.FEEDBACK_KEY);
                feedback_list.add(feedback);
                feedback_adapter.notifyDataSetChanged();

                Log.i("FeedbackActivity","feedback = " + feedback);
            }
        };
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