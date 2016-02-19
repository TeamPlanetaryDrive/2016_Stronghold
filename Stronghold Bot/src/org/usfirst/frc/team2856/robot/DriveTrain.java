package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class DriveTrain extends RobotDrive{
	
	SpeedController frontLeftMotor, rearLeftMotor, frontRightMotor,rearRightMotor;
	
	public DriveTrain(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor,
			SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
		// TODO Auto-generated constructor stub
	}
	
	public DriveTrain(SpeedController[] wheels){
		super(wheels[1], wheels[3]);//left, right
		
		frontLeftMotor = wheels[0];
		rearLeftMotor = wheels[1];
		frontRightMotor = wheels[2];
		rearRightMotor = wheels[3];
		
	}
	
	public void drive(Joystick leftStick, Joystick rightStick){
		super.tankDrive(leftStick, rightStick);
		rearRightMotor.set(frontRightMotor.get());
		rearLeftMotor.set(frontLeftMotor.get());
		
	}
	
	
	
	
}
