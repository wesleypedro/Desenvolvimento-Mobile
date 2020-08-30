package br.ufc.quixada.dsdm.trabalho01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLista extends Fragment {

    private EditText editTextAdd;
    private Button btnAdd;
    private ListView listView;

    private List<String> strs;
    private ArrayAdapter<String> adapter;

    public FragmentLista() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista, container, false);

        editTextAdd = view.findViewById(R.id.editText_Add);
        btnAdd = view.findViewById(R.id.button_Add);
        listView = view.findViewById(R.id.listView);

        strs = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strs);

        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String word = editTextAdd.getText().toString();
                strs.add(word);
                listView.setAdapter(adapter);
            }
        });

        return view;
    }
}
