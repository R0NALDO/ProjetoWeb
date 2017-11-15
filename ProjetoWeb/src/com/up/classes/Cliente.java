package com.up.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {

	public String nome;
	public String cpf;
	public String endereco;
	public String telefone;
	public String email;
	
	public void Salvar() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/primeiro?autoReconnect=true&useSSL=false","root","");
		Statement comando = con.createStatement();
		String sqlInsert = "INSERT INTO CLIENTE(NOME, SOBRENOME, EMAIL) VALUES ('"
				+ this.nome+"','"
				+ this.endereco+"','"
				+ this.email+"')";
//		System.out.println(sqlInsert);
		comando.execute(sqlInsert);
	}
	
	public void Localizar(String nome) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/primeiro?autoReconnect=true&useSSL=false","root","");
		Statement comando = con.createStatement();
		String sqlSelect = "SELECT * FROM CLIENTE WHERE NOME LIKE '% "+nome+"%'";
		ResultSet rs = comando.executeQuery(sqlSelect);
		
		if(rs.next()){
			this.nome = rs.getString("nome");
			this.endereco = rs.getString("sobrenome");
			this.email = rs.getString("email");
		}
	}
}

/*
 * "INSERT INTO CLIENTE("
				+ "NOME, "
//				+ "CPF, "
				+ "SOBRENOME, "
//				+ "TELEFONE, "
				+ "EMAIL"
				+ ") VALUES ('"
				+ this.nome+"','"
//				+ this.cpf+"','"
				+ this.sobrenome+"','"
//				+ this.telefone+"','"
				+ this.email+"')"

 */