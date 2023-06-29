package cn.cyanbukkit;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class FastSQLState {

    public static void Create(Connection connection, String TableName, String database, String tableSort){
        try {
            String yuJu = "CREATE TABLE IF NOT EXISTS `" + database + "`.`" + TableName + "`  (\n" + tableSort + ") charset=utf8;";
            Statement stmt = connection.createStatement();
            System.out.println(TableName + "表执行语句"+ yuJu +"创表状态 " + stmt.executeUpdate(yuJu));
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
    }
    
}