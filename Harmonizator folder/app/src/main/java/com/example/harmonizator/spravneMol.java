package com.example.helloworld;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.example.harmonizator.materialy;

public class spravneMol extends DialogFragment {
    public int poradie;
    materialy mat = new materialy();

    public Dialog onCreateDialog(Bundle SavedInstanceState){

        mat.counter = getActivity().findViewById(R.id.counter);
        mat.img = getActivity().findViewById(R.id.img_mol);

        mat.one = getActivity().getDrawable(R.drawable.fm0);
        mat.two = getActivity().getDrawable(R.drawable.fm1);
        mat.three = getActivity().getDrawable(R.drawable.fm2);
        mat.four = getActivity().getDrawable(R.drawable.fm3);
        mat.five = getActivity().getDrawable(R.drawable.fm4);
        mat.six = getActivity().getDrawable(R.drawable.fm5);
        mat.seven = getActivity().getDrawable(R.drawable.fm6);
        mat.eight = getActivity().getDrawable(R.drawable.fm7);

        mat.obrazky = new Drawable[]{mat.one, mat.two, mat.three, mat.four, mat.five, mat.six, mat.seven, mat.eight};

        mat.builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
        mat.builder.setTitle(R.string.excell);
        mat.builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                poradie++;
                mat.counter.setText(mat.order[poradie]);
                mat.img.setImageDrawable(mat.obrazky[poradie]);
            }
        });
        return mat.builder.create();
    }
}
