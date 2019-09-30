import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Questao03 {
	private JFrame frame;
	private int jogador, computador;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questao03 window = new Questao03();
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
	public Questao03() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JRadioButton pedra, papel, tesoura;
		pedra = new JRadioButton("Pedra", false);
		papel = new JRadioButton("Papel", false);
		tesoura = new JRadioButton("Tesoura", false);
		frame.getContentPane().add(pedra);
		frame.getContentPane().add(papel);
		frame.getContentPane().add(tesoura);
		pedra.setBounds(50, 50, 100, 30);
		papel.setBounds(200, 50, 100, 30);
		tesoura.setBounds(350, 50, 100, 30);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(pedra); grupo.add(papel); grupo.add(tesoura);
		
		JButton jogar = new JButton("JOGAR");
		jogar.setBounds(150, 150, 150, 30);
		frame.getContentPane().add(jogar);
		
		//acao do botao jogar
		jogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent jogar) {
				if(papel.isSelected()) {
					jogador = 1;
					jogo(sorteio());
				}else if(pedra.isSelected()) {
					jogador = 2;
					jogo(sorteio());
				}else if(tesoura.isSelected()) {
					jogador = 3;
					jogo(sorteio());
				}
			}
		});
	}
	

	public int sorteio() {
		double num = Math.random();
		num = (int)(1 + num * (4 - 1));
		int retorno = (int)num;
		
		return retorno;
	}
	
	public void jogo(int num) {		
		if(num == 1) {
			computador = 1;
		}else if(num == 2) {
			computador = 2;
		}else if(num == 3) {
			computador = 3;
		}
		
		if(jogador == 1 && computador == 2) {
			//papel x pedra
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ GANHOU!</p></body></html>");
		}else if(jogador == 2 && computador == 3) {
			//pedra x tesoura
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ GANHOU!</p></body></html>");
		}else if(jogador == 3 && computador == 1) {
			//tesoura x papel
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ GANHOU!</p></body></html>");
		}else if(jogador == 1 && computador == 1) {
			//papel x papel
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>EMPATE!</p></body></html>");
		}else if(jogador == 2 && computador == 2) {
			//pedra x pedra
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>EMPATE!</p></body></html>");
		}else if(jogador == 3 && computador == 3) {
			//tesoura x tesoura
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>EMPATE!</p></body></html>");
		}else if(jogador == 1 && computador == 3) {
			//papel x tesoura
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ PERDEU!</p></body></html>");
		}else if(jogador == 2 && computador == 1) {
			//pedra x papel
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ PERDEU!</p></body></html>");
		}else{
			//tesoura x pedra
			JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>VOCÊ PERDEU!</p></body></html>");
		}
	}
	
}
