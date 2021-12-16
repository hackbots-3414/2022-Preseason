// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(new PWMSparkMax(0), new PWMSparkMax(1));
  private final Joystick m_stick = new Joystick(0);
  private final Timer m_timer = new Timer();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    // observed maximums
    SmartDashboard.putNumber("Left_X_Max", 0.7);
    SmartDashboard.putNumber("Left_Y_Max", 0.6);
    SmartDashboard.putNumber("Right_X_Max", 0.8);
    SmartDashboard.putNumber("Right_Y_Max", 0.8);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    // Drive for 2 seconds
    if (m_timer.get() < 2.0) {
      m_robotDrive.arcadeDrive(0.5, 0.0); // drive forwards half speed
    } else {
      m_robotDrive.stopMotor(); // stop robot
    }
  }

  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
  }

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {
    double leftX, leftY, rightX, rightY;
    leftX = getLeftX();
    leftY = getLeftY();
    rightX = getRightX();
    rightY = getRightY();
    // helpful debugging
    SmartDashboard.putNumber("leftX", leftX);
    SmartDashboard.putNumber("leftY", leftY);
    SmartDashboard.putNumber("rightX", rightX);
    SmartDashboard.putNumber("rightY", rightY);
    
    m_robotDrive.arcadeDrive(leftY, rightX);

  }

  // NOTE: must use getRawAxis() to work around bug in WPILib
  // This formula is very simple - divide the value off the stick by the observed max, sort
  // of remapping it to a 1.0 maximum.  Better would be to come up with a formula that pins
  // center at zero, accounts for an observed minimum and an observed maximum, mapping it all
  // to -1.0 -> 0.0 -> + 1.0
  public double getLeftX() {
    return m_stick.getRawAxis(0) / SmartDashboard.getNumber("Left_X_Max", 1.0);
  }

  public double getLeftY() {
    return m_stick.getRawAxis(1) / SmartDashboard.getNumber("Left_Y_Max", 1.0);
  }

  public double getRightX() {
    return m_stick.getRawAxis(3) / SmartDashboard.getNumber("Right_X_Max", 1.0);
  }

  public double getRightY() {
    return m_stick.getRawAxis(4) / SmartDashboard.getNumber("Right_Y_Max", 1.0);
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
