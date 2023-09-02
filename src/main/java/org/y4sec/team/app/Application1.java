package org.y4sec.team.app;

import java.sql.DriverManager;

public class Application1 {
    public static void connection(String url){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
