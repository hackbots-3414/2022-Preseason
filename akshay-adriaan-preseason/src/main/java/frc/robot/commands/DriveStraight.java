// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

//This is important


public class DriveStraight extends CommandBase {

  private double speed;
  private double distance;
  public DriveSubsystem driveSubsystem;

  /** Creates a new driveStraight. */
  public DriveStraight(double speed, double distance, DriveSubsystem driveSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem);
    this.driveSubsystem = driveSubsystem;
    this.speed = speed;
    this.distance = distance;
    
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //start from a known state
    driveSubsystem.drive(0,0);
    driveSubsystem.resetEncoders();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (driveSubsystem.meanPosition() < distance) {
      driveSubsystem.drive(speed, distance);
      
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (driveSubsystem.meanPosition() >= distance) {
      return true;
    } 
    
    else {
      return false;
    }
  }
}
