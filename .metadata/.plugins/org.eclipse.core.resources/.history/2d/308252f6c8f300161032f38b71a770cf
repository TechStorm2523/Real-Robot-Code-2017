package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.OI;
import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.RobotMap;
import org.usfirst.frc.team2523.robot.commands.DriveRunner;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public boolean reversed = false;
	CANTalon motorL1 = new CANTalon(RobotMap.leftMotor1);
	CANTalon motorL2 = new CANTalon(RobotMap.leftMotor2);
	CANTalon motorR1 = new CANTalon(RobotMap.rightMotor1);
	CANTalon motorR2 = new CANTalon(RobotMap.rightMotor2);
	
	
	private final int RAMP_COEF = 0;
	private final int R_ACC_COEF = 0;
	
	private double vDriveFR;
	private double vDriveRO;
	
	RobotDrive driveControl = new RobotDrive(motorL1, motorL2, motorR1, motorR2);
	public DriveTrain(){
	driveControl.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
	driveControl.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
	}
	public double getLeftValue(){
		return motorL2.getPulseWidthPosition();
	}
	public double getRightValue(){
		return motorR2.getPulseWidthPosition();
	}
	public double getTrainValue(){ //Averages the drivetrain encoder values to get a single number.
								   //Change if not exact enough.
		return (motorL1.getPulseWidthPosition() + motorR1.getPulseWidthPosition())/2;
	}
	public void joyDrive(){
		
		driveControl.arcadeDrive(OI.controlStick.getY(),OI.controlStick.getTwist());
		
	}
	public void revJoyDrive(){
		driveControl.arcadeDrive(-OI.controlStick.getY(),-OI.controlStick.getTwist());
		
	}
	public void driveSet(double num){
		driveSet(num, num);
	}
	public void driveSet(double leftnum, double rightnum){
		motorL1.set(leftnum);
		motorL1.set(leftnum);
		motorL1.set(rightnum);
		motorL1.set(rightnum);
	}
	public void turnLeft(double num){
		driveSet(-num, num);
		
	}
	public void turnRight(double num){
		driveSet(num, -num);
		
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveRunner());
	}
}
