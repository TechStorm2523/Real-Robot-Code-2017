package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSystem extends Subsystem {
	Servo pin = new Servo(RobotMap.flap);
	
    public void down(){
    	pin.set(1);
    
    	
    	
    	
    	
    }
    
    public void up(){
    	pin.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

