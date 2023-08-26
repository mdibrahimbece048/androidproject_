package com.example.gettingpicturecamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    ImageView imgCamera;
    private final int CAMERA_REQUEST_CODE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgCamera=findViewById(R.id.imgCamera);
        btnCamera=findViewById(R.id.cameraButton);

       btnCamera.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent iCamera=new Intent();
               iCamera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
               startActivityForResult(iCamera,CAMERA_REQUEST_CODE);


           }
       });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode==RESULT_OK){

            if(requestCode==CAMERA_REQUEST_CODE){

                Bitmap image=(Bitmap)(data.getExtras().get("data"));
                imgCamera.setImageBitmap(image);
            }
        }
    }
}