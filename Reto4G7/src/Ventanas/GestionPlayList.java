package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ModeloMysql.conexionMYSQL;
import TodoMenuAdmin.Cancion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

public class GestionPlayList extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String ModeloMysql = null;
	private JPanel contentPane;
	private JTextArea textArea;
	protected String localizacion;

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
		// btnPerfil.setIcon(new
		// ImageIcon(VentanaMenuUser.class.getResource("/img/usuu.png")));
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
				
				String sql = "SELECT NombreA FROM audios;";

				try (Connection conn = conexionMYSQL.metodoConexion()) {
					PreparedStatement st = conn.prepareStatement(sql);
					ResultSet rs = st.executeQuery();

					List<Cancion> canciones = crearListaCanciones(rs);

					listPlayList obj = new listPlayList();
					obj.valoresTablaCancion(canciones);
					obj.setVisible(true);
					dispose();

					rs.close();
					st.close();

				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + ex.getMessage());
					ex.printStackTrace();

				}
			}

			private List<Cancion> crearListaCanciones(ResultSet rs) {
				List<Cancion> canciones = new ArrayList<>();

				try {
					while (rs.next()) {
						Cancion Cancion = new Cancion();
						Cancion.setNombre(rs.getString("nombreA"));					

						canciones.add(Cancion);
					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}
				return canciones;

			
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
			public void actionPerformed(ActionEvent event) {
				File directorio = new File(directorioExportar());
				File[] File = directorio.listFiles();
				File ultimoSubido = null;
				long ultimoModificado = 0;

				if (File != null) {
					for (File file : File) {
						if (file.isFile() && file.lastModified() > ultimoModificado) {
							ultimoSubido = file;
							ultimoModificado = file.lastModified();
						}
					}
				}

				if (ultimoSubido != null) {
					try {
						File file = new File(ultimoSubido.getAbsolutePath());
						FileReader lectorFile = new FileReader(file);
						BufferedReader bufferRead = new BufferedReader(lectorFile);
						StringBuilder stringBuilder = new StringBuilder();
						String line;

						while ((line = bufferRead.readLine()) != null) {
							stringBuilder.append(line).append("\n");
						}

						textArea.setText(stringBuilder.toString());
						bufferRead.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("No files found in the directory");
				}
			}

			private String directorioExportar() {
				Path localizacion = Paths.get("C:", "Users", "in1dm3", "Desktop", "carpeta", "RETO4GP7.zip_expanded",
						"Reto4G7", "txt", "archivosTXT");

				return localizacion.getParent().toString();
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

				String localizacion = directorio();

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

			private String directorio() {
				Path localizacion = Paths.get("C:", "Users", "in1dm3", "Desktop", "carpeta", "RETO4GP7.zip_expanded",
						"Reto4G7", "txt", "archivosTXT");

				return localizacion.getParent().toString();
			}

		});
		btnImportar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnImportar.setBounds(370, 479, 298, 58);
		panel.add(btnImportar);

	}
//________________________________________________

//Envia el texto al textArea
	public void setTextArea(String textCopiado) {
		textArea.setText(textCopiado);
		
	}

}
