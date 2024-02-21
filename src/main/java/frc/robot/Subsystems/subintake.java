package frc.robot.Subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.intakeconst;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;


public class subintake extends SubsystemBase {

    CANSparkMax intake, index;
    DoubleSolenoid Piston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, intakeconst.sforwardchn, intakeconst.sreversedchn);
    private int intkid = intakeconst.m_intake;
    


    public subintake(){
        intake = new CANSparkMax(intkid, MotorType.kBrushless);
       
    }

    public void velocities(double speed){
        intake.set(speed);
        

    }

    public void pistonact(){
        Piston.toggle();
    }

    //funcoiones intake
    public void pistoninit(){
        Piston.set(DoubleSolenoid.Value.kReverse);
       
    }
    public void intakeinit(){
        intake.set(0);
    }

    

  
    //funciones index 

    
   //funciones reversa

   public void reversed(){
        
        intake.set(-0.5);
   }

   public void stop(){
    intake.set(0);
   }


    
}
