package com.example.earthdefenseprogram;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Enemies {
	protected static List<Enemy> enemies = new ArrayList<Enemy>();
	private static final String TAG = Enemies.class.getSimpleName();
	static Rect bound = new Rect();
	
	public Enemies(float X, double s, double h, Bitmap bi, int r) {
		Enemy e = new Enemy();
		e.x = X;
		e.speed = s;
		e.health = h;
		e.using = bi;
		e.reward = r;
		e.bound.set((int)e.x, (int)e.y, (int)(e.x + e.using.getWidth()), (int)(e.y + e.using.getHeight()));
		enemies.add(e);
	}
	
	private class Enemy {
		float x, y = -30;
		double speed;
		double health;
		Bitmap using;
		int reward;
		Rect bound = new Rect();
	}
	
	public static boolean testMe(int x, int y, double damage) {
		for(Enemy e : enemies) {
			if(e.bound.contains(x, y)) {
				e.health -= damage;
				if(e.health <= 0)
					kill(e);
				return true;
			}
		}
		return false;
	}
	
	public static void kill(Enemy e) {
		enemies.remove(e);
		GameState.enemies --;
		GameState.LevelOver();
	}
	
	public static void update() {
		for(Enemy e : enemies) {
			e.y += e.speed * GameState.scaleY;
			
			e.bound.set((int)e.x, (int)e.y, (int)(e.x + e.using.getWidth()), (int)(e.y + e.using.getHeight()));
			
			if(e.y > GameState.height) {
				kill(e);
			}
		}
	}
	
	public static void draw(Canvas canvas) {
		try {
			for(Enemy e : enemies) {
				canvas.drawBitmap(e.using, e.x, e.y, null);
			}
		} catch (ConcurrentModificationException e) {}
	}
	
//	protected void fire() {
//		Factory.newEnemyBeam((int)x, (int)y, 1);
//	}
}