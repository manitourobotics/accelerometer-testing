package com.github.manitourobotics.accelerometertesting;


import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AccelerometerTest extends IterativeRobot {


    // The constructor arguments are
        // "the slot of the digital module that the sensor is plugged into" 
            // which equates to specify which sidecar
            // 1 - default, first
        // the range of what the accelerometer(I set 2Gs for this case).
    ADXL345_I2C accelerometer = new ADXL345_I2C(1, ADXL345_I2C.DataFormat_Range.k2G);

    // This nested class can be used to store the three axes for ease of use
    ADXL345_I2C.AllAxes axes;
    
    // I'm using the drive to test out x and y acceleration
    // Supply your own magic numbers and swap out the Jaguar class for your
    //      preferred motor controller
    final int LOGITECH_JOYSTICK = 1;
    final int PWM_1 = 1;
    final int PWM_2 = 2;
    Joystick joystick = new Joystick(LOGITECH_JOYSTICK);
    Jaguar leftDriveMotor = new Jaguar(PWM_1);
    Jaguar rightDriveMotor = new Jaguar(PWM_2);
    RobotDrive drive = new RobotDrive(leftDriveMotor, rightDriveMotor);
    // Have two people (very carefully) lift the robot to see the effects of their force upon the robot

    public void teleopPeriodic() {
        axes = accelerometer.getAccelerations();

        // The outputs are very noisy
        // Filtering is probably required to use the accelerometer in any
        //  meaningful way.
        // see http://en.wikipedia.org/wiki/Low-pass_filter
        //http://www.stackoverflow.com/questions/4026648/how-to-implement-low-pass-filter-using-java
        // http://www.chiefdelphi.com/forums/showthread.php?t=98468

        // Acceleration is measured in Gs where, G is the acceleration due to gravity
        SmartDashboard.putNumber("X axis", axes.XAxis);
        SmartDashboard.putNumber("Y axis", axes.YAxis);
        SmartDashboard.putNumber("Z axis", axes.ZAxis);

        /* You can also get the acceleration by calling the getAcceleration 
            method and supplying the axis constant as an argument */
        // example:
        //SmartDashboard.putNumber("straight Z axis", accelerometer.getAcceleration(ADXL345_I2C.Axes.kZ));

        // If the joystick that you are using is not a Logitech 3D Pro , then you may have to 'getAxis' from other axes
        // The inputs always seem to be backward for me
        drive.arcadeDrive(joystick.getAxis(Joystick.AxisType.kY) * -1, joystick.getAxis(Joystick.AxisType.kTwist) * -1);
    }
}
