package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.subsystems.GearSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto1 extends Command {

    public Auto1() {
        requires(Robot.driveTrain);
        requires(Robot.feedSystem);
        requires(Robot.launchSystem);
        requires(Robot.gearSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearSystem.down();
    	//Put Something Here.
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
