package Ventanas;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import Clases.*;

public class VentanaArtistas extends JFrame {

    private static final long serialVersionUID = 1L;
    Metodos metodo = new Metodos();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaArtistas frame = new VentanaArtistas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
	public VentanaArtistas() {
		initialize();
	}

	private void initialize() {
       
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100,706, 500);

        JPanel contentPane = new JPanel();
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
                VentanaMenuUser obj = new VentanaMenuUser();
                obj.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(0, 0, 90, 47);
        panel.add(btnNewButton);

        JButton btnPerfil = new JButton("Perfil");
        btnPerfil.setIcon(new ImageIcon("usuu.jpg"));
       // btnPerfil.setIcon(new ImageIcon(VentanaMenuUser.class.getResource("/img/usuu.png")));
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
    
        
        // Llamar al método para cargar los datos desde la base de datos
        // Crr botones con los nombres de los artistas
        ArrayList<artistaClase> artistas = metodo.obtenerArtistas();
        int posX = 0; // Posición X inicial para los botones
        int posY = 100; // Posición Y de los botones
        int separacion = 20; // Separación entre botones       
        /**/       
        
        /**/
        for (int i = 0; i < 3; i++) {
            artistaClase artista = artistas.get(i);
            String nombreArtista = artista.getNombre();
            String imgArtista = artista.getImg();
            String IDartista = artista.getIDArtista();
            
            // Eliminamos espacios que sobran en el nombre
            imgArtista = imgArtista.trim();
            
            JButton botonArtista = new JButton(nombreArtista);
            botonArtista.setFont(new Font("Tahoma", Font.PLAIN, 14));
            botonArtista.setBounds(posX,posY,210,200);
            btnPerfil.setIcon(new ImageIcon(imgArtista));
        //    botonArtista.setIcon(new ImageIcon(VentanaArtistas.class.getResource(imgArtista)));
            panel.add(botonArtista);
            
            JLabel etiquetaArtista = new JLabel(nombreArtista);
            etiquetaArtista.setFont(new Font("Tahoma", Font.PLAIN, 12));
            etiquetaArtista.setBounds(posX + 50, 320, 150, 20); // Ajusta la posición según tu diseño
            panel.add(etiquetaArtista);
         
         posX += 220 + separacion;

            botonArtista.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<albums> album = metodo.albumsBD(IDartista);                    
                    ArtistaKC obj = new ArtistaKC(IDartista);
                    obj.mostrarInfm(album,artista);
                    obj.setVisible(true);
                    dispose();
                }
            
            });
        }    
}}