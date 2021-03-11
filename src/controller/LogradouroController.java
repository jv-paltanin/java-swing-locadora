package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import util.Mensagem;
import util.Titulo;

/**
 * Classe respons�vel por controlar os m�todos do objeto Estado
 * 
 * @author Jo�o Victor
 * @since 08/03/2021
 * @version 1.0
 */
public class LogradouroController {

	// declarar o nome do arquivo TXT utilizado
	private String arquivo = "logradouros.txt";

	/*
	 * m�todo respons�vel por retornar uma lista de estados
	 */
	public ArrayList<String> getLogradouros() {
		// objeto lista para retornar no m�todo
		ArrayList<String> logradouros = buscarTodos();
		return logradouros;
	}

	/*
	 * m�todo para ler o arquivo de logradouros
	 */
	private ArrayList<String> buscarTodos() {

		// lista auxiliar para retornar no m�todo
		ArrayList<String> logradouros = new ArrayList<String>();

		try {
			// classe Scanner auxiliar para ler o arquivo de logradouros
			Scanner leitor = new Scanner(new FileReader(arquivo));

			// la�o de repeti��o para leitura do arquivo com o comando hasNext
			while (leitor.hasNext()) {
				// objeto auxiliar para retornar no m�todo
				String logradouro = leitor.nextLine();
				// atribuindo o objeto logradouro na lista de retorno
				logradouros.add(logradouro);
			}

		} catch (FileNotFoundException e) {
			// exibindo pro usu�rio uma mensagem de erro
			JOptionPane.showMessageDialog(null, Mensagem.erroLerArquivo, Titulo.cadastroCliente, 0);
			// exibe no console o log de erro do java
			e.printStackTrace();
		}

		// retornando a lista de logradouros
		return logradouros;
	}
} // fim da classe