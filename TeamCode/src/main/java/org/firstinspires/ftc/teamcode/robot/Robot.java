package org.firstinspires.ftc.teamcode.robot;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.ftc17191.ftclayer.drivetrain.mecanum.Mecanum;
import org.ftc17191.ftclayer.drivetrain.tank.TwoWheeledTank;
import org.ftc17191.ftclayer.hardware.imu.RevImu;
import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;
import org.ftc17191.ftclayer.hardware.revhub.RevHub;
import org.ftc17191.ftclayer.hardware.servo.simulatedservo.SimulatedServo;

public class Robot
{

    // Finals / the java equivalent of #define

    public double redCarouselSpeed = -1.0;
    public double blueCarouselSpeed = 1.0;

    public double triggerDeadZone = .15;

    public double speedMultiplier = 1;

    public double endingTime = 152;
    public double timeBeforeStart = 2;

    public Mecanum train;
    public MotorEx carousel;
    public MotorEx arm;
    public RevImu imu;
    public Servo rightGripper;
    public Servo leftGripper;


    public Robot(HardwareMap hardwareMap) {
        train = new Mecanum(hardwareMap,
                "motor0",
                "motor1",
                "motor2",
                "motor3",
                "imu");
        carousel = new MotorEx(hardwareMap, "motor4");
        arm = new MotorEx(hardwareMap, "motor5");
        rightGripper = hardwareMap.get(Servo.class, "servo0");
        leftGripper  = hardwareMap.get(Servo.class, "servo1");
        imu = new RevImu(hardwareMap, "imu");
    }
}
