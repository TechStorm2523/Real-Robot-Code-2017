package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.OI;
import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.RobotMap;
import org.usfirst.frc.team2523.robot.commands.DriveRunner;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public boolean reversed = false;
	public CANTalon motorL1 = new CANTalon(RobotMap.leftMotor1);
	public CANTalon motorL2 = new CANTalon(RobotMap.leftMotor2);
	public CANTalon motorR1 = new CANTalon(RobotMap.rightMotor1);
	public CANTalon motorR2 = new CANTalon(RobotMap.rightMotor2);
	
	
	private final int RAMP_COEF = 0;
	private final int R_ACC_COEF = 0;
	
	private double vDriveFR;
	private double vDriveRO;
	
	double prevLeftError = 0;
	double prevRightError = 0;
	double changeInError;
	double RowchecksWnoChange;
	
	RobotDrive driveControl = new RobotDrive(motorL1, motorL2, motorR1, motorR2);
	public DriveTrain(){
	
	driveControl.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
	driveControl.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
	motorR1.reverseOutput(true);
	motorR1.reverseSensor(false);
	motorL1.reverseSensor(true);
//	motorL2.reverseSensor(true);
	
	}
	public boolean timedOut(double margin, double tmargin){
		
		
		double lset = motorL1.getSetpoint();
		double lcurrent = motorL1.getEncPosition();
		
		double rset = motorR1.getSetpoint();
		double rcurrent = motorR1.getEncPosition();
		
		double lerr = Math.abs(lset-lcurrent);
		double rerr = Math.abs(rset-rcurrent);
		
		changeInError = ((prevLeftError+prevRightError)/2)-((lerr+rerr)/2);
		
		
		if((changeInError<=margin) && (RowchecksWnoChange<=tmargin)){
			return true;
		} else {
			RowchecksWnoChange++;
			return false;
		}
		
		
		
		
		
	}
	public boolean onTarget(double margin){
		
		boolean rOnT = false;
		boolean lOnT = false;
		
		double lset = motorL1.getSetpoint();
		double lcurrent = motorL1.getEncPosition();
		
		double rset = motorR1.getSetpoint();
		double rcurrent = motorR1.getEncPosition();
		
		double lerr = Math.abs(lset-lcurrent);
		double rerr = Math.abs(rset-rcurrent);
		
		
		
		if(lerr<margin){
			lOnT = true;
		}
		if(rerr<margin){
			rOnT = true;
		}
		if(rOnT&&lOnT){
			return true;
		} else {
			return false;
		}
		
		
		
		
		
	}
	public void reset(){
		motorL1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
		motorR1.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Absolute);
		motorL1.setPosition(0);
		motorR1.setPosition(0);
		
	}
	public double getLeftValue(){
		return motorL1.getPosition();
	}
	public double getRightValue(){
		return motorR1.getPosition();
	}
	public double getTrainValue(){ //Averages the drivetrain encoder values to get a single number.
								   //Change if not exact enough.
		return (motorL1.getPulseWidthPosition() + motorR1.getPulseWidthPosition())/2;
	}
	public void joyDrive(){
		//SmartDashboard.putNumber("Pulses", getTrainValue());
		SmartDashboard.putNumber("Pulses L", getLeftValue());
		SmartDashboard.putNumber("Pulses R", getRightValue());
		driveControl.arcadeDrive(OI.controlStick.getY()*RobotMap.speedMod,OI.controlStick.getTwist()/1.4);
		
	}
	public void revJoyDrive(){
		driveControl.arcadeDrive(-OI.controlStick.getY(),-OI.controlStick.getTwist()/1.4);
		
	}
	public void driveSet(double num){
		driveSet(num, num);
	}
	public void driveSet(double leftnum, double rightnum){
		motorL1.set(leftnum);
		motorL2.set(leftnum);
		motorR1.set(rightnum);
		motorR2.set(rightnum);
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
