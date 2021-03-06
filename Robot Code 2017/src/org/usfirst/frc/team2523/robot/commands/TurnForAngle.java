package org.usfirst.frc.team2523.robot.commands;

import org.usfirst.frc.team2523.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**Simple Drive Macro That takes a number of Rotational Degrees as a parameter.
 * Info: 1 rotation of a 6 inch diameter wheel covers 1.57083333333 feet
 * Info: 2607.5331564987 encoder pulses per foot. Gonna have to round up to 2608 per foot,
 * unless a decimal solution becomes apparent.
 *
 * Info: Pulses Per Angle of Rotation: 60.69
 *
 */
public class TurnForAngle extends Command {
	private int PulsesPerDegree = 61;
	private int pulses;
	private int PulsesAtCMDStart; //Not Used In New Version
	private int PulsesThisCheck; // Number of new pulses this check.
	private int TotalPulses = 0; //Pulses Before Addition of Rollover.
	private int GrandTotalPulses; //Pulses after Rolliver is added.
	private int RolloverPulses = 0; //Number of pulses from pre
	private double traveledDegrees; //Number of feet traveled. Final Result.
	private int numResets = 0; //Number of completed rotations.
	private double targetDegrees; // Target number of feet.
	private double maxSPD; // Used to limit motor speed for more precise, careful movement.
	private double totalPulsesPrevCheck = 0; //Obselete. Kept around in case it is needed.
	private int direc = 0;
	
    public TurnForAngle(double targetAngle, double speed, int direction) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        this.targetDegrees = targetAngle;
        this.maxSPD = speed;
        this.direc = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	PulsesAtCMDStart = (int) Robot.driveTrain.getTrainValue();
    	
    	if(direc == 1){
    	Robot.driveTrain.driveSet(maxSPD, -maxSPD);
    	} else if( direc == -1){
    	Robot.driveTrain.driveSet(-maxSPD, maxSPD);
    	}
    }	

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(direc == 1){
    	pulses = (int) Robot.driveTrain.getRightValue(); //Check pulses
    	
    	} else if(direc == -1){
    	pulses = (int) Robot.driveTrain.getLeftValue(); //Check Pulses
    	}
    	PulsesThisCheck = pulses-TotalPulses; //Calculate New Pulses
    	if(PulsesThisCheck<0){ //If the encoder rolls over...
    		TotalPulses = 0; // Reset pulse sub-total
    		numResets++; // And add one reset to the counter.
    	} else if(PulsesThisCheck>0){ //If the encoder does not (hypothetically most of the time)
    		TotalPulses += PulsesThisCheck; //Add new pulses to sub-total.
    	}
    	//Calculations for feet driven used to be here, but that presents problems in which the relationship
    	//between time and pulses became exponential, and not accurate.
    	
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	GrandTotalPulses = TotalPulses + (numResets*4096); //Add pulses lost during rollover back in.
    	traveledDegrees = GrandTotalPulses/PulsesPerDegree; //Unit conversion from pulses to linear feet.
    	if(traveledDegrees >= targetDegrees){ //Check if distance has been traveled...
    		return true; //It has!
    	}else{ //It has not!
    	GrandTotalPulses = 0; //This needs to be reset when the loop does to prevent the aforementioned exponential rise in pulses.
        return false; //Keep going.
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.driveSet(0); //Stop Moving.
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.driveSet(0); //Same as above, but less optimistic. Allows the method to be interrupted by joystick input.
    	//Possible Issue: Joydrive constantly interrupting this?
    }
}
