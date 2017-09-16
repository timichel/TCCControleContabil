package com.test;

import org.junit.Assert;
import org.junit.Test;
import com.controller.UserBean;
import com.model.User;

public class UserBeanTest {

	@Test
	public void testLoginAdmin() {
		UserBean userbean = new UserBean();
		User useradmin = new User();
		useradmin.setCpf("32884454845");
		useradmin.setSenha("123");
		userbean.setUser(useradmin);
		String pagina = userbean.login();
		Assert.assertEquals("admin.xhtml", pagina);
	}
	@Test
	public void testLoginContador() {
		UserBean userbean = new UserBean();
		User useracont = new User();
		useracont.setCpf("38900125655");
		useracont.setSenha("123");
		userbean.setUser(useracont);
		String pagina = userbean.login();
		Assert.assertEquals("contador.xhtml", pagina);
	}
	
	@Test
	public void testLoginProprietario() {
		UserBean userbean = new UserBean();
		User useraprop = new User();
		useraprop.setCpf("40289812544");
		useraprop.setSenha("123");
		userbean.setUser(useraprop);
		String pagina = userbean.login();
		Assert.assertEquals("proprietario.xhtml", pagina);
	}
	
	@Test(expected=NullPointerException.class)
	public void testLoginIncorretoCpf() {
		UserBean userbean = new UserBean();
		userbean.login();		
	}
	
	@Test(expected=NullPointerException.class)
	public void testLoginIncorretoSenha() {
		UserBean userbean = new UserBean();
		userbean.login();
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testLoginIncorretoSemCpf() {
		UserBean userbean = new UserBean();
		userbean.login();
		
	}
	
	@Test(expected=NullPointerException.class)
	public void testLoginIncorretoSemSenha() {
		UserBean userbean = new UserBean();
		userbean.login();
		
	}
	

}
