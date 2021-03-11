package model;

/**
 * Classe respos�vel por controlar o objeto Data
 * 
 * @author Jo�o Victor
 * @since 04/03/2021
 */
public class Data {

	// criando construtor vazio
	public Data() {
	}

	// declarando os atributos
	private int dia;
	private int mes;
	private int ano;

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	// m�todo toString() para exibir a Data
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}
}