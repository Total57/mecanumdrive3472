package frc.robot.Commands;

import java.util.function.Supplier;
import java.lang.Math;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.submecos;

public class conmecos extends Command {
    submecos mecosmodule;
   Supplier<Double> x, y, turn;
  
    public conmecos(submecos mecosmodule, Supplier<Double> x, Supplier<Double> y, 
                Supplier<Double> turn){
                
               
        this.mecosmodule = mecosmodule;
     
        this.x = x;
        this.y = y;
        this.turn = turn;
        addRequirements(mecosmodule); 
    
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){

        double x_pos = - x.get();
        double y_pos = y.get();
        double turn_pos = turn.get();  

        double power = Math.hypot(x_pos, y_pos);

        if (power < 0.001) {
            mecosmodule.driveMecos(0,0,turn_pos);
        }

        double theta = Math.atan2(y_pos, x_pos);

        mecosmodule.driveMecos(theta, power, turn_pos);

    }

    @Override
    public boolean isFinished(){
        return false;
    }


}