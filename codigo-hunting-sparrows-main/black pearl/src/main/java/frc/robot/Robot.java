package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Auto.modes.mode1;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Cajas;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.subsystems.Drive;
import frc.robot.subsystems.ControlBoard;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  //aqui declaramos todo lo que vamos a usar
  Drive mDrive = new Drive();
  mode1 mmode1 = new mode1();
  Cajas mCajas = new Cajas();
  Intake intake = new Intake();
  ControlBoard mControlBoard = new ControlBoard();
  private RobotContainer m_robotContainer; 
  
  private static final int PDH_CAN_ID = 1;
  private static final int NUM_PDH_CHANNELS = 24;

  PowerDistribution m_pdh = new PowerDistribution(PDH_CAN_ID,ModuleType.kRev);
    
  
  //aqui declaramos todo lo que vamos a usar
 
  //Declaracion de motores
  public final TalonSRX MotorFR = new TalonSRX(Constants.IDmotorFR); //declaracion del talon con constante
  public final TalonSRX MotorBR = new TalonSRX(Constants.IDmotorBR);
  public final TalonSRX MotorFL = new TalonSRX(Constants.IDmotorFL);
  public final TalonSRX MotorBL = new TalonSRX(Constants.IDmotorBL);
  public final TalonSRX Cajas1 = new TalonSRX(Constants.IDc1);
  public final TalonSRX Cajas2 = new TalonSRX(Constants.IDc2);

  
  //Variables
  //Declaracion del control
  
  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();
    CameraServer.startAutomaticCapture();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    mmode1.routine();
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    compressor.enableDigital();
    compressor.enabled();
  }

  //Lo que se va a ejecutar durante el match
  @Override
  public void teleopPeriodic() {
  mDrive.mainDrive(mControlBoard.getRightJoystickX1(), mControlBoard.getLeftJoystickYP(), mControlBoard.getLeftJoystickYN(), mControlBoard.getButtonRB1());
  intake.activateIntake(mControlBoard.getYButton(), mControlBoard.getAButton());
  mCajas.moverCajas(mControlBoard.getRightJoystickX2(), mControlBoard.getButtonRB2(), mControlBoard.getButtonLB2());
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
