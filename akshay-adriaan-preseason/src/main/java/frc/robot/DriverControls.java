// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/** Add your docs here. */
public class DriverControls {
    private XboxController controller;

    public DriverControls() {
        controller = new XboxController(0);
    }

    public double getThrottle() {
        return controller.getY(Hand.kLeft);
    }

    public double getSteering() {
        return controller.getX(Hand.kLeft);
    }
}
