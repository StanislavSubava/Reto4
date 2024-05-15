package TodoMenuAdmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ModeloMysql.conexionMYSQL;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class gestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JButton añadir;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gestion frame = new gestion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * En esta ventana se podra gestionar la tabla metida en el textArea, podiendo
	 * modificar el nombre, eliminar la fila o crear una nueva
	 */
	public gestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Ventana de Gestion");

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 670, 565);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMenuAdmin obj = new VentanaMenuAdmin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 10, 138, 47);
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 464, 488);
		panel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Duracion", "Tipo" }));
		scrollPane.setViewportView(table);
		/*
		 * Se genera las tablas con los valores en la tabla que esta encima
		 */
		valoresTabla(getDummyCanciones());

		/*
		 * Boton de Crear una fila para poder escribir los valores de la nueva cancion,
		 * Se aparece un boton que permite la consulta de añadir la cancion a la base de
		 * datos
		 */
		JButton crear = new JButton("Crear");
		crear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] row = { "", "", "" };
				model.addRow(row);
				añadir.setVisible(true);
				table.editCellAt(model.getRowCount() - 1, 0);
			}
		});
		crear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		crear.setBounds(484, 136, 176, 39);
		panel.add(crear);
		/*
		 * Boton de eliminar la cancion de la base de datos
		 */
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();

		        if (selectedRow >= 0) {
		            int confirm = JOptionPane.showConfirmDialog(null,
		                    "¿Estás seguro de que quieres eliminar esta canción?", "Confirmar eliminación",
		                    JOptionPane.YES_NO_OPTION);

		            if (confirm == JOptionPane.YES_OPTION) {
		       
		                String sqlCanciones = "DELETE FROM canciones WHERE IDAudio = ?";

		                try (Connection conn = conexionMYSQL.metodoConexion();
		                     PreparedStatement stCanciones = conn.prepareStatement(sqlCanciones)) {
		                	
		                	stCanciones.setString(1, sqlCanciones);
		                    stCanciones.executeUpdate(sqlCanciones);

		                    // Now delete the audio file
		                    String sqlAudios = "DELETE FROM audios WHERE IDAudio = ?";

		                    try (PreparedStatement stAudios = conn.prepareStatement(sqlAudios)) {

		                    	stAudios.setString(1, sqlAudios);
		                        stAudios.executeUpdate(sqlAudios);

		                        JOptionPane.showMessageDialog(null, "Canción eliminada correctamente.");

		                        // Recarga los datos de la tabla
		                        cargarDatos();

		                    } catch (SQLException ex) {
		                        JOptionPane.showMessageDialog(null, "Error al eliminar la canción: " + ex.getMessage());
		                        ex.printStackTrace();
		                    }

		                } catch (SQLException ex) {
		                    JOptionPane.showMessageDialog(null, "Error al eliminar la canción: " + ex.getMessage());
		                    ex.printStackTrace();
		                }
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna canción.");
		        }
		    }
		});
		eliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eliminar.setBounds(484, 218, 176, 39);
		panel.add(eliminar);
		/*
		 * Boton de Modificar datos de la tabla y de la base de datos
		 * 
		 * funciona, Pero ERROR, cambia todo el sistema de la duracion
		 */
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

				if (selectedRow >= 0) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					String idAudio = (String) model.getValueAt(selectedRow, 0);
					
					String nuevoNombre = (String) JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre:",
							"Modificar audio", JOptionPane.PLAIN_MESSAGE, null, null,
							(String) model.getValueAt(selectedRow, 0));
					
					Time nuevaDuracion = new Time(Integer.parseInt((String) model.getValueAt(selectedRow, 2)) * 1000);

					if (nuevoNombre != null) {
						String sql = "UPDATE audios SET Nombre = ?, Duracion = ? WHERE IDAudio = ?";

						try (Connection conn = conexionMYSQL.metodoConexion();
								PreparedStatement st = conn.prepareStatement(sql)) {

							st.setString(1, nuevoNombre);
							st.setTime(2, nuevaDuracion);

							int rowsAffected = st.executeUpdate();

							if (rowsAffected > 0) {
								JOptionPane.showMessageDialog(null, "El audio ha sido modificado exitosamente.");
								cargarDatos();
							} else {
								JOptionPane.showMessageDialog(null, "No se pudo modificar el audio.");
							}

						} catch (SQLException ex) {
							JOptionPane.showMessageDialog(null, "Error al modificar el audio: " + ex.getMessage());
							ex.printStackTrace();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar.");
				}
			}
		});
		modificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modificar.setBounds(484, 304, 176, 39);
		panel.add(modificar);

		JLabel lblNewLabel = new JLabel("Gestion");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(158, 10, 318, 47);
		panel.add(lblNewLabel);
		/*
		 * Boton añadir, coge los valores de las celdas, y los mete en la tabla audios,
		 * como nuevas canciones
		 * 
		 * No funciona del todo Bien, Hay un problema, que se genera otra vez la tabla
		 * completa y no solo la fila
		 */
		añadir = new JButton("Añadir");
		añadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lineaCount = table.getRowCount();
				if (lineaCount > 0) {

					List<Cancion> canciones = new ArrayList<>();
					for (int i = 0; i < lineaCount; i++) {

						String nombre = (String) table.getValueAt(i, 0);
						String duracion = (String) table.getValueAt(i, 1);
						String Tipo = (String) table.getValueAt(i, 2);

						if (!nombre.isEmpty() && duracion != null && !duracion.isEmpty()) {
							Cancion cancion = new Cancion();
							cancion.setNombre(nombre);
							cancion.setDuracion(duracion);
							cancion.setTipo(Tipo);

							canciones.add(cancion);
						}
					}
					if (!canciones.isEmpty()) {
						String sql = "INSERT INTO audios (NombreA, Duracion, Tipo) VALUES (?, ?, ?)";
						try (Connection conn = conexionMYSQL.metodoConexion()) {
							PreparedStatement st = conn.prepareStatement(sql);
							for (Cancion cancion : canciones) {
								st.setString(1, cancion.getNombre());
								st.setString(2, cancion.getDuracion());
								st.setString(3, cancion.getTipo());
								st.addBatch();
							}
							st.executeBatch();
						} catch (SQLException ex) {
							JOptionPane.showMessageDialog(null, "Error al insertar las canciones: " + ex.getMessage());
							ex.printStackTrace();
						}
					}

				}

			}
		});
		/**
		 * JOptionPane.showMessageDialog(null, "Error al insertar las canciones: " +
		 * ex.getMessage()); ex.printStackTrace();
		 */

		añadir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		añadir.setBounds(484, 86, 176, 39);
		añadir.setVisible(false);
		panel.add(añadir);

	}

	/*
	 * Recarga los datos de la tabla con todos los datos nuevos y solo modificando
	 * los que se cambian
	 */
	private void cargarDatos() {
		String sql = "SELECT NombreA, Duracion, Tipo FROM audios WHERE Tipo='Podcast'";

		try (Connection conn = conexionMYSQL.metodoConexion();
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery()) {

			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);

			while (rs.next()) {
				Object[] row = new Object[2];
				row[0] = rs.getString("Nombre");
				row[1] = rs.getString("Duracion");
				row[2] = rs.getString("Tipo");

				model.addRow(row);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al cargar las canciones: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	/*
	 * Genera la tabla con sus columnas
	 */
	void valoresTabla(List<Cancion> canciones) {
		model = new DefaultTableModel(new String[] { "Nombre", "Duracion", "Tipo" }, 0);
		table.setModel(model);

		for (Cancion cancion : canciones) {
			Object[] row = { cancion.getNombre(), cancion.getDuracion(), cancion.getTipo() };
			model.addRow(row);
		}
	}

	/*
	 * Clase para poder coger las canciones desde una clase
	 */
	private List<Cancion> getDummyCanciones() {
		List<Cancion> canciones = new ArrayList<>();
		return canciones;
	}
}
