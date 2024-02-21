// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
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


  public Joystick driverjoytick = new Joystick(0);
  public Joystick mechjoytick = new Joystick(1);
 

  double MGIzq = driverjoytick.getRawAxis(2);
  double MGDer = driverjoytick.getRawAxis(3);

  private final JoystickButton Ma = new JoystickButton(mechjoytick, 0);
  private final JoystickButton Mb = new JoystickButton(mechjoytick, 1);
  private final JoystickButton My = new JoystickButton(mechjoytick, 3);
  private final JoystickButton Mx = new JoystickButton(mechjoytick, 2);
  private final JoystickButton Momorgencia = new JoystickButton(mechjoytick, 6);
  private final JoystickButton MBizq = new JoystickButton(mechjoytick, 4);
  private final JoystickButton MBder = new JoystickButton(mechjoytick, 5);

  boolean buttval = mechjoytick.getRawButton(0);

  public RobotContainer() {

    mecosmodule.setDefaultCommand(new conmecos(mecosmodule,

      () -> driverjoytick.getRawAxis(0),
      () -> driverjoytick.getRawAxis(1),
      () -> driverjoytick.getRawAxis(4)) {
      
    });

    moutake.setDefaultCommand(new comout(moutake,
    ()-> mechjoytick.getRawAxis(3),
    ()-> mechjoytick.getRawAxis(2) ){

    });

    posoutake.setDefaultCommand(new composout(posoutake,

    ()-> mechjoytick.getRawAxis(1)){
    
    });

    configureBindings();

  }

  private void configureBindings() { 

    My.whileTrue(new ParallelCommandGroup(new InstantCommand(()-> intake.reversed()), new comindex(index, -0.5)));
  
    //index
    Mx.toggleOnTrue(new comindex(index, 0.5));

    //emergencia
    //Momorgencia.toggleOnTrue(new InstantCommand(()-> intake.stop()));

   

    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
