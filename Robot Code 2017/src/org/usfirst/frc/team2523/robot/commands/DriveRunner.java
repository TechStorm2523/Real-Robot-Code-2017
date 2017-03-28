package org.usfirst.frc.team2523.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2523.robot.Robot;
import org.usfirst.frc.team2523.robot.subsystems.DriveTrain;

/**
 *
 */
public class DriveRunner extends Command {
	private final int RAMP_COEF = 0;
	private final int R_ACC_COEF = 0;
	
	private double vDriveFR;
	private double vDriveRO;
	
	public DriveRunner() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
			Robot.driveTrain.joyDrive();
			
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
