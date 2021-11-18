package org.firstinspires.ftc.teamcode.ftctester;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/*
    Menu items

    |Motors|
    (Press A to hold/release motor at power,)

            | Power
    Motor 0 |
    Motor 1
    Motor 2
    Motor 3
 */


@TeleOp(name="FTC Tester", group="Iterative Opmode")

public class FTCTester extends OpMode
{
    private enum menu
    {
        MOTOR, SERVO, DRIVE, UTIL
    }

    menu menu_selection = menu.MOTOR;

    @Override
    public void init()
    {

    }

    public void init_loop()
    {

    }

    @Override
    public void start()
    {


    }

    @Override
    public void loop()
    {

    }

    @Override
    public void stop()
    {

    }



}


