package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.IFollower;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;


public class Cajas extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final TalonSRX Cajas1 = new TalonSRX(Constants.IDc1);
  public final TalonSRX Cajas2 = new TalonSRX(Constants.IDc2);

  //INPUTS ------------------------------------------------------------------>
  DigitalInput LimitIR = new DigitalInput(0);
  DigitalInput LimitIL = new DigitalInput(1);
  boolean Flag = false;
  boolean prevb = false;

  //OUTPUTS ----------------------------------------------------------------->
  double final_feeder_demand;
    
  //Logic ----------------------------------------------------------------->
  public Cajas(){}


  //------------------// Funciones del subsistema //-------------------------------//
public void moverCajas(double speedG, boolean d, boolean i){
  if (i){
    Cajas2.set(ControlMode.PercentOutput, speedG*0.2); //izquierda
    Cajas1.set(ControlMode.PercentOutput, 0); //derecha
  }
  else if(d){
    Cajas2.set(ControlMode.PercentOutput, 0); //izquierda
    Cajas1.set(ControlMode.PercentOutput, speedG*0.2); //derecha
  }
 else {
  Cajas2.set(ControlMode.PercentOutput, speedG*0.2); //izquierda
  Cajas1.set(ControlMode.PercentOutput, -speedG*0.2);
 }
}
public void cajasAuto(int estado){
  if (estado == 1){
    Cajas2.set(ControlMode.PercentOutput, 0.15); //izquierda
    Cajas1.set(ControlMode.PercentOutput, -0.15);
  }
  else if(estado == 2){
    Cajas2.set(ControlMode.PercentOutput, -0.15); //izquierda
    Cajas1.set(ControlMode.PercentOutput, 0.15);
  }
  else{
    Cajas2.set(ControlMode.PercentOutput, 0); //izquierda
    Cajas1.set(ControlMode.PercentOutput, 0);
  }
}
 



  @Override
  public void periodic() {
    // his metill be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
