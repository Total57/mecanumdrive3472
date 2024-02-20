package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subintake;

public class comintake extends Command{
    subintake intake;
    private final double speed;

    public comintake(subintake intake, double speed){
        
        this.intake = intake;
        this.speed = speed;
        addRequirements(intake);        

    }

    @Override
    public void initialize(){
        
        intake.pistoninit();
    }

    @Override
    public void execute(){
        intake.velocities(speed);
    }

    @Override
    public boolean isFinished(){
        
        intake.velocities(0);
        intake.pistoninit();
        return false;
    }
  
}

