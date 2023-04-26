package com.sst.practiceapp

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityTextToSpeechBinding
import java.util.*


class TextToSpeech : AppCompatActivity(),TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    lateinit var list : kotlin.collections.List<String>
    var lengthOFlist :Int = 0
    var temp=0
    private lateinit var binding: ActivityTextToSpeechBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_text_to_speech)
        binding.actionBarBack.setOnClickListener {
            finish()
        }
        // TextToSpeech(Context: this, OnInitListener: this)
        tts = TextToSpeech(this,this)
        binding.speak.setOnClickListener {
            temp=0
            val text = binding.editText.text.toString()
            list=getStringFromSb(text,50)
            lengthOFlist=list.size

            speakOut(list[temp])
        }
    }


    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // set US English as language for tts
            val result = tts!!.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            } else {
                binding.speak.isEnabled = true
                tts!!.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String) {
                        Log.i("TextToSpeech", "On Start")
                    }
                    override fun onDone(utteranceId: String) {
                        if (temp<=lengthOFlist){
                            temp++
                            speakOut(list[temp])
                        }
                    }
                    override fun onError(utteranceId: String) {
                        Log.i("TextToSpeech", "On Error")
                    }
                })
            }
        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }

    private fun speakOut(text :String) {
        if (text.length!=0){
            tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null,"")
        }
        else{
            Toast.makeText(this, "String is over", Toast.LENGTH_SHORT).show()
        }
    }
    public override fun onDestroy() {
        // Shutdown TTS
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
    fun getStringFromSb(sb: String, stringLength: Int): kotlin.collections.List<String> {
        var returnStr= mutableListOf<String>()
        var empty= mutableListOf<String>()
        var pos=0
        sb.split(".").forEach{
            empty.add(it)
        }
        for (i in 0 until  sb.length/stringLength)
        {
            returnStr.add(sb.substring(pos, pos+stringLength))
            pos+=stringLength
        }
        Log.e("list of string ","$empty")
        return empty
    }

}