package org.y4sec.team.app;

import java.net.URLDecoder;
import java.sql.DriverManager;

public class Application6 {
    public static void connection(String addr,String user,String db,String password,String extra) {
        try {
            String url = String.format("jdbc:mysql://%s/%s?",addr,db);

            StringBuilder sb = new StringBuilder();
            sb.append("user=");
            sb.append(user);
            sb.append("&");
            sb.append("password=");
            sb.append(password);
            if (!extra.equals("")){
                sb.append("&");
                sb.append(extra);
            }

            url = url + sb;

            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
