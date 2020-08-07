package com.example.examen_p2.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.examen_p2.Clases.Adaptador;
import com.example.examen_p2.Clases.Cuadros;
import com.example.examen_p2.Clases.Cuadros_Activity;
import com.example.examen_p2.R;

import java.util.ArrayList;

public class Pinturas extends Fragment {
    private ListView ViewLista;
    private ArrayList<Cuadros> item;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView = inflater.inflate(R.layout.fragment_pinturas, container, false);
        item = getArrayItem();
        ViewLista = RootView.findViewById(R.id.ListViewForm);
        final Adaptador adaptador = new Adaptador(item,getContext());
        ViewLista.setAdapter(adaptador);
        ViewLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent cambio = new Intent(getContext(), Cuadros_Activity.class);
                cambio.putExtra("Parametro",item.get(i));
                startActivity(cambio);
            }
        });
        return RootView;
    }
    public ArrayList<Cuadros> getArrayItem(){
        ArrayList<Cuadros> imagenes = new ArrayList<>();
        imagenes.add(new Cuadros(R.drawable.cuadro1,R.drawable.cuadro1,"El hombre en llamas","José Clemente Orozco","Pintada en concreto del Hospicio Cabañas de Guadalajara","1939"));
        imagenes.add(new Cuadros(R.drawable.cuadro2_1,R.drawable.img2,"Sueño y presentimiento","María Izquierdo","Oleo sobre tela","1944"));
        imagenes.add(new Cuadros(R.drawable.cuadro3_1,R.drawable.img3,"Desnudo de alcatraces","Diego Rivera","1944","Realismo mexicano, óleo sobre masonita"));
        imagenes.add(new Cuadros(R.drawable.cuadro4_1,R.drawable.img4,"El hombre controlador del universo","Diego Rivera","1934","Fresco sobre bastidor metálico transportable, para el Rockefeller Center pero repintado para el Palacio de Bellas Artes en la Ciudad de México"));
        imagenes.add(new Cuadros(R.drawable.cuadro5_1,R.drawable.img5,"La ciencia Inútil","Remedios Varos","1955","la pintura se está burlando de las pretensiones de la ciencia mientras señala el error que supone el considerar la alquimia como una ociosa manipulación de aparatos."));
        imagenes.add(new Cuadros(R.drawable.cuadro6_1,R.drawable.img6,"Nacer de nuevo","Remedios Varos","1960","Varias obras de Remedios Varo, entre ellas Nacer de Nuevo, fueron la base del icónico video “Bedtime Story” de Maddona."));
        imagenes.add(new Cuadros(R.drawable.cuadro7_1,R.drawable.img7,"Papila estelar","Remedios Varos","1958","Sus dimensiones son 91 x 60 centímetros, y se encuentra en el Museo Soumaya de la Ciudad de México."));
        imagenes.add(new Cuadros(R.drawable.cuadro8_1,R.drawable.img8,"Simpatía","Remedios Varos","1955","Surrealismo"));
        return  imagenes;
    }

}
