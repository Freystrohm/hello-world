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
		Socket Anschluss = new Socket("localhost", 6000);
		String nachricht = "";
		PrintWriter Ausgabe = new PrintWriter(Anschluss.getOutputStream(),
				true);
		boolean b = true;
		while (b)
		{
			System.out.println("Nachricht?");
			nachricht = scan.next();
			System.out.println("Ende?");
			b = scan.nextBoolean();
			System.out.println(nachricht);
			Ausgabe.println(nachricht);
		}
		
		scan.close();
		Anschluss.close();

	}

}
