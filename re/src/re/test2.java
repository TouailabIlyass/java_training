/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re;

import io.reactivex.Observable;

/**
 *
 * @author drging
 */
public class test2 {
    
    
    
    public static void main(String[] args) {
        Observable<Integer> obs =  Observable.<Integer>create(s->{
        System.out.println("osb1");
        while(!s.isDisposed())
        {
            s.onNext(1);
            System.out.println("ok");
            Thread.sleep(1000);
        }
    });
    Observable<Integer> obs2 =  Observable.<Integer>create(s->{
        System.out.println("osb2");
        while(!s.isDisposed())
        {
            s.onNext(2);
            Thread.sleep(1000);
        }
    });
    
    new Thread(()->{
        obs.subscribe(x->{
    for(int i=0;i<10;i++){
        System.out.print(x);
        Thread.sleep(10000);
    }
    System.out.println("");
    });
            }).start();
    
    //obs2.subscribe(x->{System.out.println(x);});
    
    
    }
    
}
