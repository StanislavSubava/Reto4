package Clases;

import java.util.ArrayList;

public class canciones {


String IDAudio , IDAlbum , Nombre , Duracion , Tipo;

public canciones(String iDAudio, String iDAlbum, String nombre, String duracion, String tipo) {
	super();
	IDAudio = iDAudio;
	IDAlbum = iDAlbum;
	Nombre = nombre;
	Duracion = duracion;
	Tipo = tipo;
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
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
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
public static canciones get(int i) {
	// TODO Auto-generated method stub
	return null;
}
public void add(ArrayList<canciones> canciones) {
	// TODO Auto-generated method stub
	
}
}