// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.awt.Color;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.hal.AllianceStationID;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {

  WPI_TalonSRX leftIndexerMotor;
  WPI_TalonSRX rightIndexerMotor;
  WPI_TalonFX leftLoaderMotor;
  WPI_TalonFX rightLoaderMotor;
  ColorSensorV3 colorSensor;

  /** Creates a new Indexer. */
  public Indexer() {
    leftIndexerMotor = new WPI_TalonSRX(Constants.LeftIndexerMotorCANPort);
    rightIndexerMotor = new WPI_TalonSRX(Constants.RightIndexerMotorCANPort);
    leftLoaderMotor = new WPI_TalonFX(Constants.LeftLoaderMotorCANPort);
    rightLoaderMotor = new WPI_TalonFX(Constants.RightLoaderMotorCANPort);
    colorSensor = new ColorSensorV3(Constants.i2cPort);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void indexXbox(XboxController xbox, double speed){
    if(xbox.getRightBumper()){
      indexBall(speed);
    } else {
      stop();
    }
  }

  public void indexBall(double speed){
    if (HAL.getAllianceStation().equals(AllianceStationID.Blue1)||
        HAL.getAllianceStation().equals(AllianceStationID.Blue2)||
        HAL.getAllianceStation().equals(AllianceStationID.Blue3)){
          if(colorSensor.getColor().toString().toUpperCase().equals("RED")){
            leftLoaderMotor.set(speed);
            rightLoaderMotor.set(speed);
            leftIndexerMotor.set(-0.5);
            rightIndexerMotor.set(-0.5);
          } else {
            leftLoaderMotor.set(speed);
            rightLoaderMotor.set(speed);
            leftIndexerMotor.set(speed);
            rightIndexerMotor.set(speed);
          }
    } else 
    if (HAL.getAllianceStation().equals(AllianceStationID.Red1)||
        HAL.getAllianceStation().equals(AllianceStationID.Red2)||
        HAL.getAllianceStation().equals(AllianceStationID.Red3)){
          if(colorSensor.getColor().toString().toUpperCase().equals("BLUE")){
            leftLoaderMotor.set(speed);
            rightLoaderMotor.set(speed);
            leftIndexerMotor.set(-0.5);
            rightIndexerMotor.set(-0.5);
          } else {
            leftLoaderMotor.set(speed);
            rightLoaderMotor.set(speed);
            leftIndexerMotor.set(speed);
            rightIndexerMotor.set(speed);
          }
    }
    
  }

  public void stop(){
    leftLoaderMotor.set(0);
    rightLoaderMotor.set(0);
    leftIndexerMotor.set(0);
    rightIndexerMotor.set(0);
  }

  
}
