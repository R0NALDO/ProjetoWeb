package com.up.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.up.classes.Cliente;

@WebServlet("/controllerLocalizarCliente")
public class controllerLocalizarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public controllerLocalizarCliente() {
        super();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Vnome = request.getParameter("nome");
		Cliente c = new Cliente();
		try {
			c.Localizar(Vnome);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO
			e.printStackTrace();
		}
		String JsonCliente = new Gson().toJson(c);
		response.getWriter().write(JsonCliente);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

/*
 * CREATE DATABASE PRIMEIRO;
USE PRIMEIRO;

CREATE TABLE CLIENTE(
ID INT (144) AUTO_INCREMENT NOT NULL,
NOME VARCHAR (144),
SOBRENOME VARCHAR (144),
EMAIL VARCHAR (144),
PRIMARY KEY (ID));

SELECT * FROM CLIENTE;
 * 
 * */
