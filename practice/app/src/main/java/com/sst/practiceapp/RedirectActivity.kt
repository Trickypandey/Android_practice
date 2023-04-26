package com.sst.practiceapp

import android.Manifest
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityRedirectBinding


class RedirectActivity : AppCompatActivity() {
    lateinit var binding: ActivityRedirectBinding
    lateinit var gintent:Intent
    lateinit var fintent :Intent
    lateinit var wintent :Intent
    lateinit var psintent :Intent
    lateinit var mpintent:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_redirect)
        binding.actionBarBack.setOnClickListener {
            finish()
        }
        gintent =Intent(Intent.ACTION_SEND).apply {
            // The intent does not have a URI, so declare the "text/plain" MIME type
            type = "text/plain"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("Sourabhpandey170@gmail.com")) // recipients
            putExtra(Intent.EXTRA_SUBJECT, "SUBJECT OF THE MAIL")
            putExtra(Intent.EXTRA_TEXT, "Hello my name is Sourabh")
            this.setPackage("com.google.android.gm")
            if (this.`package`?.let { available(it) } == false){
                Log.e("Status", "${ this.`package` }")
                binding.gmail.visibility=View.GONE
            }
        }
        fintent= Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Hello my name is Sourabh")
            putExtra(Intent.EXTRA_SUBJECT,"This is the subject for Facebook")
            this.setPackage("com.facebook.katana")
            if (this.`package`?.let { available(it) } == false){
                Log.e("Status", "${ this.`package` }")
                binding.facebook.visibility=View.GONE
            }
        }
        wintent= Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Hello my name is Sourabh")
            this.setPackage("com.whatsapp")
            if (this.`package`?.let { available(it) } == false){
                Log.e("Status", "${ this.`package` }")
                binding.whatsapp.visibility=View.GONE
            }
        }
//        /sdcard/Android/data/com.google.android.apps.maps
        mpintent = Intent(Intent.ACTION_SEND)
        val myLatitude = 44.433106
        val myLongitude = 26.103687
        val labelLocation = "Jorgesys @ Bucharest"
        val urlAddress = "http://maps.google.com/maps?q="+ myLatitude  +"," + myLongitude +"("+ labelLocation + ")&iwloc=A&hl=es"
            mpintent.apply {
            val mapUri = Uri.parse(urlAddress)
            this.setClassName(this@RedirectActivity.packageName, "com.google.android.apps.maps");
            mpintent.setData(mapUri)
            mpintent.setPackage("com.google.android.apps.maps")
            if (this.`package`?.let { available(it) } == false){
                Log.e("Status", "${ this.`package` }")
                binding.googlemap.visibility=View.GONE
            }
        }

        val url=Uri.parse("market://details?id==com.kiloo.subwaysurf")
        psintent = Intent(Intent.ACTION_SEND,url)
            psintent.apply {
            this.setPackage("com.android.vending")
            if (this.`package`?.let { available(it) } == false){
                Log.e("Status", "${ this.`package` }")
                binding.playstore.visibility=View.GONE
            }
        }



        allClick()
    }
    fun allClick(){
        binding.gmail.setOnClickListener {
            choosePhotoFromGallary()

        }
        binding.facebook.setOnClickListener {
            startActivity(fintent)
        }
        binding.whatsapp.setOnClickListener {

            startActivity(wintent)
        }
        binding.playstore.setOnClickListener {
            try {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=com.kiloo.subwaysurf")
                    )
                )
                    Log.e("Check","fbasbdfjklabsdfjkbvas")
            } catch (anfe: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.kiloo.subwaysurf")
                    )
                )
                Log.e("Checked","fbasbdfjklabsdfjkbvas")

            }
        }
        binding.googlemap.setOnClickListener {
//            val pg =PackageManager(P)
            mpintent.resolveActivity(this.packageManager)?.let{ startActivity(mpintent) }
        }
        binding.normalLink.setOnClickListener {
            showPictureDialog()
        }
        binding.sms.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to SEND_SMS - requesting it")
                val permissions = arrayOf<String>(Manifest.permission.SEND_SMS)
                requestPermissions(permissions, 0)
            }
            val phoneNumber = "8160837363"
            val message = "Hello Sumit bhai"
            choosePhotoFromGallarymms()
//            val sendIntent = Intent(Intent.ACTION_SEND)
//            sendIntent.putExtra("sms_body", "some text")
//            sendIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://com.google.android.apps.photos.contentprovider/-1/1/content%3A%2F%2Fmedia%2Fexternal%2Fimages%2Fmedia%2F1000021903/ORIGINAL/NONE/image%2Fpng/253834095"))
//            sendIntent.type = "image/png"
//            startActivity(sendIntent)
        }
///data/data/com.google.android.apps.messaging
    }

    private fun choosePhotoFromGallary() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, 1)
    }
    private fun choosePhotoFromGallarymms() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, 2)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1 && data!=null){
            val uri = data.data

            gintent =Intent(Intent.ACTION_SEND).apply {
                // The intent does not have a URI, so declare the "text/plain" MIME type
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("Sourabhpandey170@gmail.com")) // recipients
                putExtra(Intent.EXTRA_SUBJECT, "SUBJECT OF THE MAIL")
                putExtra(Intent.EXTRA_TEXT, "Hello my name is Sourabh")
                putExtra(Intent.EXTRA_STREAM, uri)
                this.setPackage("com.google.android.gm")
                if (this.`package`?.let { available(it) } == false){
                    Log.e("Status", "${ this.`package` }")
                    binding.gmail.visibility=View.GONE
                }
                startActivity(gintent)
            }
        }
        if (requestCode==2 && data!=null){
            val phoneNumber = "8160837363"
            val message = "Hello Sumit bhai"
            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.putExtra("address",phoneNumber)
            sendIntent.putExtra("sms_body", message)
            sendIntent.putExtra(Intent.EXTRA_STREAM, data.data)
            sendIntent.type = "image/png"
            startActivity(sendIntent)
        }
    }
//    private fun available(name: String): Boolean {
//        var list = mutableSetOf<String>()
//        try {
//            // check if available
//            packageManager.getInstalledApplications(MATCH_ALL).forEach {
//                it.toString().split(" ").forEach {
//                    val temp = it.replace("{","").replace("}","").replace(" ","")
//                    list.add(temp)
//                    val packagename=temp.toString().replace("}","").replace("[","").replace("]","")
//                    if (packagename.contains(name)) {
//                        Log.e("Answer", "$packagename $name")
//                        return true
//                    }
//                }
//               list.forEach {
//                   if (it == name) {
//                       return true
//                   }
//
//               }
//            }
//
//        } catch (e: NameNotFoundException) {
//            // if not available set
//            // available as false
//        }
//        return false
//    }
//
//    fun isAppEnabled(packageName: String, context: Context): Boolean {
//        try {
//            val packageManager = context.packageManager
//            return packageManager.getApplicationInfo(packageName, 0).enabled
//        } catch (e: PackageManager.NameNotFoundException) {
//            return false
//        }
//    }
//    private fun isPackageInstalled(packageName: String, packageManager: PackageManager): Boolean {
//        return try {
//            packageManager.getPackageInfo(packageName, 0)
//            true
//        } catch (e: NameNotFoundException) {
//            false
//        }
//    }
fun showPictureDialog() {
    val pictureDialog = AlertDialog.Builder(this)
    pictureDialog.setTitle("Select Action")
    val pictureDialogItems = arrayOf("Open in this app", "Open in default browser")
    pictureDialog.setItems(pictureDialogItems
    ) { dialog, which ->
        when (which) {
            0->{
                openApplicationBrowser()
            }
            1->{
                openBrowser()
            }
        }
    }
    pictureDialog.show()
}

    private fun available(name: String): Boolean {
        var available = true
        try {
            // check if available
            packageManager.getPackageInfo(name, 0)
        } catch (e: NameNotFoundException) {
            // if not available set
            // available as false
            available = false
        }
        return available
    }
    fun openBrowser(){
        val url: String ="https://www.dream11.com/about-us/privacypolicy"
        val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(urlIntent)
    }
    fun openApplicationBrowser(){
        val intent =Intent(this,WebActivity::class.java)
        startActivity(intent)
    }
    fun startMail(): Intent {

        return intent
    }
}