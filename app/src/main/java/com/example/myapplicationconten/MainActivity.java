package com.example.myapplicationconten;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        String[] datos = new String[]{"Primero", "Segundo", "Tercero", "Cuarto", "Quinto", "Sexto", "Septimo", "Octavo", "Noveno", "Decimo"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, datos);
        AutoCompleteTextView textView =
                findViewById(R.id.txtcontainer);
        textView.setAdapter(adapter);



        /* String[] datoslista = new String[]{"Kiara Intriago", "Brittany Cobeña", "Angel Litardo", "Cristhian Miko", "Josue Triana", "Erick Moran"};
        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        datoslista); */
        Alumno[] alumnos =
                new Alumno[]{
                        new Alumno("Josue Triana", "wtrianac@uteq.edu.ec"),
                        new Alumno("Erick Moran", "emorang@uteq.edu.ec"),
                        new Alumno("Angel Litardo", "Alitardop@uteq.edu.ec"),
                        new Alumno("Kiara Intriago", "kintriagop@uteq.edu.ec") };
        AdaptadorAlumnos adaptadorAlumnos = new AdaptadorAlumnos(this,
                alumnos);

        ListView lstListaAlumnos = findViewById(R.id.LvListaAlumnos);
        lstListaAlumnos.setAdapter(adaptadorAlumnos);
        lstListaAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position , long l) {
                Toast.makeText(getApplicationContext(), "Alumno seleccionado " + ((Alumno)adapterView.getItemAtPosition(position)).getNombre(), Toast.LENGTH_LONG).show();

            }
        });

    }
}