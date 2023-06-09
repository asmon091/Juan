package factura;

import java.util.Scanner;

public class Factura implements java.io.Serializable {
	static Scanner lee = new Scanner (System.in);
	private int nro;
	private String cliente;
	private int np;
	private String p [][] = new String [3][30]; //prod,cant,precioUnidad

	public Factura() {
		nro = np =0;
		cliente = "";		
	}
	
	public void leer(){
		System.out.println(" FACTURA nro - cliente - np, productos");
		this.nro = lee.nextInt();
		this.cliente = lee.next();
		this.np = lee.nextInt();
		for (int i = 0; i <np; i++) {
			System.out.println("\nprod, cant, precio ");
			p[0][i] = lee.next();
			p[1][i] = lee.next();
			p[2][i] = lee.next();
		}
	}
	public void mostrar(){
		System.out.println("\n	FACTURA 	");
		System.out.println("\nro: "  + this.nro);
		System.out.println("cliente: "  + this.cliente);
		System.out.println("np: "  + this.np);
		for (int i = 0; i <np; i++) {
			System.out.println(p[0][i]+ " " + p[1][i] + " " + p[2][i]);
		}
	}

	public int getNro() {
		return nro;
	}

	public String getCliente() {
		return cliente;
	}

	public int getNp() {
		return np;
	}

	public String[][] getP() {
		return p;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setNp(int np) {
		this.np = np;
	}

	public void setP(String[][] p) {
		this.p = p;
	}
	
}
