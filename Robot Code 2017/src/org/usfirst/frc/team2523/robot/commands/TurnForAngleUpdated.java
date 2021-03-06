package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnForAngleUpdated extends Command {
	CANTalon left;
	CANTalon right;
	double angle;
	double speed;
	double rots;
	int checks = 0;
	//Diam of robot turn circum = 29 inches
	//Circum = 29pi
	//Diam of robot wheels = 6 inches
	//Circum = 6pi inches
	//4.833pi rotations per full turn
	//Rotations per full turn: 15.1839166666
	//Rots per degree of turn: 0.042177546296
	

    public TurnForAngleUpdated(double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.angle = angle;
        
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.reset();
    	
    	Robot.driveTrain.motorL1.ClearIaccum();
    	Robot.driveTrain.motorR1.ClearIaccum();
    	Robot.driveTrain.motorL2.ClearIaccum();
    	Robot.driveTrain.motorR2.ClearIaccum();
    	
    	Robot.driveTrain.motorL1.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.motorR1.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.motorL2.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.motorR2.changeControlMode(TalonControlMode.Position);
//    	
//    	Robot.driveTrain.motorL1.configNominalOutputVoltage(+0, -0);
//    	Robot.driveTrain.motorL2.configNominalOutputVoltage(+0, -0);
//    	Robot.driveTrain.motorR1.configNominalOutputVoltage(+0, -0);
//    	Robot.driveTrain.motorL2.configNominalOutputVoltage(+0, -0);
//    	
//    	Robot.driveTrain.motorL1.configPeakOutputVoltage(+12, -12);
//    	Robot.driveTrain.motorL2.configPeakOutputVoltage(+12, -12);
//    	Robot.driveTrain.motorR1.configPeakOutputVoltage(+12, -12);
//    	Robot.driveTrain.motorR2.configPeakOutputVoltage(+12, -12);
    	 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.driveTrain.driveSet(angle*0.013426,-angle*0.013426);
    	SmartDashboard.putNumber("Progress", Robot.driveTrain.motorR1.getPosition());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if(checks>10){
    		checks = 0;
    		return true;
    	}
        if(Robot.driveTrain.motorL1.getPosition() < ((angle*0.013426)+.1) && Robot.driveTrain.motorL1.getPosition() > ((angle*0.013426)-.1) ){
        	checks++; //Allows for a 1/10 of a turn in error
        	return false;
        } else {
        	return false;
        }
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.motorL1.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorR1.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorL2.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorR2.changeControlMode(TalonControlMode.PercentVbus);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.motorL1.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorR1.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorL2.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorR2.changeControlMode(TalonControlMode.PercentVbus);
    	
    }
}
