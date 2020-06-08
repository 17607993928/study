package com.example.learn.thread.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建人 xjs
 * @类描述 影院案例
 * @创建时间 2020/6/1 0001 下午 21:35
 */
public class CinemaTest {
    public static void main(String[] args) {
        List<Integer> ticket=new ArrayList<>();
        ticket.add(1);
        ticket.add(2);
        ticket.add(5);
        ticket.add(4);
        ticket.add(6);
        ticket.add(8);
        Cinema cinema=new Cinema("万达",ticket);


        List<Integer> checkIn1=new ArrayList<>();
        checkIn1.add(1);
        checkIn1.add(2);
        Customer zhansan=new Customer(checkIn1,"zhanSan",cinema);

        List<Integer> checkIn2=new ArrayList<>();
        checkIn2.add(4);
        checkIn2.add(4);

        Customer liSi=new Customer(checkIn2,"liSi",cinema);

        new Thread(zhansan).start();
        new Thread(liSi).start();
    }
}

class Customer implements Runnable{
    private List<Integer> checkIn=new ArrayList<>();
    private String name;
    private Cinema cinema;

    public Customer(List<Integer> checkIn, String name, Cinema cinema) {
        this.checkIn = checkIn;
        this.name = name;
        this.cinema = cinema;
    }

    @Override
    public void run() {
        synchronized(cinema){
            boolean b = cinema.buyTicket(this.checkIn);
            if(b){
                System.out.println(name+"买了"+checkIn);
            }

        }

    }
}


class Cinema {
    private String name;
    private List<Integer> ticket;

    public Cinema(String name, List<Integer> ticket) {
        this.name = name;
        this.ticket = ticket;
    }

    public boolean buyTicket(List<Integer> checkIn){
        System.out.println("可用位置为："+ticket);
        List<Integer> copy=new ArrayList<>();

        //复制
        copy.addAll(this.ticket);

        //买票
        copy.removeAll(checkIn);

        if(ticket.size()-copy.size()!=checkIn.size()){
            System.out.println(name+"没票了");
            return false;
        }else{
            ticket=copy;
            return true;
        }

    }
}
