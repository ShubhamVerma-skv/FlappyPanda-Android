package com.example.program13_flappypanda;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;


public class GameActivity extends Activity {

    GameView gameView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        AppConstants.gameActivityContext = this;

        // Add the AdView to the view hierarchy. The view will have no size
        // until the ad is loaded.
        RelativeLayout layout = new RelativeLayout(this);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        gameView = new GameView(this); // Instantiate gameView
        // Define ad view parameters
        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layout.addView(gameView);
        // Set main renderer
        setContentView(layout);
    }
}
