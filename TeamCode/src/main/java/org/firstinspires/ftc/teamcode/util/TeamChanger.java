package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.config.Config;

public class TeamChanger extends LinearOpMode {

    Config config;

    @Override
    public void runOpMode()  {
        config = new Config();

        if (config.getTeam() == Config.Team.RED) {
            telemetry.addLine("Your current team is: Red");
        } else if (config.getTeam() == Config.Team.BLUE) {
            telemetry.addLine("Your current team is: Blue");
        }

        telemetry.addLine("Press Start to Switch Teams");
        waitForStart();

        if (config.getTeam() == Config.Team.RED) {
            config.setTeam(Config.Team.BLUE);
        } else if (config.getTeam() == Config.Team.BLUE) {
            config.setTeam(Config.Team.RED);
        }
    }
}
