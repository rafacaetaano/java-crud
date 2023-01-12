package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Alan Alonso");
		contato.setIdade(14);
		contato.setDataCadastro(new Date());
		
		contatoDao.save(contato);
		
		//atualizar contato
		Contato c1 = new Contato();
		c1.setNome("Alan Alonso Fernandes");
		c1.setIdade(37);
		c1.setDataCadastro(new Date());
		c1.setId(1); //número no banco
		
		//contatoDao.update(c1);
		
		//deletar o contato pelo ID
		contatoDao.deleteByID(1);
		
		//visualização de todos os registros do banco de dados
		
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato " + c.getNome());
		}
	}

}
