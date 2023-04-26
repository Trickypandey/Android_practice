package com.sst.practiceapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sst.practiseapp.R
import com.sst.practiseapp.databinding.ActivityVideoPlayBinding


class VideoPlayActivity : AppCompatActivity() {
    lateinit var binding : ActivityVideoPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_video_play)
        clickall()
//        binding.mediaPlayer.setVideoPath("/sdcard/DCIM/Camera/VID_20230401_144728796.mp4")
    }
    fun clickall(){
        binding.loadlink.setOnClickListener {
            val videoUrl =
                binding.link.text.toString()
            val mediaController = MediaController(this)
            val uri = Uri.parse(videoUrl)
            binding.mediaplayer.setVideoURI(uri)
            binding.mediaplayer.setMediaController(mediaController)
            mediaController.setAnchorView(binding.mediaplayer)
            binding.mediaplayer.start()
        }
        binding.loadImageGl .setOnClickListener {
            openGalleryForVideo()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                if (data?.data != null) {
                    Log.e("video data","${data.data}")
                    binding.mediaplayer.setVideoURI(data.data)
                    binding.mediaplayer.start()
                }
            }
        }
    }
    private fun openGalleryForVideo() {
        val intent = Intent(Intent.ACTION_PICK,
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
        intent.type = "video/*"
        startActivityForResult(Intent.createChooser(intent, "Select Video"),1)
    }
}