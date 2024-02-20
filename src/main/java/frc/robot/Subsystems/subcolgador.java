package frc.robot.Subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.colgConst;

public class subcolgador extends SubsystemBase {
    CANSparkMax colgador1, colgador2;
    private int Idcolg = colgConst.colgId;
    private int Idcolg2 = colgConst.colg2Id;

    public subcolgador(int Idcolg, int Idcolg2){
        colgador1 = new CANSparkMax(Idcolg, MotorType.kBrushless);
        colgador2 = new CANSparkMax(Idcolg2, MotorType.kBrushless);

    }

    public void subircolg(){
        colgador1.set(0);
        colgador2.set(0);
    }

    


}
