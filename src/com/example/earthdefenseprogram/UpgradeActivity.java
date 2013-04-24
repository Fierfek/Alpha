package com.example.earthdefenseprogram;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UpgradeActivity extends Activity {
	
	Button nextLevel;
	Intent intent;
	
	protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.upgrademenu);
        GameState.activityUpgrade = this;
        
        intent = new Intent(this, GameActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        
        nextLevel = (Button) findViewById(R.id.nextLevel);
    	nextLevel.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				SGL.setRunning(false);
				startActivity(intent);
			}
    	});
    }
}
