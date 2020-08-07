package com.example.examen_p2.Clases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examen_p2.R;

public class Cuadros_Activity extends AppCompatActivity {
    ImageView Imagen;
    TextView Obra, Autor, Descripcion, Fecha;
    Cuadros parametro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadros_);
        parametro = (Cuadros)getIntent().getSerializableExtra("Parametro");
        Imagen = findViewById(R.id.Imagen_Cuadros);
        Obra = findViewById(R.id.LblObra);
        Autor = findViewById(R.id.LblAutor_Cuadro);
        Descripcion = findViewById(R.id.LblDescripcion);
        Fecha = findViewById(R.id.LblFecha);

        Imagen.setImageResource(parametro.getImagen_Cuadro_Grande());
        Obra.setText(parametro.getNombre_Cuadro());
        Autor.setText(parametro.getAutor_Cuadro());
        Descripcion.setText(parametro.getDescripcion_Cuadro());
        Fecha.setText(parametro.getFecha());


    }
}

