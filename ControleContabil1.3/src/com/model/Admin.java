package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Admin extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	private String CRC;
	private Date DataAdm;
	
	public Admin() {
		super();
	}
	
	/*gettes e setter omitidos*/
	
	public String getCRC() {
		return CRC;
	}
	public void setCRC(String cRC) {
		CRC = cRC;
	}
	public Date getDataAdm() {
		return DataAdm;
	}
	public void setDataAdm(Date dataAdm) {
		DataAdm = dataAdm;
	}
	
	
}
