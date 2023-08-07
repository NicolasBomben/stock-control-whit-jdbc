package com.alura.controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alura.factory.ConnectionFactory;

public class ProductoController {

	public int modificar(String nombre, String descripcion, Integer cantidad, Integer id) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();

		Statement statement = con.createStatement();

		statement.execute("UPDATE PRODUCTO SET "
    		+ " NOMBRE = '" + nombre + "'"
   			+ ", DESCRIPCION = '" + descripcion + "'"
    		+ ", CANTIDAD = " + cantidad 
    		+ " WHERE ID = " + id);

		int updateCount = statement.getUpdateCount();

		con.close();

		return updateCount;
	}


	//metodo para eliminar un producto.
	public int eliminar(Integer id) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();

		Statement statement = con.createStatement();

		statement.execute("DELETE FROM PRODUCTO WHERE ID = " + id );

		return statement.getUpdateCount();
	}


	//metodo devuelve un listado de tipo string.
	public List<Map<String, String>> listar() throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();

		//CREO LA INSTANCIA PARA PODER HACER LA QUERY
		Statement statement = con.createStatement();
		//EJECUTA LA QUERY. DEVUELE BOOLEAN PARA DECIR SI ES UN LISTADO O NO.
		statement.execute("SELECT ID, NOMBRE, DESCRIPCION, CANTIDAD FROM PRODUCTO");

		ResultSet resultSet = statement.getResultSet();

		//donde guardo el resultado.
		List<Map<String, String>> resultado = new ArrayList<>();
		//while con string para mapear el resultado de las filas.
		while(resultSet.next()){
			Map<String, String> fila = new HashMap<>();
			fila.put("ID", String.valueOf(resultSet.getInt("ID")));
			fila.put("NOMBRE", resultSet.getString("NOMBRE"));
			fila.put("DESCRIPCION", resultSet.getString("DESCRIPCION"));
			fila.put("CANTIDAD", String.valueOf(resultSet.getInt("CANTIDAD")));
			//agrego las filas al resultado.
			resultado.add(fila);
		}
		//cierro conexion.
		con.close();

		return resultado;
	}

    public void guardar(Map<String, String> producto) throws SQLException {
		Connection con = new ConnectionFactory().recuperaConexion();

		Statement statement = con.createStatement();

		statement.execute("INSERT INTO PRODUCTO (nombre,descripcion,cantidad)" 
		+ "VALUES('" + producto.get("NOMBRE") + "' , '"
		+ producto.get("DESCRIPCION") + "', "
		+ producto.get("CANTIDAD") + ")", Statement.RETURN_GENERATED_KEYS);

		ResultSet resultSet = statement.getGeneratedKeys();

		while( resultSet.next()){
			System.out.println(
				String.format(
					"Fue insertado el producto de ID", 
					resultSet.getInt(1)));
		}


	}

}
