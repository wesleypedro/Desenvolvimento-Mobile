package br.ufc.quixada.dsdm.trabalho01;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentConfiguracoes extends Fragment {

    private Button buttonClique;
    private Button buttonSom;

    private MediaPlayer mediaPlayer;

    public FragmentConfiguracoes() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuracoes, container, false);

        buttonClique = view.findViewById(R.id.button_CliqueLongo);
        buttonSom = view.findViewById(R.id.button_TocarSom);

        mediaPlayer = MediaPlayer
                .create(getContext(), R.raw.sound);

        buttonClique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(), "Clique curto", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        buttonClique.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast toast = Toast.makeText(getContext(), "Clique longo!", Toast.LENGTH_LONG);
                toast.show();

                return false;
            }
        });


        buttonSom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        return view;
    }
}
