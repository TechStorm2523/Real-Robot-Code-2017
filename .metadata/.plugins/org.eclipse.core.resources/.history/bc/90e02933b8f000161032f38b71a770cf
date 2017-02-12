
package org.usfirst.frc.team2523.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2523.robot.commands.Auto0;
import org.usfirst.frc.team2523.robot.commands.DrainHopper;

import org.usfirst.frc.team2523.robot.commands.DriveRunner;
import org.usfirst.frc.team2523.robot.commands.ExampleCommand;
import org.usfirst.frc.team2523.robot.commands.FeedFuel;

import org.usfirst.frc.team2523.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2523.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2523.robot.subsystems.FeedSystem;
import org.usfirst.frc.team2523.robot.subsystems.GearSystem;
import org.usfirst.frc.team2523.robot.subsystems.LaunchSystem;
import org.usfirst.frc.team2523.robot.subsystems.WinchSystem;

import com.ctre.CANTalon;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//Instantiate Subsystems
	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final DriveTrain driveTrain = new DriveTrain();
	public static final FeedSystem feedSystem = new FeedSystem();
	public static final LaunchSystem launchSystem = new LaunchSystem();
	public static final GearSystem gearSystem = new GearSystem();
	public static final WinchSystem winchSystem = new WinchSystem();

	
	//Instantiate Commands (rework/obliterate if robot immediately breaks)
//	public static final DriveRunner driverunner = new DriveRunner();
//	public static final Auto0 auto1 = new Auto0();
//	public static final DrainHopper drainHopper = new DrainHopper();
//	public static final FeedFuel feedFuel = new FeedFuel();
//	
	
//	CANTalon motorL1 = new CANTalon(0);
//	CANTalon motorL2 = new CANTalon(1);
//	CANTalon motorR1 = new CANTalon(2);
//	CANTalon motorR2 = new CANTalon(3);
//	CANTalon intake = new CANTalon(4);
//	CANTalon transitBelt = new CANTalon(5);
//	CANTalon liftBelt = new CANTalon(6);
//	CANTalon outPut = new CANTalon(7);
	//Not Needed. Uncomment if everything is broken.
	
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		
		oi = new OI();
		chooser.addDefault("Default Auto", new ExampleCommand());
		chooser.addObject("My Auto", new Auto0());
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
