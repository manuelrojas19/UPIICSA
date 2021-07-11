package mx.manuelr.web.pr;

import java.util.List;

import mx.manuelr.web.bs.PersonaBs;
import mx.manuelr.web.entity.Persona;

public class PersonaPr {

	public static List<Persona> obtenerPersonas() {
		return PersonaBs.obtenerPersonas();
	}

	public static Persona registrarPersona(Persona persona) {
		Boolean valido = true;
		Persona personaGuardada = null;
		
		if (persona.getNombre() == null || persona.getNombre() == "") {
			valido = false;
		}
		if (persona.getPrimerApellido() == null || persona.getPrimerApellido() == "") {
			valido = false;
		} else if (!persona.getCurp().matches(
				"/^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$/")) {
		}
		
		if (valido) {
			personaGuardada = PersonaBs.registarPersona(persona);
		}
		return personaGuardada;
	}

	public static Persona obtenerPersona(Integer idPersona) {
		return PersonaBs.obtenerPersona(idPersona);
	}

	public static Persona actualizarPersona(Persona persona) {
		Boolean valido = true;
		Persona personaGuardada = null;
		if (persona.getNombre() == null || persona.getNombre() == "") {

		}
		if (persona.getNombre() == null || persona.getNombre() == "") {

		}
		if (persona.getNombre() == null || persona.getNombre() == "") {

		}
		if (persona.getNombre() == null || persona.getNombre() == "") {

		} else if (!persona.getCurp().matches(
				"/^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$/")) {

		}
		if (valido) {
			personaGuardada = PersonaBs.actualizarPersona(persona);
		}
		return personaGuardada;
	}

	public static void eliminarPersona(Integer idPersona) {
		// validaciones
		PersonaBs.eliminarPersona(idPersona);
	}
}
