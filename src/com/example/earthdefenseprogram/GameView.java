package com.example.earthdefenseprogram;

import com.example.earthdefenseprogram.model.Ship;
import com.example.earthdefenseprogram.model.ShipMovement;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{
	
	private Ship ship;
	SGL thread;
	
	public GameView(Context context, AttributeSet attrs) {
		super(context);
		getHolder().addCallback(this);
		Factory.newLevel(context, GameState.level);
		new ShipMovement();
		ship = Factory.newShip(GameState.startX, GameState.startY);
		GameState.pause = false;
		setFocusable(true);
	}

	public void surfaceChanged(SurfaceHolder arg0, int format, int width, int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		thread = new SGL(getHolder(), this);
		thread.setRunning(true);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while(retry) {
			try {
				thread.join();
				retry = false;
			} catch(InterruptedException e) {
				
			}
		}
	}
	
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
				ShipMovement.waypointX = event.getX();
				ShipMovement.waypointY = event.getY();
				ShipMovement.setDegrees(Math.toDegrees(Math.atan2(event.getY() - Ship.y, event.getX() - Ship.x)));
				ShipMovement.moving = true;
		}
		return true;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		ship.draw(canvas);
		Beams.draw(canvas);
		Stars.draw(canvas);
		Enemies.draw(canvas);
	}
}
