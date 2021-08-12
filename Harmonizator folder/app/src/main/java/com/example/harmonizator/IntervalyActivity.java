package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IntervalyActivity extends AppCompatActivity {
    spravneInt dialog = new spravneInt();
    materialy mat = new materialy();
    gratulaciaInt gratulacia = new gratulaciaInt();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intervaly);
        mat.ab = getSupportActionBar();
        mat.ab.hide();
        mat.odpovede = new int[]{R.id.c4, R.id.m6, R.id.v3, R.id.m7, R.id.v7, R.id.m3, R.id.c5, R.id.m2};
    }

    public void otazka(View view){
        new dialogOtazka().show(getSupportFragmentManager(), "otazka");
    }

    public void opdialogint(View view){
        dialogInt dialog = new dialogInt();
        dialog.show(getSupportFragmentManager(), "dialogint");
    }

    public void vyhodnot(View view){
        if (view.getId() == mat.odpovede[dialog.poradie]) {
            dialog.show(getSupportFragmentManager(), "spravne");
            if (dialog.poradie == 7){
                gratulacia.show(getSupportFragmentManager(), "congrats");
                dialog.dismiss();
            }
        } else {
            mat.toast = Toast.makeText(getApplicationContext(), R.string.incor, Toast.LENGTH_SHORT);
            mat.toast.show();
        }
    }

    @Override
    public void onBackPressed() {
        new dialogOtazka().show(getSupportFragmentManager(), "otazka");
    }
}
