package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gancho extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final Solenoid piston2 = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

  //INPUTS ------------------------------------------------------------------>
  boolean prevb = false;
  boolean Flag = true;
  //OUTPUTS ----------------------------------------------------------------->
  double final_shooter_demand;
    
  //Logic ----------------------------------------------------------------->
  
    
  public Gancho() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  public void actgancho(boolean b ){
    if (!b==prevb){
      prevb = b;
    
    if(b){
      Flag = !Flag;
    }
  }
    piston2.set(Flag);
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
