package com.lizhengxian.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import edu.princeton.cs.algs4.BinaryStdOut;

public class Demo{
	public static void main(String[] args) throws Exception {  
        FileInputStream in = new FileInputStream(new File("F:\\workspace\\DataCompression\\bin\\genomeTiny.txt"));// 指定要e取的图片  
        File file = new File("F:\\workspace\\DataCompression\\bin\\test.txt");  
        if (!file.exists()) {// 如果文件不存在，则创建该文件  
            file.createNewFile();  
        }  
        FileOutputStream out = new FileOutputStream(new File("F:\\workspace\\DataCompression\\bin\\test.txt"));// 指定要写入的图片  
        int n = 0;// 每次读取的字节长度  
        byte[] bb = new byte[1024];// 存储每次读取的内容  
        while ((n = in.read(bb)) != -1) {  
            out.write(bb, 0, n);// 将读取的内容，写入到输出流当中  
        }  
        out.close();// 关闭输入输出流  
        in.close();  
    }  
}
