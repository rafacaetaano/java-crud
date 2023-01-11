package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

//nessa clase vamos usar o DAO que é um padrão para aplicações que utilizam persistência de dados
//aqui vamos fazer com que o Java se molde a estrutura relacional que é o banco

public class ContatoDAO {
	
	//método para salvar um contato na agenda
	public void save(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//criamos uma PreaparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//adicionar os valores que são esperados pela query
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));;
			
			//executar a query
			pstm.execute();
			System.out.println("Contato salvo com sucesso");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//fechar as conexões
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
