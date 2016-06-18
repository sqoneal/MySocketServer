package com.liebao.zzj;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class Reciever implements Runnable {
	Socket client;
	// InputStream is;
	// BufferedInputStream bis;
	String strmessage;

	DataInputStream dis;

	public Reciever(Socket client) {
		this.client = client;
	}

	@Override
	public synchronized void run() {
		while (client.isConnected()) {
			try {
				dis = new DataInputStream(client.getInputStream());

				while ((strmessage = dis.readUTF()) != null) {
					System.out.println(strmessage);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// bis.close();
					// is.close();
					client.shutdownInput();
					dis.close();
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
