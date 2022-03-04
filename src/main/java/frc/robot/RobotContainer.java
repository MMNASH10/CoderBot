// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilderImpl;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.Autonomous;
import frc.robot.commands.JoystickDrive;
import frc.robot.subsystems.Camera;
//import frc.robot.commands.ShootTopCmd;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
//import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Drivetrain drivetrain;
  private Limelight limelight;
  private Camera camera;
 // private Shooter shooter;
 // private ShootTopCmd shootTop;
  private JoystickDrive joystickDrive;
  private final Autonomous auto;
  public static XboxController driverController;
  SendableChooser<Command> chooser = new SendableChooser<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drivetrain = new Drivetrain();
    //shooter = new Shooter();
    //shootTop = new ShootTopCmd(shooter);
    //shootTop.addRequirements(shooter);
    limelight = new Limelight();
    camera = new Camera();
    joystickDrive = new JoystickDrive(drivetrain, limelight);
    joystickDrive.addRequirements(drivetrain, limelight);
    drivetrain.setDefaultCommand(new JoystickDrive(drivetrain, limelight));


    driverController = new XboxController(0);

    //auto
    auto = new Autonomous(drivetrain, limelight);
    chooser.addOption("Autonomous", auto);
    SmartDashboard.putData("Auto Mode", chooser);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
   // JoystickButton ShootTopButton = new JoystickButton(driverController, XboxController.Button.kB.value);
   /// ShootTopButton.whileHeld(new ShootTopCmd(shooter));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return chooser.getSelected();
  }
}
