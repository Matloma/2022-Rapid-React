// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {

  WPI_TalonSRX leftIndexerMotor;
  WPI_TalonSRX rightIndexerMotor;
  WPI_TalonFX leftLoaderMotor;
  WPI_TalonFX rightLoaderMotor;

  /** Creates a new Indexer. */
  public Indexer() {
    leftIndexerMotor = new WPI_TalonSRX(Constants.LeftIndexerMotorCANPort);
    rightIndexerMotor = new WPI_TalonSRX(Constants.RightIndexerMotorCANPort);
    leftLoaderMotor = new WPI_TalonFX(Constants.LeftLoaderMotorCANPort);
    rightLoaderMotor = new WPI_TalonFX(Constants.RightLoaderMotorCANPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
