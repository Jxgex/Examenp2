package com.example.examen_p2.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.examen_p2.Clases.CardView_class;
import com.example.examen_p2.Clases.Usuario;
import com.example.examen_p2.R;

public class Principal_Menu extends Fragment {
    TextView Nombre,Apellido;
    String [] Datos = new String[3];
    CardView_class cambio;
    Activity actividad_cambio;
    public Principal_Menu(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_principal__menu, container, false);
        Nombre = (TextView) RootView.findViewById(R.id.Texto_Nombre);
        Apellido = (TextView) RootView.findViewById(R.id.Texto_Apellido);
        Usuario parametro = (Usuario) this.getArguments().getSerializable("Usuario");

        Datos[0] = parametro.getNombre();
        Datos[1] = parametro.getApellido_Paterno();
        Datos[2] = parametro.getApellido_Materno();

        Nombre.setText(Datos[0]);
        Apellido.setText(Datos[1]+" "+Datos[2]);
        //Home
        RootView.findViewById(R.id.gotoHome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambio.Iniciar_Home();
            }
        });
        //Contactanos
        RootView.findViewById(R.id.gotoContactanos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambio.Iniciar_Contactanos();
            }
        });
        //Juego
        RootView.findViewById(R.id.gotoJuego).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambio.Iniciar_Juego();
            }
        });
        //Pintura
        RootView.findViewById(R.id.gotoPinturas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambio.Iniciar_Pinturas();
            }
        });
        //Datos CardView
        RootView.findViewById(R.id.gotoDatos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambio.Iniciar_Datos();
            }
        });
        return RootView;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            actividad_cambio = (Activity) context;
            cambio = (CardView_class) actividad_cambio;
        }
    }
}
