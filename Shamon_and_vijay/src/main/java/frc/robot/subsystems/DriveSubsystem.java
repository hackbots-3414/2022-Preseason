// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private CANSparkMax leftFront;
  private CANSparkMax leftRear;
  private CANSparkMax rightFront;
  private CANSparkMax rightRear;

  private DifferentialDrive drive;
  
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftFront = createAndConfigureMotor(1, false);
    leftRear = createAndConfigureMotor(2, false);
    rightFront = createAndConfigureMotor(4, true);
    rightRear = createAndConfigureMotor(5, true);

  }
  private CANSparkMax createAndConfigureMotor(int canID, boolean invertMotor){
    CANSparkMax motor = new CANSparkMax(canID, kBrushless(1));//we could not get MotorType to work for the second variable needed here
    motor.setInverted(invertMotor);
    return motor;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
