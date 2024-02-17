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

    public subintake(int m_index, int m_intake, DoubleSolenoid Piston){

        Piston  = new DoubleSolenoid(PneumaticsModuleType.REVPH, intakeconst.sforwardchn, intakeconst.sreversedchn);
        intake = new CANSparkMax(intkid, MotorType.kBrushless);
        index = new CANSparkMax(indxid, MotorType.kBrushless);

        Piston.close();

    }

    //funcoiones intake
    public void setintake(){
        Piston.set(DoubleSolenoid.Value.kReverse);
        Piston.close();
    }

    public void upintake (){
        intake.set(0.7);
        Piston.toggle();
    }

    public void stopintake(){
        intake.set(0);
        Piston.set(DoubleSolenoid.Value.kReverse);
    }

    public void emergency(){
        intake.set(0);
    }

    //funciones index 

    public void onindex(){
        index.set(0.5);
    }

    public void offindex(){
        index.set(0);
    }

   //funcoines reversa

   public void reversed(){
        index.set(-0.5);
        intake.set(-0.5);
   }


    
}
