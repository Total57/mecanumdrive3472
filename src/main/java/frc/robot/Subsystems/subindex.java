package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.intakeconst;

public class subindex extends SubsystemBase{
    CANSparkMax index;
    private int indxid = intakeconst.m_index;

    public subindex(){
    
        index = new CANSparkMax(indxid, MotorType.kBrushless);
    }

    public void setindexspeed(double indexspeed){
        index.set(indexspeed);
    }

}
