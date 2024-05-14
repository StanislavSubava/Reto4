 package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.albums;
import Clases.artistas;
import Clases.canciones;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class VentanaReprdc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReprdc frame = new VentanaReprdc();
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
	public VentanaReprdc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 690, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VentanaLogin obj = new VentanaLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 0, 90, 47);
		panel.add(btnNewButton);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setIcon(new ImageIcon("usuu.jpg"));
		//btnPerfil.setIcon(new ImageIcon(VentanaMenuUser.class.getResource("usuu.png")));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				VentanaPerfil obj = new VentanaPerfil();
				obj.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPerfil.setBounds(618, 0, 90, 58);
		panel.add(btnPerfil);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(119, 43, 420, 232);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("[]|>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(293, 301, 65, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.setBounds(200, 301, 65, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton(">");
		btnNewButton_1_2.setBounds(379, 301, 65, 40);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_2 = new JButton("♥");
		btnNewButton_2.setBounds(474, 301, 65, 40);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("=");
		btnNewButton_2_1.setBounds(119, 301, 65, 40);
		panel.add(btnNewButton_2_1);
		
		textField = new JTextField();
		textField.setBounds(119, 364, 420, 97);
		panel.add(textField);
		textField.setColumns(10);
	}


	public void mostrarInformacion(albums albumActual, ArrayList<canciones> canciones) {
		// TODO Auto-generated method stub
		
		
	}
}
