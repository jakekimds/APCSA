package jk;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import robocode.*;
import robocode.robotinterfaces.IInteractiveEvents;

public class ControlBot extends Robot implements IInteractiveEvents{
	
	public void run() {
		while(true) {
			turnGunLeft(0);
		}
	}
	
	public void onKeyPressed(KeyEvent e){
		ahead(100);
	}
}