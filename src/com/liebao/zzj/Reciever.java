package com.liebao.zzj;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

class Reciever implements Runnable {
	Socket client;
	// InputStream is;
	// BufferedInputStream bis;
	public String strmessage;
	//public static int msgcount = 0;

	DataInputStream dis;
	
	public Reciever() {
	}

	public Reciever(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		while (client.isConnected()) {
			try {
				if(!client.isClosed()){
					dis = new DataInputStream(client.getInputStream());

					while ((strmessage = dis.readUTF()) != null) {
						System.out.println(strmessage);
						MessageBean.setMessagestr(strmessage);
						MessageBean.setMssagecount(MessageBean.getMssagecount()+1);
						System.out.println("Reciever:msgcount:"+MessageBean.getMssagecount());
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} /*finally {
				try {
					// bis.close();
					// is.close();
					//client.shutdownInput();
					//dis.close();
					//client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		}
	}

}
