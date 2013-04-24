package com.example.earthdefenseprogram;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity {
	
	Button start;
	Button instructions;
	Button settings;
	Button credits;
	Button blue;
	Button green;
	Button red;
	TextView pickShip;
	Display display;
	Intent intent;
	
	private static final String TAG = Main.class.getSimpleName();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double width = size.x;
        double height = size.y;
        
        //480, 800, setting speed scale
        GameState.scaleX = width/480;
        GameState.scaleY = height/800;
        GameState.startX = width/2;
        GameState.startY = height * .8;
        
        intent = new Intent(Main.this, GameActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		setContentView(R.layout.menu);
        new Assets(this);
        new GameState((int)width, (int)height, this);
        setupGUI();
    }
    
    void setupGUI() {
    	pickShip = (TextView) findViewById(R.id.pickShip);
    	pickShip.setVisibility(View.INVISIBLE);
    	blue = (Button) findViewById(R.id.BlueButton);
    	blue.setEnabled(false);
    	blue.setVisibility(View.INVISIBLE);
    	green = (Button) findViewById(R.id.GreenButton);
    	green.setEnabled(false);
    	green.setVisibility(View.INVISIBLE);
    	red = (Button) findViewById(R.id.RedButton);
    	red.setEnabled(false);
    	red.setVisibility(View.INVISIBLE);
    	
    	green.setWidth(GameState.width/3);
    	blue.setWidth(green.getLeft());
    	red.setWidth(green.getLeft() + (green.getLeft() - green.getRight()));
    	
    	start = (Button) findViewById(R.id.Start);
    	start.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				pickShip.setVisibility(View.VISIBLE);
				start.setVisibility(View.INVISIBLE);
				instructions.setVisibility(View.INVISIBLE);
				settings.setVisibility(View.INVISIBLE);
				credits.setVisibility(View.INVISIBLE);
				blue.setVisibility(View.VISIBLE);
				blue.setEnabled(true);
				green.setVisibility(View.VISIBLE);
				green.setEnabled(true);
				red.setVisibility(View.VISIBLE);
				red.setEnabled(true);
			}
    	});
    	
    	instructions = (Button) findViewById(R.id.Instructions);
    	instructions.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
			}
    	});
    	
    	settings = (Button) findViewById(R.id.Settings);
    	settings.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			
    		}
    	});
    	
    	credits = (Button) findViewById(R.id.Credits);
    	credits.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			
    		}
    	});
    	
    	blue.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			SGL.setRunning(false);
    			setShipStats(Assets.IMG_SHIP_BLUEFIGHTER, 3, 1, 70, 1);
    			startActivity(intent);
    		}
    	});
    	
    	green.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			SGL.setRunning(false);
    			setShipStats(Assets.IMG_SHIP_GREENFIGHTER, 2, 2, 100, 1);
    			startActivity(intent);
    		}
    	});
    	
    	red.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    			SGL.setRunning(false);
    			setShipStats(Assets.IMG_SHIP_REDFIGHTER, 1, 3, 150, 2);
    			startActivity(intent);
    		}
    	});
    }
    
    private void setShipStats(Bitmap b, double speed, int armor, int hp, int cannons) {
    	GameState.shipBitmap = b;
		GameState.shipSpeed = speed;
		GameState.shipArmor = armor;
		GameState.shipHP = hp;
		GameState.shipCannons = cannons;
    }
}