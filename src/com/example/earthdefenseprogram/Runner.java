package com.example.earthdefenseprogram;

import java.util.ConcurrentModificationException;
import com.example.earthdefenseprogram.model.ShipMovement;

class Runner {
	public static void run() {
		try {
			Beams.update();
			ShipMovement.update();
			Enemies.update();
		} catch(ConcurrentModificationException e) {}
	}
}
