package factura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class archFactura {
	static Scanner lee = new Scanner(System.in);
	private String nomArch; // npombre original .dat   que proviene del main// factura2.dat
	private Factura fact;
	
	public archFactura(String nom){
		this.nomArch = nom; 
	}
	
	// crear , adicionar , listar
	// 1. Crear
	public void crear() throws ClassNotFoundException, IOException{
		ObjectOutputStream archF = new ObjectOutputStream(new FileOutputStream(nomArch)); //crear el archivo
		archF.close(); // cerrar
	}
	
	// 2 adicionar
	public void Adicionar() throws ClassNotFoundException, IOException{
		String op; // (variable)opcion que va a leer de afuera
		ObjectOutputStream archF = null; // nombre del Archivo
		try { // funcionar si todo sale bien  s/n
			if(new File(nomArch).exists()){  // archivo existe
				archF = new AddObjectOutputStream(new FileOutputStream(nomArch,true));
			}else{					
				archF = new ObjectOutputStream(new FileOutputStream(nomArch,true));
			}
			do{
				fact = new Factura(); // nuestro Objeto
				fact.leer(); 
				archF.writeObject(fact); // nombArchivo , factu
				System.out.println("Desea seguir añadiendo? s/n");
				op = lee.next();
			}while(op.equals("s"));
			
		} catch (Exception e) { // cuando ocurra cualquier error
			// TODO: handle exception
			System.out.println("Fin adicion, excepcion");
		}finally{ // cuando finaliza su proceso
			archF.close();  // cerrar el archivo
		}
	}
	
	//3 listar
	public void Listar()throws ClassNotFoundException, IOException{
		ObjectInputStream archF = null; // nuevo archivo
		try {
			archF = new ObjectInputStream(new FileInputStream(nomArch));// asignamos
			while(true){
				fact = new Factura();
				fact = (Factura)archF.readObject(); // saca e;l objeto y lo asigna a fact
				fact.mostrar();
			}
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			System.out.println("Fin listado!!!!");
		}finally{
			archF.close();
		}
	}
	
	//b determinar el monto total que realizo en compras el cliente de nombre x
	//3 listar
	public int montoTotal( String nomCliente)throws ClassNotFoundException, IOException{
		ObjectInputStream archF = null; 
		int mTotal = 0;
		try {
			archF = new ObjectInputStream(new FileInputStream(nomArch));// asignamos
			while(true){
				fact = new Factura();
				fact = (Factura)archF.readObject(); // saca e;l objeto y lo asigna a fact
				if (fact.getCliente().equals(nomCliente)) {
					for (int i = 0; i < fact.getNp(); i++) {
						mTotal = mTotal + (Integer.parseInt(fact.getP()[1][i]) * Integer.parseInt(fact.getP()[2][i]));	
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.getMessage());
			System.out.println("Fin listado!!!!");
		}finally{
			//System.out.println("La cantidad total es: " + mTotal);
			archF.close();
			return mTotal;
		}
	}

	// inciso 3
	public void eliminar(String nom, int nroid)throws ClassNotFoundException, IOException{
		ObjectInputStream archF = null; // nuevo archivo original
		ObjectOutputStream archFCopia = null; // nuevo archivo original
		try {
			archF = new ObjectInputStream(new FileInputStream(nomArch));//archOriginal
			archFCopia = new ObjectOutputStream(new FileOutputStream("copiaFactura.dat", true)); // orchivoCopia
			while(true){
				fact = new Factura();
				fact = (Factura)archF.readObject(); // saca e;l objeto y lo asigna a fact
				if(fact.getCliente().equals(nom) && fact.getNro()==nroid) {
					continue;
				}else {
					archFCopia.writeObject(fact); 
				}
			}
		} catch (Exception e) {
			System.out.println("Fin listado!!!!");
		}finally{
			archF.close();
			archFCopia.close();
			File original = new File (nomArch); // archOriginal
			original.delete(); // archivoOriginal.dat
			File copia = new File ("copiafactura.dat");
			copia.renameTo(original);
			String h = "dadsa";
		}
	}
	
}













