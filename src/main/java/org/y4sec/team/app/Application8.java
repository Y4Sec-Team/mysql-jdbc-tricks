package org.y4sec.team.app;

import java.sql.DriverManager;

public class Application8 {
    public static void connection(String addr, String user, String db, String password, String extra) {
        try {
            String url = String.format("jdbc:mysql://%s/%s?", addr, db);

            StringBuilder sb = new StringBuilder();
            sb.append("user=");
            sb.append(user);
            sb.append("&");
            sb.append("password=");
            sb.append(password);

            if (!check(extra)) {
                System.out.println("you are hacker");
                return;
            }

            if (!extra.equals("")) {
                sb.append("&");
                sb.append(extra);
            }

            if (url.endsWith("?")) {
                url = url + sb + "autoDeserialize=false";
            } else {
                url = url + sb + "&autoDeserialize=false";
            }

            System.out.println(url);

            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean check(String params) {
        try {
            return !params.contains("autoDeserialize");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
