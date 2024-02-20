package frc.robot.Subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intakeconst;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;


public class subintake extends SubsystemBase {

    CANSparkMax intake, index;
    private DoubleSolenoid Piston;
    private int intkid = intakeconst.m_intake;
    private int indxid = intakeconst.m_index;
    private int forwardid = intakeconst.sforwardchn;
    private int reversedid = intakeconst.sreversedchn;

    public subintake(int m_index, int m_intake, int sforwardchn, int sreversedchn){

        Piston  = new DoubleSolenoid(PneumaticsModuleType.REVPH, forwardid, reversedid);
        intake = new CANSparkMax(intkid, MotorType.kBrushless);
        index = new CANSparkMax(indxid, MotorType.kBrushless);

        Piston.close();

    }

    public void velocities(double speed){
        intake.set(speed);
        Piston.toggle();

    }

    //funcoiones intake
    public void pistoninit(){
        Piston.set(DoubleSolenoid.Value.kReverse);
       
    }

  
    //funciones index 

    public void setoutakespeed(double indexspeed){
        index.set(indexspeed);
    }
   //funciones reversa

   public void reversed(){
        index.set(-0.5);
        intake.set(-0.5);
   }


    
}
