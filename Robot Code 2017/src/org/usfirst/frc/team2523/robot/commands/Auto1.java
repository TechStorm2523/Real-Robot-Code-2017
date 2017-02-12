package org.usfirst.frc.team2523.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto1 extends CommandGroup {

    public Auto1() { //This first part should be deleted after testing, as it is simply for calibration
    	addSequential(new DriveForDistance(4,1));
    	addSequential(new TurnForAngle(90,.5,-1));
    	addSequential(new DriveForDistance(4,1));
    	addSequential(new TurnForAngle(90,.5,-1));
    	addSequential(new DriveForDistance(4,1));
    	addSequential(new TurnForAngle(90,.5,-1));
    	addSequential(new DriveForDistance(4,1));
        // Add Commands here:
        
    	addSequential(new DriveForDistance(7.77, 1)); //Drive to base line
    	addSequential(new TurnForAngle(160, 1, 1));
    	addSequential(new DriveForDistance(7.77, 1));
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
