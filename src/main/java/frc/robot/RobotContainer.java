// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.cmdintake;
import frc.robot.Commands.conmecos;
import frc.robot.Subsystems.submecos;


public class RobotContainer {

  private final submecos mecosmodule = new submecos(constants.driveconst.fi_id,
                                                    constants.driveconst.fd_id,
                                                    constants.driveconst.ai_id,
                                                    constants.driveconst.ad_id);

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
  

  public RobotContainer() {

    mecosmodule.setDefaultCommand(new conmecos(mecosmodule,

      () -> driverjoytick.getRawAxis(0),
      () -> driverjoytick.getRawAxis(1),
      () -> driverjoytick.getRawAxis(4)) {
      
    });


    configureBindings();


  }

  private void configureBindings() {

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
