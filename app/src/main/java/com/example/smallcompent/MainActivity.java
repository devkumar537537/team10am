package com.example.smallcompent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button producedialog;
    EditText edittitle;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //combining of views
        producedialog = findViewById(R.id.producealert);
        edittitle = findViewById(R.id.titleedit);

        builder = new AlertDialog.Builder(this);

        producedialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titletext = edittitle.getText().toString();

                builder.setTitle(titletext);
                builder.setMessage(" Alert Dialog Demo");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"You choose yes",Toast.LENGTH_SHORT).show();
                    }
                })
                 .setNegativeButton("No", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(MainActivity.this,"You choose No",Toast.LENGTH_SHORT);
                     }
                 })
                 .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         Toast.makeText(MainActivity.this, "You choose cancel", Toast.LENGTH_SHORT).show();
                     dialogInterface.cancel();

                     }
                 }) ;


                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}