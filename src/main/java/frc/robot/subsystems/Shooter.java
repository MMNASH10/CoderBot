// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private TalonFX shooterWheel;
  private TalonFX shooterWheelInverted;
  private TalonFX topWheel;
  /** Creates a new Shooter. */
  public Shooter() {
    shooterWheel = new TalonFX(21);
    shooterWheelInverted = new TalonFX(22);
    topWheel = new TalonFX(23);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
