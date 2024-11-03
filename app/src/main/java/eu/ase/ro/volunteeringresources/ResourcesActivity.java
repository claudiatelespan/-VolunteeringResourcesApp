package eu.ase.ro.volunteeringresources;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ResourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_resources);

        Button motiveBtn = findViewById(R.id.banciu_diana_btn_motive);
        motiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.eliberare.com/2016/11/6-motive-sa-devii-voluntar/"));
                startActivity(browserIntent);
            }
        });


        Button pracvticiBtn = findViewById(R.id.banciu_diana_btn_practici);
        pracvticiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://volunteerhub.com/blog/best-practices-volunteer-organizations"));
                startActivity(browserIntent);
            }
        });
    }
}
