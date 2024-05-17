package Ventanas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.albums;

import Clases.canciones;

import javax.swing.JLabel;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class VentanaReprdc extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnAnterior;
	private JTextArea textAreaInfm;
	private Clip clip;
	private boolean paused = false;
	private JButton btnSiguiente;
	private JButton btnReprPausa;

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
	 * 
	 * @param cancionSeleccionada
	 */
	public VentanaReprdc(canciones cancionSeleccionada, int pscionCancionSelec, ArrayList<canciones> listaCanciones) {
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
		// btnPerfil.setIcon(new
		// ImageIcon(VentanaMenuUser.class.getResource("usuu.png")));
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

		File audEleg = new File(cancionSeleccionada.getEnlazeAudio());
		String audioFilePath = audEleg.getAbsolutePath().replace(File.separator, "/");
		System.out.println(audioFilePath);
		String audio = audEleg.getAbsolutePath();

		btnReprPausa = new JButton("[]|>");
		btnReprPausa.addActionListener(e -> {
		    if (clip == null) {
		        try {
		            playAudio(audio);
		        } catch (LineUnavailableException e1) {
		            btnReprPausa.setText("▌>");
		            e1.printStackTrace();
		        }
		    } else {
		        if (clip.isRunning()) {
		            clip.stop();
		            btnReprPausa.setText("[]|>");
		        } else {
		            clip.start();
		            btnReprPausa.setText("▌>");
		        }
		    }
		});

		/*
		 * btnReprPausa.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { if (clip != null) { if (paused) {
		 * clip.start(); paused = false; btnReprPausa.setText("▌▌"); } else {
		 * clip.stop(); paused = true; btnReprPausa.setText("▌>"); } } } });
		 * 
		 */

		btnReprPausa.setBounds(293, 301, 65, 40);
		panel.add(btnReprPausa);

		btnAnterior = new JButton("<");
		btnAnterior.setBounds(200, 301, 65, 40);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cancionAnterior = pscionCancionSelec;
				if (pscionCancionSelec > 0) {
					cancionAnterior--;
					reproducirCancion(listaCanciones.get(cancionAnterior));
				}
			}

			private void reproducirCancion(canciones cancionSeleccionada) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(btnAnterior);

		btnSiguiente = new JButton(">");
		btnSiguiente.setBounds(379, 301, 65, 40);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cancionSiguiente = pscionCancionSelec;
				if (pscionCancionSelec > 0) {
					cancionSiguiente--;
					reproducirCancion(listaCanciones.get(cancionSiguiente));
				}
			}

			private void reproducirCancion(canciones canciones) {

			}

			// "▌▌"

		});

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

	private void playAudio(String audio) throws LineUnavailableException {
		try {
			File audioFile = new File(audio);
			AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);

			System.out.println(audioFile);

			// Create a Clip to play the audio
			Clip clip = AudioSystem.getClip();
			clip.open(ais);

			// Start playing the audio
			clip.start();
		} catch (IOException | UnsupportedAudioFileException e) {
			System.err.println("Error playing audio: " + e.getMessage());
		}

	}

	public VentanaReprdc(canciones podcast, ArrayList<canciones> podcasts) {
		// TODO Auto-generated constructor stub
	}

	public VentanaReprdc() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Mostrar información de CANCIONES
	 * 
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

		formato += "Nombre de la canción: " + nmbrAud + "\n" + "Nombre del álbum: " + nmbrAlbm + "\n"
				+ "Duración del audio: " + drcnAud;

		textAreaInfm.setText(formato);

	}

	/**
	 * Mostrar información de PODCAST
	 * 
	 * @param podcast
	 * @param podcasts
	 */
	public void mostrarInformacionPd(canciones podcast, ArrayList<canciones> podcasts) {
		// TODO Auto-generated method stub
		System.out.println(podcast);
		String formato1 = "";
		String nmbrPd = podcast.getNombreA();
		String drcnPd = podcast.getDuracion();

		formato1 = "Nombre del Podcast: " + nmbrPd + "\n" + "Duración del PodCast: " + drcnPd;
		textAreaInfm.setText(formato1);

	}

}
