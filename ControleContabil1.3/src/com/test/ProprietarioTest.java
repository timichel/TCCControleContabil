package com.test;
import com.dao.UserDao;
import com.model.Contador;
import com.model.User;

public class ProprietarioTest {

	public static void main(String[] args){
		
		try {
			//admdao.CadastrarContador(c);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UserDao udao = new UserDao();
		try{
			User u = udao.Login("010101010101", "123456");
			if(u instanceof Contador){
				System.out.println("Usuario:"+u.getNome());
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
