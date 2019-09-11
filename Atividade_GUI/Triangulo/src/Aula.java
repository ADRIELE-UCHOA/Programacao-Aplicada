import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aula {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel lblTexto = new JLabel();
	
	private int lado1, lado2, lado3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aula window = new Aula();
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
	public Aula() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 548, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLado = new JLabel("Lado 1:");
		lblLado.setBounds(69, 58, 46, 14);
		frame.getContentPane().add(lblLado);
		
		JLabel lblLado_1 = new JLabel("Lado 2:");
		lblLado_1.setBounds(69, 96, 46, 14);
		frame.getContentPane().add(lblLado_1);
		
		JLabel lblLado_2 = new JLabel("Lado 3:");
		lblLado_2.setBounds(69, 130, 46, 14);
		frame.getContentPane().add(lblLado_2);
		
		textField = new JTextField();
		textField.setBounds(125, 55, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(125, 93, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(125, 127, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblTexto.setBounds(297, 96, 150, 14);
		frame.getContentPane().add(lblTexto);
		
		JButton btnNewButton = new JButton("Verificar Tipo");
		btnNewButton.setBounds(69, 170, 142, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lado1 = Integer.parseInt(textField.getText());
					lado2 = Integer.parseInt(textField_1.getText());
					lado3 = Integer.parseInt(textField_2.getText());
					
					verifica();
					
				}catch(NumberFormatException ex){
					lblTexto.setText("Digite números inteiros!");
					lblTexto.setVisible(true);
				}
			}
		});
	}
	
	public void verifica(){
		if(this.lado1 == this.lado2 && this.lado1 == this.lado3 && this.lado2 == this.lado3 ) {
			this.lblTexto.setText("Triângulo Equilátero");
		}else if (this.lado1 == this.lado2 || this.lado1 == this.lado3|| this.lado2 == this.lado3){
			this.lblTexto.setText("Triângulo Isóceles");
		}else{
			this.lblTexto.setText("Triângulo Escaleno");
		}
		this.lblTexto.setVisible(true);	
	}
}
