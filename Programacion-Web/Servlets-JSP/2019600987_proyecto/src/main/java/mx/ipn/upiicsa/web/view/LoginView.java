package mx.ipn.upiicsa.web.view;

import mx.ipn.upiicsa.web.entity.User;

public class LoginView {
	public static User login(String login, String password) {
		// TODO: implementar logica de login
		User user = new User();
		user.setId(1);
		user.setName("Manuel");
		user.setLastName("Rojas");
		user.setLogin("manuelarr99@gmail.com");
		user.setPassword("manuelrojas19");

		if(login == null) {
			
		} if (password == null) {
			
		}
		return user;
	}
}
