package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunTransit extends Command {

    public RunTransit() {
        // Use requires() here to declare subsystem dependencies
        //requires(Robot.hoppersystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.hopperSystem.transit();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    		//Robot.hopperSystem.stoptransit();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.hopperSystem.stoptransit();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.hopperSystem.stoptransit();
    }
}
