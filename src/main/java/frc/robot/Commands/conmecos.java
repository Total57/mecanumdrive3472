package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.submecos;

public class conmecos extends Command {
    submecos mecosmodule;
   // Supplier<Double> x, y, turn;
    Supplier<Double>xSpdfunction,ySpdFunction,turningSpdFunction;
    Joystick driverjoytick;
    
  
    public conmecos(submecos mecosmodule, Supplier<Double> xSpdfunction, Supplier<Double> ySpdfunction, 
                Supplier<Double> turningSpdfunction){
                
               
        this.mecosmodule = mecosmodule;

        this.xSpdfunction = xSpdfunction;
        this.ySpdFunction = ySpdfunction;
        this.turningSpdFunction = turningSpdfunction;

        addRequirements(mecosmodule); 
            
      /*   this.x = x;
        this.y = y;
        this.turn = turn; */
    
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){

        double x_value = xSpdfunction.get();
        double y_value = ySpdFunction.get();
        double turn_value = turningSpdFunction.get();


       /* double x = driverjoytick.getRawAxis(0);
        double y = -driverjoytick.getRawAxis(1);
        double turn = driverjoytick.getRawAxis(4); */ 

        double power = Math.hypot(x_value, y_value);


        if (power < 0.001) {
            mecosmodule.driveMecos(0,0,0);
        }

        
        double theta = Math.atan2(y_value, x_value);

        mecosmodule.driveMecos(theta, power, turn_value);

    }

    @Override
    public boolean isFinished(){
        return false;
    }


}