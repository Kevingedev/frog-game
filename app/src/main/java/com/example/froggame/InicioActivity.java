package com.example.froggame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InicioActivity extends AppCompatActivity {

    private VideoView videoView;
    private ImageView btnComenzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView btnExitGame = findViewById(R.id.btn_exitgame);
        videoView = findViewById(R.id.videoView);
        btnComenzar = findViewById(R.id.btn_comenzar);

        // Establecer el video de fondo
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.fondofrog; // Cambia "tu_video" por el nombre de tu archivo MP4
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.setOnPreparedListener(mediaPlayer -> mediaPlayer.setLooping(true)); // Hacer que el video se repita
        videoView.start(); // Comenzar a reproducir el video

        btnComenzar.setOnClickListener(v -> {
            // Redireccionar a la MainActivity
            Intent intent = new Intent(InicioActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Cerrar la actividad actual si no se necesita volver
        });
        btnExitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la actividad actual y sale de la aplicación
                finishAffinity(); // Este método cierra todas las actividades y sale de la app
                System.exit(0);  // Asegura que el proceso sea terminado
            }
        });


    }

}