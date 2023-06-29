package cn.cyanbukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLFunc {
    String HOST = null;

    String DB = null;

    String USER = null;

    String PASS = null;
    String port = null;

    private Connection con = null;

    public MySQLFunc(String host ,String port, String db, String user, String pass) {
        this.HOST = host;
        this.DB = db;
        this.USER = user;
        this.PASS = pass;
        this.port = port;
    }

    public Connection open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://" + this.HOST + ":" + port+ "/" + this.DB + "?autoReconnect=true&serverTimezone=UTC", this.USER, this.PASS);
            return this.con;
        } catch (SQLException e) {
            System.out.println("Could not connect to MySQL server, error code: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver was not found in this machine.");
        }
        return this.con;
    }

    public boolean checkConnection() {
        if (this.con != null)
            return true;
        return false;
    }

    public void close(Connection c) {
        c = null;
    }

    public Connection getCon() {
        return this.con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}