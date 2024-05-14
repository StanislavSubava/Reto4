package Clases;

import java.util.ArrayList;

public class canciones {

	String IDAudio, IDAlbum, NombreA, Duracion, Tipo ,EnlazeAudio ;

	public canciones(String iDAudio, String iDAlbum, String nombreA, String duracion, String tipo ,String EnlazeAudio ) {
		super();
		IDAudio = iDAudio;
		IDAlbum = iDAlbum;
		NombreA = nombreA;
		Duracion = duracion;
		Tipo = tipo;
		this.EnlazeAudio = EnlazeAudio;
	}

	public canciones(String iDAudio, String nombreA, String duracion, String tipo , String EnlazeAudio){
		IDAudio = iDAudio;
		NombreA = nombreA;
		Duracion = duracion;
		Tipo = tipo;
		this.EnlazeAudio = EnlazeAudio;

	}

	public canciones() {
		// TODO Auto-generated constructor stub

	}

	public String getIDAudio() {
		return IDAudio;
	}

	public void setIDAudio(String iDAudio) {
		IDAudio = iDAudio;
	}

	public String getIDAlbum() {
		return IDAlbum;
	}

	public void setIDAlbum(String iDAlbum) {
		IDAlbum = iDAlbum;
	}

	public String getNombreA() {
		return NombreA;
	}

	public void setNombreA(String nombre) {
		NombreA = nombre;
	}

	public String getDuracion() {
		return Duracion;
	}

	public void setDuracion(String duracion) {
		Duracion = duracion;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	
	
	public String getEnlazeAudio() {
		return EnlazeAudio;
	}

	public void setEnlazeAudio(String EnlazeAudio) {
		EnlazeAudio = EnlazeAudio;
	}

	public static canciones get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(canciones pdcast) {
		// TODO Auto-generated method stub

	}
}