package org.usfirst.frc.team2523.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearSystem extends Subsystem {
	Servo flap1 = new Servo(1);
	Servo flap2 = new Servo(2);
    public void down(){
    	flap1.set(0);
    	flap2.set(0);
    	
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

