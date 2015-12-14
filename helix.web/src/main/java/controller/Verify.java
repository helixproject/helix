package controller;

import java.awt.Container;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ContainerDaoImpl;
import daoImpl.DatabaseConnection;
import model.User;

@WebServlet("/Verify")
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Verify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model.Container c = new ContainerDaoImpl(new DatabaseConnection()).uploadContainer("dd0ec85ebfb2fb579f885e4860ea245e90633379b418d65006bea499070b071f");
		if(c == null){
			System.out.println("**********************************************this is vide");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
