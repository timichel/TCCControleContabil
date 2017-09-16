package com.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

@ManagedBean(name="dashBoardView")
@ViewScoped
public class DashBoardView implements Serializable{

	private static final long serialVersionUID = 1L;
	private DashboardModel model;
    
    @PostConstruct
    public void init() {
    	model = new DefaultDashboardModel();
    	 DashboardColumn column1 = new DefaultDashboardColumn();
         DashboardColumn column2 = new DefaultDashboardColumn();
         
         column1.addWidget("telaPrincipal");
         column2.addWidget("menuLateral");
         
         model.addColumn(column1);
         model.addColumn(column2);
    }
    
    public DashboardModel getModel(){
    	return model;
    }
    
}
