package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.config.Config;
import org.firstinspires.ftc.teamcode.robot.Robot;


@TeleOp(name = "Test OpMode", group = "Iterative Opmode")
public class Test extends OpMode {

    Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);


        telemetry.addLine("Good luck, you'll need it.");
        telemetry.update();
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
        telemetry.addData("Heading: ", robot.imu.getHeading());
        telemetry.update();
    }

}