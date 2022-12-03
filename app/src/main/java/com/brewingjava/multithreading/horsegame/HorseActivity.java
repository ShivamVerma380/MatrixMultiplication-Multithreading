package com.brewingjava.multithreading.horsegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.brewingjava.multithreading.R;

public class HorseActivity extends AppCompatActivity {

    private EditText etNumHorses;
    private Button btnStartRace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horse);

        getSupportActionBar().hide();

        etNumHorses = findViewById(R.id.etNumHorses);
        btnStartRace = findViewById(R.id.btnStartRace);

        btnStartRace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),etNumHorses.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });


    }
}