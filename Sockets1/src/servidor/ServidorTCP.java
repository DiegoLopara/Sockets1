package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) throws IOException {
		
		 // Se crea un nuevo objeto ServerSocket y se especifica el puerto a utilizar
	    ServerSocket servidor = new ServerSocket(7000);
	    System.out.println("Esperando a que alguien conecte");
	    
	    // El servidor espera a que un cliente se conecte y se acepta la conexión
	    Socket cliente = servidor.accept();
	    System.out.println("Ha conectado " + cliente.getInetAddress().getHostAddress() + ":" + cliente.getPort());
	    
	 // Se establecen las entradas y salidas para la comunicación con el cliente
	    BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
	    PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);

	    // Se espera a recibir un mensaje del cliente y se responde con el mismo mensaje en mayúsculas
	    String enviarMensaje;
	    while ((enviarMensaje = br.readLine()) != null) {
	        System.out.println("Mensaje recibido: " + enviarMensaje);
	        pw.println(enviarMensaje.toUpperCase());
	        System.out.println("Se ha contestado el mismo mensaje en mayúsculas: " + enviarMensaje.toUpperCase());
	        if (enviarMensaje.equals("fin")) {
	            break;
	        }
	    }

	    System.out.println("Comunicación finalizada");

	    cliente.close();
	    servidor.close();
	    
	}
}


