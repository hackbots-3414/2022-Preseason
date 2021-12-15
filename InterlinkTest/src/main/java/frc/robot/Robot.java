// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick.AxisType;
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
    SmartDashboard.putNumber("Left_X_Trim", 1.0);
    SmartDashboard.putNumber("Left_Y_Trim", 1.0);
    SmartDashboard.putNumber("Right_X_Trim", 1.0);
    SmartDashboard.putNumber("Right_Y_Trim", 1.0);
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
    m_robotDrive.arcadeDrive(leftY, leftX);
    System.out.println("Left: " + leftX + ", " + leftY + "; Right: " + rightX + ", " + rightY);


    // Access via RawAxis or Hand doesn't matter; these printlns display same
//    System.out.println(m_stick.getName() + ": Left: (" + m_stick.getX(Hand.kLeft) + ", " + m_stick.getY(Hand.kLeft)
//        + "), Right: (" + m_stick.getX(Hand.kRight) + ", " + m_stick.getY(Hand.kRight) + ")");
//    System.out.println("Raw Axis: " + m_stick.getName() + ": Left: (" + m_stick.getRawAxis(0) + ", "
//        + m_stick.getRawAxis(1) + "), Right: ("
//        + m_stick.getRawAxis(3) + ", " + m_stick.getRawAxis(4) + ")");

  }

  public double getLeftX() {
    return m_stick.getX(Hand.kLeft) * SmartDashboard.getNumber("Left_X_Trim", 1.0);
  }

  public double getLeftY() {
    return m_stick.getY(Hand.kLeft) * SmartDashboard.getNumber("Left_Y_Trim", 1.0);
  }

  public double getRightX() {
    return m_stick.getX(Hand.kRight) * SmartDashboard.getNumber("Right_X_Trim", 1.0);
  }

  public double getRightY() {
    return m_stick.getY(Hand.kRight) * SmartDashboard.getNumber("Right_Y_Trim", 1.0);
  }

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
