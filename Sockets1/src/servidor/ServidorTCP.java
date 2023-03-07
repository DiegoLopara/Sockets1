package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			ServerSocket socket = new ServerSocket(7000);
			System.out.println("Esperando a que alguien conecte");
			Socket socket_Cli = socket.accept();
			
			String cliente = socket_Cli.getRemoteSocketAddress().toString();
			System.out.println("Ha conectado: " + cliente);
			
			DataInputStream in = new DataInputStream(socket_Cli.getInputStream());
			DataOutputStream out = new DataOutputStream(socket_Cli.getOutputStream());
			
			out.writeUTF("Hola desde el servidor");
			
			String mensaje = "";
			String mensaje2 = "";
			
			do {
				
				System.out.println("\nEsperando recibir mensaje");
				mensaje = in.readUTF();
				System.out.println("Mensaje recibido: " + mensaje);
				mensaje2 = mensaje.toUpperCase();
				out.writeUTF(mensaje2);
				System.out.println("Se ha contestado el mismo mensaje en mayusculas");
				
			} while (!mensaje.equals("fin"));
			
			socket_Cli.close();
			System.out.println("\nComunicacion finalizada");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(1);
			
		}
	}

}
