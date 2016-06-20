package com.liebao.zzj;

public class MessageBean {
	public static String messagestr;
	public static int mssagecount = 0;
	public static String getMessagestr() {
		return messagestr;
	}
	public static void setMessagestr(String messagestr) {
		MessageBean.messagestr = messagestr;
	}
	public synchronized static int getMssagecount() {
		return mssagecount;
	}
	public static void setMssagecount(int mssagecount) {
		MessageBean.mssagecount = mssagecount;
	}

}
