package model;

/**
 * Classe respons�vel por controlar o objeto Vendedor
 * 
 * @author Jo�o Victor
 * @since 04/03/2021
 */
public class Vendedor {

	// gerando o construtor vazio
	public Vendedor() {
		// TODO Auto-generated constructor stub
	}

	private int codigo;
	private String nome;
	private String areaVenda;
	private String cidade;
	private String estado;
	private char sexo;
	private int idade;
	private double salario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaVenda() {
		return areaVenda;
	}

	public void setAreaVenda(String areaVenda) {
		this.areaVenda = areaVenda;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}