// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the manifest
 * file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  private CANSparkMax driveFrontRightSpark = new CANSparkMax(1, MotorType.kBrushed);
  private CANSparkMax driveBackRightSpark = new CANSparkMax(2, MotorType.kBrushed);
  private CANSparkMax driveFrontLeftSpark = new CANSparkMax(3, MotorType.kBrushed);
  private CANSparkMax driveBackLeftSpark = new CANSparkMax(4, MotorType.kBrushed);

  private Joystick joy1 = new Joystick(0);

  double autoStart = 0;
  boolean goForAuto = false;



  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */



  @Override
  public void teleopPeriodic(){
    System.out.println("hello world");
    setDriveMotors(-joy1.getRawAxis(1), -joy1.getRawAxis(4));
}
  @Override
  public void robotInit() {

    driveFrontRightSpark.setInverted(false);
    driveBackRightSpark.setInverted(false);
    driveFrontLeftSpark.setInverted(false);
    driveBackLeftSpark.setInverted(false);

    SmartDashboard.putBoolean("Go For Auto", false);
    goForAuto = SmartDashboard.getBoolean("Go For Auto", false);

    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_rightDrive.setInverted(true);
  }

  public void setDriveMotors(double forward, double turn) {

    /*
     * positive turn = counter clockwise, so the left side goes backwards
     */
    double left = forward - turn;
    double right = forward + turn;

    System.out.println("This Should Be Going Foward" + forward + turn);
    driveFrontLeftSpark.set(left);
    driveBackLeftSpark.set(left);
    driveFrontRightSpark.set(-right);
    driveBackRightSpark.set(-right);
  }

  /** This function is run once each time the robot enters autonomous mode. */
  // @Override
  // public void autonomousInit() {
  // //n m_timer.reset();
  // //n m_timer.start();
  // }

  // /** This function is called periodically during autonomous. */
  // @Override
  // public void autonomousPeriodic() {
  // // Drive for 2 seconds
  // /*n if (m_timer.get() < 2.0) {
  // // Drive forwards half speed, make sure to turn input squaring off
  // //n m_robotDrive.arcadeDrive(0.5, 0.0, false);
  // } else {
  // //n m_robotDrive.stopMotor(); // stop robot
  // } */
  //}

  // @Override
  // public void autonomousInit() {
  //   m_timer.reset();
  //   m_timer.start();

  // }


  @Override
  public void autonomousInit() {
    //get a time for autonomous start to do events based on time later
    autoStart = Timer.getFPGATimestamp();
    //check dashboard icon to ensure good to do auto
    goForAuto = SmartDashboard.getBoolean("Go For Auto", false);
  }


  @Override
    public void autonomousPeriodic() {
      double autoTimeElapsed = Timer.getFPGATimestamp() - autoStart;
      ///setDriveMotors(.3, 0);
      ///if(goForAuto){
        //series of timed events making up the flow of auto
      //  System.out.println(" you are not in the the section at all ");
        if(autoTimeElapsed < 1){
          setDriveMotors(.2, 0);
          System.out.println(" You are in the first section ");
       // }else if( autoTimeElapsed < 6 && autoTimeElapsed > 3){
          //stop spitting out the ball and drive backwards *slowly* for three seconds
        //  setDriveMotors(-.4, 0);
        //  System.out.println(" You are in the second section ");

        }else{
          //do nothing for the rest of auto
          System.out.println(" You are in the third section ");
          setDriveMotors(0, 0);
        }
     // }
  
    }



  /** This function is called periodically during autonomous. */
//   @Override
//   public void autonomousPeriodic() {
//     // Drive for 2 seconds
  
//     if (m_timer.get() < 30.0) {
//       setDriveMotors(0.4, 0.0);
//      // Drive forwards half speed, make sure to turn input squaring off
//       m_robotDrive.arcadeDrive(0.5, 0.0, false);
//       PWMSparkMax rearLeft = new PWMSparkMax(1);
//       rearLeft.enableDeadbandElimination(true);
//       System.out.println("M TIMER GIT");
//       rearLeft.close();
      
//     } else 
//       m_robotDrive.stopMotor(); // stop robot
//     }
//   }  
// }
/**
 * This function is called once each time the robot enters teleoperated mode.
 */


// ????????????????????????????????????????
//@Override
//public void teleopInit() {

//XboxController robotController = new XboxController(0);


//Trigger Ljoycon = new JoystickButton(robotController, 0);
// if(robotController.getXButton()){
// System.out.println("button has been pressed");

// }

// m_robotDrive.arcadeDrive(-m_controller.getLeftY(),
// -m_controller.getRightX());


// ?????????????????????????????????

// public class XboxController {

// }
// public WPI_TaLonSRX leftmaster = new WPI_TaLonSRX
// }
//}
}