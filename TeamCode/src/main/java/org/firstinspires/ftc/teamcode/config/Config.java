package org.firstinspires.ftc.teamcode.config;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Config {
    // enums
    public enum Team
    {
        RED, BLUE
    }

    // reader stuff
    private final String pathToProp = "/storage/emulated/0/ftc17191/config.prop";
    private FileReader reader;
    private FileWriter writer;

    private Properties prop;

    public Config()
    {
        prop = new Properties();

        try {
            prop.load(new FileReader(pathToProp));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Team getTeam()
    {
        if (prop.getProperty("team").equals("red")) {
            return Team.RED;
        } else if (prop.getProperty("team").equals("blue")){
            return Team.BLUE;
        }
        return null;
    }

    public void setTeam(Team team)
    {
        if (team == Team.RED) {
            prop.setProperty("team", "red");
            try {
                prop.store(new FileWriter(pathToProp), "FTC17191 Config");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            prop.setProperty("team", "blue");
            try {
                prop.store(new FileWriter(pathToProp), "FTC17191 Config");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
