/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientMain
{

	public static void main(String[] args)
			throws IOException, UnknownHostException
	{
		Scanner scan = new Scanner(System.in);
		Scanner scanServer;
		Socket anschluss = new Socket("localhost", 6000);
		scanServer = new Scanner(anschluss.getInputStream());
		String nachricht = "";
		PrintWriter ausgabe = new PrintWriter(anschluss.getOutputStream(),
				true);
		boolean b = true;
		while (b)
		{
			System.out.println("Nachricht?");
			nachricht = scan.nextLine();		
			ausgabe.println(nachricht);
			System.out.println(scanServer.nextLine());
			
			System.out.println("Ende?");
			b = scan.nextBoolean();
			scan.nextLine();
		}
		
		scan.close();
		scanServer.close();
		anschluss.close();

	}

}
