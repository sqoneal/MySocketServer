package com.liebao.zzj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ServiceConn {
	private ServerSocket serversocket;
	private ExecutorService servicepool;

	public ServiceConn(int port) {
		try {
			this.serversocket = new ServerSocket(port);
			this.servicepool = Executors.newFixedThreadPool(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void starting() {
		while (true) {
			try {
				System.out.println("*********等待客户端连接**********");
				Socket clientsocket = serversocket.accept();
				servicepool.execute(new Reciever(clientsocket));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
