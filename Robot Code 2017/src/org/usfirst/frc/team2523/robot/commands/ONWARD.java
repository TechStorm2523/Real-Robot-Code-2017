package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ONWARD extends Command {

    public ONWARD() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.motorL1.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.motorR1.changeControlMode(TalonControlMode.Position);
    	Robot.driveTrain.motorL1.set(2.56);
    	Robot.driveTrain.motorR1.set(2.56);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.driveTrain.motorL1.getPosition()>2){
    		return true;
    	} else {
        return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
    
}
