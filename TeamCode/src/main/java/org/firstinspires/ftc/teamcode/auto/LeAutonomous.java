package org.firstinspires.ftc.teamcode.auto;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robot.Robot;

@Autonomous(name = "Autonomous")
public class LeAutonomous extends LinearOpMode {
    Robot robot = new Robot(hardwareMap);


    @Override
    public void runOpMode()
    {
        robot.train.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.train.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.train.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.train.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        waitForStart();

    }

    public void driveForwardTicks(int ticks)
    {
        robot.train.frontRightMotor.goToPosition(-ticks);
        robot.train.frontLeftMotor.goToPosition(ticks);
        robot.train.backRightMotor.goToPosition(-ticks);
        robot.train.backLeftMotor.goToPosition(ticks);
    }

    public void turnRight()
    {
        robot.train.frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.train.frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.train.backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.train.backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        double initial = robot.imu.getHeading();

        robot.train.frontRightMotor.setPower(-1);
        robot.train.frontLeftMotor.setPower(-1);
        robot.train.backRightMotor.setPower(-1);
        robot.train.backLeftMotor.setPower(-1);


        // wait till we are there
        while (robot.imu.getHeading() < initial + 90)
        {
        }
        robot.train.frontRightMotor.setPower(0);
        robot.train.frontLeftMotor.setPower(0);
        robot.train.backRightMotor.setPower(0);
        robot.train.backLeftMotor.setPower(0);


    }

    public void turnLeft()
    {
        robot.train.frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.train.frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.train.backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        robot.train.backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        double initial = robot.imu.getHeading();

        robot.train.frontRightMotor.setPower(1);
        robot.train.frontLeftMotor.setPower(1);
        robot.train.backRightMotor.setPower(1);
        robot.train.backLeftMotor.setPower(1);


        // wait till we are there
        while (robot.imu.getHeading() < initial - 90)
        {
        }
        robot.train.frontRightMotor.setPower(0);
        robot.train.frontLeftMotor.setPower(0);
        robot.train.backRightMotor.setPower(0);
        robot.train.backLeftMotor.setPower(0);


    }

}
