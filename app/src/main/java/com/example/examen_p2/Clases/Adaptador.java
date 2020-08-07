package com.example.examen_p2.Clases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examen_p2.R;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private ArrayList<Cuadros> Arreglo;
    private Context contexto;

    public Adaptador(ArrayList<Cuadros> arreglo, Context contexto) {
        Arreglo = arreglo;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return Arreglo.size();
    }

    @Override
    public Object getItem(int i) {
        return Arreglo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Cuadros item = (Cuadros) getItem(i);
        view = LayoutInflater.from(contexto).inflate(R.layout.item,null);
        ImageView ImgF = view.findViewById(R.id.Imagen_1);
        TextView TxtNombre = view.findViewById(R.id.Titulo_Imagen);
        TextView TxtAutor = view.findViewById(R.id.Autor_Imagen);
        ImgF.setImageResource(item.getImagen_Cuadro());
        TxtNombre.setText(item.getNombre_Cuadro());
        TxtAutor.setText(item.getAutor_Cuadro());
        return view;
    }
}
