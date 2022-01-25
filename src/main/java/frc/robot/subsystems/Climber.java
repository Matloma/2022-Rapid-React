// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
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

  public void ClimbXbox(XboxController xbox){
    if(xbox.getPOV()==0){
      extendArm(0.1);
    }
    if(xbox.getPOV()==180){
      retractArm(0.1);
    }
    if(xbox.getPOV()==90){
      rotateArmForward(1);
    }
    if(xbox.getPOV()==270){
      rotateArmBackward(1);
    }
  }

  public void extendArm(double distance){
    leftTelescopingMotor.set(TalonFXControlMode.Position, leftTelescopingMotor.getSelectedSensorPosition()+distance/Constants.TelescopingArmRotationToDistanceInches*2048);
    rightTelescopingMotor.set(TalonFXControlMode.Position, rightTelescopingMotor.getSelectedSensorPosition()+distance/Constants.TelescopingArmRotationToDistanceInches*2048);
  }

  public void retractArm(double distance){
    leftTelescopingMotor.set(TalonFXControlMode.Position, leftTelescopingMotor.getSelectedSensorPosition()-distance/Constants.TelescopingArmRotationToDistanceInches*2048);
    rightTelescopingMotor.set(TalonFXControlMode.Position, rightTelescopingMotor.getSelectedSensorPosition()-distance/Constants.TelescopingArmRotationToDistanceInches*2048);
  }

  public void rotateArmForward(double angle){
    leftRotatingMotor.set(TalonFXControlMode.Position, leftRotatingMotor.getSelectedSensorPosition()+angle/Constants.RotatingArmRotationToAngleDegrees*2048);
    rightRotatingMotor.set(TalonFXControlMode.Position, rightRotatingMotor.getSelectedSensorPosition()+angle/Constants.RotatingArmRotationToAngleDegrees*2048);
  }

  public void rotateArmBackward(double angle){
    leftRotatingMotor.set(TalonFXControlMode.Position, leftRotatingMotor.getSelectedSensorPosition()-angle/Constants.RotatingArmRotationToAngleDegrees*2048);
    rightRotatingMotor.set(TalonFXControlMode.Position, rightRotatingMotor.getSelectedSensorPosition()-angle/Constants.RotatingArmRotationToAngleDegrees*2048);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
