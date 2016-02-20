package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class Arm {
	
	//two Victors the arm utilizes
	private SpeedController arm, winch;
	
	public Arm(SpeedController arm, SpeedController winch){
		this.arm = arm;
		this.winch = winch;
	}
	
	
	
	
	
}
