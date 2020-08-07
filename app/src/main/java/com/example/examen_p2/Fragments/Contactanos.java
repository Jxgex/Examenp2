package com.example.examen_p2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.examen_p2.R;
public class Contactanos extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_contactanos, container, false);
        RootView.findViewById(R.id.BtnCelular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Llamada = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:7714215285"));
                startActivity(Llamada);
            }
        });
        RootView.findViewById(R.id.BtnCorreo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Correo = new Intent(Intent.ACTION_SEND);
                Correo.setType("text/plain");
                Correo.putExtra(Intent.EXTRA_SUBJECT,"Informes");
                Correo.putExtra(Intent.EXTRA_TEXT,"Hola, me interesó, me gustaría recibir más información al respecto");
                Correo.putExtra(Intent.EXTRA_EMAIL, new String[]{"JorgeEMML7@gmail.com"});
                startActivity(Correo);
            }
        });
        RootView.findViewById(R.id.BtnUbicacion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Maps = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:19.980167,-98.679350"));
                startActivity(Maps);
            }
        });
        return RootView;
    }
}
