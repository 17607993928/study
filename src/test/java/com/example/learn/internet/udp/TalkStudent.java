package com.example.learn.internet.udp;
/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class TalkStudent {
	public static void main(String[] args) {
		new Thread(new TalkSend(7777,"localhost",9999)).start(); //发送		
		new Thread(new TalkReceive(8888,"老师")).start(); //接收
	}
}
