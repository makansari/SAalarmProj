package com.example.saalarmproj

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        buttonCamera.isEnabled = false

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),125)
        }
        else
        {
            buttonCamera.isEnabled = true
            buttonCamera.setOnClickListener {
                var myIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(myIntent,999)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 999){
            var myPic = data?.getParcelableExtra<Bitmap>("data")
            imageViewCamera.setImageBitmap(myPic)
        }

    }



}