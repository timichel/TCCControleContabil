package com.test;

import com.controller.UserBean;
import com.model.User;

public class UserTests {

	public static void main(String args[]){
		String pagina = "Erro";
		int cont = 1;
		UserBean ubean = new UserBean();
		User user = new User();
		//teste login contador
			user.setCpf("010101010101");
			user.setSenha("123");
			ubean.setUser(user);
			pagina = ubean.login();
			if (pagina.equals("contador.xhtml"))
			System.out.println(cont+" - "+pagina);
			cont++;
		
		//teste login proprietario
			user.setCpf("020202020202");
			user.setSenha("123");
			ubean.setUser(user);
			pagina = ubean.login();
			if (pagina.equals("contador.xhtml"))
				System.out.println(cont+" - "+pagina);
			cont++;

		//teste login admin
			user.setCpf("030303030303");
			user.setSenha("123");
			ubean.setUser(user);
			pagina = ubean.login();
			if (pagina.equals("admin.xhtml"))
				System.out.println(cont+" - "+pagina);
			cont++;
		//teste login cpf ou senhas incorretos
			user.setCpf("45645645655");
			user.setSenha("123");
			ubean.setUser(user);
			pagina = ubean.login();
			if(pagina.equals("login.xhtml"));
			System.out.println(cont+" - "+pagina);
		
		//teste segurança
		
		//teste logout
	}
	
	
	
}
