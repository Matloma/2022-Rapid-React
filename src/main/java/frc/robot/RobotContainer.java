// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static XboxController xbox;
  public static AHRS gyro;

  private final Swerve driveTrain;
  private final DriveXbox driveXbox;

  private final Intake intake;
  private final IntakeXbox intakeXbox;

  private final Indexer indexer;
  private final IndexXbox indexXbox;

  private final Shooter shooter;
  private final ShootXbox shootXbox;

  private final Climber climber;
  private final ClimbXbox climbXbox;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    xbox = new XboxController(Constants.xboxPort);
    gyro = new AHRS();

    driveTrain = new Swerve(gyro);
    driveXbox = new DriveXbox(driveTrain);
    driveXbox.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveXbox);

    intake = new Intake();
    intakeXbox = new IntakeXbox(intake);
    intakeXbox.addRequirements(intake);
    intake.setDefaultCommand(intakeXbox);

    indexer = new Indexer();
    indexXbox = new IndexXbox(indexer);
    indexXbox.addRequirements(indexer);
    indexer.setDefaultCommand(indexXbox);

    shooter = new Shooter();
    shootXbox = new ShootXbox(shooter);
    shootXbox.addRequirements(shooter);
    shooter.setDefaultCommand(shootXbox);

    climber = new Climber();
    climbXbox = new ClimbXbox(climber);
    climbXbox.addRequirements(climber);
    climber.setDefaultCommand(climbXbox);
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
