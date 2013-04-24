package com.example.earthdefenseprogram;

import com.example.earthdefenseprogram.model.Ship;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;

public class GameState {
	public static boolean gamePause = true;
	public static SGL thread = new SGL();
	public static Stars stars;
	public static int width, height;
	public static double startX, startY;
	static Intent intent;
	
	//Activities
	public static Main activityMain;
	public static GameActivity activityGame;
	public static UpgradeActivity activityUpgrade;
	
	//scales
	public static double scaleX;
	public static double scaleY;
	
	static int level = 1;
	static int wantedLevel;
	static boolean useWantedLevel = false;
	static int ship = 0;
	public static int enemies;
	public static int beamType = 0;
	static boolean pause = false;
	public static int yin;
	
	//Ship Attributes for initial load
	public static Bitmap shipBitmap;
	public static double shipSpeed;
	public static int shipArmor;
	public static int shipHP;
	public static int shipCannons;
	public static long rof = 1000;
	
	private static final String TAG = GameState.class.getSimpleName();
	
	GameState(int width2, int height2, Main m) {
		width = width2; height = height2;
		stars = new Stars(width, height, 50);
		activityMain = m;
		Assets.scaleImages(scaleX, scaleY);
		thread.start();
	}
	
	public static void LevelOver() {
		intent = new Intent(activityGame, UpgradeActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); 
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		if(enemies <= 0) {
			if(useWantedLevel == false)
				level ++;
			wantedLevel = level - 1;
			clean();
			activityGame.startActivity(intent);
		}
	}
	
	private static void clean() {
		Ship.shooting = false;
		SGL.setRunning(false);
		Beams.beams.clear();
	}
}
