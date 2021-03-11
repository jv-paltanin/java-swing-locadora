package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteController;
import controller.EstadoController;
import controller.LogradouroController;
import model.Cliente;
import model.Data;
import model.Endereco;
import model.Estado;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe respons�vel por controlar a tela CadastrarCliente
 * 
 * @author Jo�o Victor
 * @since 05/03/2021
 */
public class CadastroClienteView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando as labels
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbCpf;
	private JLabel lbRg;
	private JLabel lbDataNascimento;
	private JLabel lbIdade;
	// label Contato
	private JLabel lbTelefone;
	private JLabel lbCelular;
	private JLabel lbEmail;
	// labels Endere�o
	private JLabel lbLogradouro;
	private JLabel lbEndereco;
	private JLabel lbNumero;
	private JLabel lbComplemento;
	private JLabel lbBairro;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbCep;
	// text Endere�o
	private JTextField tfEndereco;
	private JTextField tfNumero;
	private JTextField tfComplemento;
	private JTextField tfBairro;
	private JTextField tfCidade;
	// declarando os campos e os formatados
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfEmail;
	private JFormattedTextField tfCep;
	private JFormattedTextField tfCpf;
	private JFormattedTextField tfRg;
	private JFormattedTextField tfDataNascimento;
	private JFormattedTextField tfTelefone;
	private JFormattedTextField tfCelular;
	// declarando os atributos de formata��o
	private MaskFormatter fmtCep;
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtRg;
	private MaskFormatter fmtDataNascimento;
	private MaskFormatter fmtTelefone;
	private MaskFormatter fmtCelular;
	// declarando os radio buttons
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	// componente ButtonGroup respons�vel por gerenciar os componentes de Sexo
	private ButtonGroup grpSexo;
	// declarando o JComboBox
	private JComboBox cbxEstados;
	private JComboBox cbxLogradouros;
	// declarando os bot�es
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// painel para organiza��o dos componentes
	private JPanel painel;
	private JPanel painelSexo;
	private JPanel painelContato;

	// vetor auxiliar para armazenar os estados
	private String[] estados = {};

	// vetor auxiliar para armazenar os logradouros
	private String[] logradouros = {};

	/*
	 * m�todo para criar a tela
	 */
	/**
	 * @throws ParseException
	 */
	public void iniciaGui() throws ParseException { // in�cio do m�todo

		/*
		 * configura��es dos campos de formata��o
		 */
		fmtCep = new MaskFormatter("#####-###");
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtRg = new MaskFormatter("##.###.###-#");
		fmtDataNascimento = new MaskFormatter("##/##/####");
		fmtTelefone = new MaskFormatter("(##) ####-####");
		fmtCelular = new MaskFormatter("(##) #####-####");

		/*
		 * configura��es do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o t�tulo da tela
		janela.setTitle(Titulo.cadastroCliente);
		// configurando o tamanho da tela
		janela.setSize(805, 460);
		// configurando a posi��o inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * configura��es do JLabel c�digo
		 */
		lbCodigo = new JLabel();
		// configurando texto inicial
		lbCodigo.setText("C�digo:");
		// configurando a posi��o e tamanho do componente
		lbCodigo.setBounds(20, 20, 50, 25);

		/*
		 * configura��es do JLabel Valor
		 */
		lbCpf = new JLabel();
		// configurando texto inicial
		lbCpf.setText("CPF:");
		// configurando a posi��o e tamanho do componente
		lbCpf.setBounds(170, 20, 30, 25);

		/*
		 * configura��es do JLabel Nome
		 */
		lbNome = new JLabel();
		// configurando texto inicial
		lbNome.setText("Nome:");
		// configurando a posi��o e tamanho do componente
		lbNome.setBounds(340, 20, 40, 25);

		/*
		 * configurando o campo de texto C�digo
		 */
		tfCodigo = new JTextField();
		// configurar a posi��o e o tamanho
		tfCodigo.setBounds(70, 20, 60, 25);

		/*
		 * configura��es do JFormattedTextField Cpf
		 */
		tfCpf = new JFormattedTextField(fmtCpf);
		// configurando a posi��o e o tamanho
		tfCpf.setBounds(205, 20, 105, 25);

		/*
		 * configurando o campo de texto Nome
		 */
		tfNome = new JTextField();
		// configurar a posi��o e o tamanho
		tfNome.setBounds(390, 20, 380, 25);

		/*
		 * configura��es da JLabel Data de Nascimento
		 */
		lbDataNascimento = new JLabel();
		lbDataNascimento.setText("Data de Nascimento:");
		// configurando a posi��o e tamanho
		lbDataNascimento.setBounds(20, 70, 120, 25);

		/*
		 * configura��es do JFormattedTextField Data de Nascimento
		 */
		tfDataNascimento = new JFormattedTextField(fmtDataNascimento);
		// configurando a posi��o e o tamanho
		tfDataNascimento.setBounds(145, 70, 80, 25);

		/*
		 * configura��es da JLabel RG
		 */
		lbRg = new JLabel();
		lbRg.setText("RG:");
		// configurando a posi��o e tamanho
		lbRg.setBounds(280, 70, 30, 25);

		/*
		 * configura��es do JFormattedTextField Rg
		 */
		tfRg = new JFormattedTextField(fmtRg);
		// configurando a posi��o e o tamanho
		tfRg.setBounds(310, 70, 95, 25);

		/*
		 * configura��es da JLabel Idade
		 */
		lbIdade = new JLabel();
		lbIdade.setText("Idade:");
		// configurando a posi��o e tamanho
		lbIdade.setBounds(430, 70, 50, 25);

		/*
		 * configura��es do JTextField Idade
		 */
		tfIdade = new JTextField();
		// configurando a posi��o e o tamanho
		tfIdade.setBounds(475, 70, 50, 25);

		/*
		 * configura��es do radio button Masculino e Feminino
		 */
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		// configurando o texto do componente
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");

		/*
		 * configura��es do ButtonGroup Sexo
		 */
		grpSexo = new ButtonGroup();
		grpSexo.add(rbMasculino);
		grpSexo.add(rbFeminino);

		/*
		 * configura��es do painel sexo
		 */
		painelSexo = new JPanel();
		// configurar posi��o e o tamanho
		painelSexo.setBounds(570, 55, 200, 58);
		// configurar o layout do painel
		painelSexo.setLayout(new GridLayout(1, 1, 0, 0));
		// configurar a borda do painel
		painelSexo.setBorder(new TitledBorder("Sexo"));
		painelSexo.add(rbMasculino);
		painelSexo.add(rbFeminino);

		/*
		 * configura��es da JLabel e JFormattedTextField do Telefone
		 */
		lbTelefone = new JLabel();
		lbTelefone.setText("Telefone:");
		tfTelefone = new JFormattedTextField(fmtTelefone);

		/*
		 * configura��es da JLabel e JFormattedTextField do Celular
		 */
		lbCelular = new JLabel();
		lbCelular.setText("Celular:");
		tfCelular = new JFormattedTextField(fmtCelular);

		/*
		 * configura��es da JLabel e JTextField do Email
		 */
		lbEmail = new JLabel();
		lbEmail.setText("Email:");
		tfEmail = new JTextField();

		/*
		 * configura��es da JLabel Cep
		 */
		lbCep = new JLabel();
		lbCep.setText("CEP:");
		// configurando a posi��o e tamanho
		lbCep.setBounds(20, 125, 30, 25);

		/*
		 * configura��es da JLabel Logradouro
		 */
		lbLogradouro = new JLabel();
		lbLogradouro.setText("Logradouro:");
		// configurando a posi��o e tamanho
		lbLogradouro.setBounds(20, 160, 80, 25);

		/*
		 * configura��es da JLabel Endere�o
		 */
		lbEndereco = new JLabel();
		lbEndereco.setText("Endere�o:");
		// configurando a posi��o e tamanho
		lbEndereco.setBounds(20, 195, 70, 25);

		/*
		 * configura��es da JLabel N�mero
		 */
		lbNumero = new JLabel();
		lbNumero.setText("N�:");
		// configurando a posi��o e tamanho
		lbNumero.setBounds(280, 125, 30, 25);

		/*
		 * configura��es do JFormattedTextField RgCep
		 */
		tfCep = new JFormattedTextField(fmtCep);
		// configurando a posi��o e o tamanho
		tfCep.setBounds(60, 125, 85, 25);

		/*
		 * configura��es do JComboBox
		 */
		cbxLogradouros = new JComboBox(logradouros);
		cbxLogradouros.setBounds(100, 160, 140, 25);

		/*
		 * configura��es do JTextField Logradouro
		 */
		tfEndereco = new JTextField();
		// configurando a posi��o e o tamanho
		tfEndereco.setBounds(90, 195, 150, 25);

		/*
		 * configura��es do JTextField Logradouro
		 */
		tfNumero = new JTextField();
		// configurando a posi��o e o tamanho
		tfNumero.setBounds(330, 125, 50, 25);

		/*
		 * configura��es da JLabel Complemento
		 */
		lbComplemento = new JLabel();
		lbComplemento.setText("Complemento:");
		// configurando a posi��o e tamanho
		lbComplemento.setBounds(280, 195, 90, 25);

		/*
		 * configura��es da JLabel Bairro
		 */
		lbBairro = new JLabel();
		lbBairro.setText("Bairro:");
		// configurando a posi��o e tamanho
		lbBairro.setBounds(280, 160, 40, 25);

		/*
		 * configura��es da JLabel Cidade
		 */
		lbCidade = new JLabel();
		lbCidade.setText("Cidade:");
		// configurando a posi��o e tamanho
		lbCidade.setBounds(550, 140, 60, 25);

		/*
		 * configura��es da JLabel Estado
		 */
		lbEstado = new JLabel();
		lbEstado.setText("Estado:");
		// configurando a posi��o e tamanho
		lbEstado.setBounds(550, 180, 60, 25);

		/*
		 * configura��es do JFormattedTextField Complemento
		 */
		tfComplemento = new JTextField();
		// configurando a posi��o e o tamanho
		tfComplemento.setBounds(370, 195, 95, 25);

		/*
		 * configura��es do JFormattedTextField Bairro
		 */
		tfBairro = new JTextField();
		// configurando a posi��o e o tamanho
		tfBairro.setBounds(330, 160, 135, 25);

		/*
		 * configura��es do JFormattedTextField Cidade
		 */
		tfCidade = new JTextField();
		// configurando a posi��o e o tamanho
		tfCidade.setBounds(600, 140, 150, 25);

		/*
		 * configura��es do JComboBox
		 */
		cbxEstados = new JComboBox(estados);
		cbxEstados.setBounds(600, 180, 150, 25);

		/*
		 * configura��es do painel contato
		 */
		painelContato = new JPanel();
		// configurar posi��o e o tamanho
		painelContato.setBounds(0, 240, 785, 125);
		// configurar o layout do painel
		painelContato.setLayout(new GridLayout(3, 0, 0, 0));
		// configurar a borda do painel
		painelContato.setBorder(new TitledBorder("Contato"));
		painelContato.add(lbTelefone);
		painelContato.add(tfTelefone);
		painelContato.add(lbCelular);
		painelContato.add(tfCelular);
		painelContato.add(lbEmail);
		painelContato.add(tfEmail);

		/*
		 * configura��es do JButton Salvar
		 */
		btSalvar = new JButton();
		// configurando o texto inicial
		btSalvar.setText("SALVAR");
		// configurando a posi��o e tamanho do componente
		btSalvar.setBounds(230, 375, 145, 30);
		// configurando a a��o do bot�o
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});

		/*
		 * configura��es do JButton Cancelar
		 */
		btCancelar = new JButton();
		// configurando o texto inicial
		btCancelar.setText("CANCELAR");
		// configurando a posi��o e tamanho do componente
		btCancelar.setBounds(400, 375, 145, 30);
		// configurando a a��o do bot�o
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// m�todo para limpar os campos da tela
				limparTela();
				// m�todo para bloquear os campos da tela
				bloquearTela();
			}
		});

		/*
		 * configura��es do JButton Novo e Sair
		 */
		btNovo = new JButton();
		btSair = new JButton();
		// configurando o texto inicial
		btNovo.setText("NOVO");
		btSair.setText("SAIR");
		// configurando a posi��o e tamanho do componente
		btNovo.setBounds(230, 375, 145, 30);
		btSair.setBounds(400, 375, 145, 30);
		// configurando a a��o do bot�o
		btNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				liberarTela();

			}
		});

		btSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				janela.dispose();
			}
		});

		// configurando a a��o do X e do Maximizar do JFrame
		janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		janela.setResizable(false);

		/*
		 * configura��es do painel principal da tela
		 */
		painel = (JPanel) janela.getContentPane();
		// configurar o layout inicial
		painel.setLayout(null);
		painel.add(lbCodigo);
		painel.add(lbCpf);
		painel.add(lbNome);
		painel.add(tfCodigo);
		painel.add(tfCpf);
		painel.add(tfNome);
		painel.add(lbDataNascimento);
		painel.add(lbRg);
		painel.add(lbIdade);
		painel.add(tfDataNascimento);
		painel.add(tfRg);
		painel.add(tfIdade);
		painel.add(painelSexo);
		painel.add(lbCep);
		painel.add(lbLogradouro);
		painel.add(lbEndereco);
		painel.add(lbNumero);
		painel.add(tfCep);
		painel.add(cbxLogradouros);
		painel.add(tfEndereco);
		painel.add(tfNumero);
		painel.add(lbComplemento);
		painel.add(lbBairro);
		painel.add(lbCidade);
		painel.add(lbEstado);
		painel.add(tfComplemento);
		painel.add(tfBairro);
		painel.add(tfCidade);
		painel.add(cbxEstados);
		painel.add(painelContato);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		// chamando o m�todo para carregar a combo de estados
		carregarComboEstados();

		// chamando o m�todo para carregar a combo de estados
		carregarComboLogradouros();

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a visibilidade da tela
		janela.setVisible(true);

	} // fim do m�todo

	/*
	 * m�todo para bloquear a tela de cadastro
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfCpf.setEditable(false);
		tfNome.setEditable(false);
		tfDataNascimento.setEditable(false);
		tfRg.setEditable(false);
		tfCep.setEditable(false);
		cbxLogradouros.setEnabled(false);
		tfEndereco.setEditable(false);
		tfNumero.setEditable(false);
		tfComplemento.setEditable(false);
		tfBairro.setEditable(false);
		tfCidade.setEditable(false);
		tfTelefone.setEditable(false);
		tfCelular.setEditable(false);
		tfEmail.setEditable(false);
		tfIdade.setEditable(false);
		cbxEstados.setEnabled(false);
		rbMasculino.setEnabled(false);
		rbFeminino.setEnabled(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	/*
	 * m�todo para liberar os campos da tela de cadastro
	 */
	public void liberarTela() {
		tfCodigo.setEditable(true);
		tfCpf.setEditable(true);
		tfNome.setEditable(true);
		tfCidade.setEditable(true);
		tfDataNascimento.setEditable(true);
		tfRg.setEditable(true);
		tfCep.setEditable(true);
		cbxLogradouros.setEnabled(true);
		tfEndereco.setEditable(true);
		tfNumero.setEditable(true);
		tfComplemento.setEditable(true);
		tfBairro.setEditable(true);
		tfCidade.setEditable(true);
		tfTelefone.setEditable(true);
		tfCelular.setEditable(true);
		tfEmail.setEditable(true);
		tfIdade.setEditable(true);
		cbxEstados.setEnabled(true);
		rbMasculino.setEnabled(true);
		rbFeminino.setEnabled(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
		tfCodigo.grabFocus();
	}

	/*
	 * m�todo para limpar os campos da tela de cadastro
	 */
	private void limparTela() {
		tfCodigo.setText(null);
		tfCpf.setText(null);
		tfNome.setText(null);
		tfCidade.setText(null);
		tfDataNascimento.setText(null);
		tfRg.setText(null);
		tfCep.setText(null);
		tfEndereco.setText(null);
		tfNumero.setText(null);
		tfComplemento.setText(null);
		tfBairro.setText(null);
		tfCidade.setText(null);
		tfTelefone.setText(null);
		tfCelular.setText(null);
		tfEmail.setText(null);
		tfIdade.setText(null);
		grpSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);
		cbxLogradouros.setSelectedIndex(0);
	}

	/*
	 * m�todo para preencher a combo de estados
	 */
	private void carregarComboEstados() {
		// valor inicial da combo
		cbxEstados.addItem("-Selecione Estado-");

		// la�o de repeti��o �ra carregar a combo de estados
		for (Estado estado : new EstadoController().getEstados()) {
			cbxEstados.addItem(estado.getNome());
		}

	} // fim do m�todo estados

	/*
	 * m�todo para preencher a combo de logradouros
	 */
	private void carregarComboLogradouros() {
		// valor inicial da combo
		cbxLogradouros.addItem("-Selecione Logradouro-");

		// la�o de repeti��o �ra carregar a combo de estados
		for (String logradouro : new LogradouroController().getLogradouros()) {
			cbxLogradouros.addItem(logradouro);
		}

	} // fim do m�todo estados

	/*
	 * m�todo para receber a��o do clique salvar
	 */
	public void salvar() {

		// salvar o cliente apenas se estiver v�lido todos os dados
		if (validar()) {

			/*
			 * procedimentos de grava��o do objeto cliente no arquivo TXT
			 */
			Cliente cliente = getCliente();

			// chamando o m�todo respons�vel por gravar o arquivo TXT
			new ClienteController().gravarTxtCliente(cliente);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo mensagem de sucesso para o usu�rio
			JOptionPane.showMessageDialog(null, Mensagem.clienteGravado, Titulo.cadastroCliente, 1);
		}

	}// fim do m�todo salvar

	/*
	 * m�todo para validar os campos da tela
	 */
	private boolean validar() {

		// valida��o do campo c�digo
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando o usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usu�rio que o c�digo � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo cpf
		if (Valida.isEmptyOrNull(tfCpf.getText()) || tfCpf.getText().equals("   .   .   -  ")) {
			// informando o usu�rio que o cpf n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCpf.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isStringValida(tfNome.getText())) {
			// informando ao usu�rio que o nome � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo data de nascimento
		if (Valida.isEmptyOrNull(tfDataNascimento.getText()) || tfDataNascimento.getText().equals("  /  /    ")) {
			// informando o usu�rio que a data de nascimento n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.dataNascimentoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfDataNascimento.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo rg
		if (Valida.isEmptyOrNull(tfRg.getText()) || tfRg.getText().equals("  .   .   - ")) {
			// informando o usu�rio que o rg n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfRg.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// informando o usu�rio que a idade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// informando ao usu�rio que a idade � inv�lida
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do radio button de sexo
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// informando o usu�rio que o sexo n�o foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroCliente, 0);
				// retornar falso para o m�todo
				return false;
			}
		}

		// valida��o do campo cep
		if (Valida.isEmptyOrNull(tfCep.getText()) || tfCep.getText().equals("     -   ")) {
			// informando o usu�rio que o cep n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCep.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo endere�o/rua
		if (Valida.isEmptyOrNull(tfEndereco.getText())) {
			// informando o usu�rio que o endere�o/rua n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.enderecoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfEndereco.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isInteger(tfEndereco.getText())) {
			// informando ao usu�rio que o endere�o/rua � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.enderecoInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfEndereco.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo complemento
		if (Valida.isEmptyOrNull(tfComplemento.getText())) {
			// informando o usu�rio que o complemento n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.complementoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfComplemento.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo bairro
		if (Valida.isEmptyOrNull(tfBairro.getText())) {
			// informando o usu�rio que o bairro n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfBairro.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isInteger(tfBairro.getText())) {
			// informando ao usu�rio que o bairro � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.bairroInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfBairro.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo n�mero
		if (Valida.isEmptyOrNull(tfNumero.getText())) {
			// informando o usu�rio que o n�mero n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNumero.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfNumero.getText())) {
			// informando ao usu�rio que o n�mero � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfNumero.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// informando o usu�rio que a cidade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isInteger(tfCidade.getText())) {
			// informando ao usu�rio que a cidade � inv�lida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeInvalida, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o da combo estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// informando o usu�rio que o estado n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			cbxEstados.grabFocus();
			return false;
		}

		// valida��o da combo logradouro
		if (cbxLogradouros.getSelectedIndex() == 0) {
			// informando o usu�rio que o Logradouros n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			cbxLogradouros.grabFocus();
			return false;
		}

		// valida��o do campo telefone
		if (Valida.isEmptyOrNull(tfTelefone.getText()) || tfTelefone.getText().equals("(  )     -    ")) {
			// informando o usu�rio que o telefone n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.telefoneVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfTelefone.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo celular
		if (Valida.isEmptyOrNull(tfCelular.getText()) || tfCelular.getText().equals("(  )      -    ")) {
			// informando o usu�rio que o celular n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfCelular.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo email
		if (Valida.isEmptyOrNull(tfEmail.getText())) {
			// informando o usu�rio que o email n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Titulo.cadastroCliente, 0);
			// colocando o foco no campo com erro
			tfEmail.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// devolvendo true caso esteja tudo v�lido
		return true;

	}// fim do m�todo validar

	/*
	 * m�todo para valorizar um objeto cliente utilizando so campos da tela
	 */
	private Cliente getCliente() {

		// instanciando o objeto cliente para retorno do m�todo
		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Data dataNascimento = new Data();

		// valorizando o objeto cliente
		cliente.setCodigo(Util.getInt(tfCodigo.getText()));
		cliente.setNome(tfNome.getText());
		endereco.setCodigo(Util.getInt(tfCodigo.getText()));
		endereco.setLogradouro(cbxLogradouros.getSelectedItem() + "");
		endereco.setEndereco(tfEndereco.getText());
		endereco.setNumero(Util.getInt(tfNumero.getText()));
		endereco.setComplemento(tfComplemento.getText());
		endereco.setBairro(tfBairro.getText());
		endereco.setCidade(tfCidade.getText());
		endereco.setEstado(cbxEstados.getSelectedItem() + "");
		endereco.setCep(tfCep.getText());
		cliente.setEndereco(endereco);
		// cpf e rg
		cliente.setCpf(tfCpf.getText());
		cliente.setRg(tfRg.getText());
		// data
		// Separando a data em 3
		String dataQuebrada[] = (tfDataNascimento.getText().split("/"));
		dataNascimento.setDia(Util.getInt(dataQuebrada[0]));
		dataNascimento.setMes(Util.getInt(dataQuebrada[1]));
		dataNascimento.setAno(Util.getInt(dataQuebrada[2]));
		cliente.setDataNascimento(dataNascimento);

		cliente.setIdade(Util.getInt(tfIdade.getText()));
		// condicional tern�ria - if em uma linha
		cliente.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');
		// contatos do cliente
		cliente.setTelefone(tfTelefone.getText());
		cliente.setCelular(tfCelular.getText());
		cliente.setEmail(tfEmail.getText());

		// retornando o objeto valorizado
		return cliente;

	} // fim do m�todo getCliente

} // fim da classe