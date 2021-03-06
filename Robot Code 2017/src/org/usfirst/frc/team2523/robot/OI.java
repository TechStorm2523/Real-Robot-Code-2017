package org.usfirst.frc.team2523.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2523.robot.commands.Auto1;
import org.usfirst.frc.team2523.robot.commands.Climb;
import org.usfirst.frc.team2523.robot.commands.ExampleCommand;
import org.usfirst.frc.team2523.robot.commands.FeedFuel;
import org.usfirst.frc.team2523.robot.commands.Fire;
import org.usfirst.frc.team2523.robot.commands.ONWARD;
import org.usfirst.frc.team2523.robot.commands.RunTransit;
import org.usfirst.frc.team2523.robot.commands.ServoDown;
import org.usfirst.frc.team2523.robot.commands.ServoUp;
import org.usfirst.frc.team2523.robot.commands.StopClimb;
import org.usfirst.frc.team2523.robot.commands.TestAuto;
import org.usfirst.frc.team2523.robot.commands.ToggleDrive;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick controlStick = new Joystick(5);
	//// CREATING BUTTONS
	
	//Reverse = 7
	//Unload = 1
	//Feed = 5
	//Climb = 11
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	Button trigger = new JoystickButton(controlStick, 1);
	Button c6 = new JoystickButton(controlStick, 6);
	Button c2 = new JoystickButton(controlStick, 2);
	Button c7 = new JoystickButton(controlStick, 7);
	Button c5 = new JoystickButton(controlStick, 5);
	Button c8 = new JoystickButton(controlStick, 8);
	Button c10 = new JoystickButton(controlStick, 10);
	Button c11 = new JoystickButton(controlStick, 11);
	
	public OI(){
	
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	c11.whenPressed(new TestAuto());
	c6.whileHeld(new Climb());
	c7.whileHeld(new ServoDown());
	c8.whenPressed(new ServoUp());
	
	c2.whileHeld(new FeedFuel());
	c2.whileHeld(new RunTransit());
	//trigger.whileHeld(new ONWARD());
	trigger.whileHeld(new RunTransit());
	trigger.whileHeld(new Fire());
	trigger.whileHeld(new FeedFuel());
	
	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	}
}
