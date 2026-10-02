package com.example.kosztypodruzy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText DysKm;
    EditText ZuzNaKm;
    RadioButton Benzine;
    RadioButton Diesel;
    RadioButton Lpg;
    EditText Lpasaz;
    Button Btn;
    TextView CalKoszt;
    TextView NaOsob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        DysKm = findViewById(R.id.DysKm);
        ZuzNaKm = findViewById(R.id.ZuzNakm);
        Benzine = findViewById(R.id.Benzine);
        Diesel = findViewById(R.id.Diesel);
        Lpg = findViewById(R.id.Lpg);
        Lpasaz = findViewById(R.id.Lpasaz);
        Btn = findViewById(R.id.Btn);
        CalKoszt = findViewById(R.id.CalKoszt);
        NaOsob = findViewById(R.id.NaOsob);

    }
}