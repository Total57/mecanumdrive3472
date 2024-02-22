// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.comindex;
import frc.robot.Commands.comintake;
import frc.robot.Commands.comout;
import frc.robot.Commands.composout;
import frc.robot.Commands.conmecos;
import frc.robot.Subsystems.subindex;
import frc.robot.Subsystems.subintake;
import frc.robot.Subsystems.submecos;
import frc.robot.Subsystems.suboutake;
import frc.robot.Subsystems.subpos;

public class RobotContainer {

  private final submecos mecosmodule = new submecos();

  private final suboutake moutake = new suboutake();

  private final subpos posoutake = new subpos();

  private final subintake intake = new subintake();

  private final subindex index = new subindex();


  public XboxController driverjoytick = new XboxController(0);
  public CommandXboxController mechjoytick = new CommandXboxController(1);
 

  public RobotContainer() {

    mecosmodule.setDefaultCommand(new conmecos(mecosmodule,

      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftX.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftY.value),
      ()-> driverjoytick.getRawAxis(XboxController.Axis.kRightX.value)) {
      
    });

    moutake.setDefaultCommand(new comout(moutake,
    ()-> mechjoytick.getRawAxis(XboxController.Axis.kRightTrigger.value),
    ()-> mechjoytick.getRawAxis(XboxController.Axis.kLeftTrigger.value), 
    ()-> driverjoytick.getRawAxis(XboxController.Axis.kRightTrigger.value),
    ()-> driverjoytick.getRawAxis(XboxController.Axis.kLeftTrigger.value)
    ){

    });

    posoutake.setDefaultCommand(new composout(posoutake,

    ()-> mechjoytick.getRawAxis(XboxController.Axis.kLeftY.value)){
    
    });

    /*index.setDefaultCommand(new comindex(index,

      ()-> mechjoytick.getRawAxis(5)) {
      
    });   */

    configureBindings(); 

  }

  private void configureBindings() { 

    mechjoytick.x().toggleOnTrue(new comindex(index, 0.5)); 

    mechjoytick.a().toggleOnTrue(new comintake(intake, 1));

    mechjoytick.y().whileTrue(new ParallelCommandGroup(new InstantCommand(()-> intake.reversed()), new comindex(index, -0.5)));
  
    mechjoytick.start().toggleOnTrue(new InstantCommand(()-> intake.stop()));
    mechjoytick.b().toggleOnTrue(new InstantCommand(()-> intake.forward()));

    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}