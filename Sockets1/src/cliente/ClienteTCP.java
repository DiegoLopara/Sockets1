package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

	public static void main(String[] args) throws IOException {

		// Se crea una nueva conexión con el servidor especificando la IP y el puerto
	    Socket servidor = new Socket("127.0.0.1", 7000);
	    System.out.println("Hola desde el servidor");

	    // Se establecen las entradas y salidas para la comunicación con el servidor
	    PrintWriter pw = new PrintWriter(servidor.getOutputStream(), true);

	    // Se utiliza un scanner para recibir los mensajes del usuario
	    Scanner sc = new Scanner(System.in);
	    String enviarMensaje;

	    while (true) {

	        System.out.println("Escribe el mensaje a enviar");
	        enviarMensaje = sc.nextLine();
	        // Se envía el mensaje al servidor
	        pw.println(enviarMensaje);
	        System.out.println("Mensaje enviado");

	        if (enviarMensaje.equals("fin")) {
	            break;
	        }
	    }
	    System.out.println("Comunicación finalizada");
	    sc.close();
	    servidor.close();

	}
	}