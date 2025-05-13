package com.example.fragmenty3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewInActivityDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewInActivityDisplay = findViewById(R.id.textView_in_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_input, new InputFragment())
                    .commit();

            DisplayFragment initialDisplay = DisplayFragment.newInstance("Oczekiwanie na dane z InputFragment...");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_display, initialDisplay)
                    .commit();
        }
    }

    public void handleDataFromInputFragment(String data) {
        textViewInActivityDisplay.setText("Aktywność otrzymała: " + data);
        DisplayFragment updatedDisplayFragment = DisplayFragment.newInstance("Dane z InputFragment: " + data);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_display, updatedDisplayFragment)
                .commit();
    }
}