package br.ufc.quixada.dsdm.trabalho02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final int RESULT_CHANGE = 1;
    public static final int RESULT_CANCEL = 3;

    private TextView textViewId;
    private EditText editTextNome;
    private EditText editTextDescricao;
    private Button btnChange;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewId = findViewById(R.id.textView_id);
        editTextNome = findViewById(R.id.editText_nome);
        editTextDescricao = findViewById(R.id.editText_descricao);
        btnChange = findViewById(R.id.button_change);
        btnCancelar = findViewById(R.id.button_cacelar);

        String id = (String) getIntent().getExtras().get("id");
        textViewId.setText(id);

        if (getIntent().getExtras() != null) {
            String item = (String) getIntent().getExtras().get("item");
            String desc = (String) getIntent().getExtras().get("desc");

            editTextNome.setText(item);
            editTextDescricao.setText(desc);
        }


        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editTextNome.getText().toString();
                String desc = editTextDescricao.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("item", item);
                intent.putExtra("desc", desc);

                setResult(RESULT_CHANGE, intent);
                finish();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCEL);
                finish();
            }
        });
    }
}
