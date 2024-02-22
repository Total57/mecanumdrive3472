package frc.robot.Commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subindex;

public class comindex extends Command{
    subindex index;
    Double speedy;

    public comindex(subindex index, Double speedy){

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
        
        
        return false;
    }


    
}
