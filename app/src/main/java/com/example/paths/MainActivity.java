package com.example.paths;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paths.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonLogin;
    private Button buttonMap;

    private Button buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = findViewById(R.id.button1);
        buttonLogin.setOnClickListener(v -> {
            // Create an Intent to start LoginActivity
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        buttonMap = findViewById(R.id.button2);
        buttonMap.setOnClickListener(v -> {
            // Create an Intent to start LoginActivity
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        });

        buttonSettings = findViewById(R.id.button3);
        buttonSettings.setOnClickListener(v -> {
            // Create an Intent to start LoginActivity
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        });
    }

    // Getter for login
    public Button getButtonLogin() {
        return buttonLogin;
    }

    // Setter for login
    public void setButtonLogin(Button loginButton) {
        buttonLogin = loginButton;
    }

    // Getter for map
    public Button getButtonMap() {
        return buttonMap;
    }

    // Setter for map
    public void setButtonMap(Button mapButton) {
        buttonMap = mapButton;
    }

    // Getter for settings
    public Button getButtonSettings() { return buttonSettings; }

    // Setter for settings
    public void setButtonSettings(Button settingsButton) {
        buttonSettings = settingsButton;
    }

}