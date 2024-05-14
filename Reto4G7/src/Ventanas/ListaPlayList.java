package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class ListaPlayList extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String String = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaPlayList frame = new ListaPlayList();
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
	public ListaPlayList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 691, 587);
		contentPane.add(panel);

		JButton btnNewButton = new JButton("Atras");
		btnNewButton.setBounds(10, 11, 90, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				GestionPlayList obj = new GestionPlayList();
				obj.setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnNewButton);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(591, 11, 90, 58);
		btnPerfil.setIcon(new ImageIcon("fondolog.jpg"));
		//btnPerfil.setIcon(new ImageIcon(VentanaMenuUser.class.getResource("/img/usuu.png")));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPerfil obj = new VentanaPerfil();
				obj.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnPerfil);
		// Scroll Panel

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 660, 461);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);

//HACER ESTO CON BASES DE DATOS		
		// Agregar 24 canciones y podcasts
		String[] Nombrecanciones = { "Smells Like Teen Spirit", "Lithium", "Come As You Are", "Blew - 00:02:56",
				"About A Girl", "Love Buzz", "Bohemian Rhapsody", "The Show Must Go On", "I Want It All",
				"Made In Heaven", "I Was Born To Love You", "Heaven For Everyone", "Purple Haze",
				"Voodoo Child (Slight Return)", "All Along the Watchtower", "Spanish Castle Magic", "Little Wing",
				"If 6 was 9", "Joe", "Joe2", "Tartatia", "Tartaria2", "Wild", "Wild2" };

		panel_1.setLayout(new GridLayout(0, 2, 10, 10));

		JTextArea prueba = new JTextArea();
		prueba.setBounds(124, 11, 205, 47);
		panel.add(prueba);

		for (String canciones : Nombrecanciones) {
			String[] num = canciones.split("-");
			String nombre = num[0];

			JLabel lblcancion = new JLabel(nombre);
			lblcancion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblcancion.setHorizontalAlignment(SwingConstants.CENTER);
			panel_1.add(lblcancion);

//Boton no funcino no envia los nombres al textArea del Panel GetionPlayList
			ArrayList<String> listaCanciones = new ArrayList<>();

			JButton btnAñadirCancion = new JButton("+");
			btnAñadirCancion.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnAñadirCancion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String nombreCanciones = lblcancion.getText();
					listaCanciones.add(nombreCanciones+"\n");

					prueba(listaCanciones);

					prueba.setText(listaCanciones.toString());

				}

				private void prueba(ArrayList<java.lang.String> listaCanciones) {
					StringBuilder sb = new StringBuilder();
					for (String cancion : listaCanciones) {
						sb.append(cancion);
						sb.append(", \n");
					}
					prueba.setText(sb.substring(0, sb.length() - 2));

				}

			});

			JButton btnAñadir = new JButton("Añadir");
			btnAñadir.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					GestionPlayList obj = new GestionPlayList();
					obj.setVisible(true);
					obj.setTextArea(listaCanciones);
					dispose();
				}
			});
			btnAñadir.setBounds(491, 11, 90, 47);
			panel.add(btnAñadir);

			panel_1.add(btnAñadirCancion);
		}

	}
}
