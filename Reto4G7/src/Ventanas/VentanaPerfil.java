package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModeloMysql.conexionMYSQL;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VentanaPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPerfil frame = new VentanaPerfil();
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
	public VentanaPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 670, 565);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaMenuUser obj = new VentanaMenuUser();
				obj.setVisible(true);

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 62, 138, 47);
		panel.add(btnNewButton);
		
		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPerfil.setBounds(158, 62, 354, 47);
		panel.add(lblPerfil);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 176, 532, 327);
		panel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String sentencia = "";

				String textBien = "No hay errores a la hora de meter los datos en la base de datos";
				String textMal = "Hay errores a la hora de meter los datos en la base de datos";

				try {
					Connection connection = conexionMYSQL.metodoConexion();

					PreparedStatement st = connection.prepareStatement(sentencia);

		

					int rowsAffected = st.executeUpdate();

					if (rowsAffected > 0) {
						JOptionPane.showMessageDialog(null, textBien);


					} else {
						JOptionPane.showMessageDialog(null, textMal);
					}

				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
			}
			
			
		});
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMostrar.setBounds(250, 120, 138, 47);
		panel.add(btnMostrar);
	}
}
