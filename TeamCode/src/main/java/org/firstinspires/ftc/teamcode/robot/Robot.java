package org.firstinspires.ftc.teamcode.robot;


import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.ftc17191.ftclayer.drivetrain.mecanum.Mecanum;
import org.ftc17191.ftclayer.hardware.motors.motorex.MotorEx;
import org.ftc17191.ftclayer.hardware.revhub.RevHub;
import org.ftc17191.ftclayer.hardware.servo.simulatedservo.SimulatedServo;

public class Robot
{

    // Finals / the java equivalent of #define
    public double leftGripperClosed = 1.0;
    public double leftGripperOpen   = 0;
    public double rightGripperClosed = 0;
    public double rightGripperOpen   = 1.0;

    public double redCarouselSpeed = 1.0;
    public double blueCarouselSpeed = -1.0;

    public double triggerDeadZone = .15;

    public double speedMultiplier = .50;


    // Hardware
    private RevHub controlHub;
    private RevHub expansionHub;


    public String[] controlMotorIds;
    public String[] controlServoIds;
    public String[] controlI2CIds;
    public String[] expansionMotorIds;
    public String[] expansionServoIds;
    public String[] expansionI2CIds;


    public Mecanum drive;
    public MotorEx carousel;
    public SimulatedServo arm;
    public SimulatedServo reel;

    public Servo leftGripper;
    public Servo rightGripper;

    public Robot(HardwareMap hardwareMap) {
        drive = new Mecanum(hardwareMap,
                "motor0",
                "motor1",
                "motor2",
                "motor3");
        arm  = new SimulatedServo(hardwareMap, "motor4", 0, -88);
        reel = new SimulatedServo(hardwareMap, "motor5", 0,-1200);


        leftGripper  = hardwareMap.get(Servo.class, "servo0");
        rightGripper = hardwareMap.get(Servo.class, "servo1");

    }
}
