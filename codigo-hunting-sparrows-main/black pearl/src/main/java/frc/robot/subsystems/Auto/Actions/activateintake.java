package frc.robot.subsystems.Auto.Actions;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Timer;

public class activateintake implements Action{
    Intake mIntake = new Intake();
    double duration;
    double startTime;
    
    public activateintake(double induration){
        duration = induration;
    }

    public void start(){
        mIntake.Intakeauto(.7);
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
        mIntake.Intakeauto(0);

    }
}