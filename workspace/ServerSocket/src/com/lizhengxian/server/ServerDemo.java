package com.lizhengxian.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	 private ServerSocket server;
     public static void main(String args[])
     {
    	ServerDemo sd = new ServerDemo();
    	sd.start();
     }
     public void start(){
    	 try {
			server=new ServerSocket(8888);
			this.receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
     }
     private void receive(){
    	 try {
			Socket client =server.accept();
			String msg =null;
			StringBuilder sb =new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			while((msg=br.readLine()).length()>0)
			{
				sb.append(msg);
				sb.append("\r\n");
				if(msg==null)
					break;
			}
			String requestInfo =sb.toString().trim();
			System.out.println(requestInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public void stop(){
    	 
     }
}
