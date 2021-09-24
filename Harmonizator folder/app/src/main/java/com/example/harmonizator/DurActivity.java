package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.harmonizator.materialy;

public class DurActivity extends AppCompatActivity {
    public int poradie;
   materialy mat = new materialy();
   spravneDur dialog = new spravneDur();
    gratulaciaDur gratulacia = new gratulaciaDur();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dur);
        mat.ab = getSupportActionBar();
        mat.ab.hide();
        mat.odpovede = new int[]{R.id.dom_dur, R.id.dom_dur, R.id.subd_dur, R.id.tonic_dur, R.id.tonic_dur, R.id.tonic_dur,
                R.id.subd_dur, R.id.subd_dur};
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
