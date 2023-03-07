package cliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader inTeclado = new BufferedReader(new InputStreamReader(System.in));
		String mensajeTeclado = "";
		String mensajeServidor = "";
		Scanner sc = new Scanner(System.in);
		
		try {
			
			Socket socket = new Socket("127.0.0.1", 7000);
			
			DataInputStream in = new DataInputStream(socket.getInputStream());
			mensajeServidor = in.readUTF();
			System.out.println(mensajeServidor);
			
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			
			do {
				
				System.out.println("\nEscribe el mensaje a enviar");
				mensajeTeclado = sc.nextLine();
				out.writeUTF(mensajeTeclado);
				
				System.out.println("Mensaje enviado");
				mensajeServidor = in.readUTF();
				System.out.println("Mensaje recibido del servidor: " + mensajeServidor);
				
			} while (!mensajeTeclado.equals("fin"));
			
			socket.close();
			System.out.println("\nComunicacion finalizada");
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(1);;
		}
	}

}
