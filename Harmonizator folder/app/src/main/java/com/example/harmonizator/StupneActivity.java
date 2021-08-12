package com.example.helloworld;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StupneActivity extends AppCompatActivity {
    spravneSt dialog = new spravneSt();
    gratulaciaSt gratulacia = new gratulaciaSt();
    materialy mat = new materialy();

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stupne);
        mat.ab = getSupportActionBar();
        mat.ab.hide();
        mat.img = (ImageView) findViewById(R.id.img_st);
        mat.odpovede = new int[]{R.id.st4, R.id.st2, R.id.st4, R.id.st1, R.id.st3, R.id.st7, R.id.st4, R.id.st5};
    }


    public void otazka(View view){
     new dialogOtazka().show(getSupportFragmentManager(), "otazka");
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
