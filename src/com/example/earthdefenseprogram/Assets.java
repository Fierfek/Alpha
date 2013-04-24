package com.example.earthdefenseprogram;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Assets {
	
	InputStream i;
	static OutputStreamWriter o;
	static AssetManager asset;
	
	public static Bitmap IMG_ENEMY_REDFIGHTER;
	public static Bitmap IMG_ENEMY_REDFRIGATE;
	public static Bitmap IMG_ENEMY_BLUEFIGHTER;
	public static Bitmap IMG_ENEMY_BLUEFRIGATE;
	public static Bitmap IMG_ENEMY_YELLOWFRIGATE;
	public static Bitmap IMG_ENEMY_YELLOWCRUISER;
	public static Bitmap IMG_ENEMY_BOSSONE;
	public static Bitmap IMG_ENEMY_BOSSTWO;
	public static Bitmap IMG_ENEMY_BOSSTHREE;
	public static Bitmap IMG_ENEMY_BOSSFINAL;
	public static Bitmap IMG_SHIP_GREENFIGHTER;
	public static Bitmap IMG_SHIP_GREENFRIGATE;
	public static Bitmap IMG_SHIP_GREENCRUISER;
	public static Bitmap IMG_SHIP_REDFIGHTER;
	public static Bitmap IMG_SHIP_REDFRIGATE;
	public static Bitmap IMG_SHIP_REDCRUISER;
	public static Bitmap IMG_SHIP_BLUEFIGHTER;
	public static Bitmap IMG_SHIP_BLUEFRIGATE;
	public static Bitmap IMG_SHIP_BLUECRUISER;
	public static Bitmap IMG_BEAM_BOLT;
	public static Bitmap IMG_BEAM_PEN;
	public static Bitmap IMG_BEAM_POISON;
	public static Bitmap IMG_BEAM_WAVE;
	public static Bitmap IMG_BEAM_EXPLODING;
	public static Bitmap IMG_MENU_DAMAGE;
	public static Bitmap IMG_MENU_HEALTH;
	public static Bitmap IMG_MENU_SPEED;
	public static Bitmap IMG_MENU_PEN;
	public static Bitmap IMG_MENU_POISON;
	public static Bitmap IMG_MENU_WAVE;
	public static Bitmap IMG_MENU_EXPLODING;
	public static boolean loaded;
	
	
	Assets(Context context) {
		asset = context.getAssets();
		
		try {
			IMG_ENEMY_REDFIGHTER = loadAsset("redFighter.png"); i.close();
			IMG_ENEMY_REDFRIGATE = loadAsset("redHeavy.png"); i.close();
			IMG_ENEMY_BLUEFIGHTER = loadAsset("blueFighter.png"); i.close();
			IMG_ENEMY_BLUEFRIGATE = loadAsset("blueHeavy.png"); i.close();
			IMG_ENEMY_YELLOWFRIGATE = loadAsset("medYellow.png"); i.close(); 
			IMG_ENEMY_YELLOWCRUISER = loadAsset("bigYellow.png"); i.close();
			IMG_ENEMY_BOSSONE = loadAsset("boss_one.png"); i.close();
			IMG_ENEMY_BOSSTWO = loadAsset("boss_two.png"); i.close();
			IMG_ENEMY_BOSSTHREE = loadAsset("boss_three.png"); i.close();
			IMG_ENEMY_BOSSFINAL = loadAsset("boss_four.png"); i.close();
			IMG_SHIP_GREENFIGHTER = loadAsset("smallGreenArmor.png"); i.close();
			IMG_SHIP_GREENFRIGATE = loadAsset("medGreenArmor.png"); i.close();
			IMG_SHIP_GREENCRUISER = loadAsset("largeGreenArmor.png"); i.close();
			IMG_SHIP_REDFIGHTER = loadAsset("smallRedArmor.png"); i.close();
			IMG_SHIP_REDFRIGATE = loadAsset("medRedArmor.png"); i.close();
			IMG_SHIP_REDCRUISER = loadAsset("largeRedArmor.png"); i.close();
			IMG_SHIP_BLUEFIGHTER = loadAsset("smallBlueArmor.png"); i.close();
			IMG_SHIP_BLUEFRIGATE = loadAsset("medBlueArmor.png"); i.close();
			IMG_SHIP_BLUECRUISER = loadAsset("largeBlueArmor.png"); i.close();
			IMG_BEAM_BOLT = loadAsset("dropBolt.png"); i.close();
			IMG_BEAM_PEN = loadAsset("dropPen.png"); i.close();
			IMG_BEAM_POISON = loadAsset("dropPoison.png"); i.close();
			IMG_BEAM_WAVE = loadAsset("dropWave.png"); i.close();
			IMG_BEAM_EXPLODING = loadAsset("dropExploding.png"); i.close();
			IMG_MENU_DAMAGE = loadAsset("damage.png"); i.close();
			IMG_MENU_HEALTH = loadAsset("health.png"); i.close();
			IMG_MENU_SPEED = loadAsset("speed.png"); i.close();
			IMG_MENU_PEN = loadAsset("menuPierce.png"); i.close();
			IMG_MENU_POISON = loadAsset("menuPierce.png"); i.close();
			IMG_MENU_WAVE = loadAsset("menuWave.png"); i.close();
			IMG_MENU_EXPLODING = loadAsset("menuExplosive.png"); i.close();			
		} catch (IOException e) {}
		loaded = true;
	}

	private Bitmap loadAsset(String imgName) throws IOException {
		i = asset.open("Images/" + imgName);
		return BitmapFactory.decodeStream(i);
	}
	
	public static void scaleImages(double scaleX, double scaleY) {
		IMG_ENEMY_REDFIGHTER = scaleThis(IMG_ENEMY_REDFIGHTER, scaleX, scaleY);
		IMG_ENEMY_REDFRIGATE = scaleThis(IMG_ENEMY_REDFRIGATE, scaleX, scaleY);
		IMG_ENEMY_BLUEFIGHTER = scaleThis(IMG_ENEMY_BLUEFIGHTER, scaleX, scaleY);
		IMG_ENEMY_BLUEFRIGATE = scaleThis(IMG_ENEMY_BLUEFRIGATE, scaleX, scaleY);
		IMG_ENEMY_YELLOWFRIGATE = scaleThis(IMG_ENEMY_YELLOWFRIGATE, scaleX, scaleY);
		IMG_ENEMY_YELLOWCRUISER = scaleThis(IMG_ENEMY_YELLOWCRUISER, scaleX, scaleY);
		IMG_ENEMY_BOSSONE = scaleThis(IMG_ENEMY_BOSSONE, scaleX, scaleY);
		IMG_ENEMY_BOSSTWO = scaleThis(IMG_ENEMY_BOSSTWO, scaleX, scaleY);
		IMG_ENEMY_BOSSTHREE = scaleThis(IMG_ENEMY_BOSSTHREE, scaleX, scaleY);
		IMG_ENEMY_BOSSFINAL = scaleThis(IMG_ENEMY_BOSSFINAL, scaleX, scaleY);
		IMG_SHIP_GREENFIGHTER = scaleThis(IMG_SHIP_GREENFIGHTER, scaleX, scaleY);
		IMG_SHIP_GREENFRIGATE = scaleThis(IMG_SHIP_GREENFRIGATE, scaleX, scaleY);
		IMG_SHIP_GREENCRUISER = scaleThis(IMG_SHIP_GREENCRUISER, scaleX, scaleY);
		IMG_SHIP_REDFIGHTER = scaleThis(IMG_SHIP_REDFIGHTER, scaleX, scaleY);
		IMG_SHIP_REDFRIGATE = scaleThis(IMG_SHIP_REDFRIGATE, scaleX, scaleY);
		IMG_SHIP_REDCRUISER = scaleThis(IMG_SHIP_REDCRUISER, scaleX, scaleY);
		IMG_SHIP_BLUEFIGHTER = scaleThis(IMG_SHIP_BLUEFIGHTER, scaleX, scaleY);
		IMG_SHIP_BLUEFRIGATE = scaleThis(IMG_SHIP_BLUEFRIGATE, scaleX, scaleY);
		IMG_SHIP_BLUECRUISER = scaleThis(IMG_SHIP_BLUECRUISER, scaleX, scaleY);
		IMG_BEAM_BOLT = scaleThis(IMG_BEAM_BOLT, scaleX, scaleY);
		IMG_BEAM_PEN = scaleThis(IMG_BEAM_PEN, scaleX, scaleY);
		IMG_BEAM_POISON = scaleThis(IMG_BEAM_POISON, scaleX, scaleY);
		IMG_BEAM_WAVE = scaleThis(IMG_BEAM_WAVE, scaleX, scaleY);
		IMG_BEAM_EXPLODING = scaleThis(IMG_BEAM_EXPLODING, scaleX, scaleY);
		IMG_MENU_DAMAGE = scaleThis(IMG_MENU_DAMAGE, scaleX, scaleY);
		IMG_MENU_HEALTH = scaleThis(IMG_MENU_HEALTH, scaleX, scaleY);
		IMG_MENU_SPEED = scaleThis(IMG_MENU_SPEED, scaleX, scaleY);
		IMG_MENU_PEN = scaleThis(IMG_MENU_PEN, scaleX, scaleY);
		IMG_MENU_POISON = scaleThis(IMG_MENU_POISON, scaleX, scaleY);
		IMG_MENU_WAVE = scaleThis(IMG_MENU_WAVE, scaleX, scaleY);
		IMG_MENU_EXPLODING = scaleThis(IMG_MENU_EXPLODING, scaleX, scaleY);
	}
	
	private static Bitmap scaleThis(Bitmap b, double scaleX, double scaleY) {
		return Bitmap.createScaledBitmap(b, (int)(b.getWidth() * scaleX), (int)(b.getHeight() * scaleY), true);
	}

	public static void printErrorToFile(String str) {
//		try {
//			o = new OutputStreamWriter(openFileOutput("Errors.txt",0));
//			o.write(str);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
	}
}
