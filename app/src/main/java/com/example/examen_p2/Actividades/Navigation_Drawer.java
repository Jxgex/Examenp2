package com.example.examen_p2.Actividades;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.examen_p2.Clases.CardView_class;
import com.example.examen_p2.Clases.Usuario;
import com.example.examen_p2.Fragments.Contactanos;
import com.example.examen_p2.Fragments.Datos;
import com.example.examen_p2.Fragments.Juego;
import com.example.examen_p2.Fragments.Pinturas;
import com.example.examen_p2.Fragments.Principal_Menu;
import com.example.examen_p2.R;
import com.google.android.material.navigation.NavigationView;

public class Navigation_Drawer extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener, CardView_class {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar barra;
    NavigationView  navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Principal_Menu principal = new Principal_Menu();
    Contactanos contactanos = new Contactanos();
    Datos datos = new Datos();
    Juego juegos = new Juego();
    Pinturas pinturas = new Pinturas();


    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__drawer);

        Usuario parametro = (Usuario)getIntent().getExtras().getSerializable("Usuario");

        barra = findViewById(R.id.toolbar);
        setSupportActionBar(barra);
        drawerLayout = findViewById(R.id.Drawer);
        navigationView = findViewById(R.id.navigation_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,barra,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        //Estableciendo el elemento Onclick
        navigationView.setNavigationItemSelectedListener(this);

        //Fragment Principal

        bundle.putSerializable("Usuario", parametro);

        principal.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.Contenedor,principal);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.home:
                setFragment(principal);
                return true;
            case R.id.Pinturas:
                setFragment(pinturas);
                return true;
            case R.id.datos:
                Iniciar_Datos();
                return true;
            case R.id.Juego:
                setFragment(juegos);
                return true;
            case R.id.Contactos:
                setFragment(contactanos);
                return true;
        }
        return false;
    }

    @Override
    public void Iniciar_Home() {
        principal.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Contenedor,principal);
        fragmentTransaction.commit();

    }

    @Override
    public void Iniciar_Contactanos() {
        setFragment(contactanos);
    }

    @Override
    public void Iniciar_Datos() {
        datos.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.Contenedor,datos);
        fragmentTransaction.commit();
    }

    @Override
    public void Iniciar_Juego() {
        setFragment(juegos);
    }

    @Override
    public void Iniciar_Pinturas() {
        setFragment(pinturas);
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction Fragmento = getSupportFragmentManager().beginTransaction();
        Fragmento.replace(R.id.Contenedor,fragment);
        Fragmento.commit();
    }

}
