package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//adelante es right negativo y left positivo

public class Drive extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final TalonSRX MotorFR = new TalonSRX(Constants.IDmotorFR); //declaracion del talon con constante
  public final TalonSRX MotorBR = new TalonSRX(Constants.IDmotorBR);
  public final TalonSRX MotorFL = new TalonSRX(Constants.IDmotorFL);
  public final TalonSRX MotorBL = new TalonSRX(Constants.IDmotorBL);

  //INPUTS ------------------------------------------------------------------>
  double xSpeed = 0;
  double Throttle = 0;  
  double Brake = 0;  
    
  //OUTPUTS ----------------------------------------------------------------->
  double final_left_front_demand = 0;
  double final_right_front_demand = 0;
  double final_left_back_demand = 0;
  double final_right_back_demand = 0;

  //Logic ----------------------------------------------------------------->
  boolean rampActive = true;
  double leftPwm = 0;
  boolean Flag =true;
  boolean pinverted = false;
  double rightPwm = 0;
    
  public Drive() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void mainDrive(double xInSpeed, double InBrake, double inThrottle, boolean inverted ){
    xSpeed = xInSpeed;
    Brake = InBrake *Constants.DriveSensitivity;
    Throttle = inThrottle*Constants.DriveSensitivity;
    if (!inverted==pinverted){
      pinverted = inverted;
      if(inverted){
        Flag = !Flag;
      }
    }
    double absThrottle = Throttle - Brake;
     //valor de absMove con sensibilidad del control

    if(xSpeed>=0){
      leftPwm = ((xSpeed) + absThrottle)*Constants.DriveSensitivity; //sensibilidad del control agregada
      rightPwm = -(-(xSpeed) + absThrottle)*Constants.DriveSensitivity;
    }
    else{
      leftPwm = ((xSpeed) + absThrottle)*Constants.DriveSensitivity;
      rightPwm = -(-(xSpeed) + absThrottle)*Constants.DriveSensitivity;
  }
 /*
    final_right_front_demand = speedTramp(rightPwm, final_right_front_demand);
    final_right_back_demand = speedTramp(rightPwm, final_right_back_demand);
    final_left_front_demand = speedTramp(leftPwm, final_left_front_demand);
    final_left_back_demand = speedTramp(leftPwm, final_left_back_demand);
*/

    final_right_front_demand = rightPwm;
    final_right_back_demand = rightPwm;
    final_left_front_demand =leftPwm;
    final_left_back_demand = leftPwm;


    
    

    outMotores(); //llamado de la funcion de salida de motores
   }

  //Funcion que le da salida de motores
  private void outMotores(){
    if(Flag){
    MotorFR.set(ControlMode.PercentOutput, final_right_front_demand);
    MotorBR.set(ControlMode.PercentOutput, final_right_back_demand);
    MotorFL.set(ControlMode.PercentOutput, final_left_front_demand);
    MotorBL.set(ControlMode.PercentOutput, final_left_back_demand);
    }
    else{
    MotorFR.set(ControlMode.PercentOutput, final_left_back_demand);
    MotorBR.set(ControlMode.PercentOutput, final_left_front_demand);
    MotorFL.set(ControlMode.PercentOutput, final_right_back_demand);
    MotorBL.set(ControlMode.PercentOutput, final_right_front_demand);
    }
  }

  public void outMotoresAuto( double frontRightDemand, double backRightDemand, 
    double frontLeftDemand, double backleftDemand ){
      MotorFR.set(ControlMode.PercentOutput, frontRightDemand);
      MotorBR.set(ControlMode.PercentOutput, backRightDemand);
      MotorFL.set(ControlMode.PercentOutput, frontLeftDemand);
      MotorBL.set(ControlMode.PercentOutput, backleftDemand);
  }

  //Funcion para la rampa de velocidad que toma argumentos de velocidad actual y la velocidad que da el control
  
  private double speedTramp( double targetSpeed, double currentSpeed ){
    if( Math.abs( (Math.abs(targetSpeed) - Math.abs(currentSpeed) ) ) < Constants.DriveRampD) return targetSpeed;
    if( currentSpeed < targetSpeed ) return currentSpeed + Constants.DriveRampD;
    else if( currentSpeed > targetSpeed ) return currentSpeed - Constants.DriveRampD;
    return 0;
    
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}