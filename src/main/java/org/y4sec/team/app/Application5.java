package org.y4sec.team.app;

import java.net.URI;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

public class Application5 {
    public static void connection(String url) {
        try {
            if (!check(url)) {
                System.out.println("you are hacker");
                return;
            }
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean check(String jdbcUrl) {
        try {
            URI uri = new URI(jdbcUrl.replace("jdbc:", ""));

            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();
            String dbname = path.substring(1);

            Map<String, String> params = new HashMap<>();
            String query = uri.getQuery();
            if (query != null) {
                String[] pairs = query.split("&");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=");
                    String key = keyValue[0];
                    String value = keyValue.length > 1 ? keyValue[1] : "";
                    params.put(key, value);
                }
            }

            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("DB Name: " + dbname);
            System.out.println("Params: " + params);

            for (Map.Entry<String, String> p : params.entrySet()) {
                if (p.getKey().equals("autoDeserialize")) {
                    String value = p.getValue();
                    value = value.toLowerCase();
                    if (value.equals("true") || value.equals("yes")) {
                        return false;
                    }
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
