package com.controller;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="lancamentos")
public class listLancamentos {

	private List<debitoCredito> lancamentos = new ArrayList<debitoCredito>();
	
	public listLancamentos(){
		debitoCredito dc2 = new debitoCredito();
		dc2.setContaContabil("1.1.1");
		dc2.setNomeConta("Caixa");
		dc2.setValor("30.000,00");
		dc2.setDc("D");
		debitoCredito dc1 = new debitoCredito();
		dc1.setContaContabil("4.1.1");
		dc1.setNomeConta("Faturamento Bruto");
		dc1.setValor("30.000,00");
		dc1.setDc("C");
		lancamentos.add(dc2);
		lancamentos.add(dc1);
	}

	public List<debitoCredito> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<debitoCredito> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	
}
