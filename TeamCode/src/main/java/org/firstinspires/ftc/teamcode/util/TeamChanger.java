package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.config.Config;

@TeleOp(name = "Team Changer", group = "Iterative opmode")
public class TeamChanger extends LinearOpMode {

    Config config;

    @Override
    public void runOpMode()  {
        config = new Config();

        if (config.getTeam() == Config.Team.RED) {
            telemetry.addLine("Your current team is: Red");
        } else if (config.getTeam() == Config.Team.BLUE) {
            telemetry.addLine("Your current team is: Blue");
        } else if (config.getTeam() == null) {
            telemetry.addLine("You have no team set. Start will add a team");
        }

        telemetry.addLine("Press Start to Switch Teams");
        waitForStart();

        if (config.getTeam() == Config.Team.RED) {
            config.setTeam(Config.Team.BLUE);
        } else if (config.getTeam() == Config.Team.BLUE) {
            config.setTeam(Config.Team.RED);
        } else {
            config.setTeam(Config.Team.RED);
        }
    }
}
