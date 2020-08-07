package com.example.examen_p2.Actividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.examen_p2.Clases.Alertas;
import com.example.examen_p2.Clases.Usuario;
import com.example.examen_p2.R;

public class Formulario_Registro extends AppCompatActivity implements Alertas {
    Spinner spedad;
    EditText Nombre, APaterno, AMaterno, NTelefono;
    RadioButton RH,RM,RO;
    Usuario obj = new Usuario();
    Integer[] Opciones = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario__registro);

        spedad = findViewById(R.id.SpEdad);
        spedad.setAdapter(new ArrayAdapter<Integer>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,Opciones));
        Nombre = findViewById(R.id.TxtNombreDatos);
        APaterno = findViewById(R.id.TxtApaternoDatos);
        AMaterno = findViewById(R.id.TxtAMaternoDatos);
        NTelefono = findViewById(R.id.TxtTelefono);
        RH = findViewById(R.id.RBHDatos);
        RM = findViewById(R.id.RBMDatos);
        RO = findViewById(R.id.RBODatos);

        findViewById(R.id.BtnSiguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Nombre.getText().toString()==""||APaterno.getText().toString()==""||
                        AMaterno.getText().toString()==""||NTelefono.getText().toString()==""){
                    AlertaDialog();
                }
                else{
                    if(RH.isChecked()){
                        obj.setNombre(Nombre.getText().toString());
                        obj.setApellido_Paterno(APaterno.getText().toString());
                        obj.setApellido_Materno(AMaterno.getText().toString());
                        obj.setNumero_Telefono(NTelefono.getText().toString());
                        obj.setSexo('H');
                        obj.setEdad(Integer.parseInt(spedad.getSelectedItem().toString()));
                        CorrectoDialog();
                        CambiodePantalla(obj);
                    }else if(RM.isChecked()){
                        obj.setNombre(Nombre.getText().toString());
                        obj.setApellido_Paterno(APaterno.getText().toString());
                        obj.setApellido_Materno(AMaterno.getText().toString());
                        obj.setNumero_Telefono(NTelefono.getText().toString());
                        obj.setSexo('M');
                        obj.setEdad(Integer.parseInt(spedad.getSelectedItem().toString()));
                        CorrectoDialog();
                        CambiodePantalla(obj);

                    }else if(RO.isChecked()){
                        obj.setNombre(Nombre.getText().toString());
                        obj.setApellido_Paterno(APaterno.getText().toString());
                        obj.setApellido_Materno(AMaterno.getText().toString());
                        obj.setNumero_Telefono(NTelefono.getText().toString());
                        obj.setSexo('O');
                        obj.setEdad(Integer.parseInt(spedad.getSelectedItem().toString()));
                        CorrectoDialog();
                        CambiodePantalla(obj);

                    }else{
                            AlertaDialog();

                        }
                }
            }
        });
    }

    @Override
    public void CorrectoDialog() {
        AlertDialog.Builder constructor = new AlertDialog.Builder(Formulario_Registro.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(Formulario_Registro.this).inflate(
                R.layout.layout_aceptador_dialog,(ConstraintLayout) findViewById(R.id.layoutDialogContainer));
        constructor.setView(view);
        ((TextView) view.findViewById(R.id.Titulo)).setText("¡Correcto!");
        ((TextView) view.findViewById(R.id.Mensage_view)).setText("Datos guardados correctamente");
        ((Button)   view.findViewById(R.id.BtnAceptar)).setText("Aceptar");
        ((ImageView) view.findViewById(R.id.icono)).setImageResource(R.drawable.ic_hecho);
        final AlertDialog dialogo = constructor.create();
        view.findViewById(R.id.BtnAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo.dismiss();
            }
        });
        if(dialogo.getWindow()!=null){
            dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialogo.show();
    }

    @Override
    public void AlertaDialog() {
        AlertDialog.Builder constructor = new AlertDialog.Builder(Formulario_Registro.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(Formulario_Registro.this).inflate(
                R.layout.layout_advertencia_dialog,(ConstraintLayout) findViewById(R.id.layoutDialogContainer));
        constructor.setView(view);
        ((TextView) view.findViewById(R.id.Titulo)).setText("¡Advertencia!");
        ((TextView) view.findViewById(R.id.Mensage_view)).setText("Campos sin llenar");
        ((Button)   view.findViewById(R.id.BtnAceptar)).setText("Aceptar");
        ((ImageView) view.findViewById(R.id.icono)).setImageResource(R.drawable.ic_advertencia);
        final AlertDialog dialogo = constructor.create();
        view.findViewById(R.id.BtnAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo.dismiss();
            }
        });
        if(dialogo.getWindow()!=null){
            dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialogo.show();
    }

    @Override
    public void ErrorDialog() {
        AlertDialog.Builder constructor = new AlertDialog.Builder(Formulario_Registro.this,R.style.AlertDialogTheme);
        View view = LayoutInflater.from(Formulario_Registro.this).inflate(
                R.layout.layout_error_dialog,(ConstraintLayout) findViewById(R.id.layoutDialogContainer));
        constructor.setView(view);
        ((TextView) view.findViewById(R.id.Titulo)).setText("¡Eror!");
        ((TextView) view.findViewById(R.id.Mensage_view)).setText("Los datos no fueron guardados correctamente");
        ((Button)   view.findViewById(R.id.BtnAceptar)).setText("Aceptar");
        ((ImageView) view.findViewById(R.id.icono)).setImageResource(R.drawable.ic_error_black_24dp);
        final AlertDialog dialogo = constructor.create();
        view.findViewById(R.id.BtnAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogo.dismiss();
            }
        });
        if(dialogo.getWindow()!=null){
            dialogo.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        dialogo.show();

    }
    public void CambiodePantalla(Usuario usuario){
        Intent CambioPantalla = new Intent(Formulario_Registro.this, Navigation_Drawer.class);
        CambioPantalla.putExtra("Usuario",usuario);
        startActivity(CambioPantalla);
    }

}
