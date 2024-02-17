package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.outakeconst;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class suboutake extends SubsystemBase{

    CANSparkMax outake;

    private int outakeid = outakeconst.outid;


    public suboutake(int outid){
        outake = new CANSparkMax(outakeid, MotorType.kBrushless);
 
 
    }

    public void lowvel(){
        outake.set(0.3);
    }

    public void highvel(){
        outake.set(0.9);
    }

    public void stopoutake(){
        outake.set(0);
    }

    @Override
    public void periodic(){
        //SmartDashboard.putNumber("Encoder Externo", enc;
    }
}
