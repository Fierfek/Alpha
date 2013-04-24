package com.example.earthdefenseprogram.model;

import com.example.earthdefenseprogram.GameState;

public class ShipMovement {
	
	public static double waypointX, waypointY;
	static double degrees;
	public static boolean moving;
	
	public ShipMovement() {
		
	}
	
	public static void update() {
		if(moving) {
			if(Math.abs(waypointY - Ship.y) <= Ship.speed*GameState.scaleY && Math.abs(waypointX - Ship.x ) <= Ship.speed*GameState.scaleX) {
				Ship.x = waypointX;
				Ship.y = waypointY;
				Ship.updateRect();
				moving = false;
			} else {			
				Ship.x += (Ship.speed * GameState.scaleX) *  Math.cos(Math.toRadians(degrees));
				Ship.y += (Ship.speed * GameState.scaleY) * Math.sin(Math.toRadians(degrees));
				Ship.updateRect();
			}
		}
	}

	public static void setDegrees(double d) {
		degrees = d;
		if(degrees < 0) {
			degrees += 360;
		}
	}
}
