// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubSystem extends SubsystemBase {
  private WPI_TalonSRX leftfrTalonSRX;
    private WPI_TalonSRX leftbackTalonSRX;
    private WPI_TalonSRX rightfrTalonSRX;
    private WPI_TalonSRX rightbackTalonSRX;
    private DifferentialDrive drive;

  /** Creates a new DriveSubSystem. */
  public DriveSubSystem() {
      leftfrTalonSRX = createAndConfigureMotor(2,false);
      leftbackTalonSRX = createAndConfigureMotor(1,false);
      rightfrTalonSRX = createAndConfigureMotor(4,true);
      rightbackTalonSRX = createAndConfigureMotor(5,true);
      
      SpeedControllerGroup leftside = 
        new SpeedControllerGroup(leftfrTalonSRX, leftbackTalonSRX);
      SpeedControllerGroup rightside =
        new SpeedControllerGroup(rightfrTalonSRX, rightbackTalonSRX);
      drive = new DifferentialDrive(leftside, rightside);
      drive.setRightSideInverted(false);
  }
  private WPI_TalonSRX createAndConfigureMotor(int canID, boolean InvertMotor){
    WPI_TalonSRX motor = new WPI_TalonSRX(canID);
    motor.setInverted(InvertMotor);
    return motor;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    super.periodic();
  }
  public void drive(double x, double y) {
    drive.arcadeDrive(y , x , true);
  }
}
