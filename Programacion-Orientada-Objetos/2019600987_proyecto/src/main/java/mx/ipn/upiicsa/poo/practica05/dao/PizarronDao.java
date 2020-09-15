package mx.ipn.upiicsa.poo.practica05.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import mx.ipn.upiicsa.poo.practica05.model.Diagrama;

public class PizarronDao {

	public static List<Diagrama> obtenerDiagramas() {
		List<Diagrama> diagramas = new ArrayList<>();
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from diagrama");
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String nombre = resultSet.getString(2);
				String descripcion = resultSet.getString(3);
				LocalDateTime fechaCreacion = resultSet.getObject(4, LocalDateTime.class);
				LocalDateTime fechaModificacion = resultSet.getObject(5, LocalDateTime.class);
				Diagrama diagrama = new Diagrama(id, nombre, descripcion, fechaCreacion, fechaModificacion);
				diagramas.add(diagrama);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("---> error en la consulta de diagramas");
			e.printStackTrace();
		} finally {
		}
		return diagramas;
	}

	public static Diagrama obtenerDiagrama(int idDiagrama) {
		Diagrama diagrama = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("Select * from diagrama where id_diagrama = ?");
			preparedStatement.setInt(1, idDiagrama);
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				Integer id = resultSet.getInt(1);
				String nombre = resultSet.getString(2);
				String descripcion = resultSet.getString(3);
				LocalDateTime fechaCreacion = resultSet.getObject(4, LocalDateTime.class);
				LocalDateTime fechaModificacion = resultSet.getObject(5, LocalDateTime.class);
				String json = resultSet.getString(6);
				diagrama = new Diagrama(id, nombre, descripcion, fechaCreacion, fechaModificacion, json);
			}
			connection.close();
		} catch (SQLException e) {
			System.out.println("---> error en la obtencion del diagrama");
			e.printStackTrace();
		}
		return diagrama;
	}

	public static Diagrama guardarDiagrama(Diagrama diagrama) {
		Diagrama diagramaGuardado = null;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO diagrama(tx_nombre, tx_descripcion, fh_creacion, fh_modificacion, tx_json) VALUES (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, diagrama.getNombre());
			preparedStatement.setString(2, diagrama.getDescripcion());
			preparedStatement.setObject(3, diagrama.getFechaCreacion());
			preparedStatement.setObject(4, diagrama.getFechaActualizacion());
			preparedStatement.setString(5, diagrama.getJson());
			int resultado = preparedStatement.executeUpdate();
			if (resultado == 1) {
				diagramaGuardado = diagrama;
			}
			connection.close();
		} catch (SQLException e) {
			diagramaGuardado = null;
			System.out.println("---> error en el guardar diagrama");
			e.printStackTrace();
		}
		return diagramaGuardado;
	}

	public static Boolean eliminarDiagrama(int idDiagrama) {
		boolean diagramaEliminado = false;
		try {
			Connection connection = ConnectionUtil.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("Delete from diagrama where id_diagrama = ?");
			preparedStatement.setInt(1, idDiagrama);
			int resultado = preparedStatement.executeUpdate();
			if (resultado == 1) {
				diagramaEliminado = true;
			}
			connection.close();
		} catch (SQLException e) {
			diagramaEliminado = false;
			System.out.println("---> error en el eliminar diagrama");
			e.printStackTrace();
		}
		return diagramaEliminado;
	}

	public static Boolean actualizarDiagrama(Diagrama newDiagrama, Integer idOldDiagrama) {
		boolean diagramaActualizado = false;
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement statement = con.prepareStatement(
					"update diagrama set tx_nombre=?, tx_descripcion=?, fh_modificacion=?, tx_json=? where id_diagrama=?");
			statement.setString(1, newDiagrama.getNombre());
			statement.setString(2, newDiagrama.getDescripcion());
			statement.setObject(3, newDiagrama.getFechaCreacion());
			statement.setString(4, newDiagrama.getJson());
			statement.setInt(5, idOldDiagrama);
			int resultado = statement.executeUpdate();
			if (resultado == 1) {
				diagramaActualizado = true;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return diagramaActualizado;
	}

}
