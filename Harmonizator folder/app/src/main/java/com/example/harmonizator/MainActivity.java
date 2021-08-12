package com.example.helloworld;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.helloworld.R.id;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public View view;
    private AppBarConfiguration appBarConfig;
    public NavigationView navigationView;
    public Context context;
    public Bundle savedInstanceState;
    public NavController navController;
    materialy mat = new materialy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = (NavigationView) findViewById(R.id.navView);
        appBarConfig = new AppBarConfiguration.Builder(R.id.nav_home).setDrawerLayout(drawer).build();
       navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);
        mat.intent = new Intent(this, StupneActivity.class);
    }

    @SuppressLint("NonConstantResourceId")
    public void spusti(MenuItem item){
        switch (item.getItemId()) {
            case id.nav_stupne:
                mat.intent.setClass(getApplicationContext(), StupneActivity.class);
                startActivity(mat.intent);
                finish();
        }
        switch (item.getItemId()) {
            case id.nav_intervaly:
                mat.intent.setClass(getApplicationContext(), IntervalyActivity.class);
                startActivity(mat.intent);
                finish();
        }
        switch (item.getItemId()) {
            case id.nav_akordy:
                mat.intent.setClass(getApplicationContext(), AkordyActivity.class);
                startActivity(mat.intent);
                finish();
        }
        switch (item.getItemId()) {
            case id.nav_dur:
                mat.intent.setClass(getApplicationContext(), DurActivity.class);
                startActivity(mat.intent);
                finish();
        }
        switch (item.getItemId()) {
            case id.nav_mol:
                mat.intent.setClass(getApplicationContext(), MolActivity.class);
                startActivity(mat.intent);
                finish();
        }

    }

    public void viac(MenuItem item){
        dialogViac dialog = new dialogViac();
        dialog.show(getSupportFragmentManager(), "viac");
    }

    public void info(MenuItem item) {
        String url = "https://drive.google.com/drive/u/0/folders/1k0clllUnhkNaX0Ftw_StM1wdlSf5msmn";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragmentContainerView);
        return NavigationUI.navigateUp(navController, appBarConfig)
                || super.onSupportNavigateUp();
    }

}