package com.example.learn.internet;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class IPTest01 {
    public static void main(String[] args) {
        try {
            InetAddress localHost = Inet4Address.getLocalHost();
            InetSocketAddress unresolved = InetSocketAddress.createUnresolved(localHost.getHostName(), 8050);
            System.out.println(localHost.getHostAddress());
            System.out.println(localHost.getHostName());
            System.out.println(unresolved.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
