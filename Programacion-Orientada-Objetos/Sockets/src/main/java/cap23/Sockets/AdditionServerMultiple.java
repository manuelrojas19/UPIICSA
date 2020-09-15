package cap23.Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AdditionServerMultiple {

	public static void main(String[] args) {
		final int port = 8901;
		AdditionServerThread serverThread;
		Socket socket;
		
		System.out.println("Escuchando en el puerto " + port);
		
		try {
			@SuppressWarnings("resource")
			ServerSocket listenSocket = new ServerSocket(port);
			
			while(true) {
				socket = listenSocket.accept();
				serverThread = new AdditionServerThread(socket);
				serverThread.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
