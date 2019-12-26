package com.example.ssb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ssb.dal.AlarmaDAL;
import com.example.ssb.dto.Alarma;

import java.util.ArrayList;


public class MenuActivity extends AppCompatActivity {
    private Button btnConectar, btnDesconectar, btnEstado, btnAtencion, btnCerrar;
    private AlarmaDAL alarmaDAL;
    private ListView listNot1;
    private ArrayAdapter<Alarma> adapter;
    private ArrayList<Alarma> listaAlarma1;
    private int codPosicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.alarmaDAL = new AlarmaDAL(getApplicationContext(), new Alarma());
        this.listaAlarma1 = new AlarmaDAL(getBaseContext()).seleccionar();

        this.adapter = new ArrayAdapter<Alarma>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                this.listaAlarma1
        );

        this.listNot1.setAdapter(adapter);

        this.btnConectar = findViewById(R.id.btnConectar);
        this.btnDesconectar = findViewById(R.id.btnDesconectar);
        this.btnEstado = findViewById(R.id.btnEstado);
        this.btnAtencion = findViewById(R.id.btnAtencion);
        this.btnCerrar = findViewById(R.id.btnCerrar);

        btnAtencion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnAtencion = new Intent(MenuActivity.this, ClienteActivity.class);

                startActivity(btnAtencion);

            }

        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnAtencion = new Intent(MenuActivity.this, MainActivity.class);

                startActivity(btnAtencion);

            }

        });

        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setMessage("Su alarma está conectada");
                builder.setTitle("Desconexión");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }

        });
        
        btnDesconectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setMessage("Su alarma está desconectada");
                builder.setTitle("Conexión");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });



        //btnEstado.set

        listNot1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                codPosicion = posicion;
                abrirNotificacionActivity();
            }
        });

    }

    private void abrirNotificacionActivity() {
        Intent intento = new Intent(MenuActivity.this, NotificacionActivity.class);
        Alarma a = (Alarma) listaAlarma1.get(codPosicion);

        intento.putExtra("Alarma", a);
        startActivityForResult(intento, 100);
    }
}
