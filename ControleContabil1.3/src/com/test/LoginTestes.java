package com.test;

import com.controller.UserBean;

public class LoginTestes {

	public static void main(String[] args){
		UserBean userbean = new UserBean();
		String pagina = userbean.login();
		System.out.println("Pagina: "+pagina);
	}
}
