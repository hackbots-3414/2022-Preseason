// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class DriverControls {
  private XboxController controller;

  public DriverControls() {
    controller = new XboxController(0);
    

  }
  public double getY() {
    return controller.getY(Hand.kLeft);
  }

  public double getX() {
    return controller.getX(Hand.kRight);
  }
}
