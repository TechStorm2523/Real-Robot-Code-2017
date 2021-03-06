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
	public static double rightvoltage = 12;
	public static double leftvoltage = 11;
	public static double rightAvoltage = 7.7;
	public static double leftAvoltage = 7.06;
	public static int leftMotor1 = 4;
	public static int rightMotor1 = 1;
	public static int leftMotor2 = 2;
	public static int rightMotor2 = 3;
	public static int intake = 0;
	public static int transitBelt = 5;
	public static int liftBelt = 4;
	public static int liftRoller = 6;
	public static int winchMotor = 3;
	public static int flap = 9;
	public static double speedMod = 1;
	
	
	
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
