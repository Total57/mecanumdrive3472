package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.submecos;

public class conmecos extends Command {
    submecos mecosmodule;
    Supplier<Double> x, y, turn;
    Joystick driverjoytick;
    
  
  

    public conmecos(submecos mecosmodule, Supplier<Double> x, Supplier<Double> y, 
                Supplier<Double> turn){
                
        addRequirements(mecosmodule);        
        this.mecosmodule = mecosmodule;
            
        this.x = x;
        this.y = y;
        this.turn = turn;
    
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){


        double x = driverjoytick.getRawAxis(0);
        double y = -driverjoytick.getRawAxis(1);
        double turn = driverjoytick.getRawAxis(4);

        double power = Math.hypot(x, y);

        if (power < 0.001) {
            return;
        }

        double theta = Math.atan2(y, x);

        mecosmodule.driveMecos(theta, power, turn);

    }

    @Override
    public boolean isFinished(){
        return true;
    }


}