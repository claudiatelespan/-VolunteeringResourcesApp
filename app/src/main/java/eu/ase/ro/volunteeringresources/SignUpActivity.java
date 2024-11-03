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
    private Spinner spnEveniment;
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
        spnEveniment=findViewById(R.id.tertes_raluca_add_event);
        btnSignup=findViewById(R.id.tertes_raluca_btn_signup);
        btnSignup.setOnClickListener(getSaveSignup());
    }

    private View.OnClickListener getSaveSignup() {
        return v -> {
            if (isValid()) {
                Persoana person = buildFromView();
                if (person != null) {
                    intent.putExtra(SIGN_UP_KEY, person);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Toast.makeText(this, "Nu s-a putut crea obiectul Persoana.", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    private Persoana buildFromView() {
        try {
            String cnpText = tietCNP.getText().toString().trim();
            String nameText = tietName.getText().toString().trim();
            String ageText = tietAge.getText().toString().trim();

            if (cnpText.isEmpty() || nameText.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(this, "Completați toate campurile", Toast.LENGTH_SHORT).show();
                return null;
            }


            if (cnpText.length() != 13 || !(cnpText.startsWith("5") || cnpText.startsWith("6"))) {
                Toast.makeText(this, "CNP-ul trebuie sa fie format din 13 cifre si sa inceapa cu 5 sau 6.", Toast.LENGTH_SHORT).show();
                return null;
            }

            int age = Integer.parseInt(ageText); // Conversia pentru vârstă
            String college = spnCollege.getSelectedItem().toString();
            String Eveniment = spnEveniment.getSelectedItem().toString();

            return new Persoana(cnpText, nameText, age, college, Eveniment);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Datele introduse sunt invalide. Verificați formatul CNP-ului si varstei.", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    private boolean isValid() {
        String cnpText = tietCNP.getText().toString().trim();
        if (cnpText.isEmpty() || cnpText.length() != 13 ||
                !(cnpText.startsWith("5") || cnpText.startsWith("6"))) {
            Toast.makeText(getApplicationContext(), "CNP INVALID TREBUIE SA INCEAPA CU 5 SAU 6.", Toast.LENGTH_SHORT).show();
            return false;
        }


        String ageText = tietAge.getText().toString().trim();
        if (ageText.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Varsta nu poate fi goala", Toast.LENGTH_SHORT).show();
            return false;
        }
        try {
            int age = Integer.parseInt(ageText);
            if (age < 0) {
                Toast.makeText(getApplicationContext(), "Varsta trebuie sa fie pozitiva.", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Varsta trebuie să fie un numar valid", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }



}