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

    public static final double DRIVE_SPEED = 0.5;
    public static final int RIGHT_TRIGGER = 3;
    public static final int LEFT_TRIGGER = 2;
    public static final int XBOX_LEFT_X_AXIS = 0;
    public static final int SHOOTER_FALCON = 21;
    public static final int SHOOTER_FALCON_INVERTED = 22;
    public static final int SHOOTER_FALCON_TOP = 23;
    public static final int HOOD_TALON = 0;
    public static final int kTimeoutMs = 0;
    public static final int kPIDLoopIdx = 0;
    public static final Gains kGains_Velocit_shooterWheel = new Gains(0.1,  0.001,  2,  767.25/17207,  300,  1.00);
    public static final Gains kGains_Velocit_topWheel = new Gains(0.1,  0.001,  2,  767.25/17207,  300,  1.00);
}
