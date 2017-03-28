package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForDistanceUpdated extends Command {
	CANTalon left;
	CANTalon right;
	double feet;
	double speed;
	double rots;
	double checks;
	

    public DriveForDistanceUpdated(double feet) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.feet = feet;
        
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.reset();
    	
    	Robot.driveTrain.motorL1.ClearIaccum();
    	Robot.driveTrain.motorR1.ClearIaccum();
    //	Robot.driveTrain.motorL2.ClearIaccum();
    	//Robot.driveTrain.motorR2.ClearIaccum();
    	
    	Robot.driveTrain.motorL1.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.motorR1.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.motorL2.changeControlMode(TalonControlMode.Follower);
    	Robot.driveTrain.motorR2.changeControlMode(TalonControlMode.Follower);
    	Robot.driveTrain.motorL2.set(Robot.driveTrain.motorL1.getDeviceID());
    	Robot.driveTrain.motorR2.set(Robot.driveTrain.motorR1.getDeviceID());
//    	
    	Robot.driveTrain.motorL1.configNominalOutputVoltage(+0, -0);
    	Robot.driveTrain.motorL2.configNominalOutputVoltage(+0, -0);
    	Robot.driveTrain.motorR1.configNominalOutputVoltage(+0, -0);
    	Robot.driveTrain.motorL2.configNominalOutputVoltage(+0, -0);
    	
    	Robot.driveTrain.motorL1.configMaxOutputVoltage(RobotMap.leftAvoltage);
    	Robot.driveTrain.motorL2.configMaxOutputVoltage(RobotMap.leftAvoltage);
    	Robot.driveTrain.motorR1.configMaxOutputVoltage(RobotMap.rightAvoltage);
    	Robot.driveTrain.motorR2.configMaxOutputVoltage(RobotMap.rightAvoltage);
    	
    	 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveSet(feet*.64);
    	SmartDashboard.putNumber("Progress", Robot.driveTrain.motorR1.getPosition());
    	SmartDashboard.putNumber("Progress2", Robot.driveTrain.motorL1.getPosition());
//    	if(Robot.driveTrain.motorL1.getPosition()<Robot.driveTrain.motorR1.getPosition()){ //This section compensates for drift
//    		RobotMap.leftvoltage = RobotMap.leftvoltage+.05;
//    		RobotMap.rightvoltage = RobotMap.rightvoltage-.05;
//    	} else if(Robot.driveTrain.motorL1.getPosition()>Robot.driveTrain.motorR1.getPosition()) {
//    		RobotMap.leftvoltage = RobotMap.leftvoltage-.05;
//    		RobotMap.rightvoltage = RobotMap.rightvoltage+.05;
//    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute() ||Robot.driveTrain.timedOut(.1,500)
    protected boolean isFinished() {
    	
    	
    	
    	if(checks>5){
    		checks = 0;
    		return true;
    	}
        if(Robot.driveTrain.motorL1.getPosition() < ((feet*.64)+.1) && Robot.driveTrain.motorL1.getPosition() > ((feet*.64)-.1) ){
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
    	
    	Robot.driveTrain.motorL1.configPeakOutputVoltage(RobotMap.leftvoltage, -RobotMap.leftvoltage);
    	Robot.driveTrain.motorL2.configPeakOutputVoltage(RobotMap.leftvoltage, -RobotMap.leftvoltage);
    	Robot.driveTrain.motorR1.configPeakOutputVoltage(RobotMap.rightvoltage, -RobotMap.rightvoltage);
    	Robot.driveTrain.motorR2.configPeakOutputVoltage(RobotMap.rightvoltage, -RobotMap.rightvoltage);
    	
    	Robot.driveTrain.motorL1.configMaxOutputVoltage(RobotMap.leftvoltage);
    	Robot.driveTrain.motorL2.configMaxOutputVoltage(RobotMap.leftvoltage);
    	Robot.driveTrain.motorR1.configMaxOutputVoltage(RobotMap.rightvoltage);
    	Robot.driveTrain.motorR2.configMaxOutputVoltage(RobotMap.rightvoltage);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.motorL1.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorR1.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorL2.changeControlMode(TalonControlMode.PercentVbus);
    	Robot.driveTrain.motorR2.changeControlMode(TalonControlMode.PercentVbus);
    	
    	Robot.driveTrain.motorL1.configPeakOutputVoltage(RobotMap.leftvoltage, -RobotMap.leftvoltage);
    	Robot.driveTrain.motorL2.configPeakOutputVoltage(RobotMap.leftvoltage, -RobotMap.leftvoltage);
    	Robot.driveTrain.motorR1.configPeakOutputVoltage(RobotMap.rightvoltage, -RobotMap.rightvoltage);
    	Robot.driveTrain.motorR2.configPeakOutputVoltage(RobotMap.rightvoltage, -RobotMap.rightvoltage);
    	
    	Robot.driveTrain.motorL1.configMaxOutputVoltage(RobotMap.leftvoltage);
    	Robot.driveTrain.motorL2.configMaxOutputVoltage(RobotMap.leftvoltage);
    	Robot.driveTrain.motorR1.configMaxOutputVoltage(RobotMap.rightvoltage);
    	Robot.driveTrain.motorR2.configMaxOutputVoltage(RobotMap.rightvoltage);
    	
    	
    }
}
