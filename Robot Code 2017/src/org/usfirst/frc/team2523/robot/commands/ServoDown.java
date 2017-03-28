package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ServoDown extends Command {

    public ServoDown() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.gearSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearSystem.down();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearSystem.down();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.gearSystem.down();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.gearSystem.down();
    }
}
