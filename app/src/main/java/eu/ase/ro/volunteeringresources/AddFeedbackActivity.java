package eu.ase.ro.volunteeringresources;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import eu.ase.ro.volunteeringresources.domain.Feedback;
import eu.ase.ro.volunteeringresources.domain.ParticipareViitoareEvenimente;

public class AddFeedbackActivity extends AppCompatActivity {

    private TextInputEditText tietName;
    private Spinner spnEveniment;
    private RadioGroup rgParticipare;
    private TextInputEditText tietSugestii;
    private TextInputEditText tietComentarii;
    private RatingBar rbNota;
    private Button btnTrimite;
    private Intent intent;
    public static final String FEEDBACK_KEY = "feedback_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_feedback);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initComponents();
        intent = getIntent();
    }

    private void initComponents(){
        tietName = findViewById(R.id.stroe_ioana_ruxandra_addFeedback_tiet_name);
        spnEveniment = findViewById(R.id.stroe_ioana_ruxandra_addFeedback_spn_eveniment);
        rgParticipare = findViewById(R.id.stroe_ioana_ruxandra_addFeedback_rg_raspuns);
        tietSugestii = findViewById(R.id.stroe_ioana_ruxandra_addFeedback_tiet_sugestii);
        tietComentarii = findViewById(R.id.stroe_ioana_ruxandra_addFeedback_tiet_comentarii);
        rbNota = findViewById(R.id.stroe_ioana_ruxandra_addFeedback_rb_rating);
        btnTrimite = findViewById(R.id.stroe_ioana_ruxandra_addFeedback_btn_trimite);

        btnTrimite.setOnClickListener(v->{
            if(isValid())
            {
                Feedback feedback = buildFeedbackFromView();
                intent.putExtra(FEEDBACK_KEY, feedback);
                setResult(RESULT_OK,intent);
                finish();
             }
        });
    }

    private Feedback buildFeedbackFromView() {
        String name = tietName.getText().toString();
        String eveniment = spnEveniment.getSelectedItem().toString();
        ParticipareViitoareEvenimente participareViitoareEvenimente = rgParticipare.getCheckedRadioButtonId()==R.id.stroe_ioana_ruxandra_addFeedback_rb_da ? ParticipareViitoareEvenimente.DA : ParticipareViitoareEvenimente.NU;
        String sugestii = tietSugestii.getText().toString();
        String comentarii = tietComentarii.getText().toString();
        float rating  = rbNota.getRating();
        return new Feedback(name, eveniment, sugestii,comentarii,rating,participareViitoareEvenimente);
    }

    private boolean isValid(){
        if(tietName.getText()==null || tietName.getText().toString().trim().length()<3)
        {
            Toast.makeText(getApplicationContext(), R.string.addFeedbackActivity_nume_invalid_minim_3_caractere_necesare, Toast.LENGTH_LONG).show();
            return false;
        }
        if(tietComentarii.getText().toString().length() > 250)
        {
            Toast.makeText(getApplicationContext(), R.string.addFeedbackActivity_comentariile_trebuie_sa_se_incadreze_in_250_de_caractere, Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}