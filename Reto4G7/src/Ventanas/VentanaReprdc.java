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
import javax.print.attribute.standard.Media;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class VentanaReprdc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAnterior;
	private JTextArea textAreaInfm;


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
	 * @param cancionSeleccionada 
	 */
	public VentanaReprdc(canciones cancionSeleccionada) {
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
		
		
		JLabel lblfotAlbm = new JLabel("New label");
		lblfotAlbm.setBounds(119, 43, 420, 232);
		panel.add(lblfotAlbm);
		
		String audEleg = cancionSeleccionada.getEnlazeAudio();
		
		JButton btnReprPausa = new JButton("[]|>");
		btnReprPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
		           /**if (paused) {
	                    paused = false;
	                    play(cancionSeleccionada.getEnlazeAudio());
	                } else {
	                    paused = true;
	                    paused();
	                }
	             */
			} });
		btnReprPausa.setBounds(293, 301, 65, 40);
		panel.add(btnReprPausa);
		
		btnAnterior = new JButton("<");
		btnAnterior.setBounds(200, 301, 65, 40);
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.setBounds(379, 301, 65, 40);
		panel.add(btnSiguiente);
		
		JButton btnmeGusta = new JButton("♥");
		btnmeGusta.setBounds(474, 301, 65, 40);
		panel.add(btnmeGusta);
		
		JButton btnMenu = new JButton("=");
		btnMenu.setBounds(119, 301, 65, 40);
		panel.add(btnMenu);
		
		textAreaInfm = new JTextArea();
		textAreaInfm.setLineWrap(true);
		textAreaInfm.setBounds(119, 366, 420, 95);
		panel.add(textAreaInfm);

		
	}
	
	/**
	 * Mostrar información de CANCIONES
	 * @param albumActual
	 * @param cancionSeleccionada
	 */
	public void mostrarInformacion(albums albumActual, canciones cancionSeleccionada) {
		// TODO Auto-generated method stub
		System.out.println(cancionSeleccionada);
		String formato = "";
		String audEleg = cancionSeleccionada.getEnlazeAudio();
		String nmbrAud = cancionSeleccionada.getNombreA();
		String nmbrAlbm = albumActual.getTitulo();
		String drcnAud = cancionSeleccionada.getDuracion();
		String imgAlbm = albumActual.getImagen();
		
		 formato += "Nombre de la canción: " + nmbrAud + "\n" +
                "Nombre del álbum: " + nmbrAlbm + "\n" +
                "Duración del audio: " + drcnAud;

		
		 textAreaInfm.setText(formato);
		
	}

	
	public VentanaReprdc() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Mostrar información de PODCAST
	 * @param podcast
	 * @param podcasts
	 */
	public void mostrarInformacionPd(canciones podcast, ArrayList<canciones> podcasts) {
		// TODO Auto-generated method stub
		System.out.println(podcast);
		String formato1 = "";
		String nmbrPd = podcast.getNombreA();
		String drcnPd = podcast.getDuracion();		
		
		formato1 = "Nombre del Podcast: " + nmbrPd + "\n" +  "Duración del PodCast: " + drcnPd;
		textAreaInfm.setText(formato1);
		
		
	}

}
