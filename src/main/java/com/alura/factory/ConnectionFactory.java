package com.alura.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
    
    private DataSource dataSource;
    //creando pool.
    public ConnectionFactory() {
        var comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("root123456");
        comboPooledDataSource.setMaxPoolSize(10);
        
        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperaConexion() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}