package cap23.Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AditionServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		final int port = 8901;

		Socket connection;
		ServerSocket listenSocket;

		InputStream inStream;
		DataInputStream inDataStream;

		OutputStream outSteam;
		DataOutputStream outDataStream;

		String client;
		int first, second, sum;
		boolean connected;
		while (true) {
			try {
				// create a server socket
				listenSocket = new ServerSocket(port);
				System.out.println("Escuchando en el puerto " + port);

				// listen for a connection from the client
				connection = listenSocket.accept();
				connected = true;
				System.out.println("Conexión establecida");

				// create an input stream from the client
				inStream = connection.getInputStream();
				inDataStream = new DataInputStream(inStream);

				// create an output stream to the client
				outSteam = connection.getOutputStream();
				outDataStream = new DataOutputStream(outSteam);

				// wait for a string from the client
				client = inDataStream.readUTF();
				System.out.println("Dirección del cliente: " + client);
				while (connected) {
					first = inDataStream.readInt();
					System.out.println("Primer numero recibido: " + first);

					second = inDataStream.readInt();
					System.out.println("Segundo numero recibido. " + second);

					sum = first + second;
					System.out.println("Suma: " + sum);

					outDataStream.writeInt(sum);
				}
			} catch (IOException e) {
				connected = false;
			}
		}
	}
}
