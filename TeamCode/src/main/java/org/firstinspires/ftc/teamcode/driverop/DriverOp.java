package org.firstinspires.ftc.teamcode.driverop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.config.Config;
import org.firstinspires.ftc.teamcode.robot.Robot;


@TeleOp(name = "DriverOp", group = "Iterative Opmode")
public class DriverOp extends OpMode {

    Robot robot;
    double stopTime = 122;

    boolean isTriggerPressed = false;
    @Override
    public void init() {
        robot = new Robot(hardwareMap);
        robot.carousel.dcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        robot.arm.dcMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        telemetry.addLine("Good luck, you'll need it.");
        telemetry.update();
    }

    @Override
    public void start() {
        resetStartTime();
    }

    @Override
    public void loop() {

        robot.train.powerAbsoluteDrive(
                -gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x);

        if (gamepad2.b)
        {
            robot.carousel.setPower(robot.redCarouselSpeed);
        } else if (gamepad2.x) {
            robot.carousel.setPower(robot.blueCarouselSpeed);
        } else {
            robot.carousel.setPower(0);
        }



        robot.arm.setPower(gamepad2.right_stick_y);





        if (gamepad2.right_trigger > 0.05 && !isTriggerPressed)
        {
            // Grip
            robot.rightGripper.setPosition(0);
            robot.leftGripper.setPosition(1);

            isTriggerPressed = true;
        } else if (gamepad2.right_trigger < 0.05 && isTriggerPressed) {
            // un grip

            robot.rightGripper.setPosition(1);
            robot.leftGripper.setPosition(0);

            isTriggerPressed = false;
        }

        telemetry.addData("Elapsed Time", getRuntime());
        if (getRuntime() > stopTime)
        telemetry.update();
    }

}

