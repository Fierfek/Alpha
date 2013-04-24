package com.example.earthdefenseprogram;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import com.example.earthdefenseprogram.model.Ship;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Beams {
	protected static List<Beam> beams = new ArrayList<Beam>();
	private static final String TAG = Enemies.class.getSimpleName();
	
	private class Beam {
		double x, y;
		double speed;
		boolean down;
		double damage;
		Bitmap using;
	}
	
	public Beams(double X, double Y, double s, boolean b, double d, Bitmap bi) {
		Beam beam = new Beam();
		beam.x = X;
		beam.y = Y;
		beam.speed = s;
		beam.down = b;
		beam.damage = d;
		beam.using = bi;
		beams.add(beam);
	}

	public static void update() {
		for(Beam b : beams) {
			if(!b.down) {
				b.y += b.speed * GameState.scaleY;
				
				if(b.y > GameState.height || Ship.testShip((int)b.x, (int)b.y, b.damage))
					kill(b);
			} else {
				b.y -= b.speed * GameState.scaleY;
				
				if(b.y < 0 || Enemies.testMe((int)b.x, (int)b.y, b.damage))
					kill(b);
			}
		}
	}
	
	public static void kill(Beam b) {
		beams.remove(b);
	}

	public static void draw(Canvas canvas) {
		try {
			for(Beam b : beams) {
				canvas.drawBitmap(b.using, (float)b.x - b.using.getWidth()/2, (float)b.y - b.using.getHeight()/2 , null);
			}
		} catch (ConcurrentModificationException e) {}
	}
}