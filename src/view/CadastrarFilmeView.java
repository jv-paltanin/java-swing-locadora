package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.FilmeController;
import model.Filme;
import util.Mensagem;
import util.Titulo;
import util.Util;
import util.Valida;

/**
 * Classe respons�vel por controlar a tela CadastrarFilme
 * 
 * @author Jo�o Victor
 * @since 04/03/2021
 */
public class CadastrarFilmeView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando as labels
	private JLabel lbCodigo;
	private JLabel lbNome;
	private JLabel lbValor;
	private JLabel lbDisponivel;
	private JLabel lbPromocao;
	private JLabel lbValorPromocao;
	private JLabel lbGenero;
	// declarando os TextFields
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfValor;
	private JTextField tfValorPromocao;
	// declarando os radio buttons
	private JRadioButton rbSimDisponivel;
	private JRadioButton rbNaoDisponivel;
	private JRadioButton rbSimPromocao;
	private JRadioButton rbNaoPromocao;
	// componente ButtonGroup respons�vel por gerenciar os componentes radio button
	// Disponivel e Promocao
	private ButtonGroup grpDispopnivel;
	private ButtonGroup grpPromocao;
	// declarando a checkbox
	// componente checkbox que permite a sele��o de mais de uma op��o
	private JCheckBox cbAcao;
	private JCheckBox cbFiccao;
	private JCheckBox cbTerror;
	private JCheckBox cbComedia;
	private JCheckBox cbOutro;
	// declarando os bot�es
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// painel para organiza��o dos componentes
	private JPanel painel;

	/*
	 * m�todo para criar a tela
	 */
	public void iniciaGui() { // in�cio do m�todo

		/*
		 * configura��es do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o t�tulo da tela
		janela.setTitle(Titulo.cadastroFilme);
		// configurando o tamanho da tela
		janela.setSize(580, 350);
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
		 * configura��es do JLabel Valor
		 */
		lbValor = new JLabel();
		// configurando texto inicial
		lbValor.setText("Valor:");
		// configurando a posi��o e tmaanho do componente
		lbValor.setBounds(20, 80, 50, 25);

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
		 * configurando o campo de texto Valor
		 */
		tfValor = new JTextField();
		// configurar a posi��o e o tamanho
		tfValor.setBounds(120, 80, 410, 25);

		/*
		 * configura��es do JLabel Disponivel
		 */
		lbDisponivel = new JLabel();
		// configurando tezto inicial
		lbDisponivel.setText("Dispon�vel:");
		// configurando a posi��o e tamanho do componente
		lbDisponivel.setBounds(20, 110, 70, 25);

		/*
		 * configura��es do radio button Dispon�vel
		 */
		rbSimDisponivel = new JRadioButton();
		rbNaoDisponivel = new JRadioButton();
		// configurando o texto do componente
		rbSimDisponivel.setText("Sim");
		rbNaoDisponivel.setText("N�o");
		// configurando a posi��o e o tamanho
		rbSimDisponivel.setBounds(120, 110, 50, 25);
		rbNaoDisponivel.setBounds(180, 110, 50, 25);

		/*
		 * configura��es do ButtonGroup Dispon�vel
		 */
		grpDispopnivel = new ButtonGroup();
		grpDispopnivel.add(rbSimDisponivel);
		grpDispopnivel.add(rbNaoDisponivel);

		/*
		 * configura��es do JLabel Promo��o
		 */
		lbPromocao = new JLabel();
		// configurando texto inicial
		lbPromocao.setText("Promo��o:");
		// configurando a posi��o e tamanho do componente
		lbPromocao.setBounds(20, 138, 70, 25);

		/*
		 * configura��es do radio button Promo��o
		 */
		rbSimPromocao = new JRadioButton();
		rbNaoPromocao = new JRadioButton();
		// configurando o texto do componente
		rbSimPromocao.setText("Sim");
		rbNaoPromocao.setText("N�o");
		// configurando a posi��o e o tamanho
		rbSimPromocao.setBounds(120, 138, 50, 25);
		rbNaoPromocao.setBounds(180, 138, 50, 25);

		/*
		 * configura��es do ButtonGroup Promo��o
		 */
		grpPromocao = new ButtonGroup();
		grpPromocao.add(rbSimPromocao);
		grpPromocao.add(rbNaoPromocao);

		/*
		 * configura��es do JLabel ValorPromocao
		 */
		lbValorPromocao = new JLabel();
		// configurando texto inicial
		lbValorPromocao.setText("Valor Promo��o:");
		// configurando a posi��o e tmaanho do componente
		lbValorPromocao.setBounds(20, 165, 100, 25);

		/*
		 * configurando o campo de texto ValorPromocao
		 */
		tfValorPromocao = new JTextField();
		// configurar a posi��o e o tamanho
		tfValorPromocao.setBounds(120, 165, 410, 25);

		/*
		 * configura��es do JLabel G�nero
		 */
		lbGenero = new JLabel();
		// configurando texto inicial
		lbGenero.setText("G�nero:");
		// configurando a posi��o e tamanho do componente
		lbGenero.setBounds(20, 195, 100, 25);

		/*
		 * configura��es do JCheckBox G�nero
		 */
		cbAcao = new JCheckBox();
		cbFiccao = new JCheckBox();
		cbTerror = new JCheckBox();
		cbComedia = new JCheckBox();
		cbOutro = new JCheckBox();
		// configurando o texto exibido no componente
		cbAcao.setText("A��o");
		cbFiccao.setText("Fic��o");
		cbTerror.setText("Terror");
		cbComedia.setText("Com�dia");
		cbOutro.setText("Outro");
		// configurando a posi��o e tamanho do componente
		cbAcao.setBounds(120, 195, 55, 25);
		cbFiccao.setBounds(180, 195, 65, 25);
		cbTerror.setBounds(245, 195, 65, 25);
		cbComedia.setBounds(310, 195, 75, 25);
		cbOutro.setBounds(390, 195, 60, 25);

		/*
		 * configura��es do JButton Salvar
		 */
		btSalvar = new JButton();
		// configurando o texto inicial
		btSalvar.setText("SALVAR");
		// configurando a posi��o e tamanho do componente
		btSalvar.setBounds(120, 250, 145, 30);
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
		btCancelar.setBounds(285, 250, 145, 30);
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
		btNovo.setBounds(120, 250, 145, 30);
		btSair.setBounds(285, 250, 145, 30);
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
		painel.add(lbNome);
		painel.add(lbValor);
		painel.add(tfCodigo);
		painel.add(tfNome);
		painel.add(tfValor);
		painel.add(lbDisponivel);
		painel.add(rbSimDisponivel);
		painel.add(rbNaoDisponivel);
		painel.add(lbPromocao);
		painel.add(rbSimPromocao);
		painel.add(rbNaoPromocao);
		painel.add(lbValorPromocao);
		painel.add(tfValorPromocao);
		painel.add(lbGenero);
		painel.add(cbAcao);
		painel.add(cbFiccao);
		painel.add(cbTerror);
		painel.add(cbComedia);
		painel.add(cbOutro);
		painel.add(btSalvar);
		painel.add(btCancelar);
		painel.add(btNovo);
		painel.add(btSair);

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
		tfNome.setEditable(false);
		tfValor.setEditable(false);
		rbSimDisponivel.setEnabled(false);
		rbNaoDisponivel.setEnabled(false);
		rbSimPromocao.setEnabled(false);
		rbNaoPromocao.setEnabled(false);
		tfValorPromocao.setEditable(false);
		cbAcao.setEnabled(false);
		cbComedia.setEnabled(false);
		cbFiccao.setEnabled(false);
		cbOutro.setEnabled(false);
		cbTerror.setEnabled(false);
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
		tfValor.setEditable(true);
		rbSimDisponivel.setEnabled(true);
		rbNaoDisponivel.setEnabled(true);
		rbSimPromocao.setEnabled(true);
		rbNaoPromocao.setEnabled(true);
		tfValorPromocao.setEditable(true);
		cbAcao.setEnabled(true);
		cbComedia.setEnabled(true);
		cbFiccao.setEnabled(true);
		cbOutro.setEnabled(true);
		cbTerror.setEnabled(true);
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
		tfValor.setText(null);
		grpDispopnivel.clearSelection();
		grpPromocao.clearSelection();
		tfValorPromocao.setText(null);
		cbAcao.setSelected(false);
		cbComedia.setSelected(false);
		cbFiccao.setSelected(false);
		cbOutro.setSelected(false);
		cbTerror.setSelected(false);
	}

	/*
	 * m�todo para receber a��o do clique salvar
	 */
	public void salvar() {

		// salvar o filme apenas se estiver v�lido todos os dados
		if (validar()) {

			/*
			 * procedimentos de grava��o do objeto filme no arquivo TXT
			 */
			Filme filme = getFilme();

			// chamando o m�todo respons�vel por gravar o arquivo TXT
			new FilmeController().gravarTxtFilme(filme);

			// limpar a tela preenchida
			limparTela();

			// bloquear a tela
			bloquearTela();

			// exibindo mensagem de sucesso para o usu�rio
			JOptionPane.showMessageDialog(null, Mensagem.filmeGravado, Titulo.cadastroFilme, 1);
		}

	} // fim do m�todo salvar

	/*
	 * m�todo para validar os campos da tela
	 */
	private boolean validar() {

		// valida��o do campo c�digo
		if (Valida.isEmptyOrNull(tfCodigo.getText())) {
			// informando o usu�rio que o c�digo n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isInteger(tfCodigo.getText())) {
			// informando ao usu�rio que o c�digo � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfCodigo.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo nome
		if (Valida.isEmptyOrNull(tfNome.getText())) {
			// informando o usu�rio que o nome n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (Valida.isInteger(tfNome.getText())) {
			// informando ao usu�rio que o nome � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.nomeInvalido, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfNome.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do campo valor
		if (Valida.isEmptyOrNull(tfValor.getText())) {
			// informando o usu�rio que o valor n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValor.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isDouble(tfValor.getText())) {
			// informando ao usu�rio que o valor � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.valorInvalido, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValor.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do radio button de Disponivel
		if (!rbSimDisponivel.isSelected()) {
			if (!rbNaoDisponivel.isSelected()) {
				// informando o usu�rio que o dispon�vel n�o foi selecionado
				JOptionPane.showMessageDialog(null, Mensagem.disponivelVazio, Titulo.cadastroFilme, 0);
				// retornar falso para o m�todo
				return false;
			}
		}

		// valida��o do radio button de Promocao
		if (!rbSimPromocao.isSelected()) {
			if (!rbNaoPromocao.isSelected()) {
				// informando o usu�rio que a promo��o n�o foi selecionada
				JOptionPane.showMessageDialog(null, Mensagem.promocaoVazio, Titulo.cadastroFilme, 0);
				// retornar falso para o m�todo
				return false;
			}
		}

		// valida��o do campo valor promo��o
		if (Valida.isEmptyOrNull(tfValorPromocao.getText())) {
			// informando o usu�rio que o valor promo��o n�o est� preenchido
			JOptionPane.showMessageDialog(null, Mensagem.valorVazio, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValorPromocao.grabFocus();
			// retornar false para o m�todo
			return false;
		} else if (!Valida.isDouble(tfValorPromocao.getText())) {
			// informando ao usu�rio que o valor promo��o � inv�lido
			JOptionPane.showMessageDialog(null, Mensagem.valorPromocaoInvalido, Titulo.cadastroFilme, 0);
			// colocando o foco no campo com erro
			tfValorPromocao.grabFocus();
			// retornar false para o m�todo
			return false;
		}

		// valida��o do checkbox de g�neros
		if (!cbAcao.isSelected()) {
			if (!cbFiccao.isSelected()) {
				if (!cbTerror.isSelected()) {
					if (!cbComedia.isSelected()) {
						if (!cbOutro.isSelected()) {
							// informando o usu�rio que o promo��o n�o foi selecionado
							JOptionPane.showMessageDialog(null, Mensagem.generoVazio, Titulo.cadastroFilme, 0);
							// retornar falso para o m�todo
							return false;
						}
					}
				}
			}
		}

		// devolvendo true caso esteja tudo v�lido
		return true;
	} // fim do m�todo validar

	/*
	 * m�todo para valorizar um objeto filme utilizando so campos da tela
	 */
	private Filme getFilme() {

		// instanciando o objeto filme para retorno do m�todo
		Filme filme = new Filme();

		// valorizando o objeto filme
		filme.setCodigo(Util.getInt(tfCodigo.getText()));
		filme.setNome(tfNome.getText());
		filme.setValor(Util.getDouble(tfValor.getText()));

		// condicional para verificar se est� Dispon�vel ou n�o
		if (rbSimDisponivel.isSelected()) {
			filme.setDisponivel(true);
		} else {
			filme.setDisponivel(false);
		}
		// condicional para verificar se est� na Promo��o ou n�o
		if (rbSimPromocao.isSelected()) {
			filme.setPromocao(true);
		} else {
			filme.setPromocao(false);
		}

		filme.setValorPromocao(Util.getDouble(tfValorPromocao.getText()));

		// vari�vel auxiliar para receber g�neros
		String generos = "";
		if (cbAcao.isSelected()) {
			generos += cbAcao.getText() + ";";
		}
		if (cbFiccao.isSelected()) {
			generos += cbFiccao.getText() + ";";
		}
		if (cbTerror.isSelected()) {
			generos += cbTerror.getText() + ";";
		}
		if (cbComedia.isSelected()) {
			generos += cbComedia.getText() + ";";
		}
		if (cbOutro.isSelected()) {
			generos += cbOutro.getText() + ";";
		}
		generos = generos.substring(0, generos.length() - 1);

		filme.setGenero(generos);

		// retornando o objeto valorizado
		return filme;
	} // fim do m�todo getFilme

} // fim da classe