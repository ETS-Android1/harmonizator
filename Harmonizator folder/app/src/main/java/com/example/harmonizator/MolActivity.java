package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MolActivity extends AppCompatActivity {
    materialy mat = new materialy();
    spravneMol dialog = new spravneMol();
    gratulaciaMol gratulacia = new gratulaciaMol();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mol);
        mat.ab = getSupportActionBar();
        mat.ab.hide();
        mat.odpovede = new int[]{R.id.dom_mol, R.id.tonic_mol, R.id.subd_mol, R.id.dom_mol, R.id.tonic_mol, R.id.tonic_mol,
                R.id.tonic_mol, R.id.dom_mol};
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
