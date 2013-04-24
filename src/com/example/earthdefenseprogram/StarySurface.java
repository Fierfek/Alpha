package com.example.earthdefenseprogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StarySurface extends SurfaceView implements SurfaceHolder.Callback {
	
	SGL thread;
	
	public StarySurface(Context context, AttributeSet attrs) {
		super(context);
		getHolder().addCallback(this);
		setFocusable(true);
	}
	
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		Stars.draw(canvas);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}

	@Override
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
}
