// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  WPI_TalonSRX intakeMotor;
  Solenoid gasSpring;

  /** Creates a new Intake. */
  public Intake() {
    intakeMotor = new WPI_TalonSRX(Constants.IntakeMotorCanPort);
    gasSpring = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.GasSpringPCMPort);
  }

  public void intakeXbox(XboxController xbox, double speed){
    if(xbox.getLeftBumper()){
      intakeBall(speed);
    } else {
      stop();
    }
  }

  public void intakeBall(double speed){
    intakeMotor.set(speed);
  }

  public void stop(){
    intakeMotor.set(0);
  }

  public void releaseIntake(){
    gasSpring.toggle();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
