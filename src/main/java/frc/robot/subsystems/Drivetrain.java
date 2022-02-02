// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.ScheduleCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private MotorController leftFront;
  private MotorController leftBack;
  private MotorController rightFront;
  private MotorController rightBack;

  private MotorControllerGroup left;
  private MotorControllerGroup right;

  private DifferentialDrive drive;

  public Drivetrain() {
    leftFront = new WPI_TalonFX(1);
    leftFront.setInverted(false);
    leftBack = new WPI_TalonFX(2);
    leftBack.setInverted(false);

    rightFront = new WPI_TalonFX(3);
    rightFront.setInverted(true);
    rightBack = new WPI_TalonFX(4);
    rightBack.setInverted(true);

    left = new MotorControllerGroup(leftFront, leftBack);
    right = new MotorControllerGroup(rightFront, rightBack);

    drive = new DifferentialDrive(leftFront, rightFront);
  }

  public void joystickDrive(XboxController controller, double speed) {
    //double xSpeed = ((controller.getRawAxis(Constants.RIGHT_TRIGGER))-(controller.getRawAxis(Constants.LEFT_TRIGGER)))*speed;
    //double zRotation = controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*-speed;
    //drive.arcadeDrive(xSpeed, zRotation);

    drive.arcadeDrive(((controller.getRawAxis(Constants.RIGHT_TRIGGER))-(controller.getRawAxis(Constants.LEFT_TRIGGER)))*speed, controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*-speed);
  }

  public void moveMotor() {
    leftFront.set(0.1);
  }

  public void stop() {
    drive.stopMotor();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
