package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.FileProvider
import java.io.File

class MainActivity : AppCompatActivity() {
    lateinit var img :ImageView
    lateinit var btn :Button
    lateinit var currentPhotoPath:String
    lateinit var imgUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img=findViewById(R.id.imageView)
        btn=findViewById(R.id.button)
        btn.setOnClickListener {
            var fileName ="photo"
            var storageDirectory : File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            var imageFile :File=File.createTempFile(fileName,".jpg",storageDirectory)
            currentPhotoPath=imageFile.absolutePath
             val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE )
            imgUri=FileProvider.getUriForFile( this,"com.example.myapplication.fileprovider" , imageFile  )
            intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUri  )
            startActivityForResult(intent,1 )

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1 && resultCode== RESULT_OK) {
            var bitmap:Bitmap=BitmapFactory.decodeFile(currentPhotoPath)
            img.setImageBitmap(bitmap)
        }
     }
}