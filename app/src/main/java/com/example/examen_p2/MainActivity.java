package com.example.examen_p2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examen_p2.Actividades.Formulario_Registro;
import com.example.examen_p2.Clases.Alertas;

public class MainActivity extends AppCompatActivity implements Alertas {
    EditText Usuario,Contrasenia;
    Button BtnIniciar;
    String Datos[] = new String[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Usuario = findViewById(R.id.TxtEMail);
        Contrasenia = findViewById(R.id.TxtContrasena);
        BtnIniciar = (Button) findViewById(R.id.BtnLogin);
        BtnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Datos[0] = Usuario.getText().toString();
                Datos[1] = Contrasenia.getText().toString();
                if(Datos[0].isEmpty()||Datos[1].isEmpty()) {
                    AlertaDialog();
                }
                else if((Datos[0].equals("Jorge")) && (Datos[1].equals("123"))){
                    Usuario.setText("");
                    Contrasenia.setText("");
                    Intent Cambio_de_Pantalla = new Intent(MainActivity.this, Formulario_Registro.class);
                    startActivity(Cambio_de_Pantalla);
                }
                else {
                    ErrorDialog();
                }
            }
        });


    }


    @Override
    public void CorrectoDialog() {
        AlertDialog.Builder constructor = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_aceptador_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        constructor.setView(view);
        ((TextView) view.findViewById(R.id.Titulo)).setText(getResources().getString(R.string.Titulo_aceptado));
        ((TextView) view.findViewById(R.id.Mensage_view)).setText("Correcto");
        ((Button)   view.findViewById(R.id.BtnAceptar)).setText(getResources().getString(R.string.aceptar));
        ((ImageView) view.findViewById(R.id.icono)).setImageResource(R.drawable.ic_hecho);
        final AlertDialog alertaDialog = constructor.create();
        view.findViewById(R.id.BtnAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertaDialog.dismiss();
            }
        });
        if(alertaDialog.getWindow()!=null){
            alertaDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertaDialog.show();
    }

    @Override
    public void AlertaDialog() {
        AlertDialog.Builder constructor = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_advertencia_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        constructor.setView(view);
        ((TextView) view.findViewById(R.id.Titulo)).setText(getResources().getString(R.string.Titulo_alerta));
        ((TextView) view.findViewById(R.id.Mensage_view)).setText("Algunos campos no han sido llenados");
        ((Button)   view.findViewById(R.id.BtnAceptar)).setText(getResources().getString(R.string.aceptar));
        ((ImageView) view.findViewById(R.id.icono)).setImageResource(R.drawable.ic_advertencia);
        final AlertDialog alertaDialog = constructor.create();
        view.findViewById(R.id.BtnAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertaDialog.dismiss();
            }
        });
        if(alertaDialog.getWindow()!=null){
            alertaDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertaDialog.show();
    }

    @Override
    public void ErrorDialog() {
        AlertDialog.Builder constructor = new AlertDialog.Builder(MainActivity.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(MainActivity.this).inflate(
                R.layout.layout_error_dialog,
                (ConstraintLayout) findViewById(R.id.layoutDialogContainer)
        );
        constructor.setView(view);
        ((TextView) view.findViewById(R.id.Titulo)).setText(getResources().getString(R.string.Titulo_error));
        ((TextView) view.findViewById(R.id.Mensage_view)).setText("Error al ingresar los datos");
        ((Button)   view.findViewById(R.id.BtnAceptar)).setText(getResources().getString(R.string.aceptar));
        ((ImageView) view.findViewById(R.id.icono)).setImageResource(R.drawable.ic_error_black_24dp);
        final AlertDialog alertaDialog = constructor.create();
        view.findViewById(R.id.BtnAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertaDialog.dismiss();
            }
        });
        if(alertaDialog.getWindow()!=null){
            alertaDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertaDialog.show();
    }
}
