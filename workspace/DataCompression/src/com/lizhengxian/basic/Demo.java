package com.lizhengxian.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import edu.princeton.cs.algs4.BinaryStdOut;

public class Demo{
	public static void main(String[] args) throws Exception {  
        FileInputStream in = new FileInputStream(new File("F:\\workspace\\DataCompression\\bin\\genomeTiny.txt"));// ָ��Ҫeȡ��ͼƬ  
        File file = new File("F:\\workspace\\DataCompression\\bin\\test.txt");  
        if (!file.exists()) {// ����ļ������ڣ��򴴽����ļ�  
            file.createNewFile();  
        }  
        FileOutputStream out = new FileOutputStream(new File("F:\\workspace\\DataCompression\\bin\\test.txt"));// ָ��Ҫд���ͼƬ  
        int n = 0;// ÿ�ζ�ȡ���ֽڳ���  
        byte[] bb = new byte[1024];// �洢ÿ�ζ�ȡ������  
        while ((n = in.read(bb)) != -1) {  
            out.write(bb, 0, n);// ����ȡ�����ݣ�д�뵽���������  
        }  
        out.close();// �ر����������  
        in.close();  
    }  
}
