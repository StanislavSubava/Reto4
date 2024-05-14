package Ventanas;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Clases.albums;
import Clases.artistaClase;
import Clases.artistas;
import Clases.canciones;
import ModeloMysql.conexionMYSQL;

public class Metodos {

    public  ArrayList<artistaClase> obtenerArtistas() {
        ArrayList<artistaClase> artistas = new ArrayList<artistaClase>();
        try (Connection conn = conexionMYSQL.metodoConexion()) {
            String sql = "SELECT * FROM musicos";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                
            	artistaClase artista = new artistaClase();
               
            	String descripcion = rs.getString("DescripcionMusico");
                String caracteristica = rs.getString("Caracteristica");
                String idmusico = rs.getString("IDMusico");
                String nombre = rs.getString("NombreArtistico");
                String img =rs.getString("Imagen");
               
                artista.setNombre(nombre);
                artista.setCaracteristicas(caracteristica);
                artista.setDescripcion(descripcion);
                artista.setImg(img);
                artista.setIDArtista(idmusico);
                artistas.add(artista);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
        }
        return artistas;
    }

    public ArrayList<albums> albumsBD(String IDArtista) {
        ArrayList<albums> albums = new ArrayList<albums>();
        String sql = "SELECT a.IDAlbum, a.IDMusico , a.Imagen, a.Titulo, a.Año, a.Genero FROM album a JOIN musicos m ON a.IDMusico = m.IDMusico WHERE m.IDMusico = '"+ IDArtista+"' ";
        try (Connection conn = conexionMYSQL.metodoConexion()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                albums album = new albums();
                String idAlbum = rs.getString("IDAlbum");
                String idmusico = rs.getString("IDMusico");
                String imgAlbm = rs.getString("Imagen");
                String nmbrAlbm = rs.getString("Titulo");
                String lanzamiento = rs.getString("Año");
                String genero = rs.getString("Genero");
                album.setImagen(imgAlbm);
                album.setTitulo(nmbrAlbm);
                album.setGenero(genero);
                album.setAño(lanzamiento);
                album.setIDAlbum(idAlbum);
                album.setIDMusico(idmusico);
                albums.add(album);
               
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
        }
        return albums;
    }
    
    

	public ArrayList<canciones> obtenerCanciones(String idAlbum) {
		// TODO Auto-generated method stub
	    ArrayList<canciones> canciones = new ArrayList<canciones>();
	    String sql = "SELECT A.Nombre AS NombreCancion, A.Duracion, C.IDAlbum, A.Tipo FROM audios A INNER JOIN canciones C ON A.IDAudio = C.IDAudio WHERE A.Tipo = 'Cancion' AND C.IDAlbum = '"+ idAlbum+"' ";
        try (Connection conn = conexionMYSQL.metodoConexion()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
            	canciones cancion = new canciones();
            	String nmbrcncn = rs.getString("NombreCancion");
            	String drcn = rs.getString("Duracion");
            	String idAlbum1 = rs.getString("IDAlbum");
            	String tipo = rs.getString("Tipo");
            	cancion.setNombre(nmbrcncn);
            	cancion.setDuracion(drcn);
            	cancion.setIDAlbum(idAlbum1);
            	cancion.setTipo(tipo);
                canciones.add(cancion);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta SQL: " + ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage());
        }
		
		return canciones;
	}

    }
    
 
   
    

	
	
