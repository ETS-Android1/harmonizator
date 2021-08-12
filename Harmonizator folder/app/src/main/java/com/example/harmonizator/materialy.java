package com.example.helloworld;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;

public class materialy {
    public Drawable one;
    public Drawable two;
    public Drawable three;
    public Drawable four;
    public Drawable five;
    public Drawable six;
    public Drawable seven;
    public Drawable eight;

    public TextView counter;
  public Drawable[] obrazky;
  public int[] odpovede;
  public int poradielekcie;
  public ImageView img;
  public Toast toast;
  public ActionBar ab;
  public AlertDialog.Builder builder;
  public Intent intent;
    public CharSequence[] order = {"1/8", "2/8", "3/8", "4/8", "5/8", "6/8", "7/8", "8/8"};
}
