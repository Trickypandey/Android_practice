package com.sst.practiceapp

import android.content.Intent
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.lyrebirdstudio.croppylib.Croppy
import com.lyrebirdstudio.croppylib.main.CropRequest
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityLoadImageBinding
import java.io.File
import java.io.IOException

class LoadImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoadImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_load_image)

        clickAll()
    }

    private fun clickAll() {

        binding.loadImage1.setOnClickListener {
            if (binding.url.text.toString()!="") {
                var url = binding.url.text.toString()
                Glide.with(this).load(url).into(binding.main)
            }
            else{
                Toast.makeText(this, "Please enter a Link ", Toast.LENGTH_SHORT).show()
            }
        }
        binding.loadImage2.setOnClickListener {
            choosePhotoFromGallary()
        }
    }
    private fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, 1)
    }
    public override fun onActivityResult( requestCode:Int, resultCode:Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        Log.e("Result and req Code","$requestCode $resultCode")
        if (data != null && requestCode==1 && resultCode== RESULT_OK)
        {
            val contentURI = data.data
            try
            {
                val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                if (contentURI != null) {
//                    binding.cropImageView.setImageUriAsync(contentURI)
//                    val cropped: Bitmap? = binding.cropImageView.getCroppedImage()
//                    val currentPhotoPath = getRealPathFromURI(contentURI)


                    val cropRequest = CropRequest.Auto(contentURI, 101)
                    Croppy.start(this, cropRequest)
                    Log.e("imageuri","$contentURI")
//                   cropRequest binding.crop.setOnClickListener {
//                        Glide.with(this)
//                            .load(cropped)
//                            .into(binding.main)
//                    }
                }
            }
            catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
            }
        }
        if (requestCode == 101 && resultCode== RESULT_OK) {
            if (data != null) {
                Log.e("Result and req Code","$requestCode $resultCode")
                binding.main.setImageURI(data.data)
            }

        }
    }

    private fun getRealPathFromURI(contentURI: Uri): String? {
        val result: String?
        val cursor = contentResolver.query(contentURI, null, null, null, null)
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.path
        } else {
            cursor.moveToFirst()
            val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
            result = cursor.getString(idx)
            cursor.close()
        }
        return result
    }
    fun getCameraPhotoOrientation(imagePath: String?): Int {
        var rotate = 0
        try {
            val imageFile = File(imagePath)
            val exif = ExifInterface(
                imageFile.absolutePath
            )
            val orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL
            )
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_270 -> rotate = 270
                ExifInterface.ORIENTATION_ROTATE_180 -> rotate = 180
                ExifInterface.ORIENTATION_ROTATE_90 -> rotate = 90
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return rotate
    }
}