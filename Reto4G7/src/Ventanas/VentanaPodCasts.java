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
import javax.swing.border.EmptyBorder;

public class VentanaPodCasts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnJR;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPodCasts frame = new VentanaPodCasts();
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
	public VentanaPodCasts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 690, 587);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				VentanaLogin obj = new VentanaLogin();
				System.out.println(obj);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(0, 0, 90, 47);
		panel.add(btnNewButton);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setIcon(new ImageIcon("usuu.jpg"));
		//btnPerfil.setIcon(new ImageIcon("C:\\Users\\in1dm3\\Desktop\\xxx\\Reto4_Grupo7\\src\\Img\\usuu.png"));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				VentanaPerfil obj = new VentanaPerfil();
				obj.setVisible(true);
				dispose();
			}
		});
 btnPerfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPerfil.setBounds(645, 0, 70, 47);
		panel.add(btnPerfil);
		
		
		
		JLabel lblArtsitas = new JLabel("Artistas");
		lblArtsitas.setBackground(Color.WHITE);
		lblArtsitas.setFont(new Font("Wide Latin", Font.BOLD, 20));
		lblArtsitas.setBounds(263, 11, 161, 95);
		panel.add(lblArtsitas);
		

		
		btnJR = new JButton("The Joe Rogan Experience");
		btnJR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				PodCastJR obj = new PodCastJR();
					  obj.setVisible(true);
					dispose();
			}
		});
		btnJR.setBackground(Color.WHITE);
		btnJR.setBounds(47, 381, 160, 29);
		panel.add(btnJR);
		
		JButton btnWP = new JButton("The Wild Project");
		btnWP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PodCastJR obj = new PodCastJR();
				  obj.setVisible(true);
				dispose();
			}
		});
		btnWP.setBackground(Color.WHITE);
		btnWP.setBounds(263, 381, 150, 29);
		panel.add(btnWP);
		
		JButton btnSM = new JButton("Sin Miedo al Exito");
		btnSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PodCastJR obj = new PodCastJR();
				  obj.setVisible(true);
				dispose();
			}
		});
		btnSM.setBackground(Color.WHITE);
		btnSM.setBounds(483, 381, 150, 29);
		panel.add(btnSM);
		
		JLabel ftPdCstJR = new JLabel("");
		ftPdCstJR.setIcon(new ImageIcon("JoeRogan.jpg"));
		//ftPdCstJR.setIcon(new ImageIcon(VentanaPodCasts.class.getResource("/img/The_Joe_Rogan_Experience_logo.jpg")));
		ftPdCstJR.setBounds(26, 147, 191, 223);
		panel.add(ftPdCstJR);
		
		JLabel ftPdCstSM = new JLabel("New label");
		ftPdCstSM.setIcon(new ImageIcon("jimmi.jpg"));
		//ftPdCstSM.setIcon(new ImageIcon(VentanaArtistas.class.getResource("/img/jimi (3).jpg")));
		ftPdCstSM.setBounds(457, 147, 191, 223);
		panel.add(ftPdCstSM);
		
		JLabel lblfondo = new JLabel("");
		lblfondo.setIcon(new ImageIcon("fondolog.jpg"));
		//lblfondo.setIcon(new ImageIcon(VentanaArtistas.class.getResource("/img/fondo.jpg")));
		lblfondo.setBounds(0, 0, 691, 587);
		panel.add(lblfondo);
		
		JLabel ftPdCstWP = new JLabel("New label");
		ftPdCstWP.setIcon(new ImageIcon("fondolog.jpg"));
		//ftPdCstWP.setIcon(new ImageIcon(VentanaPodCasts.class.getResource("/img/channels4_profile (1).jpg")));
		ftPdCstWP.setBounds(243, 147, 191, 223);
		panel.add(ftPdCstWP);
		
	}
}
