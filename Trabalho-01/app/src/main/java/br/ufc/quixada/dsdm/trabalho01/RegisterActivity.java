package br.ufc.quixada.dsdm.trabalho01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    private static final String[] paises = new String[]{
            "Alemanha", "Bolivia", "Brasil", "China", "Síria"
    };

    private AutoCompleteTextView autComplete;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cadastrar = findViewById(R.id.button_Cadastrar);

        autComplete = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_Pais);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, paises);

        autComplete.setThreshold(1);
        autComplete.setAdapter(adapter);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
