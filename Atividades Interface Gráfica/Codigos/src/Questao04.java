import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Questao04 {
	private JFrame frame;
	private String matriculaFinal, tamanhoFinal, corFinal;
	private int quantidadeFinal;
	private boolean statusCor, statusMatricula, statusTamanho, statusQuantidade = true;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questao04 window = new Questao04();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Questao04() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.CYAN);
		
		JLabel matricula = new JLabel("Matrícula");
		frame.getContentPane().add(matricula);
		matricula.setBounds(50, 55, 100, 30);
		
		JTextField matriculaTexto = new JTextField();
		frame.getContentPane().add(matriculaTexto);
		matriculaTexto.setBounds(120, 60, 100, 20);
		
		JLabel tamanho = new JLabel("Tamanho");
		frame.getContentPane().add(tamanho);
		tamanho.setBounds(250, 55, 100, 30);
		
		JRadioButton p, m, g;
		p = new JRadioButton("P", false);
		m = new JRadioButton("M", false);
		g = new JRadioButton("G", false);
		frame.getContentPane().add(p);
		frame.getContentPane().add(m);
		frame.getContentPane().add(g);
		p.setBounds(320, 60, 35, 20);
		m.setBounds(360, 60, 35, 20);
		g.setBounds(400, 60, 35, 20);
		p.setBackground(Color.CYAN);
		m.setBackground(Color.CYAN);
		g.setBackground(Color.CYAN);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(p); grupo1.add(m); grupo1.add(g);
		
		JLabel cor = new JLabel("Selecione a Cor");
		frame.getContentPane().add(cor);
		cor.setBounds(50, 130, 100, 30);
		
		JLabel amarela = new JLabel("Amarela");
		frame.getContentPane().add(amarela);
		amarela.setBounds(50, 180, 100, 20);
		amarela.setForeground(new Color(255,165,0));
		amarela.setFont(new Font("Tahoma", 1, 12));
		JLabel azul = new JLabel("Azul");
		frame.getContentPane().add(azul);
		azul.setBounds(140, 180, 100, 20);
		azul.setForeground(Color.BLUE);
		azul.setFont(new Font("Tahoma", 1, 12));
		JLabel branca = new JLabel("Branca");
		frame.getContentPane().add(branca);
		branca.setBounds(210, 180, 100, 20);
		branca.setForeground(Color.WHITE);
		branca.setFont(new Font("Tahoma", 1, 12));
		JLabel verde = new JLabel("Verde");
		frame.getContentPane().add(verde);
		verde.setBounds(290, 180, 100, 20);
		verde.setForeground(new Color(0,100,0));
		verde.setFont(new Font("Tahoma", 1, 12));
		JLabel vermelha = new JLabel("Vermelha");
		frame.getContentPane().add(vermelha);
		vermelha.setBounds(360, 180, 100, 20);
		vermelha.setForeground(Color.RED);
		vermelha.setFont(new Font("Tahoma", 1, 12));
		
		JRadioButton amarela1, azul1, branca1, verde1, vermelha1;
		amarela1 = new JRadioButton("", false);
		azul1 = new JRadioButton("", false);
		branca1 = new JRadioButton("", false);
		verde1 = new JRadioButton("", false);
		vermelha1 = new JRadioButton("", false);
		frame.getContentPane().add(amarela1);
		frame.getContentPane().add(azul1);
		frame.getContentPane().add(branca1);
		frame.getContentPane().add(verde1);
		frame.getContentPane().add(vermelha1);
		amarela1.setBounds(110, 180, 20, 20);
		azul1.setBounds(175, 180, 20, 20);
		branca1.setBounds(260, 180, 20, 20);
		verde1.setBounds(330, 180, 20, 20);
		vermelha1.setBounds(420, 180, 20, 20);
		amarela1.setBackground(Color.CYAN);
		azul1.setBackground(Color.CYAN);
		branca1.setBackground(Color.CYAN);
		verde1.setBackground(Color.CYAN);
		vermelha1.setBackground(Color.CYAN);
		
		ButtonGroup grupo2 = new ButtonGroup();
		grupo2.add(amarela1); grupo2.add(azul1); grupo2.add(branca1);
		grupo2.add(verde1); grupo2.add(vermelha1);
		
		JLabel quantidade = new JLabel("Quantidade");
		frame.getContentPane().add(quantidade);
		quantidade.setBounds(50, 250, 100, 30);
		
		JTextField quantidadeTexto = new JTextField();
		frame.getContentPane().add(quantidadeTexto);
		quantidadeTexto.setBounds(140, 255, 100, 20);
		
		JButton solicitar = new JButton("SOLICITAR");
		frame.getContentPane().add(solicitar);
		solicitar.setBounds(50, 350, 150, 30);
		
		JButton sair = new JButton("SAIR");
		frame.getContentPane().add(sair);
		sair.setBounds(270, 350, 150, 30);
		
		sair.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent sair){
				System.exit(0);
			}
		});
		
		solicitar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent sair){
				try {
					matriculaFinal = matriculaTexto.getText();
					quantidadeFinal = Integer.parseInt(quantidadeTexto.getText());
					
					if(p.isSelected()) {
						tamanhoFinal = "P"; statusTamanho = true;
					}else if(m.isSelected()){
						tamanhoFinal = "M"; statusTamanho = true;
					}else if(g.isSelected()) {
						tamanhoFinal = "G"; statusTamanho = true;
					}else {
						statusTamanho = false;
					}
					
					if (amarela1.isSelected()) {
						corFinal = "0010"; statusCor = true;
					}else if(azul1.isSelected()) {
						corFinal = "1100"; statusCor = true;
					}else if (branca1.isSelected()) {
						corFinal = "0000"; statusCor = true;
					}else if(verde1.isSelected()) {
						corFinal = "1010"; statusCor = true;
					}else if(vermelha1.isSelected()) {
						corFinal = "0110"; statusCor = true;
					}else {
						statusCor = false;
					}
					
					for(int i=0; i<matriculaFinal.length(); i++) {
						char c = '0';
						if(matriculaFinal.charAt(i) != c) {
							statusMatricula = true;
							break;
						}else{
							statusMatricula = false;
						}
					}
					
					if(quantidadeFinal == 0) {
						statusQuantidade = false;
					}else {
						statusQuantidade = true;
					}
					
				}catch(NumberFormatException e) {
					statusQuantidade = false;
				}
				
				if(statusCor && statusMatricula && statusQuantidade && statusTamanho) {
					String textoFinal = matriculaFinal+":"+tamanhoFinal+":"+corFinal;
					for(int i=0; i<quantidadeFinal; i++) {
						try {
							gravar(textoFinal);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "Solicitação realizada com sucesso!");
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
				}
				System.out.println(matriculaFinal+":"+tamanhoFinal+":"+corFinal);
			}
		});
	}
	
	public void gravar(String texto) throws IOException {
		String usuario = System.getProperty("user.home");
		FileWriter arquivo = new FileWriter(usuario+"\\Desktop\\Questao04.txt", true);
		PrintWriter gravarArquivo = new PrintWriter(arquivo); 

		gravarArquivo.println(texto);
		
		arquivo.close();
		gravarArquivo.close();
	}
}
