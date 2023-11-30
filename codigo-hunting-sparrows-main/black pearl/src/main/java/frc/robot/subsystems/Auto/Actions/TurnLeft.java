package frc.robot.subsystems.Auto.Actions;
import frc.robot.subsystems.Drive;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class TurnLeft  implements Action{
    Drive mAutoDrive = new Drive();
    double duration;
    double startTime;
    
    public TurnLeft(double induration){
        duration = induration;
    }

    public void start(){
        mAutoDrive.outMotoresAuto(-Constants.Autospeed, -Constants.Autospeed, -Constants.Autospeed, -Constants.Autospeed);
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
        mAutoDrive.outMotoresAuto(0, 0, 0, 0);

    }
}