package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.suboutake;

public class comout extends Command{
    suboutake outake;
    Supplier<Double>speed, speed2;

    public comout(suboutake outake, Supplier<Double>speed, Supplier<Double>speed2){
        
        this.outake = outake;
        this.speed = speed;
        this.speed2 = speed2;
        addRequirements(outake);        

    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
       double gatder = speed.get();
       double gatizq = speed2.get();

       if (gatder > 0.001 && gatizq < 0.001){
        
        outake.setoutakespeed(0.9);
       }
       
       else if (gatder < 0.001 && gatizq > 0.001){

        outake.setoutakespeed(0.3);}

       else{

        outake.setoutakespeed(0);}

       }

    @Override
    public boolean isFinished(){
        
        return false;
    }
  
}
