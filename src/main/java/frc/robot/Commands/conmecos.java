package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.submecos;

public class conmecos extends Command {
    submecos mecosmodule;
    Supplier<Double> x, y, turn, theta, power;

    XboxController joytick;
    
  
  

    public conmecos(submecos mecosmodule, Supplier<Double> x, Supplier<Double> y, 
                Supplier<Double> turn){
                
        addRequirements(mecosmodule);        
        this.mecosmodule = mecosmodule;
            
        this.x = x;
        this.y = y;
        this.turn = turn;
    
    }



    @Override
    public void execute(){


        double x = joytick.getRawAxis(0);
        double y = -joytick.getRawAxis(1);
        double turn = joytick.getRawAxis(4);

        double theta = Math.atan2(y, x);
        double power = Math.hypot(x, y);

        mecosmodule.driveMecos(theta, power, turn);
        

    }


}
