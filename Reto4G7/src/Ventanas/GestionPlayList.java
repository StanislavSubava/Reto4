package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;

import java.io.File;

import java.io.FileWriter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class GestionPlayList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPlayList frame = new GestionPlayList();
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
	public GestionPlayList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 32, 691, 587);
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
		btnNewButton.setBounds(10, 11, 90, 47);
		panel.add(btnNewButton);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setIcon(new ImageIcon("usuu.jpg"));
		//btnPerfil.setIcon(new ImageIcon(VentanaMenuUser.class.getResource("/img/usuu.png")));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPerfil obj = new VentanaPerfil();
				obj.setVisible(true);
				dispose();
			}
		});
		btnPerfil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPerfil.setBounds(591, 11, 90, 58);
		panel.add(btnPerfil);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 85, 350, 461);
		panel.add(scrollPane);

		JButton btnCrearLista = new JButton("Crear nueva Lista");
		btnCrearLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPlayList obj = new ListaPlayList();
				obj.setVisible(true);
				dispose();
			}
		});
		btnCrearLista.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCrearLista.setBounds(370, 133, 298, 58);
		panel.add(btnCrearLista);

		JButton btnBorrarLista = new JButton("Borrar");
		btnBorrarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(" ");
			}
		});
		btnBorrarLista.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBorrarLista.setBounds(370, 250, 298, 58);
		panel.add(btnBorrarLista);

		/**
		 * Boton para poder guarda el documento.txt en el archivo
		 */
		JButton btnExportar = new JButton("Exportar");
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String localizacion = "C:\\Users\\in1dm3\\git\\Reto4_Main\\Reto4_Grupo7\\src\\archivosTXT";

				File file = FileUtiles.getMostRecentFile(localizacion, "txt");
				if (Objects.nonNull(file)) {
					String fileContents = FileUtiles.readFile(file);
					if (fileContents != null) {
						FileUtiles.displayFileContents(fileContents, textArea);
					} else {
						System.err.println("Error al buscar el archivo");
					}
				} else {
					System.err.println("No se ha encontrado directorio.");
				}
			}
		});

		// -------------------------------------------------------------------------
		btnExportar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExportar.setBounds(370, 367, 298, 58);
		panel.add(btnExportar);

		/**
		 * Boton para importar el archivo de la carpeta al textArea
		 */
		JButton btnImportar = new JButton("Importar");
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String localizacion = "C:\\Users\\in1dm3\\git\\Reto4_Main\\Reto4_Grupo7\\src\\archivosTXT";

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String tiempo = sdf.format(new Date());
				String nombreArchivo = "MiMusica_" + tiempo + ".txt";
				File file = new File(localizacion, nombreArchivo);

				try (FileWriter lector = new FileWriter(file)) {
					lector.write(textArea.getText());
					JOptionPane.showMessageDialog(null, "Se ha cargado bien el archivo!");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + ex.getMessage());
				}
			}
		});
		btnImportar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnImportar.setBounds(370, 479, 298, 58);
		panel.add(btnImportar);

	}
	/*
	 * //Metodos para exportar protected File getMostRecentFile(String localizacion,
	 * String string) { File directory = new File(localizacion); File[] files =
	 * directory.listFiles(); if (files == null || files.length == 0) { return null;
	 * } File mostRecentFile = files[0]; for (int i = 1; i < files.length; i++) {
	 * File file = files[i]; Date lastModified = new Date(file.lastModified()); if
	 * (lastModified.getTime() > mostRecentFile.lastModified()) { mostRecentFile =
	 * file; } } return mostRecentFile; }
	 * 
	 * protected String readFile(File file) { try (BufferedReader reader = new
	 * BufferedReader(new FileReader(file))) { StringBuilder content = new
	 * StringBuilder(); String line; while ((line = reader.readLine()) != null) {
	 * content.append(line).append("\n"); } return content.toString(); } catch
	 * (IOException e) { System.err.println("Error al ver el archivo: " +
	 * e.getMessage()); return null; } }
	 * 
	 * protected void displayFileContents(String fileContents, JTextArea textArea2)
	 * { textArea.setText(fileContents); }
	 */
//________________________________________________

//Envia el texto al textArea
	public void setTextArea(ArrayList<String> listaCanciones) {
		StringBuilder text = new StringBuilder();
		for (String cancion : listaCanciones) {
			text.append(cancion);
		}
		textArea.setText(text.toString());

	}

}
