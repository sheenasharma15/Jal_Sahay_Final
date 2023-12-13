package com.internshala.jalsahayfinal.Activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.internshala.jalsahayfinal.R
import java.io.File

class CameraActivity : AppCompatActivity() {
    lateinit var Cameraimage: ImageView
    lateinit var Cmaerabutton: FloatingActionButton
    lateinit var imageUri: Uri
    private val contract = registerForActivityResult(ActivityResultContracts.TakePicture()){
        Cameraimage.setImageURI(null)
        Cameraimage.setImageURI(imageUri)
    }
    val REQUEST_CODE=100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Cmaerabutton=findViewById(R.id.cameraButton)
//        Cameraimage=findViewById(R.id.imageView)

        Cmaerabutton.setOnClickListener {
            val takePicture= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try{
                startActivityForResult(takePicture,REQUEST_CODE)
            }
            catch (e: ActivityNotFoundException){
                Toast.makeText(this,"Error"+e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==REQUEST_CODE && resultCode== RESULT_OK){
            val imageBitmap=data?.extras?.get("data") as Bitmap
            Cameraimage.setImageBitmap(imageBitmap)
        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun createImageUri():Uri?{
        val image= File(applicationContext.filesDir,"camera_photo.png")
        return FileProvider.getUriForFile(applicationContext,"com.techmania.cameraapp",
            image)
    }
}