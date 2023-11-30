package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Timer;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->

  public final TalonSRX Motorintake = new TalonSRX(Constants.IDintake);

  //INPUTS ------------------------------------------------------------------>
  boolean Flag = false;
  boolean prevact= false;
      
  //OUTPUTS ----------------------------------------------------------------->
double t = 0;

    
  //Logic ----------------------------------------------------------------->
  
    
  public Intake() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void activateIntake(boolean active, boolean remove){
    if (!active==prevact){
      prevact = active;
      if(active){
        Flag = !Flag;
      }
    }
    if (remove){  
      Motorintake.set(ControlMode.PercentOutput, .7 );
  }
  else{
    if (Flag){  
        Motorintake.set(ControlMode.PercentOutput, -.7 );
    }
    else{
        Motorintake.set(ControlMode.PercentOutput, 0);
    } 
  }
}
public void Intakeauto(double potencia){
  Motorintake.set(ControlMode.PercentOutput, potencia);
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
