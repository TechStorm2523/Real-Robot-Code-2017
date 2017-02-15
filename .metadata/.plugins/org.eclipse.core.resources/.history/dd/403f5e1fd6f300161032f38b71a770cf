package org.usfirst.frc.team2523.robot.subsystems;

import org.usfirst.frc.team2523.robot.RobotMap;







import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallPurge extends Subsystem {
	

    CANTalon lift = new CANTalon(RobotMap.liftBelt);
    CANTalon intermediate = new CANTalon(RobotMap.outPut);
    
    public void Dump(double speed){
    	lift.set(speed);
    	intermediate.set(speed);
    }
    public void StopDump(){
    	lift.set(0);
    	intermediate.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

