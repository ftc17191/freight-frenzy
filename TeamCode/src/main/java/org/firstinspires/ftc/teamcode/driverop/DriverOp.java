package org.firstinspires.ftc.teamcode.driverop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.config.Config;
import org.firstinspires.ftc.teamcode.robot.Robot;


@TeleOp(name = "DriverOp", group = "Iterative Opmode")
public class DriverOp extends OpMode {

    Robot robot;
    Config config;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);

        telemetry.addLine("Press run on 3.");
        telemetry.addLine("Good luck, you'll need it.");
        telemetry.update();
    }

    @Override
    public void start() {
        resetStartTime();
    }

    @Override
    public void loop() {
        robot.drive.powerDrive( gamepad1.left_stick_y * robot.speedMultiplier,
                                gamepad1.left_stick_x * robot.speedMultiplier,
                                gamepad1.right_stick_x * robot.speedMultiplier);

        // arms up / down
        if (gamepad1.dpad_up)
        {
            // check for max
            if (robot.arm.getPosition() != 1) {
                robot.arm.setPosition(robot.arm.getPosition() + 0.01);
            }
        } else if (gamepad1.dpad_down)
        {
            // check for min
            if (robot.arm.getPosition() != 0) {
                robot.arm.setPosition(robot.arm.getPosition() - 0.01);
            }
        }


        // arms extend / retract
        if (gamepad1.dpad_left)
        {
            // check for max
            if (robot.reel.getPosition() != 1) {
                robot.reel.setPosition(robot.reel.getPosition() + 0.01);
            }
        } else if (gamepad1.dpad_right)
        {
            // check for min
            if (robot.reel.getPosition() != 0) {
                robot.reel.setPosition(robot.reel.getPosition() - 0.01);
            }
        }

        // Grip / no grip
        if (gamepad1.right_trigger > robot.triggerDeadZone) {
            robot.leftGripper.setPosition(robot.leftGripperClosed);
            robot.rightGripper.setPosition(robot.rightGripperClosed);
        } else {
            robot.leftGripper.setPosition(robot.leftGripperOpen);
            robot.rightGripper.setPosition(robot.rightGripperOpen);
        }

        // Carousel
        if (gamepad1.a) {
            if (config.getTeam() == Config.Team.RED) {

            } else if (config.getTeam() == Config.Team.BLUE) {

            }
        }
    }
}
