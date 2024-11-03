package eu.ase.ro.volunteeringresources;

import android.content.Intent;
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
    public static final String SIGN_UP_KEY = "sign_up_key";
    
    private Intent intent;

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
        intent = getIntent();
    }

    private void initComponents()
    {
        tietCNP=findViewById(R.id.tertes_raluca_tiet_add_cnp);
        tietName=findViewById(R.id.tertes_raluca_tiet_add_name);
        tietAge=findViewById(R.id.tertes_raluca_tiet_add_varsta);
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
                Persoana person=buildFromView();
//                if(person == null)
//                {
//                    Toast.makeText(this, "NULL PERSON", Toast.LENGTH_SHORT).show();
//                }
                intent.putExtra(SIGN_UP_KEY,person);
                setResult(RESULT_OK, intent);
                finish();
            }

        };

    }

    private Persoana buildFromView() {
        try {
            int CNP = Integer.parseInt(tietCNP.getText().toString().trim());
            String Name = tietName.getText().toString().trim();
            int Age = Integer.parseInt(tietAge.getText().toString().trim());
            String College = (String) spnCollege.getSelectedItem();

            return new Persoana(CNP, Name, Age, College);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Datele introduse sunt invalide. Verificați formatul CNP-ului și vârstei.", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    private boolean isValid()
    {
        if (tietCNP.getText() == null ||
                tietCNP.getText().toString().trim().isEmpty() ||
                tietCNP.getText().toString().trim().length() != 13 ||
                !(tietCNP.getText().toString().trim().startsWith("5") || tietCNP.getText().toString().trim().startsWith("6"))) {
            Toast.makeText(getApplicationContext(), "CNP INVALID TREBUIE SA INCEAPA CU 5 SAU 6.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (tietAge.getText() == null || tietAge.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Vârsta nu poate fi goală", Toast.LENGTH_SHORT).show();
            return false;
        }


            int age = Integer.parseInt(tietAge.getText().toString().trim());
            if (age < 0) {
                Toast.makeText(getApplicationContext(), "Invalid age input", Toast.LENGTH_SHORT).show();
                return false;
            }


//        try {
//            int age = Integer.parseInt(tietAge.getText().toString().trim());
//            if (age < 0) {
//                Toast.makeText(getApplicationContext(), "Invalid age input", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        } catch (NumberFormatException e) {
//            Toast.makeText(getApplicationContext(), "Vârsta trebuie să fie un număr valid", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        return true;
    }



}