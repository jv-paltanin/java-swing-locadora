package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Classe respons�vel por controlar a tela CadastrarLoca��o
 * 
 * @author Jo�o Victor
 * @since 04/03/2021
 */
public class CadastrarLocacaoView {

	// declarando os atributos da tela
	private JFrame janela;
	// declarando as labels
	private JLabel lbNomeVendedor;
	private JLabel lbNomeFilme;
	private JLabel lbFormaPagamento;
	private JLabel lbValorTotal;
	private JLabel lbValorPago;
	private JLabel lbTroco;
	// declarando os TextFields
	private JTextField tfValorTotal;
	private JTextField tfValorPago;
	private JTextField tfTroco;
	// declarando os JComboBoxs
	private JComboBox cbxNomeVendedores;
	private JComboBox cbxNomeFilmes;
	// declarando a tabela para armazenar os daos inputado pelo usu�rio
	private JTable tabelaLocacao;
	// declarando o scroll auxiliar para exibir os registros da tabela
	private JScrollPane scrollTabelaLocacao;
	// declarando os radio buttons
	private JRadioButton rbDinheiro;
	private JRadioButton rbCheque;
	private JRadioButton rbDebito;
	private JRadioButton rbCredito;
	// componente ButtonGroup respons�vel por gerenciar as Formas de pagamento
	private ButtonGroup grpFormaPagamento;
	// declarando os bot�es
	private JButton btIncluir;
	private JButton btSalvar;
	private JButton btCancelar;
	private JButton btNovo;
	private JButton btSair;
	// declarando o painel para organizar os componentes de tela
	private JPanel painel;

	// vetor auxiliar para armazenar os nomes de vendedores
	private String vendedores[] = { "-Selecione um Vendedor-" };
	// vetor auxiliar para armazenar os nomes de filmes
	private String filmes[] = { "-Selecione um Filme-" };
	// vetor auxiliar para armazenar os nomes das colunas
	private String colunas[] = { "C�digo", "Nome", "Valor", "Dispon�vel", "Promo��o", "Valor Promocional" };
	// matriz auxiliar para armazenar os dados exibidos na tabela
	private String linhas[][] = {};

	/*
	 * m�todo para criar a tela
	 */
	public void iniciaGui() { // in�cio do m�todo

		/*
		 * configura��es do JFrame - tela
		 */
		janela = new JFrame();
		// configurando o t�tulo da tela
		janela.setTitle("LOCA��O DE FILME");
		// configurando o tamanho da tela
		janela.setSize(700, 450);
		// configurando a posi��o inicial da tela - centralizada
		janela.setLocationRelativeTo(null);

		/*
		 * configura��es do JLabel Nome do Vendedor
		 */
		lbNomeVendedor = new JLabel();
		// configurando texto inicial
		lbNomeVendedor.setText("Nome do Vendedor:");
		// configurando a posi��o e tamanho do componente
		lbNomeVendedor.setBounds(10, 20, 120, 30);

		/*
		 * configura��es do JComboBox Nome dos Vendedores
		 */
		cbxNomeVendedores = new JComboBox(vendedores);
		cbxNomeVendedores.setBounds(150, 20, 510, 30);

		/*
		 * configura��es do JLabel Nome de Filme
		 */
		lbNomeFilme = new JLabel();
		// configurando texto inicial
		lbNomeFilme.setText("Nome do Filme:");
		// configurando a posi��o e tmaanho do componente
		lbNomeFilme.setBounds(10, 60, 100, 30);

		/*
		 * configura��es do JComboBox Nome do Filme
		 */
		cbxNomeFilmes = new JComboBox(filmes);
		cbxNomeFilmes.setBounds(150, 60, 380, 30);

		/*
		 * configura��es do JButton Salvar
		 */
		btIncluir = new JButton();
		// configurando o texto inicial
		btIncluir.setText("INCLUIR");
		// configurando a posi��o e tamanho do componente
		btIncluir.setBounds(545, 61, 115, 28);
		// configurando a a��o do bot�o

		/*
		 * configura��es do componente JTable - tabela de dados
		 */
		// definir o modelo utilizado na tabela - quantidade de linhas e colunas
		DefaultTableModel modelo = new DefaultTableModel(linhas, colunas);
		tabelaLocacao = new JTable(modelo);
		// configurar a posi��o e tamanho
		// tabelaLocacao.setBounds(19, 30, 300, 95);
		// configurar a a��o do usu�rio quando clica no registro armazena
		tabelaLocacao.setEnabled(true);

		/*
		 * configura��es do componente JScrollPane
		 */
		scrollTabelaLocacao = new JScrollPane(tabelaLocacao);
		// configurar local de exibi��o do scroll
		scrollTabelaLocacao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// configurar a posi��o e tamanho
		scrollTabelaLocacao.setBounds(0, 110, 685, 130);

		/*
		 * configura��es do JLabel Forma de Pagamento
		 */
		lbFormaPagamento = new JLabel();
		// configurando texto inicial
		lbFormaPagamento.setText("Forma de Pagamento:");
		// configurando a posi��o e tamanho do componente
		lbFormaPagamento.setBounds(10, 245, 130, 30);

		/*
		 * configura��es do radio button para Forma de Pagamento
		 */

		rbDinheiro = new JRadioButton();
		rbCheque = new JRadioButton();
		rbDebito = new JRadioButton();
		rbCredito = new JRadioButton();
		// configurando o texto do componente
		rbDinheiro.setText("Dinheiro");
		rbCheque.setText("Cheque");
		rbDebito.setText("D�bito");
		rbCredito.setText("Cr�dito");
		// configurando a posi��o e o tamanho
		rbDinheiro.setBounds(160, 245, 80, 30);
		rbCheque.setBounds(160, 270, 80, 30);
		rbDebito.setBounds(160, 295, 80, 30);
		rbCredito.setBounds(160, 320, 80, 30);

		/*
		 * configura��es do ButtonGroup Forma de Pagamento
		 */
		grpFormaPagamento = new ButtonGroup();
		grpFormaPagamento.add(rbDinheiro);
		grpFormaPagamento.add(rbCheque);
		grpFormaPagamento.add(rbDebito);
		grpFormaPagamento.add(rbCredito);

		/*
		 * configura��es do JLabel Valor Total
		 */
		lbValorTotal = new JLabel();
		// configurando texto inicial
		lbValorTotal.setText("Valor Total:");
		// configurando a posi��o e tamanho do componente
		lbValorTotal.setBounds(390, 245, 130, 30);

		/*
		 * configura��es do JLabel Valor Pago
		 */
		lbValorPago = new JLabel();
		// configurando texto inicial
		lbValorPago.setText("Valor Pago:");
		// configurando a posi��o e tamanho do componente
		lbValorPago.setBounds(390, 270, 130, 30);

		/*
		 * configura��es do JLabel Troco
		 */
		lbTroco = new JLabel();
		// configurando texto inicial
		lbTroco.setText("Troco:");
		// configurando a posi��o e tamanho do componente
		lbTroco.setBounds(390, 295, 130, 30);

		/*
		 * configurando o campo de texto Valor total
		 */
		tfValorTotal = new JTextField();
		// configurar a posi��o e o tamanho
		tfValorTotal.setBounds(460, 245, 150, 30);

		/*
		 * configurando o campo de texto Valor pago
		 */
		tfValorPago = new JTextField();
		// configurar a posi��o e o tamanho
		tfValorPago.setBounds(460, 270, 150, 30);

		/*
		 * configurando o campo de texto Troco
		 */
		tfTroco = new JTextField();
		// configurar a posi��o e o tamanho
		tfTroco.setBounds(460, 295, 150, 30);

		/*
		 * configura��es do JButton Salvar
		 */
		btSalvar = new JButton();
		// configurando o texto inicial
		btSalvar.setText("SALVAR");
		// configurando a posi��o e tamanho do componente
		btSalvar.setBounds(210, 365, 130, 30);
		// configurando a a��o do bot�o

		/*
		 * configura��es do JButton Cancelar
		 */
		btCancelar = new JButton();
		// configurando o texto inicial
		btCancelar.setText("CANCELAR");
		// configurando a posi��o e tamanho do componente
		btCancelar.setBounds(350, 365, 130, 30);
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
		btNovo.setBounds(210, 365, 130, 30);
		btSair.setBounds(350, 365, 130, 30);
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
		painel.add(lbNomeVendedor);
		painel.add(cbxNomeVendedores);
		painel.add(lbNomeFilme);
		painel.add(cbxNomeFilmes);
		painel.add(btIncluir);
		painel.add(scrollTabelaLocacao);
		painel.add(lbFormaPagamento);
		painel.add(rbDinheiro);
		painel.add(rbCheque);
		painel.add(rbDebito);
		painel.add(rbCredito);
		painel.add(lbValorTotal);
		painel.add(lbValorPago);
		painel.add(lbTroco);
		painel.add(tfValorTotal);
		painel.add(tfValorPago);
		painel.add(tfTroco);
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
		cbxNomeVendedores.setEnabled(false);
		cbxNomeFilmes.setEnabled(false);
		btIncluir.setVisible(false);
		rbDinheiro.setEnabled(false);
		rbCheque.setEnabled(false);
		rbDebito.setEnabled(false);
		rbCredito.setEnabled(false);
		tfValorTotal.setEditable(false);
		tfValorPago.setEditable(false);
		tfTroco.setEditable(false);
		btSalvar.setVisible(false);
		btCancelar.setVisible(false);
		btNovo.setVisible(true);
		btSair.setVisible(true);
	}

	/*
	 * m�todo para liberar os campos da tela de cadastro
	 */
	public void liberarTela() {
		cbxNomeVendedores.setEnabled(true);
		cbxNomeFilmes.setEnabled(true);
		btIncluir.setVisible(true);
		rbDinheiro.setEnabled(true);
		rbCheque.setEnabled(true);
		rbDebito.setEnabled(true);
		rbCredito.setEnabled(true);
		tfValorTotal.setEditable(true);
		tfValorPago.setEditable(true);
		tfTroco.setEditable(true);
		btSalvar.setVisible(true);
		btCancelar.setVisible(true);
		btNovo.setVisible(false);
		btSair.setVisible(false);
	}

	/*
	 * m�todo para limpar os campos da tela de cadastro
	 */
	private void limparTela() {
		cbxNomeVendedores.setSelectedIndex(0);
		cbxNomeFilmes.setSelectedIndex(0);
		grpFormaPagamento.clearSelection();
		tfValorTotal.setText(null);
		tfValorPago.setText(null);
		tfTroco.setText(null);
	}

}// fim da classe