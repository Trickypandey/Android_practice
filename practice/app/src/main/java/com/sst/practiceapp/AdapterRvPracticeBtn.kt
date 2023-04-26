package com.sst.practiceapp

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.sst.practiseapp.R
import java.util.*


class AdapterRvPracticeBtn(private val list: ArrayList<PracticeBtn>, private val activity: Activity,private val recyclerViewClickInterface: RecyclerViewClickInterface):RecyclerView.Adapter <AdapterRvPracticeBtn.ViewHolder>() {
    lateinit var cameraManager: CameraManager
        lateinit var getCameraID:String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        cameraManager = activity.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        getCameraID = cameraManager.cameraIdList[0]
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclervie_layout,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    // view binder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=list[position]
        if (list[position].type=="Toggle"){
            holder.btn.visibility=View.GONE
            holder.tourch.setOnClickListener {
                recyclerViewClickInterface.onItemClick(position)
                toggleFlashLight(holder.tourch)
            }
        }
        else{
            holder.btn.text=currentItem.text
            holder.tourch.visibility=View.GONE
        }

        holder.btn.setOnClickListener {
            recyclerViewClickInterface.onItemClick(position)
        }




        // on click listener for btn in RV
//        holder.btn.setOnClickListener {
//            when(position){
//                0->{
//                    val intent = Intent(activity, MainActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    activity.startActivity(intent)
//                }
//                1->{
//                    val intent = Intent(activity, image_acrivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    activity.startActivity(intent)
//                }
//                2->{
//                    val pictureDialog = AlertDialog.Builder(activity)
//                    val inflater = activity.layoutInflater
//                    pictureDialog.setTitle("Print the Table")
//                    val view = inflater.inflate(com.sst.practiseapp.R.layout.custom_dailoguebox, null)
//                    val temp = view.findViewById<EditText>(com.sst.practiseapp.R.id.username).text
//
//                    pictureDialog.setView(view)
//
//                    pictureDialog.setPositiveButton(
//                        "Submit"
//                    ) { dialog, which ->
//                        val intent = Intent(activity, PrintTable::class.java)
//                        if (temp.isEmpty() || temp == null) {
//                            Toast.makeText(activity, "please enter a value", Toast.LENGTH_SHORT).show()
//                            dialog.dismiss()
//                        } else {
//                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            intent.putExtra("Number", Integer.parseInt(temp.toString()))
//                            activity.startActivity(intent)
//                        }
//                        dialog.dismiss()
//                    }
//                    pictureDialog.setNegativeButton(
//                        "Cancel"
//                    ) { dialog, which ->
//                        dialog.dismiss()
//                    }
//                    pictureDialog.show()
//                }
//                3->{
//                    val intent = Intent(activity, AgeCalculatorActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//                }
//                4->{
//                    val intent = Intent(activity, WorkingHourActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//                }
//                5->{
//                    val intent = Intent(activity, RedirectActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//                }
//                7->{
//                    displayLanguaDailogue(true)
//                }
//                8->{
//                    val intent = Intent(activity, ConnectionCheckActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//                }
//                9->{
//                    val intent = Intent(activity, PushActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//
//                }
//                10->{
//                    val intent = Intent(activity, TextToSpeech::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//
//                }
//                11->{
//                    val intent = Intent(activity, LoadImageActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//
//                }
//                12->{
//                    val intent = Intent(activity, VideoPlayActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                    activity.startActivity(intent)
//
//                }
//                else->{
//
//                }
//            }
//        }

    }


    // view holder for Recycler view Adapter
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val btn :Button=itemView.findViewById(R.id.btnHome)
        val tourch:ToggleButton = itemView.findViewById(R.id.tourch)

    }

    // to turn on the Flash Light
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
                Toast.makeText(activity, "Flashlight is turned ON", Toast.LENGTH_SHORT)
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
                Toast.makeText(activity, "Flashlight is turned OFF", Toast.LENGTH_SHORT)
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
       val sharedPreferences:SharedPreferences = activity.getSharedPreferences("local", MODE_PRIVATE)
        var myEdit: SharedPreferences.Editor= sharedPreferences.edit()
        var  localLang=sharedPreferences.getString("local","English")
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Alert !");
        val inflater = activity.layoutInflater
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
        setAppLocale(activity,"en")
        val intent = Intent(activity, HomeActivity::class.java)
        Toast.makeText(activity, "Reach to ENSLISH", Toast.LENGTH_SHORT)
            .show()
        Log.e("after dailoge","$changer")
        activity.finish()
        activity.startActivity(intent)
    }
    if (changer=="Hindi"){
        setAppLocale(activity,"hi")
        val intent = Intent(activity, HomeActivity::class.java)
        Toast.makeText(activity, "hindi", Toast.LENGTH_SHORT)
            .show()
        Log.e("after dailoge","$changer")
        activity.finish()
        activity.startActivity(intent)
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
