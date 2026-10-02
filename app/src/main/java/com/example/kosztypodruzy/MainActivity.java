package com.example.kosztypodruzy;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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
    double benzine = 6.50;
    double diesel = 6.70;
    double lpg = 3.10;

    int lpasaz = 1;

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

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dystansStr = DysKm.getText().toString().replace(',', '.').trim();
                String spalanieStr = ZuzNaKm.getText().toString().replace(',', '.').trim();
                String pasazerowieStr = Lpasaz.getText().toString().trim();

                if (dystansStr.isEmpty() || spalanieStr.isEmpty()) {
                    CalKoszt.setTextColor(android.graphics.Color.RED);
                    CalKoszt.setText("Wpisz dystans i zużycie paliwa!");
                    NaOsob.setText("");
                    return;
                }

                double dystans;
                double spalanie;
                try {
                    dystans = Double.parseDouble(dystansStr);
                    spalanie = Double.parseDouble(spalanieStr);
                } catch (NumberFormatException e) {
                    CalKoszt.setTextColor(android.graphics.Color.RED);
                    CalKoszt.setText("Błędny format liczb!");
                    NaOsob.setText("");
                    return;
                }

                int pasazerowie = 1;
                if (!pasazerowieStr.isEmpty()) {
                    try {
                        pasazerowie = Integer.parseInt(pasazerowieStr);
                        if (pasazerowie <= 0) pasazerowie = 1;
                    } catch (NumberFormatException e) {
                        pasazerowie = 1;
                    }
                }

                // 3.
                double cenaPaliwa = benzine;
                if (Diesel.isChecked()) {
                    cenaPaliwa = diesel;
                } else if (Lpg.isChecked()) {
                    cenaPaliwa = lpg;
                }

                double calkowityKoszt = dystans * (spalanie / 100.0) * cenaPaliwa;
                double kosztNaOsobe = calkowityKoszt / pasazerowie;

                CalKoszt.setTextColor(Color.GREEN);
                CalKoszt.setText(String.format("Całkowity koszt: %.2f zł", calkowityKoszt));
                NaOsob.setTextColor(Color.GREEN);
                NaOsob.setText(String.format("Koszt na osobę: %.2f zł", kosztNaOsobe));


            }
        });
    }
}