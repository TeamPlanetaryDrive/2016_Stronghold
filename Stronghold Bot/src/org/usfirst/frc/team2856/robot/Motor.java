package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.SpeedController;

public class Motor implements SpeedController{
	
	//Vars
	private SpeedController motor;
	//private 
	
	public void pidWrite(double output) {
		motor.pidWrite(output);
	}

	
	public double get(){return motor.get();}

	public void set(double speed, byte syncGroup){motor.set(speed, syncGroup);}

	/****CHANGED METHODS****/
	//Standard get
	public void set(double speed){motor.set(speed);}
	
	
	
	/**********************/
	
	
	public void setInverted(boolean isInverted){motor.setInverted(isInverted);}

	@Override
	public boolean getInverted() {return motor.getInverted();}

	@Override
	public void disable() {
		motor.set(0);
		motor.disable();
	}
	
}
