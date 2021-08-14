package com.example.project8_dariwan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class InternalStorage extends AppCompatActivity implements View.OnClickListener{
    public static final String fileName = "fileinternal.txt";
    Button buat, ubah, baca, hapus;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);

        buat = findViewById(R.id.btnBuat);
        ubah = findViewById(R.id.btnUbah);
        baca = findViewById(R.id.btnBaca);
        hapus = findViewById(R.id.btnHapus);
        output = findViewById(R.id.output);

        buat.setOnClickListener(this);
        ubah.setOnClickListener(this);
        baca.setOnClickListener(this);
        hapus.setOnClickListener(this);

    }
    void buat(){
        String buatFile = "ini file Internal";
        File file = new File(getFilesDir(),fileName);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(buatFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    void ubah(){
        String ubahFile = "update file Internal";
        File file = new File(getFilesDir(),fileName);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubahFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    void baca(){
        File internal = getFilesDir();
        File file = new File(internal, fileName);

        if (file.exists()){
            StringBuilder isi = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line = br.readLine();

                while (line != null){
                    isi.append(line);
                    line = br.readLine();
                }
                br.close();
            }
            catch (IOException e){
                System.out.println("Error"+e.getMessage());
            }
            output.setText(isi.toString());
        }
    }

    void hapus(){
        File file = new File(Environment.getExternalStorageDirectory(),fileName);
        if (file.exists()){
            file.delete();
        }
    }
    @Override
    public void onClick(View view) {
        jalankanPerintah(view.getId());

    }

    private void jalankanPerintah(int id) {
        switch (id){
            case R.id.btnBuat:
                buat();
                break;
            case R.id.btnBaca:
                baca();
                break;
            case R.id.btnUbah:
                ubah();
                break;
            case R.id.btnHapus:
                hapus();
                break;
        }
    }
}