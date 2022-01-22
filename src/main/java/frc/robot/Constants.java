// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //CAN Ports --------------------------------------------------------------------------------
        //Swerve Ports ---------------------------------------------------------
            public static final int FRDCanPort = 0;
            public static final int FRSCanPort = 1;
            public static final int BRDCanPort = 2;
            public static final int BRSCanPort = 3;
            public static final int FLDCanPort = 4;
            public static final int FLSCanPort = 5;
            public static final int BLDCanPort = 6;
            public static final int BLSCanPort = 7;
        //Shooter Ports --------------------------------------------------------
            public static final int ShooterTurningMotorCanPort = 8;
            public static final int LeftShooterPowerMotorCanPort = 9;
            public static final int RightShooterPowerMotorCanPort = 10;
        //Indexer Ports --------------------------------------------------------
            public static final int LeftIndexerMotorCANPort = 11;
            public static final int RightIndexerMotorCANPort = 12;
            public static final int LeftLoaderMotorCANPort = 13;
            public static final int RightLoaderMotorCANPort = 14;
        //Intake Ports ---------------------------------------------------------
            public static final int IntakeMotorCanPort = 15;
        //Climber Ports --------------------------------------------------------
            public static final int LeftTelescopingMotorCANPort = 16;
            public static final int RightRotatingMotorCANPort = 17;
            public static final int LeftRotatingMotorCANPort = 18;
            public static final int RightTelescopingMotorCANPort = 19;
    
    //PWM Ports --------------------------------------------------------------------------------
        //Shooter Ports --------------------------------------------------------
            public static final int LeftShooterServoPWMPort = 0;
            public static final int RightShooterServoPWMPort = 1;

    //PCM Ports --------------------------------------------------------------------------------
        //Intake Ports ---------------------------------------------------------
            public static final int GasSpringPCMPort = 0;

    //Other Ports ------------------------------------------------------------------------------
        public static final int xboxPort = 0;

    //Constants --------------------------------------------------------------------------------
	    public static final double wheelPositionAbsoluteValue = 0;
	    public static final int angleGearReduction = 0;

    //Variables --------------------------------------------------------------------------------
        public static double throttle = 0.5;

    
    

}
