package com.example.helloworld;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class spravneInt extends DialogFragment {

    public int poradie;
    materialy mat = new materialy();


    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mat.counter = getActivity().findViewById(R.id.counter);
        mat.img = getActivity().findViewById(R.id.img_int);

        mat.one = getActivity().getDrawable(R.drawable.int0);
        mat.two = getActivity().getDrawable(R.drawable.int1);
        mat.three = getActivity().getDrawable(R.drawable.int2);
        mat.four = getActivity().getDrawable(R.drawable.int3);
        mat.five = getActivity().getDrawable(R.drawable.int4);
        mat.six = getActivity().getDrawable(R.drawable.int5);
        mat.seven = getActivity().getDrawable(R.drawable.int6);
        mat.eight = getActivity().getDrawable(R.drawable.int7);

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
