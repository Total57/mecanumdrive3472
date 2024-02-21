package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subintake;

public class comindex extends Command{
    subintake index;
    private final double speedy;

    public comindex(subintake index, double speedy){

        this.index = index;
        this.speedy = speedy;

        addRequirements(index);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        index.setindexspeed(speedy);
    }

    @Override
    public boolean isFinished(){
        index.setindexspeed(0);
        
        return false;
    }


    
}
