class my extends Thread{
  public synchronized  void run(){
    try {
    System.out.println("cureent thread :"+Thread.currentThread().getName());
    Thread.sleep(1000);
    System.out.println("cureent thread after sleep :"+Thread.currentThread().getName());
  }
  catch (Exception e) {
  System.out.println(e);

  }
}}

public class Thrd{
  public static void main(String[] args) {
    my t1=new my();
   my t=new my();
    t1.start();
  System.out.println("...1..."+t1);
    t.start();
    System.out.println(".....3....."+t);
  }/*
  my t2;
  public void run(){
    synchronized (t2){
    t2.dis();}
  }*/
}
