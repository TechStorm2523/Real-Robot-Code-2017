package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**Desc:
 * This method exists as a fallback, and if it's in use,
 * I've not managed to make the encoder based program work.
 * 
 *
 */
public class DforDFallback extends Command {
	double FeetPerSec = 10;
	double FeetPerSecLocal;
	double speed;
	double feet;
	double time2go;

    public DforDFallback(double feet, double speed) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.speed = speed;
        this.feet = feet;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	FeetPerSecLocal = FeetPerSec*speed;
    	time2go = feet*FeetPerSecLocal;
    //	Robot.driveTrain.driveSet(num); //Change this to individual if robot spins around
    	Timer.delay(time2go);
    	Robot.driveTrain.driveSet(0);
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
    	Robot.driveTrain.driveSet(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.driveSet(0);
    }
}
