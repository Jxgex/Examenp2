package com.example.examen_p2.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.examen_p2.Clases.Usuario;
import com.example.examen_p2.R;

public class Datos extends Fragment {
    TextView Nombre,APaterno,AMaterno,Telefono,Edad;
    RadioButton RH,RM,RO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_datos, container, false);
        Usuario parametro = (Usuario) this.getArguments().getSerializable("Usuario");


        Nombre = RootView.findViewById(R.id.TxtNombreDatos);
        APaterno = RootView.findViewById(R.id.TxtApaternoDatos);
        AMaterno = RootView.findViewById(R.id.TxtAMaternoDatos);
        Telefono = RootView.findViewById(R.id.TxtTelefonoDatos);
        RH = RootView.findViewById(R.id.RBHDatos);
        RM = RootView.findViewById(R.id.RBMDatos);
        RO = RootView.findViewById(R.id.RBODatos);
        Edad = RootView.findViewById(R.id.TxtEdadDatos);
        Nombre.setText(parametro.getNombre());
        APaterno.setText(parametro.getApellido_Paterno());
        AMaterno.setText(parametro.getApellido_Materno());
        Telefono.setText(parametro.getNumero_Telefono());
        if(parametro.getSexo()=='H'){
            RH.setSelected(true);
        }else if(parametro.getSexo()=='M'){
            RM.setSelected(true);
        }
        else{
            RO.setSelected(true);
        }
        Edad.setText(Integer.toString(parametro.getEdad()));
        return RootView;
    }

}
