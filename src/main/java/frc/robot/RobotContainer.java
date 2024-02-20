// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.comintake;
import frc.robot.Commands.comout;
import frc.robot.Commands.conmecos;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;


public class RobotContainer {

  private final submecos mecosmodule = new submecos(constants.driveconst.fi_id,
                                                    constants.driveconst.fd_id,
                                                    constants.driveconst.ai_id,
                                                    constants.driveconst.ad_id);

  private final suboutake outake = new suboutake(
                                                  constants.outakeconst.outid, 
                                                  constants.outakeconst.outid2,
                                                  constants.outakeconst.posoutid,
                                                  constants.outakeconst.posoutid2
  );

  private final subintake intake = new subintake(
                                                  constants.intakeconst.m_index,
                                                  constants.intakeconst.m_intake,
                                                  constants.intakeconst.sforwardchn,
                                                  constants.intakeconst.sreversedchn
  );

  Joystick driverjoytick = new Joystick(0);
  Joystick mechjoytick = new Joystick(1);

  double MGIzq = driverjoytick.getRawAxis(2);
  double MGDer = driverjoytick.getRawAxis(3);

  private final JoystickButton Ma = new JoystickButton(mechjoytick, 0);
  private final JoystickButton Mb = new JoystickButton(mechjoytick, 1);
  private final JoystickButton My = new JoystickButton(mechjoytick, 3);
  private final JoystickButton Mx = new JoystickButton(mechjoytick, 2);
  private final JoystickButton Momorgencia = new JoystickButton(mechjoytick, 6);
  private final JoystickButton MBizq = new JoystickButton(mechjoytick, 4);
  private final JoystickButton MBder = new JoystickButton(mechjoytick, 5);


  boolean buttval = mechjoytick.getRawButton(o);
  

  public RobotContainer() {

    mecosmodule.setDefaultCommand(new conmecos(mecosmodule,

      () -> driverjoytick.getRawAxis(0),
      () -> driverjoytick.getRawAxis(1),
      () -> driverjoytick.getRawAxis(4)) {
      
    });


    configureBindings();


  }

  private void configureBindings() { 
    //outake
    MBizq.whileTrue(new comout(outake, 0.3));
    MBder.whileTrue(new comout(outake, 0.9));

    
    int flag ;
    

    while (buttval == true){

      flag = flag + 1;

    }

    int b = flag%2;

    if (b != 0){
     // return new comintake(intake, 0.5);
    }



    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
