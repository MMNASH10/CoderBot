// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class JoystickDrive extends CommandBase {
  Drivetrain drivetrain;
  Limelight limelight;
  /** Creates a new JoystickDrive. */
  public JoystickDrive(Drivetrain dt, Limelight l) {
    drivetrain = dt;
    limelight = l;
    addRequirements(drivetrain, limelight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if (RobotContainer.driverController.getAButton()) {
      if (limelight.isTargetValid()) {
        drivetrain.aimLimelight(0, -1*limelight.getSteer());
      } else {
        drivetrain.stop();
      }
    } else {
      drivetrain.joystickDrive(RobotContainer.driverController, Constants.DRIVE_SPEED);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
