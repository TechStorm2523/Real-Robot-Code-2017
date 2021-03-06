package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.RobotMap;


import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class WinchSystem extends Subsystem {
	Spark winch = new Spark(RobotMap.winchMotor);

	
	public void forwardSpin(){
		winch.set(1);
		System.out.println("VROOM!");
	}
	public void backSpin(){
		winch.set(-1);
	}
	public void stopSpin(){
		winch.set(0);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
