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
		Socket lauschen = anschluss.accept();
		PrintWriter clientOut = new PrintWriter(lauschen.getOutputStream(), true);
		while (!S.equals("ENDE"))
		{
			
			InputStreamReader PortLeser = new InputStreamReader(
					lauschen.getInputStream());
			BufferedReader Eingabe = new BufferedReader(PortLeser);
			S = Eingabe.readLine();
			System.out.println("Client sagt: " + S);
			if(S.equals("Hörst du mich"))
			{
				clientOut.println("Ich höre dich");
			}
			else
			{
				clientOut.println("habe ich nicht verstanden");
			}
		}
		lauschen.close();
		anschluss.close();
	}

}
