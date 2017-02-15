package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.OI;
import org.usfirst.frc.team2523.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class HopperSystem extends Subsystem {
	
	Spark hopperbelt = new Spark(RobotMap.transitBelt);
	
	public void transit(){
		hopperbelt.set(-.5);
	}
	public void stoptransit(){
		hopperbelt.set(0);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		
	}
}
