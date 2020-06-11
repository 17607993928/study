package com.example.DesignPatterns;

/**
 * @类描述:装饰器模式
 * @创建人:xiejs
 * @创建时间:2020-6-11 10:32:55
 */
public  class Decorate {

    public static void main(String[] args) {
        Person person=new Person();
        person.say();

        Loudspeaker loudspeaker=new Loudspeaker(person);
        loudspeaker.say();
    }


    public interface Say{
        void say();
    }

    public static class Person implements Say{
        private int fenBei=10;

        public int getFenBei() {
            return fenBei;
        }

        @Override
        public void say() {
            System.out.println("人的声音为"+fenBei);
        }
    }


    public static class Loudspeaker implements Say{

        private Person person;

        public Loudspeaker(Person person) {
            this.person = person;
        }

        @Override
        public void say() {
            System.out.println("人的声音为"+person.getFenBei()*10);
        }
    }

}
