package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

public class Teleop {

	//Variables
	DriveTrain dt;
	Joystick left, right;
	Victor roller;

	public Teleop(DriveTrain dt, Joystick left, Joystick right, Victor roller){//Arm arm
		//add vars
		this.dt = dt;
		this.left = left;
		this.right = right;
		this.roller = roller;
	}

	public void teleopLoop(){
		//TANKDRIVE 
		//note: they might actually want arcadeDrive
		dt.drive(left);

		//INTAKE
		if(left.getBumper()){//left bumper has priority
			roller.set(1);
		}else if(right.getBumper()){//right bumper 
			roller.set(-1);
		}else{//no bumper
			roller.set(0);
		}
	}
	
	public void autoLoop(String mode){
		//"+ up down - left right"   up 1 down 1 left 1 right 1
		String[] dir = mode.split(" ");
		String direction;
		double time, value;
		
		
		for(int i = 0; i < dir.length; i+=2){
			direction = dir[i];
			direction = direction.toLowerCase();
			value = Double.parseDouble(dir[i+1]);
			
			if(direction == "+"){
				
				long startTime = System.currentTimeMillis()/1000;
				long currTime = System.currentTimeMillis()/1000;
				long end = (long) Math.abs(value);
				
				while(currTime - startTime < Math.abs(value)){
					if(value<1)
						dt.arcadeDrive(-0.8, 0);
					else
						dt.arcadeDrive(0.8,0);
					
					currTime = System.currentTimeMillis()/1000;
				}
			}else if(direction == "-"){
				long startTime = System.currentTimeMillis()/1000;
				long currTime = System.currentTimeMillis()/1000;
				long end = (long) Math.abs(value);
				
				while(currTime - startTime < Math.abs(value)){
					if(value<1)
						dt.arcadeDrive(0, -0.8);
					else
						dt.arcadeDrive(0, 0.8);
					
					currTime = System.currentTimeMillis()/1000;
				}
			}
			
		}
		
		/*drive
		switch(mode){
			case "Mode1":
				long startTime = System.currentTimeMillis()/1000;
				long currTime = System.currentTimeMillis()/1000;
				
				while(currTime - startTime < 10){
					dt.arcadeDrive(0.8, 0);
					currTime = System.currentTimeMillis()/1000;
				}
				
				break;
			case "Mode2":
				
				
				break;
			default:
				
				
				break;
				
		}*/
		
		
	}

}
