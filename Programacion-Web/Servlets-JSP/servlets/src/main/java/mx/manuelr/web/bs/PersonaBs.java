package mx.manuelr.web.bs;

import java.util.List;

import mx.manuelr.web.dao.PersonaDao;
import mx.manuelr.web.entity.Persona;

public class PersonaBs {
	public static List<Persona> obtenerPersonas() {
		return PersonaDao.obtenerPersonas();
	}
	
	public static Persona registarPersona(Persona persona) {
		Boolean valido = true;
		Persona personaGuardada = null;
		//validadción de mayoria de edad
		if(valido) {
			personaGuardada = PersonaDao.registrarPersona(persona);
		}
		return personaGuardada;
	}

	public static Persona obtenerPersona(Integer idPersona) {
		// Validacion 
		return PersonaDao.obtenerPersona(idPersona);
	}

	public static Persona actualizarPersona(Persona persona) {
		//validaciones
		Persona personaGuardada = obtenerPersona(persona.getId());
		personaGuardada.setNombre(persona.getNombre());
		personaGuardada.setPrimerApellido(persona.getPrimerApellido());
		personaGuardada.setSegundoApellido(persona.getSegundoApellido());
		personaGuardada.setCurp(persona.getCurp());
		return PersonaDao.actualizarPersona(personaGuardada);
	}

	public static void eliminarPersona(Integer idPersona) {
		// validaciones
		PersonaDao.eliminarPersona(idPersona);
	}
}
