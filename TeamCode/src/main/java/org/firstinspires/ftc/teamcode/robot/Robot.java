package org.firstinspires.ftc.teamcode.robot;


import com.qualcomm.robotcore.hardware.HardwareMap;
import org.ftc17191.ftclayer.drivetrain.mecanum.Mecanum;
import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;
import org.ftc17191.ftclayer.hardware.servo.simulatedservo.SimulatedServo;

public class Robot
{

    public Mecanum drive;
    public MotorEx carousel;
    public SimulatedServo arm;

    public Robot(HardwareMap hardwareMap) {
        drive = new Mecanum(hardwareMap,
                "motor0",
                "motor1",
                "motor2",
                "motor3");

    }
}
