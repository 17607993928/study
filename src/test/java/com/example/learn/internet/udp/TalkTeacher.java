package com.example.learn.internet.udp;
/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * 
 * @author 裴新 QQ:3401997271
 *
 */
public class TalkTeacher {
	public static void main(String[] args) {
		new Thread(new TalkReceive(9999,"学生")).start(); //接收
		
		new Thread(new TalkSend(5555,"localhost",8888)).start(); //发送
	}
}
