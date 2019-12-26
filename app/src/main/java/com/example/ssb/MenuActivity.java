package com.example.ssb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ssb.dto.Estado;

import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MenuActivity extends AppCompatActivity {
    private Button btnConectar, btnDesconectar, btnEstado, btnAtencion, btnCerrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

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

        btnEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnConectar.hasOnClickListeners() ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

                    builder.setMessage("Su estado es conectado");
                    builder.setTitle("Estado de la Alarma");
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                        }
                    });
                } if (btnDesconectar.hasOnClickListeners()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

                    builder.setMessage("Su estado es desconectado");
                    builder.setTitle("Estado de la Alarma");
                    builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();

                        }
                    });
                }
            }


        });





    }
    public void intentoDeGuardarEstado(Estado estado){
       boolean conectar = true;
        if (btnConectar.hasOnClickListeners() ) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

            builder.setMessage("Su estado es conectado");
            builder.setTitle("Estado de la Alarma");
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
        } if (btnDesconectar.hasOnClickListeners()){
            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

            builder.setMessage("Su estado es desconectado");
            builder.setTitle("Estado de la Alarma");
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
        }
    }
    public void intentoDeIprimirFechaDelLosButtons(){

        if (btnConectar == btnDesconectar ) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date date = new Date();

            String fecha = dateFormat.format(date);
        }
    }



}
