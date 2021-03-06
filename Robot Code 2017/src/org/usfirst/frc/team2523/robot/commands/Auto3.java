package org.usfirst.frc.team2523.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto3 extends CommandGroup {

    public Auto3() { 
    	addSequential(new ServoUp());

        //Auto for Boiler side, blue team
    	//Hypothetically Done.
    	
        
    	addSequential(new drive6point5()); //Drive to base line
    	addSequential(new TurnForAngleUpdated(55));//Turn right to face gear peg
    	addSequential(new DriveForDistanceUpdated(3.5));//Put on Gear (Maybe not accurate enough, maybe is)
//    	Timer.delay(3);
//    	addSequential(new DriveForDistanceUpdated(-4.25));//Reverse off of gear
//    	addSequential(new TurnForAngle(55, 1, -1));//Turn left to face forward
//    	addSequential(new DriveForDistanceUpdated(-2.385)); //Back off to midpoint
//    	addSequential(new TurnForAngle(115.7, 1, -1));//Turn left To Face Boiler
//    	addSequential(new DriveForDistanceUpdated(4.47)); //go Forwards
//    	//Wait
//    	addParallel(new Fire()); //go backwards
//    	addParallel(new FeedFuel());//Turn left to face forward
//    	addParallel(new RunTransit());//Put on Gear (Maybe not accurate enough, maybe is)
// //   }
    	
    	
    	
    	
    	
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
