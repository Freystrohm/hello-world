/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{

	public static void main(String[] args) throws IOException
	{
		ServerSocket anschluss = new ServerSocket(6000);
		String S="";
		while (!S.equals("ENDE"))
		{
			Socket lauschen = anschluss.accept();
			InputStreamReader PortLeser = new InputStreamReader(
					lauschen.getInputStream());
			BufferedReader Eingabe = new BufferedReader(PortLeser);
			S = Eingabe.readLine();
			System.out.println("Client sagt: " + S);
		}
		anschluss.close();
	}

}
