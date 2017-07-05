package com.senmiao.util.http;

import com.senmiao.util.DataUtil;

import java.sql.*;
import java.util.Properties;

/**
 * Created by zx on 2016/12/6.
 */
public class DefaultConnection {

    private static String url;
    private static String driver;
    private static String username;
    private static String password;

    private static Connection conn = null;
    private static Statement state = null;
    private static ResultSet result = null;

    public static ResultSet execute(String sql){
        Properties prop = DataUtil.loadProperty("application.properties");
        url = prop.getProperty("spring.datasource.url");
        driver = prop.getProperty("spring.datasource.driverClassName");
        username = prop.getProperty("spring.datasource.username");
        password = prop.getProperty("spring.datasource.password");

        try{
            //加载驱动
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            state = conn.createStatement();
            state.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(result != null){
                try {
                    result.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(state != null){
                try {
                    state.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
