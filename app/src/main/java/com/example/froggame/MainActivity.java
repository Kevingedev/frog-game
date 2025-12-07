package com.example.froggame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ImageView img1, img2, img3, piedra, img4, img5, img6, img7;
    ImageView[] imagenes;
    boolean[] saltoDisponible = {false, false, false, true, false, false, false};
    int[] rana = {1, 2, 3, 4, 5, 6, 7};
    ImageView btn_reinicio, btn_exit;

    private int intentos = 0;
    private Drawable[] imagenesIniciales;

    private MediaPlayer mediaPlayer;


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

        img1 = findViewById(R.id.ranaIzquierda3);
        img2 = findViewById(R.id.ranaIzquierda2);
        img3 = findViewById(R.id.ranaIzquierda1);
        img4 = findViewById(R.id.piedraCentro);
        img5 = findViewById(R.id.ranaDerecha1);
        img6 = findViewById(R.id.ranaDerecha2);
        img7 = findViewById(R.id.ranaDerecha3);
        piedra = findViewById(R.id.piedraCentro); // variable que se puede utilizar para validaciones
        btn_reinicio = findViewById(R.id.btn_reinicio);
        btn_exit = findViewById(R.id.btn_exit);

        mediaPlayer = MediaPlayer.create(this, R.raw.audiofrogs);

        btn_exit.setOnClickListener(v -> {
            // Redireccionar a la MainActivity
            Intent intent = new Intent(MainActivity.this, InicioActivity.class);
            startActivity(intent);
            finish(); // Cerrar la actividad actual si no se necesita volver
        });

        inicializarImagenes();

        btn_reinicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Botón", "Reinicio presionado"); // Log para verificar que se presiona el botón
                reiniciarIntentos(); // Llama al método de reinicio
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = encontrarTrue(saltoDisponible);
                int posicionRana;
                if (saltoDisponible[1] == true || saltoDisponible[2] == true){ //valida que tenga salto disponible esta rana
                    intercambiar(1,posicion);

                    //se habilita el true donde quedo la piedra
                    saltoDisponible[0] = true;
                    saltoDisponible[posicion] = false;
                    //se actualiza array de rana para validar la rana que se esta moviendo a cada posicion
                    posicionRana = rana[0];
                    rana[0] = rana[posicion];
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                    audioRana();
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = encontrarTrue(saltoDisponible);
                int posicionRana;
                if ((rana[1] < 4) && (saltoDisponible[2] == true || saltoDisponible[3] == true)){
                    intercambiar(2,posicion);

                    saltoDisponible[1] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[1];
                    rana[1] = rana[posicion];
                    rana[posicion] = posicionRana;
                    //Sumar los intentos o movimientos
                    intentos++;
                } else if (rana[1] == 5 && saltoDisponible[0] == true) {
                    intercambiar(2,posicion);
                    saltoDisponible[1] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[1];
                    rana[1] = rana[posicion];//4
                    rana[posicion] = posicionRana;
                    //Sumar los intentos o movimientos
                    intentos++;
                }
                audioRana();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Cambio", "La rana: " + Arrays.toString(rana) + " por la disponible: " + Arrays.toString(saltoDisponible));
                int posicion = encontrarTrue(saltoDisponible);
                int posicionRana;
                if (rana[2] == 1 && (saltoDisponible[4] == true)){

                    intercambiar(3,posicion);

                    saltoDisponible[2] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[2];
                    rana[2] = rana[posicion];
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                } else if (rana[2] == 2 && (saltoDisponible[3] == true || saltoDisponible[4] == true)){

                    intercambiar(3,posicion);

                    saltoDisponible[2] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[2];
                    rana[2] = rana[posicion];
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                } else if (rana[2] == 3 && (saltoDisponible[3] == true || saltoDisponible[4] == true)){

                    intercambiar(3,posicion);

                    saltoDisponible[2] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[2];
                    rana[2] = rana[posicion];
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                } else if (rana[2] == 5 && (saltoDisponible[0] == true || saltoDisponible[1] == true)) {
                    intercambiar(3,posicion);

                    saltoDisponible[2] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[2];
                    rana[2] = rana[posicion];//4
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                } else if (rana[2] == 6 && saltoDisponible[1] == true) {
                    intercambiar(3,posicion);

                    saltoDisponible[2] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[2];
                    rana[2] = rana[posicion];//4
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                }
                audioRana();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = encontrarTrue(saltoDisponible);
                int posicionRana;
                if ((rana[3] < 4) && (saltoDisponible[4] == true || saltoDisponible[5] == true)){
                    intercambiar(4,posicion);

                    saltoDisponible[3] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[3];
                    rana[3] = rana[posicion];
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                    if (intentos >= 15){
                        mostrarDialog();
                    }
                } else if ((rana[3] > 4) && (saltoDisponible[1] == true || saltoDisponible[2] == true)) {
                    intercambiar(4,posicion);

                    saltoDisponible[3] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[3];
                    rana[3] = rana[posicion];//4
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                    if (intentos >= 15){
                        mostrarDialog();
                    }
                }
                audioRana();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = encontrarTrue(saltoDisponible);
                int posicionRana;
                if ((rana[4] < 4) && (saltoDisponible[5] == true || saltoDisponible[6] == true)){
                    intercambiar(5,posicion);

                    saltoDisponible[4] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[4];
                    rana[4] = rana[posicion];
                    rana[posicion] = posicionRana;
                    //Sumar los intentos o movimientos
                    intentos++;
                } else if ((rana[4] > 4) && (saltoDisponible[2] == true || saltoDisponible[3] == true)) {
                    intercambiar(5,posicion);

                    saltoDisponible[4] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[4];
                    rana[4] = rana[posicion];//4
                    rana[posicion] = posicionRana;
                    //Sumar los intentos o movimientos
                    intentos++;
                }
                audioRana();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = encontrarTrue(saltoDisponible);
                int posicionRana;
                if ((rana[5] < 4) && saltoDisponible[6] == true){
                    intercambiar(6,posicion);

                    saltoDisponible[5] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[5];
                    rana[5] = rana[posicion];
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                } else if ((rana[5] > 4) && (saltoDisponible[3] == true || saltoDisponible[4] == true)) {
                    intercambiar(6,posicion);

                    saltoDisponible[5] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[5];
                    rana[5] = rana[posicion];//4
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                }
                audioRana();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicion = encontrarTrue(saltoDisponible);
                int posicionRana;
                if ((rana[6] == 7) && (saltoDisponible[4] == true || saltoDisponible[5] == true)){
                    intercambiar(7,posicion);

                    saltoDisponible[6] = true;
                    saltoDisponible[posicion] = false;

                    posicionRana = rana[6];
                    rana[6] = rana[posicion];
                    rana[posicion] = posicionRana;

                    //Sumar los intentos o movimientos
                    intentos++;
                }
                audioRana();
            }
        });

    }

    // Paso 2: Inicializa el arreglo de imágenes y guarda los Drawables iniciales
    private void inicializarImagenes() {
        imagenes = new ImageView[]{
                findViewById(R.id.ranaIzquierda3),
                findViewById(R.id.ranaIzquierda2),
                findViewById(R.id.ranaIzquierda1),
                findViewById(R.id.piedraCentro),
                findViewById(R.id.ranaDerecha1),
                findViewById(R.id.ranaDerecha2),
                findViewById(R.id.ranaDerecha3),
        };

        // Guarda los Drawables iniciales
        imagenesIniciales = new Drawable[imagenes.length];
        for (int i = 0; i < imagenes.length; i++) {
            imagenesIniciales[i] = imagenes[i].getDrawable(); // Guardar el drawable actual
        }
    }


    public void intercambiar(int imagen1, int imagen2){

        int index1 = imagen1 - 1;
        int index2 = imagen2;

        Drawable drawableImg3 = imagenes[index1].getDrawable();
        Drawable drawableImg4 = imagenes[index2].getDrawable();

        int ancho3 = imagenes[index1].getWidth();
        int alto3 = imagenes[index1].getHeight();

        int ancho4 = imagenes[index2].getWidth();
        int alto4 = imagenes[index2].getHeight();

        imagenes[index1].setImageDrawable(drawableImg4);
        imagenes[index2].setImageDrawable(drawableImg3);

        imagenes[index1].getLayoutParams().width=ancho3;
        imagenes[index1].getLayoutParams().height=alto3;
        imagenes[index1].requestLayout();

        imagenes[index2].getLayoutParams().width=ancho4;
        imagenes[index2].getLayoutParams().height=alto4;
        imagenes[index2].requestLayout();



    }

    // Función que retorna la posición del primer 'true' en el array
    public int encontrarTrue(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                return i;  // Retorna la posición en la que encontró 'true'
            }
        }
        return -1;  // Retorna -1 si no se encuentra ningún valor 'true'
    }
    //Funcion para mostrar alerta
    private void mostrarDialog() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Hey sos coco bicho !")
                .setMessage("Completaste el juego.")

                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Cerrar el diálogo
                    }
                })
                .show();
    }

    private void reiniciarIntentos() {
        // Reiniciar el array rana antes de reorganizar las imágenes
        Log.d("Reinicio", "Botón de reinicio presionado");
        intentos = 0;

        // Reasignar las imágenes al estado inicial
        for (int i = 0; i < imagenes.length; i++) {
            if (imagenesIniciales[i] != null) {
                imagenes[i].setImageDrawable(imagenesIniciales[i]); // Asigna el drawable inicial
                Log.d("Drawable", "Drawable asignado a imagen " + i + ": " + imagenesIniciales[i]);
            }

            // Ajustar las dimensiones de los ImageView
            // Aquí puedes establecer el tamaño deseado de forma fija o usar WRAP_CONTENT
            imagenes[i].getLayoutParams().width = (int) (90 * getResources().getDisplayMetrics().density); // 90dp a píxeles
            imagenes[i].getLayoutParams().height = (int) (113 * getResources().getDisplayMetrics().density); // 113dp a píxeles
            imagenes[i].requestLayout(); // Fuerza la actualización del layout
            imagenes[i].invalidate(); // Pinta de nuevo la vista
        }

        // Reiniciar el estado de saltoDisponible
        saltoDisponible = new boolean[]{false, false, false, true, false, false, false};
        rana = new int[]{1, 2, 3, 4, 5, 6, 7};

    }

    private void audioRana() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Libera el MediaPlayer al destruir la actividad
            mediaPlayer = null;
        }
    }
}