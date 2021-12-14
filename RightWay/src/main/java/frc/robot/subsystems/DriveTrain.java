// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_TalonSRX frontLeft;
private WPI_TalonSRX backLeft;
private SpeedControllerGroup left;
private WPI_TalonSRX backRight;
private WPI_TalonSRX frontRight;
private SpeedControllerGroup right;
private DifferentialDrive tankDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
frontLeft = new WPI_TalonSRX(1);
 
 

backLeft = new WPI_TalonSRX(2);
 
 

SpeedControllerGroup left = new SpeedControllerGroup(frontLeft, backLeft  );
 addChild("Left",left);
 

backRight = new WPI_TalonSRX(4);
 
 

frontRight = new WPI_TalonSRX(5);
 
 

SpeedControllerGroup right = new SpeedControllerGroup(backRight, frontRight  );
 addChild("Right",right);
 

tankDrive = new DifferentialDrive(left, right);
 addChild("TankDrive",tankDrive);
 tankDrive.setSafetyEnabled(true);
tankDrive.setExpiration(0.1);
tankDrive.setMaxOutput(1.0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void tankDrive(double left, double right) {
        // Tank drive
        tankDrive.tankDrive(-left, -right);
    }

}

