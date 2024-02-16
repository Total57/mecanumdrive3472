// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.conmecos;
import frc.robot.Subsystems.submecos;


public class RobotContainer {

  private final submecos mecosmodule = new submecos(constants.driveconst.fi_id,
                                                    constants.driveconst.fd_id,
                                                    constants.driveconst.ai_id,
                                                    constants.driveconst.ad_id);

  XboxController joytick = new XboxController(0);

  public RobotContainer() {

    mecosmodule.setDefaultCommand(new conmecos(mecosmodule,

      () -> joytick.getRawAxis(0),
      () -> joytick.getRawAxis(1),
      () -> joytick.getRawAxis(4)) {
      
    });


    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
