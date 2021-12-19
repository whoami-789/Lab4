package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int requestcode = 1;

    public void onActivityResult(int requestcode, int resultCode, Intent data){

        super.onActivityResult(requestcode, resultCode, data);
            Context context = getApplicationContext();

        if (requestcode == requestcode && resultCode == Activity.RESULT_OK){
                if (data == null){
                    return;
                }
                Uri uri = data.getData();
                Toast.makeText(context, uri.getPath(), Toast.LENGTH_SHORT).show();
            }
    }

    public void openFileChooser(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, requestcode);
    }
}