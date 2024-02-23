package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.constants.outakeconst;

public class subpos extends SubsystemBase{

     CANSparkMax posout1, posout2;
     private int poutid = outakeconst.posoutid;
     private int poutid2 = outakeconst.posoutid2;
     private Encoder encoderBore = new Encoder(outakeconst.encoderAchannel, outakeconst.encoderBchannel,outakeconst.encoderIndchannel);


     public subpos(){
        posout1 = new CANSparkMax(poutid, MotorType.kBrushless);
        posout2 = new CANSparkMax(poutid2, MotorType.kBrushless);
     }

     public void angulo1(){

        while(encoderBore.getDistance()<90){

            posout1.set(0.6);
            posout2.set(0.6);

        }

   /*   public void angulo2(){

        while(encoderBore.getDistance()<120){

            posout1.set(0.6);
            posout2.set(0.6);
        }*/
    }


     

     @Override
    public void periodic(){

                SmartDashboard.putNumber("Encoder bore Encoder Encoder externo Encoder Absoluto", encoderBore.getDistance());

          
    }
        public void setposspeed(double oposspeed){
            posout1.set(oposspeed);
            posout2.set(oposspeed*-1);
        }




}
