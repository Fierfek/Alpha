package com.example.earthdefenseprogram;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Stars {
	static Star s;
	private static int width;
	private static int height;
	private int arraySize;
	private static Star[] starArray;
	static Paint p;
	
	private static final String TAG = Stars.class.getSimpleName();
	
	public Stars(int w, int h, int number) {
		width = w;
		height = h;
		arraySize = number;
		init();
		p = new Paint();
		p.setColor(Color.WHITE);
	}
	
	private class Star {
		int x, y;
		int size;
		int dir;
	}
	
	void init() {
		//Log.d(TAG, "Y:" + GameState.scaleY + " X:" + GameState.scaleX);
		starArray = new Star[arraySize];
		for(int i = 0; i < 50; i ++) {
			s = new Star();
			s.x = (int)(Math.random() * width);
			s.y = (int)(Math.random() * height);
			s.size = 1 + (int)(Math.random() * 4);
			s.dir = (int) ((1 + (int)(Math.random() * s.size))*GameState.scaleY);
			starArray[i] = s;
		}
	}
	
	public static void draw(Canvas canvas) {
		for(Star s : starArray) {
			canvas.drawCircle(s.x, s.y, s.size, p);
		}
	}
	
	public static void update() {
		for(Star s : starArray) {
			s.y += s.dir;
			
			if (s.y > height) {
				s.y = 0;
				s.x = (int)(Math.random() * width);
			}
		}
	}
}