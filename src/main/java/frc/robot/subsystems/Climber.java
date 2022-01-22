// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

  WPI_TalonFX leftTelescopingMotor;
  WPI_TalonFX rightTelescopingMotor;
  WPI_TalonFX leftRotatingMotor;
  WPI_TalonFX rightRotatingMotor;


  /** Creates a new Climber. */
  public Climber() {
    leftTelescopingMotor = new WPI_TalonFX(Constants.LeftTelescopingMotorCANPort);
    rightTelescopingMotor = new WPI_TalonFX(Constants.RightTelescopingMotorCANPort);
    leftRotatingMotor = new WPI_TalonFX(Constants.LeftRotatingMotorCANPort);
    rightRotatingMotor = new WPI_TalonFX(Constants.RightRotatingMotorCANPort);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
