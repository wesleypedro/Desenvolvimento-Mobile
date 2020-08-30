package br.ufc.quixada.dsdm.trabalho02;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.dsdm.trabalho02.model.Modelo;

public class MainActivity extends AppCompatActivity {

    private int id = 1;
    private int currentId = -1;

    public final static int REQUEST_ADD = 1;
    public final static int REQUEST_EDT = 2;

    private List<Modelo> modeloList;
    ArrayAdapter<String> adapter;

    private EditText idEdit;
    private Button btnAdd;
    private Button btnEdt;
    private ListView listView;
    private TextView desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        modeloList = new ArrayList<>();
//        adapter = new ArrayAdapter<>(MainActivity.this, R.layout.sim)

        modeloList.add(new Modelo(id ++, "Item 1", "Descrição 1"));
        modeloList.add(new Modelo(id ++, "Item 2", "Descrição 2"));
        modeloList.add(new Modelo(id ++, "Item 3", "Descrição 3"));
        modeloList.add(new Modelo(id ++, "Item 4", "Descrição 4"));

        idEdit = findViewById(R.id.editText_idEdt);
        btnAdd = findViewById(R.id.button_add);
        btnEdt = findViewById(R.id.button_edt);
        listView = findViewById(R.id.listView);
        desc = findViewById(R.id.textView_Details);

        updateView();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("id", String.valueOf(id));
                startActivityForResult(intent, REQUEST_ADD);
            }
        });

        btnEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(idEdit.getText().toString());
                boolean finded = false;

                for (Modelo modelo: modeloList) {
                    if (modelo.getId() == id) {
                        finded = true;

                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                        intent.putExtra("id", String.valueOf(modelo.getId()));
                        intent.putExtra("item", modelo.getItem());
                        intent.putExtra("desc", modelo.getDescricao());

                        currentId = modelo.getId();
                        startActivityForResult(intent, REQUEST_EDT);
                    }
                }

                if (!finded) {
                    Toast.makeText(MainActivity.this, "Id não encontrado!", Toast.LENGTH_SHORT).show();
                }

                idEdit.setText("");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                desc.setText(modeloList.get(i).getDescricao());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == SecondActivity.RESULT_CHANGE) {
            String item = (String) data.getExtras().get("item");
            String desc = (String) data.getExtras().get("desc");
            if (currentId != -1) {
                for (Modelo modelo : modeloList) {
                    if(modelo.getId() == currentId) {
                        modelo.setItem(item);
                        modelo.setDescricao(desc);
                        currentId = -1;
                        updateView();
                        break;

                    }
                }
            } else {
                modeloList.add(new Modelo(id++, item, desc));
                updateView();
            }
        }
    }

    public void updateView(){
        List<String> items = new ArrayList<>();
        for (Modelo modelo : modeloList) {
            items.add(modelo.getItem());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }
}
