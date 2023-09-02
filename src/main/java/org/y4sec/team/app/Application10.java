package org.y4sec.team.app;

import java.sql.DriverManager;

public class Application10 {
    public static void connection(String addr, String user, String db, String password, String extra) {
        try {
            String url = String.format("jdbc:mysql://%s/%s?", addr, db);

            StringBuilder sb = new StringBuilder();
            sb.append("user=");
            sb.append(check(user));
            sb.append("&");
            sb.append("password=");
            sb.append(check(password));

            if (!extra.equals("")) {
                sb.append("&");
                sb.append(check(extra));
            }

            url = url + sb;

            check(url);

            System.out.println(url);

            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String check(String params) {
        if (params.contains("autoDeserialize")) {
            throw new RuntimeException("you are hacker");
        }
        return params;
    }
}
