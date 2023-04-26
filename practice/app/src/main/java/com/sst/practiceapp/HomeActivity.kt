package com.sst.practiceapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sst.constants.Constants
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityHomeBinding
import java.util.*

class HomeActivity :AppCompatActivity(),RecyclerViewClickInterface {
    lateinit var cameraManager: CameraManager
    lateinit var getCameraID:String
    private lateinit var binding: ActivityHomeBinding
    private lateinit var btnlist:ArrayList<PracticeBtn>
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.recyclervie_layout2)
        cameraManager = this.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        getCameraID = cameraManager.cameraIdList[0]
        recyclerView= findViewById(R.id.recyclerView)
        recyclerView.layoutManager= LinearLayoutManager( this)
        btnlist= ArrayList()
        addDataList()
    }


    private fun addDataList(){
        btnlist.add(PracticeBtn(resources.getString(R.string.sign_up)))
        btnlist.add(PracticeBtn(resources.getString(R.string.image_selector)))
        btnlist.add(PracticeBtn(resources.getString(R.string.print_table)))
        btnlist.add(PracticeBtn(resources.getString(R.string.date_calculator)))
        btnlist.add(PracticeBtn(resources.getString(R.string.working_hour)))
        btnlist.add(PracticeBtn(resources.getString(R.string.redirect)))
        btnlist.add(PracticeBtn(resources.getString(R.string.turn_on),"Toggle"))
        btnlist.add(PracticeBtn(resources.getString(R.string.Localization)))
        btnlist.add(PracticeBtn(resources.getString(R.string.check_network_connection)))
        btnlist.add(PracticeBtn(resources.getString(R.string.push_notification)))
        btnlist.add(PracticeBtn(resources.getString(R.string.text_to_speech)))
        btnlist.add(PracticeBtn(resources.getString(R.string.load_images)))
        btnlist.add(PracticeBtn(resources.getString(R.string.video_play)))
        btnlist.add(PracticeBtn(resources.getString(R.string.bottom_nav)))
        btnlist.add(PracticeBtn(resources.getString(R.string.Profle_Page)))
        btnlist.add((PracticeBtn("View Pager")))
        recyclerView.adapter=AdapterRvPracticeBtn(btnlist,this,this)
    }

    override fun onItemClick(position: Int) {
        when(position){
            0->{
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.startActivity(intent)
            }
            1->{
                val intent = Intent(this, image_acrivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.startActivity(intent)
            }
            2->{
                val pictureDialog = AlertDialog.Builder(this)
                val inflater = this.layoutInflater
                pictureDialog.setTitle("Print the Table")
                val view = inflater.inflate(R.layout.custom_dailoguebox, null)
                val temp = view.findViewById<EditText>(R.id.username).text

                pictureDialog.setView(view)

                pictureDialog.setPositiveButton(
                    "Submit"
                ) { dialog, which ->
                    val intent = Intent(this, PrintTable::class.java)
                    if (temp.isEmpty() || temp == null) {
                        Toast.makeText(this, "please enter a value", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    } else {
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("Number", Integer.parseInt(temp.toString()))
                        this.startActivity(intent)
                    }
                    dialog.dismiss()
                }
                pictureDialog.setNegativeButton(
                    "Cancel"
                ) { dialog, which ->
                    dialog.dismiss()
                }
                pictureDialog.show()
            }
            3->{
                val intent = Intent(this, AgeCalculatorActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)
            }
            4->{
                val intent = Intent(this, WorkingHourActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)
            }
            5->{
                val intent = Intent(this, RedirectActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)
            }
            7->{
                displayLanguaDailogue(true)
            }
            8->{
                val intent = Intent(this, ConnectionCheckActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)
            }
            9->{
                val intent = Intent(this, PushActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)

            }
            10->{
                val intent = Intent(this, TextToSpeech::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)

            }
            11->{
                val intent = Intent(this, LoadImageActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)

            }
            12->{
                val intent = Intent(this, VideoPlayActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)

            }
            13->{
                val intent = Intent(this, BottlomNavigationActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)
            }
            14->{
                val sh = getSharedPreferences(Constants.shred_pre_user_data, MODE_PRIVATE)
                if (sh.getBoolean("login",false)){
                    val intentsecond_activity = Intent(this, BottlomNavigationActivity::class.java)
                    startActivity(intentsecond_activity)
                }else{
                    val intent = Intent(this, SignUpBottomNavActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    this.startActivity(intent)
                }
            }
            15->{
                val intent = Intent(this, ViewPagerActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)
            }
            else->{

            }
        }
    }
    private fun toggleFlashLight(view: ToggleButton) {

        if (view.isChecked) {
            // Exception is handled, because to check
            // whether the camera resource is being used by
            // another service or not.
            try {
                // true sets the torch in ON mode
                cameraManager.setTorchMode(getCameraID, true)

                // Inform the user about the flashlight
                // status using Toast message
                Toast.makeText(this, "Flashlight is turned ON", Toast.LENGTH_SHORT)
                    .show()
            } catch (e: CameraAccessException) {
                // prints stack trace on standard error
                // output error stream
                e.printStackTrace()
            }
        } else {
            // Exception is handled, because to check
            // whether the camera resource is being used by
            // another service or not.
            try {
                // true sets the torch in OFF mode
                cameraManager.setTorchMode(getCameraID, false)

                // Inform the user about the flashlight
                // status using Toast message
                Toast.makeText(this, "Flashlight is turned OFF", Toast.LENGTH_SHORT)
                    .show()
            } catch (e: CameraAccessException) {
                // prints stack trace on standard error
                // output error stream
                e.printStackTrace()
            }
        }
    }

    // to display dia;pgue box to change the language
    fun displayLanguaDailogue(temp:Boolean): String? {
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("local", MODE_PRIVATE)
        var myEdit: SharedPreferences.Editor= sharedPreferences.edit()
        var  localLang=sharedPreferences.getString("local","English")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert !");
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.custom_dailoguebox_radio, null)
        val languageRG = view.findViewById<RadioGroup>(R.id.language_Group)
        if (localLang=="English"){
            languageRG.check(R.id.english)
            Log.e("reached","reched in if eng")
        }
//            if (Locale.getDefault().language=="hi"){
        if (localLang=="Hindi"){
            languageRG.check(R.id.hindi)
            Log.e("reached","reched in if hindi")
        }

        builder.setView(view)
        builder.setPositiveButton("Change"
        ) {
                dialog: DialogInterface?, which: Int ->
            when(languageRG.checkedRadioButtonId){
                R.id.english->{
                    Log.e("selected ","hello im in 1")
                    localLang="English"
                    myEdit.putString("local","English")
                    change(localLang!!)
                    myEdit.commit()
                }
                R.id .hindi->{
                    Log.e("selected ","hello im in 2")
                    localLang="Hindi"
                    myEdit.putString("local","Hindi")
                    change(localLang!!)
                    myEdit.commit()
                }
            }
            Log.e("selected ","${languageRG.checkedRadioButtonId}")

        }
        builder.setNegativeButton("Cancel"
        ) { dialog: DialogInterface, which: Int ->
            dialog.cancel()
        }
        myEdit.commit()
        Log.e("shp","${sharedPreferences.all}")
        val alertDialog = builder.create()
        alertDialog.show()
        return localLang
    }


    // to update the activity when locale get updated
    fun change(changer :String){
        if (changer=="English"){
            setAppLocale(this,"en")
            val intent = Intent(this, HomeActivity::class.java)
            Toast.makeText(this, "Reach to ENSLISH", Toast.LENGTH_SHORT)
                .show()
            Log.e("after dailoge","$changer")
            this.finish()
            this.startActivity(intent)
        }
        if (changer=="Hindi"){
            setAppLocale(this,"hi")
            val intent = Intent(this, HomeActivity::class.java)
            Toast.makeText(this, "hindi", Toast.LENGTH_SHORT)
                .show()
            Log.e("after dailoge","$changer")
            this.finish()
            this.startActivity(intent)
        }
    }
    // to change the locale language
    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
}
















//class HomeActivity : AppCompatActivity() {
//    lateinit var cameraManager:CameraManager
//    lateinit var getCameraID:String
//    lateinit var contextL: Context
//    lateinit var resource :Resources
//    lateinit var sharedPreferences : SharedPreferences
//
//    private lateinit var binding: ActivityHomeBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
//         cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
//        getCameraID = cameraManager.cameraIdList[0]
//        sharedPreferences=getSharedPreferences("local", MODE_PRIVATE)
////        localLang= sharedPreferences.getString("local","").toString()
//        // open signup form
//        binding.signUp.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        // open image picker
//        binding.imageSelector.setOnClickListener {
//            val imgintent = Intent(this, image_acrivity::class.java)
//            startActivity(imgintent)
//        }
//
//        //  table printer
//        binding.tablePrint.setOnClickListener {
//            val pictureDialog = AlertDialog.Builder(this)
//            val inflater = this.layoutInflater
//            pictureDialog.setTitle("Print the Table")
//            val view = inflater.inflate(com.sst.practiseapp.R.layout.custom_dailoguebox, null)
//            val temp = view.findViewById<EditText>(com.sst.practiseapp.R.id.username).text
//
//            pictureDialog.setView(view)
//
//            pictureDialog.setPositiveButton(
//                "Submit"
//            ) { dialog, which ->
//                val intent = Intent(this, PrintTable::class.java)
//                if (temp.isEmpty() || temp == null) {
//                    Toast.makeText(this, "please enter a value", Toast.LENGTH_SHORT).show()
//                    dialog.dismiss()
//                } else {
//                    intent.putExtra("Number", Integer.parseInt(temp.toString()))
//                    startActivity(intent)
//                }
//                dialog.dismiss()
//            }
//            pictureDialog.setNegativeButton(
//                "Cancel"
//            ) { dialog, which ->
//                dialog.dismiss()
//            }
//            pictureDialog.show()
//        }
//
//        // open age calculator
//        binding.birthdayCal.setOnClickListener {
//            val intent = Intent(this, AgeCalculatorActivity::class.java)
//            startActivity(intent)
//        }
//
//        // Working hour calculator
//        binding.workingHour.setOnClickListener {
//            val intent = Intent(this, WorkingHourActivity::class.java)
//            startActivity(intent)
//        }
//        // to open menu
//        binding.menu.setOnClickListener {
//            val popupMenu: PopupMenu = PopupMenu(this,binding.menu)
//            popupMenu.menuInflater.inflate(R.menu.homemenu,popupMenu.menu)
//            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
//                when(item.itemId) {
//                    R.id.share -> {
//                        Toast.makeText(this, "You Clicked : " + item.title, Toast.LENGTH_SHORT)
//                            .show()
//                        val text: String = "https://play.google.com/store/apps/details?id=com.sst.practice"
//                        val intentt = Intent(Intent.ACTION_SEND)
//                        intentt.type = "text/plain"
//                        intentt.putExtra(Intent.EXTRA_TEXT, text)
//                        startActivity(Intent.createChooser(intentt,"temp"))
//
//                    }
//                    R.id.copy -> {
//                        Toast.makeText(this, "You Clicked : " + item.title, Toast.LENGTH_SHORT).show()
//                        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                        val clip =ClipData.newPlainText("data","asgjkdfgasda sdfa sdfas df asdf asdf")
//                        clipboard.setPrimaryClip(clip)
//                    }
//                }
//                true
//            })
//            popupMenu.show()
//        }
//        // to redirect to other page
//        binding.redirection.setOnClickListener {
//            val intent =Intent(this, RedirectActivity::class.java)
//            startActivity(intent)
//        }
//        // yo turn on Flash
//        binding.onOffFlashlight.setOnCheckedChangeListener { compoundButton, b ->
//            toggleFlashLight(compoundButton)
//        }
//        binding.Localization.setOnClickListener {
//            displayLanguaDailogue(true)
//
//        }
//        binding.connection.setOnClickListener {
//            val intent =Intent(this,ConnectionCheckActivity::class.java)
//            startActivity(intent)
//        }
//
//        // to push notification
//
//        binding.pushNotification.setOnClickListener {
//            val intent =Intent(this,PushActivity::class.java)
//            startActivity(intent)
//        }
//
//        // text to speech
//        binding.textToSpeech.setOnClickListener {
//            val intent =Intent(this,TextToSpeech::class.java)
//            startActivity(intent)
//        }
//
//        // Load Image from link
//
//        binding.loadImage.setOnClickListener {
//            val intent =Intent(this,LoadImageActivity::class.java)
//            startActivity(intent)
//        }
//
//        // to  play video
//
//        binding.video.setOnClickListener {
//            val intent =Intent(this,VideoPlayActivity::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun toggleFlashLight(view: View?) {
//        Log.e("Flash" ,getCameraID)
//        if (binding.onOffFlashlight.isChecked) {
//            // Exception is handled, because to check
//            // whether the camera resource is being used by
//            // another service or not.
//            try {
//                // true sets the torch in ON mode
//                cameraManager.setTorchMode(getCameraID, true)
//
//                // Inform the user about the flashlight
//                // status using Toast message
//                Toast.makeText(this, "Flashlight is turned ON", Toast.LENGTH_SHORT)
//                    .show()
//            } catch (e: CameraAccessException) {
//                // prints stack trace on standard error
//                // output error stream
//                e.printStackTrace()
//            }
//        } else {
//            // Exception is handled, because to check
//            // whether the camera resource is being used by
//            // another service or not.
//            try {
//                // true sets the torch in OFF mode
//                cameraManager.setTorchMode(getCameraID, false)
//
//                // Inform the user about the flashlight
//                // status using Toast message
//                Toast.makeText(this, "Flashlight is turned OFF", Toast.LENGTH_SHORT)
//                    .show()
//            } catch (e: CameraAccessException) {
//                // prints stack trace on standard error
//                // output error stream
//                e.printStackTrace()
//            }
//        }
//    }
//    // checki INternet Connection
//    fun isNetworkAvailable(context: Context): Boolean {
//        val connectivityManager =
//            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
//        return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!
//            .isConnected
//    }
//    fun setAppLocale(context: Context, language: String) {
//        val locale = Locale(language)
//        Locale.setDefault(locale)
//        val config = context.resources.configuration
//        config.setLocale(locale)
//        context.createConfigurationContext(config)
//        context.resources.updateConfiguration(config, context.resources.displayMetrics)
//    }
//
//
//    fun displayLanguaDailogue(temp:Boolean): String? {
//        var myEdit:SharedPreferences.Editor= sharedPreferences.edit()
//        var  localLang=sharedPreferences.getString("local","English")
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Alert !");
//        val inflater = this.layoutInflater
//        val view = inflater.inflate(com.sst.practiseapp.R.layout.custom_dailoguebox_radio, null)
//        val languageRG = view.findViewById<RadioGroup>(com.sst.practiseapp.R.id.language_Group)
//        if (localLang=="English"){
//            languageRG.check(R.id.english)
//            Log.e("reached","reched in if eng")
//        }
////            if (Locale.getDefault().language=="hi"){
//        if (localLang=="Hindi"){
//            languageRG.check(R.id.hindi)
//            Log.e("reached","reched in if hindi")
//        }
//
//        builder.setView(view)
//        builder.setPositiveButton("Change"
//        ) {
//                dialog: DialogInterface?, which: Int ->
//            when(languageRG.checkedRadioButtonId){
//                R.id.english->{
//                    Log.e("selected ","hello im in 1")
//                    localLang="English"
//                    myEdit.putString("local","English")
//                    change(localLang!!)
//                    myEdit.commit()
//                }
//                R.id .hindi->{
//                    Log.e("selected ","hello im in 2")
//                    localLang="Hindi"
//                    myEdit.putString("local","Hindi")
//                    change(localLang!!)
//                    myEdit.commit()
//                }
//            }
//            Log.e("selected ","${languageRG.checkedRadioButtonId}")
//
//        }
//        builder.setNegativeButton("Cancel"
//        ) { dialog: DialogInterface, which: Int ->
//            dialog.cancel()
//        }
//        myEdit.commit()
//        Log.e("shp","${sharedPreferences.all}")
//        val alertDialog = builder.create()
//        alertDialog.show()
//        return localLang
//    }
//fun change(changer :String){
//    if (changer=="English"){
//        setAppLocale(this,"en")
//        val intent = Intent(this, HomeActivity::class.java)
//        Toast.makeText(this, "Reach to ENSLISH", Toast.LENGTH_SHORT)
//            .show()
//        Log.e("after dailoge","$changer")
//        finish()
//        startActivity(intent)
//    }
//    if (changer=="Hindi"){
//        setAppLocale(this,"hi")
//        val intent = Intent(this, HomeActivity::class.java)
//        Toast.makeText(this, "hindi", Toast.LENGTH_SHORT)
//            .show()
//        Log.e("after dailoge","$changer")
//        finish()
//        startActivity(intent)
//    }
//}
//    override fun finish() {
//        super.finish()
//        try {
//            // true sets the torch in OFF mode
//            cameraManager.setTorchMode(getCameraID, false)
//
//            // Inform the user about the flashlight
//            // status using Toast message
//            Toast.makeText(this, "Flashlight is turned OFF",Toast.LENGTH_SHORT ).show()
//        } catch (e: CameraAccessException) {
//            // prints stack trace on standard error
//            // output error stream
//            e.printStackTrace()
//        }
//    }
//
//}