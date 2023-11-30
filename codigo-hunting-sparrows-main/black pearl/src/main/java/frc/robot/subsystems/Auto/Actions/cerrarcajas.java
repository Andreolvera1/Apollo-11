package frc.robot.subsystems.Auto.Actions;
import frc.robot.subsystems.Cajas;
import edu.wpi.first.wpilibj.Timer;

public class cerrarcajas implements Action{
    Cajas mCajas = new Cajas();
    double duration;
    double startTime;
    
    public cerrarcajas(double induration){
        duration = induration;
    }

    public void start(){
        mCajas.cajasAuto(1);
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
        mCajas.cajasAuto(1);

    }
}