package kreibich;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Handler implements Runnable {
	
	private Socket client;
	
	public Handler(Socket client) {
		
		this.client = client;
		
	}

	@Override
	public void run() {

		try {			
			// Streams amk 3.0
			OutputStream out = client.getOutputStream(); // Holt sich was gesendet wird 
			PrintWriter wrtr = new PrintWriter(out);      // schreibt was geholt wurde formatiert ab
			
			InputStream in = client.getInputStream();
			BufferedReader rdr = new BufferedReader(new InputStreamReader(in)); 
			//--------------------------------------------------
			
			String s = null;
			
			while((s = rdr.readLine()) != null) {
				
				wrtr.write(s +"\n");
				wrtr.flush();
				System.out.println("Von Diese Daki(Client) erhalten:" + s);
				
			}
			
			wrtr.close();
			rdr.close();
			
			client.close();
			
		} catch (Exception e) {
			System.out.println("Handler-Class error");
		}
	
	}

}
