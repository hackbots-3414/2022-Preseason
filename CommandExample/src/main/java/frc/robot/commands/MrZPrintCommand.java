// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class MrZPrintCommand extends CommandBase {
  private static final Logger LOG = LoggerFactory.getLogger(MrZPrintCommand.class);
  private int counter = 0;

  /** Creates a new MrZPrintCommand. */
  public MrZPrintCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    LOG.info("Initializing...");
    counter = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    counter ++;
    LOG.trace("counter: {}", counter);

    // example ways to debug code
    // Note that System.out will ALWAYS happen, which can significantly clutter logs
    System.out.println("MrZPrintCommand.execute(): I'm here!");

    // Using a logger means we can control which Java packages (folders) and even classes
    // write to the log, and at what level.  The slf4j we picked up from StrykeForce is also
    // much more efficient than System.out.
    //
    // TRACE is for very fine-grained debugging.  There tends to be a lot of them, but once 
    // a bug is fixed, they can be turned off
    // DEBUG is like trace but meant to be a little more important / less frequently shown
    // INFO is more important than debug
    // WARN is for potential problems
    // ERROR is for touble - fundamental assumptions not met, exception reporting, etc.
    //
    LOG.trace("This is a trace");
    LOG.debug("I'm here, in the logger!");
    LOG.info("Hello, I'm informing you");
    LOG.warn("You need to know something important");
    LOG.error("Houston, we have a problem");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    LOG.debug("end");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    LOG.trace("isFinished saw counter: {}", counter);
    if (counter < 10) {
      LOG.trace("returning false");
      return false;
    }
    LOG.trace("returning true");
    return true;
  }
}
