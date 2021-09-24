package com.example.helloworld;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.harmonizator.materialy;

public class spravneSt extends DialogFragment {
    public View view;
    public int poradie;
    public TextView ton;
    public CharSequence st0;
    public CharSequence st1;
    public CharSequence st2;
    public CharSequence st3;
    public CharSequence st4;
    public CharSequence st5;
    public CharSequence st6;
    public CharSequence st7;
    public CharSequence[] stupne;

    materialy mat = new materialy();

    public Dialog onCreateDialog(Bundle SavedInstanceState) {

        mat.counter = getActivity().findViewById(R.id.counter);
        TextView ton = getActivity().findViewById(R.id.ton);
        mat.img = getActivity().findViewById(R.id.img_st);

        st0 = getResources().getString(R.string.st0);
        st1 = getResources().getString(R.string.st1);
        st2 = getResources().getString(R.string.st2);
        st3 = getResources().getString(R.string.st3);
        st4 = getResources().getString(R.string.st4);
        st5 = getResources().getString(R.string.st5);
        st6 = getResources().getString(R.string.st6);
        st7 = getResources().getString(R.string.st7);

        mat.one = getActivity().getDrawable(R.drawable.stupne0);
        mat.two = getActivity().getDrawable(R.drawable.stupne1);
        mat.three = getActivity().getDrawable(R.drawable.stupne2);
        mat.four = getActivity().getDrawable(R.drawable.stupne3);
        mat.five = getActivity().getDrawable(R.drawable.stupne4);
        mat.six = getActivity().getDrawable(R.drawable.stupne5);
        mat.seven = getActivity().getDrawable(R.drawable.stupne6);
        mat.eight = getActivity().getDrawable(R.drawable.stupne7);

        stupne = new CharSequence[]{st0, st1, st2, st3, st4, st5, st6, st7};
        mat.obrazky = new Drawable[]{mat.one, mat.two, mat.three, mat.four, mat.five, mat.six, mat.seven, mat.eight};

        mat.builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());

       mat.builder.setTitle(R.string.excell);
       mat.builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int which) {
               poradie++;
               mat.counter.setText(mat.order[poradie]);
               mat.img.setImageDrawable(mat.obrazky[poradie]);
               ton.setText(stupne[poradie]);
           }
       });

        return mat.builder.create();
   }
}
