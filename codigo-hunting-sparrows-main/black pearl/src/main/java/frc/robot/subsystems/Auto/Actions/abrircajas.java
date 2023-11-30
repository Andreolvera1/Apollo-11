package frc.robot.subsystems.Auto.Actions;
import frc.robot.subsystems.Cajas;

import edu.wpi.first.wpilibj.Timer;


public class abrircajas implements Action{
    Cajas mCajas = new Cajas();
    double duration;
    double startTime;
    
    public abrircajas(double induration){
        duration = induration;
    }

    public void start(){
        mCajas.cajasAuto(2);
        startTime = Timer.getFPGATimestamp();
        


    }
    public boolean update(){
        if (Timer.getFPGATimestamp()-startTime >= duration){
            return false;
        }
        else{
            return true;
        }
    }
    public void done(){
        mCajas.cajasAuto(3);

    }
}