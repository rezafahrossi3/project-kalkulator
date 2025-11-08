package com.example.kalkulator_reza3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3;
    Button tambah, kurang, kali, bagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);

        tambah = findViewById(R.id.tambah);
        kurang = findViewById(R.id.kurang);
        kali = findViewById(R.id.kali);
        bagi = findViewById(R.id.bagi);

        View.OnClickListener operasi = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ✅ Cek input kosong
                if (e1.getText().toString().trim().isEmpty() || e2.getText().toString().trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Isi kedua angka terlebih dahulu", Toast.LENGTH_SHORT).show();
                    return;
                }

                double a = Double.parseDouble(e1.getText().toString());
                double b = Double.parseDouble(e2.getText().toString());
                double hasil = 0;

                if (v == tambah) {
                    hasil = a + b;
                } else if (v == kurang) {
                    hasil = a - b;
                } else if (v == kali) {
                    hasil = a * b;
                } else if (v == bagi) {
                    if (b == 0) {
                        e3.setText("Tidak bisa bagi 0");
                        return;
                    } else {
                        hasil = a / b;
                    }
                }

                e3.setText(String.valueOf(hasil));
            }
        };

        tambah.setOnClickListener(operasi);
        kurang.setOnClickListener(operasi);
        kali.setOnClickListener(operasi);
        bagi.setOnClickListener(operasi);
    }
}
