package logic;

import java.util.ArrayList;
import java.util.LinkedList;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	
	public Login() {
		dp=new DataPersona();
		dr=new DataRol();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}

	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
	}
	
	public ArrayList<Persona> getByApellido(Persona per) {
		return dp.getByApellido(per);
	}
	
	public LinkedList<Rol> getAllRoles(){
		return dr.getAll();
	}
	
	public Persona addPersona(Persona per) {
		return dp.add(per);
	}
	
	public Persona edit(Persona per) {
		return dp.edit(per);
	}
	
//	public Rol getRolById(Rol rol) {
//		return dr.getById(rol);
//	}
	
	public Persona delete(Persona per) {
		return dp.delete(per);
	}
	
}
