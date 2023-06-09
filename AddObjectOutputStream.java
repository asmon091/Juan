package factura;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AddObjectOutputStream extends ObjectOutputStream{
	
	public AddObjectOutputStream(OutputStream out) throws IOException{ //a;adir
			super(out);
	}
	protected void writeStreamHeader() throws IOException{//mostrar
		this.reset();
	}
}
