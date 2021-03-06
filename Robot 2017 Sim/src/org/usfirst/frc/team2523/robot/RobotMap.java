package org.usfirst.frc.team2523.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	public static int leftMotor1 = 1;
	public static int rightMotor1 = 2;
	public static int leftMotor2 = 3;
	public static int rightMotor2 = 4;
	public static int intake = 5;
	public static int transitBelt = 6;
	public static int liftBelt = 7;
	public static int outPut = 8;
	public static int flap1 = 1;
	public static int flap2 = 2;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
