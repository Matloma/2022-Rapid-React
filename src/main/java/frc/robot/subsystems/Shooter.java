// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  WPI_TalonFX turningMotor; 
  WPI_TalonFX leftShooterMotor;
  WPI_TalonFX rightShooterMotor;
  Servo leftServo;
  Servo rightServo;

  /** Creates a new Shooter. */
  public Shooter() {
    turningMotor = new WPI_TalonFX(Constants.ShooterTurningMotorCanPort);
    leftShooterMotor = new WPI_TalonFX(Constants.LeftShooterPowerMotorCanPort);
    rightShooterMotor = new WPI_TalonFX(Constants.RightShooterPowerMotorCanPort);
    leftServo = new Servo(Constants.LeftShooterServoPWMPort);
    rightServo = new Servo(Constants.RightShooterServoPWMPort);
  }

  public void shootXbox(XboxController xbox, double speed){
    if(xbox.getRightTriggerAxis()>=0.1){
      shoot(xbox.getRightTriggerAxis()*speed);
    } else {
      stop();
    }
  }

  public void shoot(double speed){
    leftShooterMotor.set(speed);
    rightShooterMotor.set(speed);
  }

  public void stop(){

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
