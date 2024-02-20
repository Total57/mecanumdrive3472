package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.suboutake;

public class comout extends Command{
    suboutake outake;
    private final double speed;

    public comout(suboutake outake, double speed){
        
        this.outake = outake;
        this.speed = speed;
        addRequirements(outake);        

    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        outake.setoutakespeed(speed);
    }

    @Override
    public boolean isFinished(){

        outake.setoutakespeed(0);
        return false;
    }
  
}
