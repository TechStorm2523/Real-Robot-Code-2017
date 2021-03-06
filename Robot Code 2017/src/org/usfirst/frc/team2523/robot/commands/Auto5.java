package org.usfirst.frc.team2523.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto5 extends CommandGroup {

    public Auto5() { 
    	addSequential(new ServoUp());
    	

        //Auto for Center side, red team
    	//Done apart from calibration and bugfixing.
    	//Fix directional comments
    	
        
    	addSequential(new drive6point5()); //Drive to base line (also puts on gear)
//    	Timer.delay(3);
//    	addSequential(new DriveForDistanceUpdated(-2.385));//Reverse off of gear
//    	addSequential(new TurnForAngle(101, 1, 1));//Turn right around to face Boiler
//    	addSequential(new DriveForDistanceUpdated(12.17)); //go forward Boiler
//    	
//    	addParallel(new Fire()); //go backwards
//    	addParallel(new FeedFuel());//Turn left to face forward
//    	addParallel(new RunTransit());//Put on Gear (Maybe not accurate enough, maybe is)
//    	
    	
    	
    	
    	
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
