package org.firstinspires.ftc.teamcode.robot;

import org.firstinspires.ftc.teamcode.config.Config;
import org.firstinspires.ftc.teamcode.ftclayer.drivetrain.mechanum.Mechanum;
import org.firstinspires.ftc.teamcode.ftclayer.hardware.motors.MotorEx;

public class Robot
{
    private Config conf;
    private Mechanum drive;
    private MotorEx carousel_turner;

    public Robot(Config config)
    {
        conf = config;
    }



}
