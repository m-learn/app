package com.example.salman.myfypapp;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class HtmlBasic extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htmlbasic);

        VideoView videoView =(VideoView)findViewById(R.id.videoView);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r6---sn-5hnedn7s.googlevideo.com/Cj0LENy73wIaNAmqlTKN6k3WIhMYDSANFC295dZWMOCoAUIASARgvs7PsoOH9epWigELV09yVV9YYzRoWGsM/E408B0004CE9DE9719462D8DBB3B3FA7C9F432D1.8508973D203D8BF5B70C69E61AD600243666ADD3/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }



}