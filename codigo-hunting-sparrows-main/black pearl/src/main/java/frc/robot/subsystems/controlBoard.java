package frc.robot.subsystems;

import java.lang.annotation.Retention;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlBoard extends SubsystemBase {
  //Hardware ----------------------------------------------------------------->
  public final XboxController Control1 = new XboxController(0);
  public final XboxController Control2 = new XboxController(1);


  //INPUTS ------------------------------------------------------------------>
      
  //OUTPUTS ----------------------------------------------------------------->
      
  //Logic ----------------------------------------------------------------->
  
    
  public ControlBoard() {} //constructor del subsistema

  //------------------// Funciones del subsistema //-------------------------------//

  //funcion principal de Drive con argumentos de entrada de controles
  //botones
  public boolean XButton2(){
    return Control2.getRawButton(3);
  }
  public boolean XButton1(){
    return Control1.getRawButton(3);
  }
  public boolean getBButton2(){
    return Control2.getRawButton(2);
  }

  public boolean getAButton(){
    return Control2.getRawButton(1);
  }
  public boolean getButtonLB2(){
    return Control2.getRawButton(5);
  }
  public boolean getButtonRB2(){
    return Control2.getRawButton(6);
  }
  public boolean getButtonRB1(){
    return Control1.getRawButton(6);
  }
  public boolean getYButton(){
    return Control2.getRawButton(4);
  }

  public double getRightTrigger(){
    return Control1.getRawAxis(3);

  }
  public double getLeftTrigger(){
    return Control1.getRawAxis(2);
  }
  public double getRightJoystickX2(){
    return Control2.getRawAxis(4);
  }
  public double getLeftJoystickX(){
    return Control1.getRawAxis(0);
  }
  public double getLeftJoystickYP(){
    if(Control1.getRawAxis(1)>0){
      return Control1.getRawAxis(1);
    }
    return 0;
  }
  public double getLeftJoystickYN(){
    if(Control1.getRawAxis(1)<0){
      return -Control1.getRawAxis(1);
    }
    return 0;
  }

  public double getRightJoystickY(){
    return Control1.getRawAxis(5);
  }
  public double getRightJoystickX1(){
    return Control1.getRawAxis(4);
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
