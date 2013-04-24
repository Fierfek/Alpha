package com.example.earthdefenseprogram;

import java.util.Random;

import com.example.earthdefenseprogram.model.Ship;
import android.content.Context;
import android.graphics.Bitmap;

public class Factory {
	
	static Enemies e;
	static Ship s;
	static Beams b;
	
	private static void newBeam(double x, double y, int type, boolean yourBeam) {
		switch(type) {
		case 0: b = new Beams(x, y, 6, yourBeam, 5, Assets.IMG_BEAM_BOLT); break;
		
		case 1: b = new Beams(x, y, 3.2, yourBeam, 10, Assets.IMG_BEAM_BOLT); break;

		case 2: b = new Beams(x, y, 3.2, yourBeam, .1, Assets.IMG_BEAM_PEN); break;
		
		case 3: b = new Beams(x, y, 2.0, yourBeam, 20, Assets.IMG_BEAM_EXPLODING); break;
		
		case 4: b = new Beams(x, y, 3.2, yourBeam, 5, Assets.IMG_BEAM_BOLT); break;
		
		case 5: b = new Beams(x, y, 3.2, yourBeam, 5, Assets.IMG_BEAM_BOLT); break;

		case 6: b = new Beams(x, y, 3.2, yourBeam, 5, Assets.IMG_BEAM_BOLT); break;
		}
	}
	
	public static void newEnemyBeam(double x, double y, int type){
		newBeam(x, y, type, false);
	}
	
	public static void newShipBeam(double x, double y, int type) {
		newBeam(x, y, type, true);
	}
	
	static void newEnemy(int type) {
		switch(type) {
		case 1: e = new Enemies(ranGenX(Assets.IMG_ENEMY_REDFIGHTER), 1, 5, Assets.IMG_ENEMY_REDFIGHTER, 1); break;
		
		case 2: e = new Enemies(ranGenX(Assets.IMG_ENEMY_REDFRIGATE), .7, 20, Assets.IMG_ENEMY_REDFRIGATE, 10); break;
		
		case 3: e = new Enemies(ranGenX(Assets.IMG_ENEMY_BLUEFIGHTER), .9, 15, Assets.IMG_ENEMY_BLUEFIGHTER, 3); break;
		
		case 4: e = new Enemies(ranGenX(Assets.IMG_ENEMY_BLUEFRIGATE), .6, 30, Assets.IMG_ENEMY_BLUEFRIGATE, 12); break;
		
		case 5: e = new Enemies(ranGenX(Assets.IMG_ENEMY_YELLOWFRIGATE), .7, 50, Assets.IMG_ENEMY_YELLOWFRIGATE, 20); break;
		
		case 6: e = new Enemies(ranGenX(Assets.IMG_ENEMY_YELLOWCRUISER), .5, 70, Assets.IMG_ENEMY_YELLOWCRUISER, 25); break;
		}
	}
	
	private static float ranGenX(Bitmap bi) {
		Random generator = new Random();
		return generator.nextInt(GameState.width - bi.getWidth()) + 1;
	}
	
	static Ship newShip(double startX, double startY) {
		return s = new Ship(startX, startY, GameState.shipBitmap, GameState.shipSpeed, GameState.shipArmor, GameState.shipHP, GameState.shipCannons);
	}
	
	static void newLevel(Context context, int lvl) {
		new BuildLevel().newLevel(context, lvl);
	}
}