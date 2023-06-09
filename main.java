package factura;
import java.io.IOException;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		archFactura a = new archFactura("factura2.dat");
		//a.crear();
		//a.Adicionar();
		//a.Listar();
		//int monto = a.montoTotal("Alina");
		//System.out.println("La cantidad total es: " + monto);
		// eliminar al cliente con nombre X y nro y 
		//System.out.println("\n ELIMINAR \n");
		a.eliminar("c1", 1);
		a.Listar();
	}

}
