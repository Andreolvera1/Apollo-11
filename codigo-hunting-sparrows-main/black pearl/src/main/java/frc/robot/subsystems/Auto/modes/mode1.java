package frc.robot.subsystems.Auto.modes;
import frc.robot.subsystems.Auto.Actions.*;

public class mode1 extends runAction{
  
   public void routine(){
      run (new abrircajas(1));
      //run(new Backwards(1.5));
      run(new cerrarcajas(2));
      //run(new TurnLeft(1.5));
      //run(new Forward(1));
      run(new abrircajas(1));
      

   
}}