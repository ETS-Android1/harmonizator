package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AkordyActivity extends AppCompatActivity {
materialy mat = new materialy();
spravneAkd dialog = new spravneAkd();
    gratulaciaAkd gratulacia = new gratulaciaAkd();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.akordy);
        mat.ab = getSupportActionBar();
        mat.ab.hide();
        mat.odpovede = new int[]{R.id.mol_kvint, R.id.dur_kvart, R.id.mol_sext, R.id.mol_kvint, R.id.dur_sext, R.id.dur_kvart,
                R.id.dur_kvint, R.id.dur_sext};
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
