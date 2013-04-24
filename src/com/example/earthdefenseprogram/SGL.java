package com.example.earthdefenseprogram;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SGL extends Thread {
	static boolean running = false;
	public static boolean gameRunning = true;
	public static boolean done = false;
	static SurfaceHolder surfaceHolder;
	private static SurfaceView currentView;
	private static Canvas canvas;
	private static final String TAG = SGL.class.getSimpleName();
	
	
	long beginTime;
	long timeDiff;
	int sleepTime;
	int framesSkipped;
	private final static int MAX_FPS = 50;
	private final static int MAX_FRAME_SKIPS = 5;
	private final static int FRAME_PERIOD = 1000/MAX_FPS;
	//
	
	public SGL() {
		
	}
	
	public SGL(SurfaceHolder sh, SurfaceView gamePanel) {
		surfaceHolder = sh;
		currentView = gamePanel;
	}
	
	public static void setRunning(boolean r) {
		running = r;
	}
	
	public void run() {
		while(running) {
			try {
				canvas = surfaceHolder.lockCanvas();
				synchronized(surfaceHolder) {
					beginTime = System.currentTimeMillis();
					framesSkipped = 0;
					
					//do stuff here
					if(canvas != null)
						currentView.draw(canvas);
					if(!GameState.pause) {
						Runner.run();
					}
					Stars.update();
						
					timeDiff = System.currentTimeMillis() - beginTime;
					sleepTime = (int)(FRAME_PERIOD - timeDiff);
					
					if(sleepTime > 0) {
						try {
							Thread.sleep(sleepTime);
						} catch(InterruptedException e) {}
					}
					
					while(sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
						if(!GameState.pause) {
							Runner.run();
						}
						Stars.update();
						
						sleepTime += FRAME_PERIOD;
						framesSkipped ++;
					}
				}
			} finally {
				if (canvas != null) {
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
}
