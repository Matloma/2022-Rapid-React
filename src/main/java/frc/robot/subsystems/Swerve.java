// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Swerve extends SubsystemBase {
  /** Creates a new Swerve. */

  private WPI_TalonFX FrontLeftDriveMotor;
  private WPI_TalonFX FrontLeftSteerMotor;
  private WPI_TalonFX BackLeftDriveMotor;
  private WPI_TalonFX BackLeftSteerMotor;
  private WPI_TalonFX FrontRightDriveMotor;
  private WPI_TalonFX FrontRightSteerMotor;
  private WPI_TalonFX BackRightDriveMotor;
  private WPI_TalonFX BackRightSteerMotor;

  private AHRS gyro;
  
  private Translation2d frontLeftLocation; 
  private Translation2d frontRightLocation; 
  private Translation2d backLeftLocation; 
  private Translation2d backRightLocation; 

  private SwerveDriveKinematics kinematics;

  private ChassisSpeeds speeds;

  private SwerveModuleState[] moduleStates;
  private SwerveModuleState frontLeft;
  private SwerveModuleState frontRight;
  private SwerveModuleState backLeft;
  private SwerveModuleState backRight;

  public Swerve(AHRS GYRO) {
    gyro = GYRO;

    FrontLeftDriveMotor = new WPI_TalonFX(Constants.FLDCanPort);
    FrontLeftSteerMotor = new WPI_TalonFX(Constants.FLSCanPort);
    BackLeftDriveMotor = new WPI_TalonFX(Constants.BLDCanPort);
    BackLeftSteerMotor = new WPI_TalonFX(Constants.BLSCanPort);
    FrontRightDriveMotor = new WPI_TalonFX(Constants.FRDCanPort);
    FrontRightSteerMotor = new WPI_TalonFX(Constants.FRSCanPort);
    BackRightDriveMotor = new WPI_TalonFX(Constants.BRDCanPort);
    BackRightSteerMotor = new WPI_TalonFX(Constants.BRSCanPort);

    frontLeftLocation = new Translation2d(Constants.wheelPositionAbsoluteValue, Constants.wheelPositionAbsoluteValue);
    frontRightLocation = new Translation2d(Constants.wheelPositionAbsoluteValue, -Constants.wheelPositionAbsoluteValue);
    backLeftLocation = new Translation2d(-Constants.wheelPositionAbsoluteValue, Constants.wheelPositionAbsoluteValue);
    backRightLocation = new Translation2d(-Constants.wheelPositionAbsoluteValue, -Constants.wheelPositionAbsoluteValue);

    kinematics = new SwerveDriveKinematics(frontLeftLocation, frontRightLocation, backLeftLocation, backRightLocation);    
  }

  public void drive(double Y, double X, double R) {
		
    speeds = ChassisSpeeds.fromFieldRelativeSpeeds(Y, -X, -R, Rotation2d.fromDegrees(gyro.getAngle()));

    moduleStates = kinematics.toSwerveModuleStates(speeds);
    frontLeft = moduleStates[0];
    frontRight = moduleStates[1];
    backLeft = moduleStates[2];
    backRight = moduleStates[3];

    FrontLeftDriveMotor.set(TalonFXControlMode.PercentOutput, frontLeft.speedMetersPerSecond*Constants.throttle);  //The maximum speed in MPS from the SwerveDrive class just barely exceeds 1 (1.012 is the highest Ive seen), so using Percent Output is more efficient than Velocity Mode
    FrontLeftSteerMotor.set(TalonFXControlMode.Position, frontLeft.angle.getDegrees() * -1.0 / 360 * 2048/Constants.angleGearReduction);        //*-1 because gyro goes counterclockwise for positive values, but motor doesnt, /360 to get a ratio, *2048 because falcon500 encoders have 2048 points per rotation.
    FrontRightDriveMotor.set(TalonFXControlMode.PercentOutput, frontRight.speedMetersPerSecond*Constants.throttle);
    FrontRightSteerMotor.set(TalonFXControlMode.Position, frontRight.angle.getDegrees() * -1.0 / 360 * 2048/Constants.angleGearReduction);
    BackLeftDriveMotor.set(TalonFXControlMode.PercentOutput, backLeft.speedMetersPerSecond*Constants.throttle);
    BackLeftSteerMotor.set(TalonFXControlMode.Position, backLeft.angle.getDegrees() * -1.0 / 360 * 2048/Constants.angleGearReduction);
    BackRightDriveMotor.set(TalonFXControlMode.PercentOutput, backRight.speedMetersPerSecond*Constants.throttle);
    BackRightSteerMotor.set(TalonFXControlMode.Position, backRight.angle.getDegrees() * -1.0 / 360 * 2048/Constants.angleGearReduction);
    
  }

  public void driveXbox(XboxController xbox, double speed){
    drive(xbox.getLeftY()*-1*speed, xbox.getLeftX()*speed, xbox.getRightX()*speed);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

//flex rq