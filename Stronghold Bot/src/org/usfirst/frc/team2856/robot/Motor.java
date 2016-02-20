package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class Motor implements SpeedController{
	
	//Vars
	private SpeedController motor;
	
	/****MUTATORS****/
	//Standard set
	public void set(double speed){motor.set(speed);}
	
	public void pidWrite(double output) {motor.pidWrite(output);}
	/**********************/
	
	public double get(){return motor.get();}

	public void set(double speed, byte syncGroup){motor.set(speed, syncGroup);}
	
	public void setInverted(boolean isInverted){motor.setInverted(isInverted);}
	
	public boolean getInverted() {return motor.getInverted();}

	public void disable() {
		motor.set(0);
		motor.disable();
	}
	
}
