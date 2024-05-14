package Ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class PodCastJR extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PodCastJR frame = new PodCastJR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PodCastJR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuUser obj = new VentanaMenuUser();
				  obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 9, 84, 26);
		panel.add(btnNewButton);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setIcon(new ImageIcon("usuu.png"));
		//btnPerfil.setIcon(new ImageIcon("C:\\Users\\in1dm3\\Desktop\\xxx\\Reto4_Grupo7\\src\\Img\\usuu.png"));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaPerfil obj = new VentanaPerfil();
				obj.setVisible(true);
			}
		});
		btnPerfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPerfil.setBounds(379, 0, 70, 47);
		panel.add(btnPerfil);
		
		
		JLabel lblArtsitas = new JLabel("The Joe Rogan Experience");
		lblArtsitas.setBackground(Color.WHITE);
		lblArtsitas.setFont(new Font("Wide Latin", Font.BOLD, 20));
		lblArtsitas.setBounds(84, 11, 309, 26);
		panel.add(lblArtsitas);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.setBounds(10, 11, 64, 27);
		panel.add(btnNewButton_1);
		
		JTextArea txtArDisc = new JTextArea();
		txtArDisc.setBounds(27, 48, 164, 81);
		panel.add(txtArDisc);
		
		JTextArea txtrDfdfd = new JTextArea();
		txtrDfdfd.setBounds(212, 48, 212, 81);
		panel.add(txtrDfdfd);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(222, 138, 202, 112);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(27, 138, 164, 112);
		panel.add(lblNewLabel_1);
		
	}

}
