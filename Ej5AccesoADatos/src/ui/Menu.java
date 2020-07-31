package ui;


import java.util.ArrayList;
import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "search":
			for(Persona p:search()) {
				System.out.println(p);
			}
			break;
		case "new":
			System.out.println("Persona agregada " + newPersona());
			break;
		case "edit":
			System.out.println("Persona modificada " + edit());
			break;
		case "delete":
			System.out.println("Persona eliminada " + delete());
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando segÃºn la opciÃ³n que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	
	private ArrayList<Persona> search() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Apellido:");
		p.setApellido(s.nextLine());
		
		return ctrlLogin.getByApellido(p);
	}
	
	private Persona newPersona() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.println("Ingrese los datos de la persona a agregar");
		
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		System.out.print("Nombre: ");
		p.setNombre(s.nextLine());
		
		System.out.print("Apellido: ");
		p.setApellido(s.nextLine());
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("Telefono: ");
		p.setTel(s.nextLine());
		
		System.out.print("Contraseña: ");
		p.setPassword(s.nextLine());
		
		System.out.println("Presione (1) si esta habilitado o (0) si no esta habilitado");
		String hab = s.nextLine();
		if(Integer.parseInt(hab) == 1) {
			p.setHabilitado(true);
		} else if(Integer.parseInt(hab) == 0) {
			p.setHabilitado(false);
		} else p.setHabilitado(false);
		
		//		System.out.println("Roles:");
		//		for (Rol rol:ctrlLogin.getAllRoles()) {
		//			System.out.println(rol.getId() + ": " + rol.getDescripcion());
		//		};
		//		System.out.print("Elija el rol para este usuario: ");
		//		Rol rol = new Rol();
		//		rol.setId(s.nextInt());
		//		rol = ctrlLogin.getRolById(rol);
		//		p.addRol(rol);
		
		return ctrlLogin.addPersona(p);
	}
	
	private Persona edit() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		p = ctrlLogin.getByDocumento(p);
		
		System.out.println("Ingrese los datos a modificar");
		
		System.out.print("Nombre: ");
		p.setNombre(s.nextLine());
		
		System.out.print("Apellido: ");
		p.setApellido(s.nextLine());
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("Telefono: ");
		p.setTel(s.nextLine());
		
		System.out.print("Contraseña: ");
		p.setPassword(s.nextLine());
		
		System.out.println("Presione (1) si esta habilitado o (0) si no esta habilitado");
		String hab = s.nextLine();
		if(Integer.parseInt(hab) == 1) {
			p.setHabilitado(true);
		} else if(Integer.parseInt(hab) == 0) {
			p.setHabilitado(false);
		} else p.setHabilitado(false);
		
		return ctrlLogin.edit(p);
		
	}
	
	private Persona delete() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		p = ctrlLogin.getByDocumento(p);
		
		return ctrlLogin.delete(p);
	}

}
