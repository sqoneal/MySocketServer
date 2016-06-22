package com.liebao.zzj;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Sender implements Runnable {

	Socket client;

	DataOutputStream dos;
	int msgcount = 0;
	String msg;

	public Sender(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		while (client.isConnected()) {
			if (client.isClosed()) {
				break;
			}
			if (msgcount < MessageBean.getMssagecount()) {
				try {
					System.out
							.println("Sender:" + MessageBean.getMssagecount() + " msg:" + MessageBean.getMessagestr());
					this.msg = MessageBean.getMessagestr();
					dos = new DataOutputStream(client.getOutputStream());
					dos.writeUTF(this.msg);
					this.msgcount = MessageBean.getMssagecount();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			dos.close();
			client.shutdownOutput();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
