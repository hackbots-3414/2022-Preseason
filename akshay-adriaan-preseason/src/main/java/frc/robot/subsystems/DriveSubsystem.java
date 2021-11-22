// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase

;

public class DriveSubsystem extends SubsystemBase {
  private WPI_TalonSRX leftFront;
  private WPI_TalonSRX leftRear;
  private WPI_TalonSRX rightFront;
  private WPI_TalonSRX rightRear;

  private DifferentialDrive drive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftFront = createAndConfigureMotor(2, false);
    leftRear = createAndConfigureMotor(1, false);
    rightFront = createAndConfigureMotor(4, true);
     rightRear = createAndConfigureMotor(5, true);

    SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFront, leftRear);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(rightFront, rightRear);

    drive = new DifferentialDrive(leftSide, rightSide);
    drive.setRightSideInverted(false);
  }

  public double getLeftFrontPosition() {
    return leftFront.getSelectedSensorPosition();
  
  }

  //public double getLeftRearPosition() {
    //return leftRear.getSelectedSensorPosition();

  public double getRightFrontPosition(){
    return rightFront.getSelectedSensorPosition();
  }

  //public double getRightRearPosition() {
    //return rightRear.getSelectedSensorPosition();
    {
  }
  

  public double meanPosition() {
    return (getRightFrontPosition() + getLeftFrontPosition())/2;

  }

  public void resetEncoders() {
    
    rightFront.setSelectedSensorPosition(0);
    leftFront.setSelectedSensorPosition(0);

  }

  private WPI_TalonSRX createAndConfigureMotor(int canID, boolean invert) {
    WPI_TalonSRX motor = new WPI_TalonSRX(canID);
    motor.setInverted(invert);
    return motor;
  }

  @Override
  public void periodic() {
    super.periodic();
  }

  public void drive(double x, double y) {
    drive.arcadeDrive(x, y, true);
  }


  
}
