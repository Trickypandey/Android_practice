package com.sst.practiceapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.sst.practiseapp.R
import java.io.File
import java.io.IOException

class Getimg_activity : AppCompatActivity() {
    var path:String? = null
    lateinit var imgUri: Uri
    lateinit var imageView:ImageView
    lateinit var detail :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getimg)

        path = intent.extras?.getString("path")

        val bitmap: Bitmap? = BitmapFactory.decodeFile(path)
        Log.d("Bitmap","$bitmap")
        imageView=findViewById(R.id.imageView1)
        detail=findViewById(R.id.details)
        val back =findViewById<ImageButton>(R.id.action_bar_back)
        back.setOnClickListener{
            finish()
        }
        imageView.setImageBitmap(bitmap)
        val btnRotate = findViewById<Button>(R.id.rotate)

        imageView.rotation = getCameraPhotoOrientation(path).toFloat()
        btnRotate.setOnClickListener {
           showEdit()
        }
    }
//    to rotate the image from camara
private fun getCameraPhotoOrientation(imagePath: String?): Int {
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
            detail.text="Device Company = ${exif.getAttribute(ExifInterface.TAG_MAKE)}\n Devide Model = ${exif.getAttribute(ExifInterface.TAG_MODEL)}\n Date & Time = \n ${exif.getAttribute(ExifInterface.TAG_DATETIME)}"

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
//    to confirm edit dailoge box
    private fun showEdit () {
        val pictureDialog = AlertDialog.Builder(this)
        pictureDialog.setTitle("Are you sure to Edit image")
        val pictureDialogItems = arrayOf("Yess", "No")
        pictureDialog.setItems(pictureDialogItems
        ) { dialog, which ->
            when (which) {
                0->showPictureDialog()
                1-> dialog.cancel()
            }
        }
        pictureDialog.show()
    }
    // to choose image from gallery or camara

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
        path=imageFile.absolutePath
        val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE )
        imgUri=
            FileProvider.getUriForFile( this,"com.sst.practice.fileprovider", imageFile  )
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUri  )
        startActivityForResult(intent,2 )
    }
    private fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, 1)
    }
    public override fun onActivityResult( requestCode:Int, resultCode:Int, data:Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1)
        {
            if (data != null)
            {
                val contentURI = data.data
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                    if (contentURI != null) {
                        path = getRealPathFromURI(contentURI)
                        imageView.setRotation(getCameraPhotoOrientation(path).toFloat())
                    }
                    imageView.setImageBitmap(bitmap)
                }
                catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else if (requestCode == 2)
        {
            try{
                val bitmap: Bitmap = BitmapFactory.decodeFile(path)
                imageView.setImageBitmap(bitmap)
                imageView.setRotation(getCameraPhotoOrientation(path).toFloat())
                Toast.makeText(this, "Image Saved!", Toast.LENGTH_SHORT).show()
            }
            catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
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
}