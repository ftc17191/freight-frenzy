package org.firstinspires.ftc.teamcode.driverop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.config.Config;
import org.firstinspires.ftc.teamcode.robot.Robot;


@TeleOp(name = "2 Person DriverOp", group = "Iterative Opmode")
public class DriverOp extends OpMode {

    Robot robot;
    int armTarget = 0;

    int firstLevelTarget = 0;
    int secondLevelTarget = 0;
    int thirdLevelTarget = 0;
    int armLimit = 1440;

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
        armTarget = 0;
    }

    @Override
    public void loop() {

        robot.train.powerDrive(
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

        if (gamepad2.dpad_up && armTarget < armLimit) {
            armTarget++;
        } else if (gamepad2.dpad_down && armTarget > 0) {
            armTarget--;
        }

        robot.arm.dcMotor.setTargetPosition(armTarget);
        robot.arm.dcMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(robot.arm.dcMotor.isBusy()) {
            robot.arm.setPower(.75);
        }
        robot.arm.setPower(0);


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

        telemetry.addData("Arm Target Pos", armTarget);
        telemetry.addData("current armpos", robot.arm.dcMotor.getTargetPosition());

        telemetry.addData("GP2 left stick y val", gamepad2.left_stick_y);
        telemetry.update();
    }
}