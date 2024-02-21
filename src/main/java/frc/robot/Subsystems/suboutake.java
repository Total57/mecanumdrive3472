package frc.robot.Subsystems;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.outakeconst;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class suboutake extends SubsystemBase{

    CANSparkMax outake, outake2, posout1, posout2;

    private int outakeid = outakeconst.outid;
    private int outakeid2 = outakeconst.outid2;
    private int poutid = outakeconst.posoutid;
    private int poutid2 = outakeconst.posoutid2;

    private Encoder encoderBore = new Encoder(outakeconst.encoderAchannel, outakeconst.encoderBchannel,outakeconst.encoderIndchannel);


    public suboutake(int outid, int outid2, int posutid, int posutid2){
        outake = new CANSparkMax(outakeid, MotorType.kBrushless);
        outake2 = new CANSparkMax(outakeid2, MotorType.kBrushless);

        posout1 = new CANSparkMax(poutid, MotorType.kBrushless);
        posout2 = new CANSparkMax(poutid2, MotorType.kBrushless);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Encoder bore Encoder Encoder externo Encoder Absoluto", encoderBore.getDistance());
        outake2.follow(outake);
        posout2.follow(posout1);

    }
        public void setoutakespeed(double outspeed){
            outake.set(outspeed);
        }

        public void setposspeed(double oposspeed){
            posout1.set(oposspeed);
        }

}