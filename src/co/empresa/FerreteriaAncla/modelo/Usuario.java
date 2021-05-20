package co.empresa.FerreteriaAncla.modelo;

import java.io.Serializable;

import lombok.Data;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
	
	private Integer id;
	private String nombre;
	private String email;
	private String pais;
	public Usuario() {
		
	}
	public Usuario(Integer id, String nombre, String email, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
	}
	
	public Usuario(String nombre2, String email2, String pais2) {
		
		this.nombre = nombre2;
		this.email = email2;
		this.pais= pais2;
	}
public Usuario(String nombre2,  String pais2) {
		
		this.nombre = nombre2;
		
		this.pais= pais2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	

}
