package com.up.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.classes.Cliente;

@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ClienteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		
		System.out.println(nome+"ok4");
		
		Cliente c = new Cliente();
		c.nome = nome;
		c.sobrenome = sobrenome;
		c.email = email;
		
		try {
			c.Salvar();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}

/*
 *package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class teste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public teste() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String email = request.getParameter("email");
		System.out.println("testedaservlet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
 
 */
