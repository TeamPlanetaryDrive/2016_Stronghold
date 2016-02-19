package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;

public class Teleop {
	
	//Variables
	DriveTrain dt;
	Joystick left, right;
	Victor roller;
	
	public Teleop(DriveTrain dt, Joystick left, Joystick right, Victor roller){
		//add vars
		this.dt = dt;
		this.left = left;
		this.right = right;
		this.roller = roller;
		
		
		
	}
	
	public void teleopLoop(){
		 dt.drive(left, right);//tankdrive
	        
	        if(left.getBumper()){
	        	roller.set(1);
	        }else if(right.getBumper()){
	        	roller.set(-1);
	        }else{
	        	roller.set(0);
	        }
	}
	
}
