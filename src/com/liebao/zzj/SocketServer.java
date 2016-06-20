package com.liebao.zzj;

public class SocketServer {

	public static void main(String[] args) {
		//SocketServer ss = new SocketServer();
		
		try {
			ServiceConn sc = new ServiceConn(8899);
			sc.starting();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ss.servicepool.execute(sc);
		
	}

}
