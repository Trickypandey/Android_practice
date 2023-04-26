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
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.FileProvider
import com.sst.practiseapp.R
import java.io.File
import java.io.IOException

class image_acrivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var send: Button
    private lateinit var imageview: ImageView
    var currentPhotoPath:String? = null
    lateinit var imgUri: Uri
    private val GALLERY = 1
    private val CAMERA = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_acrivity)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        val back =findViewById<ImageButton>(R.id.action_bar_back)
        back.setOnClickListener{
            finish()
        }
        btn=findViewById(R.id.btn)
        imageview=findViewById(R.id.iv)
        send=findViewById(R.id.send)

        btn.setOnClickListener {
            showPictureDialog()

        }
        send.setOnClickListener {
            val intent = Intent(this, Getimg_activity::class.java)
            intent.putExtra("path",currentPhotoPath)

            startActivity(intent)
        }
    }
    fun showPictureDialog() {
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
            FileProvider.getUriForFile( this,"com.sst.practice.fileprovider", imageFile  )
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imgUri  )
        startActivityForResult(intent,2 )

    }
    private fun choosePhotoFromGallary() {
        val galleryIntent = Intent(Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, GALLERY)
    }
    public override fun onActivityResult( requestCode:Int, resultCode:Int, data:Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY)
        {
            if (data != null)
            {
                Log.e("Result","$resultCode")
                val contentURI = data.data
                try
                {
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                    if (contentURI != null) {
                        currentPhotoPath = getRealPathFromURI(contentURI)
                        imageview.setRotation(getCameraPhotoOrientation(currentPhotoPath).toFloat())
                    }
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
                imageview.setRotation(getCameraPhotoOrientation(currentPhotoPath).toFloat())
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