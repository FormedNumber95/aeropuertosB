package model;



import java.util.Objects;

public class Persona {

	private String nombre;
	private String apellidos;
	private int edad;
	
	public Persona(String nombre,String apellidos,int edad){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, edad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && edad 
				== other.edad && Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getEdad() {
		return edad;
	}
	
	
	
}
