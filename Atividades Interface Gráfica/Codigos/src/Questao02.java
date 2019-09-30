import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Questao02 {
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questao02 window = new Questao02();
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
	public Questao02() {
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
		
		JLabel texto_1 = new JLabel("Peso na Terra (kg):");
		texto_1.setBounds(50, 20, 110, 20);
		frame.getContentPane().add(texto_1);
		
		JTextField campo_1 = new JTextField();
		campo_1.setBounds(50, 60, 110, 20);
		frame.getContentPane().add(campo_1);
		
		JLabel texto_2 = new JLabel("Selecione o planeta:");
		texto_2.setBounds(50, 100, 150, 20);
		frame.getContentPane().add(texto_2);
		
		JRadioButton mercurio, marte, saturno, venus, jupiter, urano;
		mercurio = new JRadioButton("Mércurio", false);
		marte = new JRadioButton("Marte", false);
		saturno = new JRadioButton("Saturno", false);
		venus = new JRadioButton("Vênus", false);
		jupiter = new JRadioButton("Júpiter", false);
		urano = new JRadioButton("Urano", false);
		frame.getContentPane().add(mercurio);
		frame.getContentPane().add(marte);
		frame.getContentPane().add(saturno);
		frame.getContentPane().add(venus);
		frame.getContentPane().add(jupiter);
		frame.getContentPane().add(urano);
		mercurio.setBounds(50, 130, 80, 30);
		marte.setBounds(160, 130, 80, 30);
		saturno.setBounds(250, 130, 80, 30);
		venus.setBounds(50, 160, 80, 30);
		jupiter.setBounds(160, 160, 80, 30);
		urano.setBounds(250, 160, 80, 30);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(mercurio); grupo.add(marte); grupo.add(saturno);
		grupo.add(venus); grupo.add(jupiter); grupo.add(urano);
		
		JButton calcula = new JButton("Calcular Peso");
		calcula.setBounds(200, 60, 150, 20);
		frame.getContentPane().add(calcula);
		
		//acao do bota calcular peso
		calcula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent calcular) {
				try {
					double peso = Double.parseDouble(campo_1.getText());
					double pesoPlaneta;
					if(mercurio.isSelected()) {
						pesoPlaneta = peso * 0.37;
						JOptionPane.showMessageDialog(null, "O seu peso em Mércurio é: " + pesoPlaneta + " kg");
					}else if(marte.isSelected()) {
						pesoPlaneta = peso * 0.38;
						JOptionPane.showMessageDialog(null, "O seu peso em Marte é: " + pesoPlaneta + " kg");
					}else if(saturno.isSelected()) {
						pesoPlaneta = peso * 1.15;
						JOptionPane.showMessageDialog(null, "O seu peso em Saturno é: " + pesoPlaneta + " kg");
					}else if(venus.isSelected()) {
						pesoPlaneta = peso * 0.88;
						JOptionPane.showMessageDialog(null, "O seu peso em Vênus é: " + pesoPlaneta + " kg");
					}else if(jupiter.isSelected()) {
						pesoPlaneta = peso * 2.64;
						JOptionPane.showMessageDialog(null, "O seu peso em Júpiter é: " + pesoPlaneta + " kg");
					}else if(urano.isSelected()) {
						pesoPlaneta = peso * 1.17;
						JOptionPane.showMessageDialog(null, "O seu peso em Urano é: " + pesoPlaneta + " kg");
					}else {
						JOptionPane.showMessageDialog(null, "<html><body><p width='120px' align='center'>Escolha um Planeta!</p></body></html>");
					}
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "<html><body><p width='130px' align='center'>Informe um valor válido!</p></body></html>");
				}
			}
		});
	}
}
