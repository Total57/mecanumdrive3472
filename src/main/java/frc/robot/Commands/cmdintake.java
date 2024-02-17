package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subintake;

public class cmdintake extends Command{
    subintake intake;

    public cmdintake(subintake intake){

        addRequirements(intake);        
        this.intake = intake;

    }

    @Override
    public void initialize(){
        intake.setintake();
    }

    @Override
    public void execute(){
        intake.upintake();
    }

    @Override
    public boolean isFinished(){
        intake.stopintake();
        return true;
    }


    
}
