package br.ufc.quixada.dsdm.trabalho01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class RegisterActivity extends AppCompatActivity {

    private static final String[] paises = new String[]{
            "Alemanha", "Bolivia", "Brasil", "China", "Síria"
    };

    private AutoCompleteTextView autComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        autComplete = findViewById(R.id.autoCompletePais);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_register, paises);

    }
}
