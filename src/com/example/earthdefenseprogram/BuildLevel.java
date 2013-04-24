package com.example.earthdefenseprogram;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.content.res.AssetManager;

public class BuildLevel {
	Timer timer = new Timer();
	Scanner scan;
	List<Integer> times = new ArrayList<Integer>();
	List<Integer> types = new ArrayList<Integer>();
	int Counter;
	AssetManager asset;
	
	public void newLevel(Context context, int lvl) {
		asset = context.getAssets();
		InputStream inFile = null;
		try {
			inFile = asset.open("Levels/lvl" + lvl + ".txt");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Thread.currentThread().getContextClassLoader().getResourceAsStream(Resource.levelsPath + "lvl" + lvl + ".txt");
		getData(inFile);
	}
	
	private void getData(InputStream iff) {
		
		scan = new Scanner(iff);
		while(scan.hasNext()) {
			times.add(scan.nextInt());
			types.add(scan.nextInt());
		}
		GameState.enemies = times.size();
		
		timer.schedule(new Task(), 1, 1000);
	}
	
	class Task extends TimerTask {
		public void run() {
			update();
		}
	}
	
	public void update() {
		if(GameState.pause == false) {
			Counter += 1;
			for(int i = 0; i < times.size(); i ++)
				if(Counter >= times.get(i)) {
					Factory.newEnemy(types.get(i));
					times.remove(i);
					types.remove(i);
					
					if(times.isEmpty()) {
						timer.cancel();
					}
				}
		}
	}
}