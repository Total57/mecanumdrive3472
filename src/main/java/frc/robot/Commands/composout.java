package frc.robot.Commands;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.subpos;

public class composout extends Command{

    subpos posoutake;
    Supplier<Double>posspeed;

    public composout(subpos posoutake, Supplier<Double>posspeed){

        this.posoutake = posoutake;
        this.posspeed = posspeed;

        addRequirements(posoutake);

    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){

        double speedpos = posspeed.get();

        posoutake.setposspeed(speedpos * 0.85);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
