package com.example.practice

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException


class image_acrivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var imageview: ImageView
    lateinit var currentPhotoPath:String
    lateinit var imgUri: Uri
    private val GALLERY = 1
    private val CAMERA = 2
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_acrivity)
        btn=findViewById(R.id.btn)
        imageview=findViewById(R.id.iv)
        val txv:TextView=findViewById(R.id.text)
        btn.setOnClickListener {
            txv.text = "asdfvahsdvfavsdfv"
            showPictureDialog()}
    }

    private fun showPictureDialog() {
        val pictureDialog = AlertDialog.Builder(this)
        pictureDialog.setTitle("Select Action")
        val pictureDialogItems = arrayOf("Select photo from gallery", "Capture photo from camera")
        pictureDialog.setItems(pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0 -> choosePhotoFromGallary()
                1 -> takePhotoFromCamera()
            }
        }
        pictureDialog.show()
    }

    private fun takePhotoFromCamera() {
        val fileName ="photo"
        val storageDirectory : File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imageFile :File=File.createTempFile(fileName,".jpg",storageDirectory)
        currentPhotoPath=imageFile.absolutePath
        val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE )
        imgUri=
            FileProvider.getUriForFile( this,"com.example.practice.fileprovider" , imageFile  )
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUri  )
        startActivityForResult(intent,2 )

    }

    private fun choosePhotoFromGallary() {
        val galleryIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        startActivityForResult(galleryIntent, GALLERY)
    }
    public override fun onActivityResult(requestCode:Int, resultCode:Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY)
        {
            if (data != null)
            {
                val contentURI = data.data
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
//                    val path = saveImage(bitmap)
                    Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show()
                    imageview.setImageBitmap(bitmap)

                }
                catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                }

            }

        }
        else if (requestCode == CAMERA)
        {
            try{
                val bitmap: Bitmap = BitmapFactory.decodeFile(currentPhotoPath)
                imageview.setImageBitmap(bitmap)
                Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show()
            }
            catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

//    fun saveImage(myBitmap: Bitmap):String {
//        val bytes = ByteArrayOutputStream()
//        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
//        val wallpaperDirectory = File(
//            (Environment.getExternalStorageDirectory()).toString() + IMAGE_DIRECTORY)
//        // have the object build the directory structure, if needed.
//        Log.d("fee",wallpaperDirectory.toString())
//        if (!wallpaperDirectory.exists())
//        {
//
//            wallpaperDirectory.mkdirs()
//        }
//
//        try
//        {
//            Log.d("heel",wallpaperDirectory.toString())
//            val f = File(wallpaperDirectory, ((Calendar.getInstance()
//                .getTimeInMillis()).toString() + ".jpg"))
//            f.createNewFile()
//            val fo = FileOutputStream(f)
//            fo.write(bytes.toByteArray())
//            MediaScannerConnection.scanFile(this,
//                arrayOf(f.getPath()),
//                arrayOf("image/jpeg"), null)
//            fo.close()
//            Log.d("TAG", "File Saved::--->" + f.getAbsolutePath())
//
//            return f.getAbsolutePath()
//        }
//        catch (e1: IOException) {
//            e1.printStackTrace()
//        }
//
//        return ""
//    }
//    companion object {
//        private val IMAGE_DIRECTORY = "/demonuts"
//    }

}