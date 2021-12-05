package org.firstinspires.ftc.teamcode.driverop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.ftc17191.ftclayer.drivetrain.mecanum.Mecanum;

@TeleOp(name = "DriverOp", group = "Iterative Opmode")
public class DriverOp extends OpMode {

    private Mecanum train;


    @Override
    public void init() {
        train = new Mecanum(hardwareMap, "motor0", "motor1", "motor2", "motor3");

    }

    @Override
    public void loop() {
        train.powerDrive(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);
    }
}
