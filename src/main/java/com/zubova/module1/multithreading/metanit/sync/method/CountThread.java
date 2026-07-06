package com.zubova.module1.multithreading.metanit.sync.method;

class CountThread implements Runnable{
  
    CommonResource res;
    CountThread(CommonResource res){
        this.res = res;
    }
      
    public void run(){
        res.increment();
    }
}