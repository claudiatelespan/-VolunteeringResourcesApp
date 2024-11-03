package eu.ase.ro.volunteeringresources;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity {

    private TextInputEditText tietCNP;
    private TextInputEditText tietName;
    private TextInputEditText tietAge;
    private Spinner spnCollege;
    private Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponents();
    }

    private void initComponents()
    {
        tietCNP=findViewById(R.id.tertes_raluca_add_cnp);
        tietName=findViewById(R.id.tertes_raluca_add_name);
        tietAge=findViewById(R.id.tertes_raluca_add_varsta);
        spnCollege=findViewById(R.id.tertes_raluca_add_college);
        btnSignup=findViewById(R.id.tertes_raluca_btn_signup);
        btnSignup.setOnClickListener(getSaveSignup());
    }

    private View.OnClickListener getSaveSignup()
    {
        return v ->
        {
            if(isValid())
            {
                Persoana person=builFromView();
            }

        };

    }

    private Persoana builFromView() {
        Integer CNP=Integer.getInteger(tietCNP.getText().toString());
        String Name=tietName.getText().toString();
        Integer Age=Integer.getInteger(tietAge.getText().toString());
        String College=(String) spnCollege.getSelectedItem();

        return new Persoana(CNP, Name, Age, College);
    }

    private boolean isValid() {

        if (tietCNP.getText() == null ||
                tietCNP.getText().toString().trim().isEmpty() ||
                tietCNP.getText().toString().trim().length() != 13 ||
                !(tietCNP.getText().toString().trim().startsWith("5") || tietCNP.getText().toString().trim().startsWith("6")))
        {

            Toast.makeText(getApplicationContext(), "Invalid CNP. It must start with 5 or 6 and be exactly 13 digits long.",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        if (tietAge.getText() == null ||
                    tietAge.getText().toString().trim().isEmpty()
                    || Integer.getInteger(tietAge.getText().toString()) < 0) {
                Toast.makeText(getApplicationContext(), "Invalid age input", Toast.LENGTH_SHORT).show();
                return false;
            }
        return true;
    }



}