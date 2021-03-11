package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.EstadoController;
import controller.VendedorController;
import model.Estado;
import model.Vendedor;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe respons�vel por controlar a tela CadastrarVendedor
 * 
 * @author Jo�o Victor
 * @since 04/03/2021
 */
public class CadastrarVendedorView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando as labels
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbAreaVenda;
	private JLabel lbCidade;
	private JLabel lbEstado;
	private JLabel lbSexo;
	private JLabel lbIdade;
	private JLabel lbSalario;
	// declarando os TextFields
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfAreaVenda;
	private JTextField tfCidade;
	private JTextField tfIdade;
	private JTextField tfSalario;
	// declarando o JComboBox
	private JComboBox cbxEstados;
	// declarando os radio buttons
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	// componente ButtonGroup respons�vel por gerenciar os componentes de Sexo
	private ButtonGroup grpSexo;
	// declarando os bot�es
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// painel para organiza��o dos componentes
	private JPanel painel;

	// vetor auxiliar para armazenar os estados
	private String[] estados = {};

	/*
	 * m�todo para criar a tela
	 */
	public void iniciaGui() { // in�cio do m�todo

		/*
		 * configura��es do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o t�tulo da tela
		janela.setTitle(Titulo.cadastroVendedor);
		// configurando o tamanho da tela
		janela.setSize(580, 360);
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
		 * configura��es do JLabel Nome
		 */
		lbNome = new JLabel();
		// configurando texto inicial
		lbNome.setText("Nome:");
		// configurando a posi��o e tmaanho do componente
		lbNome.setBounds(20, 50, 50, 25);

		/*
		 * configura��es do JLabel Area de Venda
		 */
		lbAreaVenda = new JLabel();
		// configurando texto inicial
		lbAreaVenda.setText("�rea de Venda:");
		// configurando a posi��o e tmaanho do componente
		lbAreaVenda.setBounds(20, 80, 85, 25);

		/*
		 * configura��es do JLabel Valor
		 */
		lbCidade = new JLabel();
		// configurando texto inicial
		lbCidade.setText("Cidade:");
		// configurando a posi��o e tmaanho do componente
		lbCidade.setBounds(20, 110, 70, 25);

		/*
		 * configurando o campo de texto C�digo
		 */
		tfCodigo = new JTextField();
		// configurar a posi��o e o tamanho
		tfCodigo.setBounds(120, 20, 410, 25);

		/*
		 * configurando o campo de texto Nome
		 */
		tfNome = new JTextField();
		// configurar a posi��o e o tamanho
		tfNome.setBounds(120, 50, 410, 25);

		/*
		 * configurando o campo de texto �rea de Venda
		 */
		tfAreaVenda = new JTextField();
		// configurar a posi��o e o tamanho
		tfAreaVenda.setBounds(120, 80, 410, 25);

		/*
		 * configurando o campo de texto Valor
		 */
		tfCidade = new JTextField();
		// configurar a posi��o e o tamanho
		tfCidade.setBounds(120, 110, 410, 25);

		/*
		 * configura��es do JLabel Estado
		 */
		lbEstado = new JLabel();
		// configurando tezto inicial
		lbEstado.setText("Estado:");
		// configurando a posi��o e tamanho do componente
		lbEstado.setBounds(20, 142, 70, 25);

		/*
		 * configura��es do JComboBox
		 */
		cbxEstados = new JComboBox(estados);
		cbxEstados.setBounds(120, 142, 300, 25);

		/*
		 * configura��es do JLabel Sexo
		 */
		lbSexo = new JLabel();
		// configurando texto inicial
		lbSexo.setText("Sexo:");
		// configurando a posi��o e tamanho do componente
		lbSexo.setBounds(20, 175, 50, 25);

		/*
		 * configura��es do radio button Masculino e Feminino
		 */
		rbMasculino = new JRadioButton();
		rbFeminino = new JRadioButton();
		// configurando o texto do componente
		rbMasculino.setText("Masculino");
		rbFeminino.setText("Feminino");
		// configurando a posi��o e o tamanho
		rbMasculino.setBounds(120, 175, 80, 25);
		rbFeminino.setBounds(220, 175, 80, 25);

		/*
		 * configura��es do ButtonGroup Sexo
		 */
		grpSexo = new ButtonGroup();
		grpSexo.add(rbMasculino);
		grpSexo.add(rbFeminino);

		/*
		 * configura��es do JLabel Idade
		 */
		lbIdade = new JLabel();
		// configurando texto inicial
		lbIdade.setText("Idade:");
		// configurando a posi��o e tamanho do componente
		lbIdade.setBounds(20, 205, 100, 25);

		/*
		 * configurando o campo de texto Idade
		 */
		tfIdade = new JTextField();
		// configurar a posi��o e o tamanho
		tfIdade.setBounds(120, 205, 410, 25);

		/*
		 * configura��es do JLabel Sal�rio
		 */
		lbSalario = new JLabel();
		// configurando texto inicial
		lbSalario.setText("Sal�rio:");
		// configurando a posi��o e tamanho do componente
		lbSalario.setBounds(20, 235, 100, 25);

		/*
		 * configurando o campo de texto Sal�rio
		 */
		tfSalario = new JTextField();
		// configurar a posi��o e o tamanho
		tfSalario.setBounds(120, 235, 410, 25);

		/*
		 * configura��es do JButton Salvar
		 */
		btSalvar = new JButton();
		// configurando o texto inicial
		btSalvar.setText("SALVAR");
		// configurando a posi��o e tamanho do componente
		btSalvar.setBounds(120, 275, 145, 30);
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
		btCancelar.setBounds(285, 275, 145, 30);
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
		btNovo.setBounds(120, 275, 145, 30);
		btSair.setBounds(285, 275, 145, 30);
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
		 * configura��es do painel da janela
		 */
		painel = (JPanel) janela.getContentPane();
		painel.setLayout(null);
		painel.add(lbCodigo);
		painel.add(tfCodigo);
		painel.add(lbNome);
		painel.add(tfNome);
		painel.add(lbAreaVenda);
		painel.add(tfAreaVenda);
		painel.add(lbCidade);
		painel.add(tfCidade);
		painel.add(lbEstado);
		painel.add(cbxEstados);
		painel.add(lbSexo);
		painel.add(rbMasculino);
		painel.add(rbFeminino);
		painel.add(lbIdade);
		painel.add(tfIdade);
		painel.add(lbSalario);
		painel.add(tfSalario);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

		// chamando o m�todo para carregar a combo de estados
		carregarComboEstados();

		// bloqueando a tela ao iniciar
		bloquearTela();

		// configurando a visibilidade da tela
		janela.setVisible(true);
	} // fim do m�todo gui

	/*
	 * m�todo para bloquear a tela de cadastro
	 */
	private void bloquearTela() {
		tfCodigo.setEditable(false);
		tfNome.setEditable(false);
		tfAreaVenda.setEditable(false);
		tfCidade.setEditable(false);
		cbxEstados.setEnabled(false);
		tfIdade.setEditable(false);
		tfSalario.setEditable(false);
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
		tfNome.setEditable(true);
		tfAreaVenda.setEditable(true);
		tfCidade.setEditable(true);
		cbxEstados.setEnabled(true);
		tfIdade.setEditable(true);
		tfSalario.setEditable(true);
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
		tfNome.setText(null);
		tfAreaVenda.setText(null);
		tfCidade.setText(null);
		tfIdade.setText(null);
		tfSalario.setText(null);
		grpSexo.clearSelection();
		cbxEstados.setSelectedIndex(0);
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

	}

	/*
	 * m�todo para receber a��o do clique salvar
	 */
	public void salvar() {

		// salvar o vendedor apenas se estiver v�lido todos os dados
		if (validar()) {

			/*
			 * procedimentos de grava��o do objeto vendedor no arquivo TXT
			 */
			Vendedor vendedor = getVendedor();

			// chamando o m�todo respons�vepor gravar o arquivo TXT
			new VendedorController().gravarTxtVendedor(vendedor);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo mensagem de sucesso para o usu�rio
			JOptionPane.showMessageDialog(null, Mensagem.vendedorGravado, Titulo.cadastroVendedor, 1);
		}

	}

	/*
	 * m�todo para validar os campos da tela
	 */
	private boolean validar() {

		// valida��o do campo c�digo
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando o usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usu�rio que o c�digo � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isStringValida(tfNome.getText())) {
			// informando ao usu�rio que o nome � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo �rea de venda
		if (Valida.isEmptyOrNull(tfAreaVenda.getText())) {
			// informando o usu�rio que a �rea de venda n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfAreaVenda.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isStringValida(tfAreaVenda.getText())) {
			// informando ao usu�rio que a �rea de venda � inv�lida
			JOptionPane.showMessageDialog(null, Mensagem.areaVendaInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfAreaVenda.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo cidade
		if (Valida.isEmptyOrNull(tfCidade.getText())) {
			// informando o usu�rio que a cidade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isStringValida(tfCidade.getText())) {
			// informando ao usu�rio que a cidade � inv�lida
			JOptionPane.showMessageDialog(null, Mensagem.cidadeInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfCidade.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o da combo estado
		if (cbxEstados.getSelectedIndex() == 0) {
			// informando o usu�rio que o estado n�o foi selecionado
			JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Titulo.cadastroVendedor, 0);
			// colocando o foc no campo com erro
			cbxEstados.grabFocus();
			return false;
		}

		// valida��o do radio button de sexo
		if (!rbMasculino.isSelected()) {
			if (!rbFeminino.isSelected()) {
				// informando o usu�rio que o sexo n�o foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.sexoVazio, Titulo.cadastroVendedor, 0);
				// retornar falso para o m�todo
				return false;
			}
		}

		// valida��o do campo idade
		if (Valida.isEmptyOrNull(tfIdade.getText())) {
			// informando o usu�rio que a idade n�o est� preenchida
			JOptionPane.showMessageDialog(null, Mensagem.idadeVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfIdade.getText())) {
			// informando ao usu�rio que a idade � inv�lida
			JOptionPane.showMessageDialog(null, Mensagem.idadeInvalida, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfIdade.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo sal�rio
		if (Valida.isEmptyOrNull(tfSalario.getText())) {
			// informando o usu�rio que o sal�rio n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isDouble(tfSalario.getText())) {
			// informando ao usu�rio que o sal�rio � inv�lidp
			JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Titulo.cadastroVendedor, 0);
			// colocando o foco no campo com erro
			tfSalario.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// devolvendo true caso esteja tudo v�lido
		return true;
	} // fim do m�todo validar

	/*
	 * m�todo para valorizar um objeto vendedor utilizando so campos da tela
	 */
	private Vendedor getVendedor() {

		// instanciando o objeto vendedor para retorno do m�todo
		Vendedor vendedor = new Vendedor();

		// valorizando o objeto vendedor
		vendedor.setCodigo(Util.getInt(tfCodigo.getText()));
		vendedor.setNome(tfNome.getText());
		vendedor.setAreaVenda(tfAreaVenda.getText());
		vendedor.setCidade(tfCidade.getText());
		vendedor.setEstado(cbxEstados.getSelectedItem() + "");

		// condicional tern�ria - if em uma linha
		vendedor.setSexo((rbMasculino.isSelected()) ? 'M' : 'F');

		vendedor.setIdade(Util.getInt(tfIdade.getText()));
		vendedor.setSalario(Util.getDouble(tfSalario.getText()));

		// retornando o onjeto valorizado
		return vendedor;

	} // fim do m�todo getVendedor

} // fim da classe