package frc.robot.Commands;

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
        index.setindexspeed(0);
    }

    @Override
    public void execute(){
        
        index.setindexspeed(speedy);
    }

    @Override
    public void end(boolean interrupted) {
        index.setindexspeed(0);
    }


    @Override
    public boolean isFinished(){
        
        
        return false;
    }

    
}
