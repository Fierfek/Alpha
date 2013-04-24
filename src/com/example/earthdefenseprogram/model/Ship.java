package com.example.earthdefenseprogram.model;

import com.example.earthdefenseprogram.Enemies;
import com.example.earthdefenseprogram.Factory;
import com.example.earthdefenseprogram.GameState;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Ship extends Thread {
	private static Bitmap using;
	public static double width, height;
	public static double x, y;
	static double speed = 3;
	static int armor, hp, cannons;
	private static Rect bound = new Rect();
	public static boolean shooting = true;
	
	private static final String TAG = Enemies.class.getSimpleName();
	
	public Ship(double X, double Y, Bitmap bitmap, double s, int a, int h, int c) {
		setBitmap(bitmap);
		x = X;
		y = Y;
		armor = a;
		hp = h;
		cannons = c;
		bound.set((int)x, (int)y, (int)x + bitmap.getWidth(), (int)y + bitmap.getHeight());
		shooting = true;
		start();
	}
	
	public Bitmap getBitmap() {
		return using;
	}
	
	public void setBitmap(Bitmap bitmap) {
		using = bitmap;
		width = bitmap.getWidth();
		height = bitmap.getHeight();
	}
	
	public static boolean testShip(int x, int y, double damage) {
		if(bound.contains(x, y)) {
			hp -= damage - armor;
			return true;
		} else {
			return false;
		}
	}
	
	public static void updateRect() {
		bound.set((int)x, (int)y, (int)x + using.getWidth(), (int)y + using.getHeight());
	}
	
	public void draw(Canvas canvas) {
		canvas.drawBitmap(using, (float)x - using.getWidth()/2, (float)y - using.getHeight()/2, null);
	}
	
	public void run() {
		while(shooting) {
			switch(cannons) {
			case 1: Factory.newShipBeam(x, y, 0); break;
			case 2: Factory.newShipBeam(x - using.getWidth()/2, y, 0); Factory.newShipBeam(x + using.getWidth()/2, y, 0); break;
			case 3: Factory.newShipBeam(x, y, 0); Factory.newShipBeam(x - using.getWidth()/2, y, 0); Factory.newShipBeam(x + using.getWidth()/2, y, 0); break;
			case 4: Factory.newShipBeam(x - using.getWidth()/2, y, 0); Factory.newShipBeam(x - 5, y, 0); Factory.newShipBeam(x + 5, y, 0); Factory.newShipBeam(x + using.getWidth()/2, y, 0); break;
			}
			
			try {
				Thread.sleep(GameState.rof);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}