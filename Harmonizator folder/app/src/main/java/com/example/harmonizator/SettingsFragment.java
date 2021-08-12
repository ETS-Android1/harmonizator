package com.example.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import static com.example.helloworld.R.style.TextAppearance_AppCompat;
import static com.example.helloworld.R.style.Theme_HelloWorld;


public class SettingsFragment extends PreferenceFragmentCompat {
    public Context context;
public SwitchPreference darkmode;
public CharSequence dark;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.nastavenia, rootKey);
        dark = getString(R.string.darkmode);
        darkmode = (SwitchPreference) findPreference(dark);
        darkmode.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (darkmode.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    getActivity().recreate();
                } else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    getActivity().recreate();
                }
                return true;
            }
        });
    }
}