// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubSystem;

public class DriveStraight extends CommandBase {
  private DriveSubSystem driveSubSystem;

  private double distance;
  private double speed;

  /** Creates a new DriveStraight. */
  public DriveStraight(double speed, double distance, DriveSubSystem driveSubSystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubSystem);
    this.driveSubSystem = driveSubSystem;
    this.speed = speed;
    this.distance = distance;
    if ((distance < 0 && speed > 0) || (distance > 0 && speed < 0)) {
      speed = -speed;
    }

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveSubSystem.drive(0, 0);
    driveSubSystem.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubSystem.drive(-speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveSubSystem.drive(0, 0);
    driveSubSystem.resetEncoders();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println("Average Encoder: " + driveSubSystem.getAverageEncoderPosition() + "Left Encoder: " + driveSubSystem.getLeftEncoderPosition() + "Right Encoder: " + driveSubSystem.getRightEncoderPosition());
    if (distance > 0) {
      if (driveSubSystem.getAverageEncoderPosition() >= distance) {
        return true;
      }
    } else {
      if (driveSubSystem.getAverageEncoderPosition() <= distance) {
        return true;
      }
    }
    return false;
  }
}
