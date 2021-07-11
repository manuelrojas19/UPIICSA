package mx.manuelr.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mx.manuelr.web.entity.Persona;

public class PersonaDao {
	public static List<Persona> obtenerPersonas() {
		List<Persona> personas = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from persona order by id_persona");
			statement.execute();
			ResultSet res = statement.getResultSet();
			personas = new ArrayList<>();
			while (res.next()) {
				Integer idPersona = res.getInt("id_persona");
				String nombre = res.getString("tx_nombre");
				String primerApellido = res.getString("tx_primer_ap");
				String segundoApellido = res.getString("tx_segundo_ap");
				String curp = res.getString("tx_curp");
				personas.add(new Persona(idPersona, nombre, primerApellido, segundoApellido, curp));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			personas = new ArrayList<>();
		} finally {
			if (personas == null) {
				personas = new ArrayList<>();
			}
			
		}
		return personas;
	}
	
	public static Persona registrarPersona(Persona persona) {
		Persona personaGuadada = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement statement = con.prepareStatement("INSERT INTO persona(tx_nombre, tx_primer_ap, tx_segundo_ap, tx_curp) VALUES (?, ?, ?, ?)");
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getPrimerApellido());
			statement.setString(3, persona.getSegundoApellido());
			statement.setString(4, persona.getCurp());
			int resultado = statement.executeUpdate();
			if(resultado==1) {
				personaGuadada = persona;
			}
			con.close();
		} catch (SQLException e) {
			personaGuadada = null;
		}
		return personaGuadada;
	}

	public static Persona obtenerPersona(Integer idPersona) {
		Persona personaGuardada = null;
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM persona WHERE id_persona=?");
			statement.setInt(1, idPersona);
			ResultSet resultado = statement.executeQuery();
			if(resultado.next()) {
				personaGuardada = new Persona();
				Integer id = resultado.getInt("id_persona");
				String nombre = resultado.getString("tx_nombre");
				String primerApellido = resultado.getString("tx_primer_ap");
				String segundoApellido = resultado.getString("tx_segundo_ap");
				String curp = resultado.getString("tx_curp");
				personaGuardada = new Persona(id, nombre, primerApellido, segundoApellido, curp);
			}
			con.close();
		} catch (SQLException e) {
			personaGuardada = null;
		}
		return personaGuardada;
	}

	public static Persona actualizarPersona(Persona persona) {
		try {
			Connection con = ConnectionUtil.getConnection();
			PreparedStatement statement = con.prepareStatement("update persona set tx_nombre=?, tx_primer_ap=?, tx_segundo_ap=?, tx_curp=? where id_persona=?");
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getPrimerApellido());
			statement.setString(3, persona.getSegundoApellido());
			statement.setString(4, persona.getCurp());
			statement.setInt(5, persona.getId());
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persona;
	}

	public static void eliminarPersona(Integer idPersona) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			PreparedStatement statement = con.prepareStatement("delete from persona where id_persona=?");
			statement.setInt(1, idPersona);
			statement.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
