package org.usfirst.frc.team2856.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class DriveTrain extends RobotDrive {

	SpeedController frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor;
	//PID control
//	PIDController fl, rl, fr, rr;

	public DriveTrain(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, SpeedController rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	}

	public DriveTrain(SpeedController[] wheels) {
		super(wheels[1], wheels[3]);// frontLeft, frontRight

		frontLeftMotor = wheels[0];
		rearLeftMotor = wheels[1];
		frontRightMotor = wheels[2];
		rearRightMotor = wheels[3];

	}

	public void drive(Joystick Stick) {
		
		if(Stick.getRawButton(3))
			super.arcadeDrive(Stick.getY(), 0);
		else
			super.arcadeDrive(Stick);
		
		rearRightMotor.set(frontRightMotor.get());
		rearLeftMotor.set(frontLeftMotor.get());
		
		
			
	}
	
	public void tankDrive(double xValue, double yValue){
		super.tankDrive(xValue, yValue);;
		//super.arcadeDrive(leftStick);
		
		rearRightMotor.set(frontRightMotor.get());
		rearLeftMotor.set(frontLeftMotor.get());
	}
	
/*PID METHODS IF ENCODERS ARE USED*/
//	public void initPID() {
//		fl = new PIDController(Kp, Ki, Kd, someEncoder, frontLeftMotor, period);
//		rl = new PIDController(Kp, Ki, Kd, someEncoder, frontLeftMotor, period);
//		fr = new PIDController(Kp, Ki, Kd, someEncoder, frontLeftMotor, period);
//		rr = new PIDController(Kp, Ki, Kd, someEncoder, frontLeftMotor, period);
//	}
//
//	public void togglePID() {
//		frontLeftMotor.pidWrite(fl.get());
//		rearLeftMotor.pidWrite(rl.get());
//		frontRightMotor.pidWrite(fr.get());
//		rearRightMotor.pidWrite(rr.get());
//	}

}
