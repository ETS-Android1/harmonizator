package com.example.helloworld;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.harmonizator.MainActivity;
import com.example.harmonizator.materialy;

public class gratulaciaSt extends DialogFragment {
    materialy mat = new materialy();

    public Dialog onCreateDialog(Bundle SavedInstanceState){
        mat.builder = new AlertDialog.Builder(getActivity());
        mat.builder.setTitle(R.string.congrats);
        mat.builder.setMessage(R.string.carry_on_question);

            mat.builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
              mat.intent = new Intent(getActivity(), mat.lekcie[mat.poradielekcie]);
              mat.poradielekcie++;
              mat.intent.setClass(getContext(), mat.lekcie[mat.poradielekcie]);
              startActivity(mat.intent);
              getActivity().finish();
                }
            });

        mat.builder.setNeutralButton(R.string.repeat, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().recreate();
                dismiss();
            }
        });
        mat.builder.setNegativeButton(R.string.endLesson, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            mat.intent = new Intent(getActivity(), MainActivity.class);
            startActivity(mat.intent);
            getActivity().finish();
            }
        });
        return mat.builder.create();
    }
}
