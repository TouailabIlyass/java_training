/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import org.reactivestreams.Subscriber;

/**
 *
 * @author drging
 */
public class Re {
    public  void x(String str)
    {
        System.out.println(str+str);
    }

    public static void main(String[] args) {
      Flowable.just("Hello World!","ccc").subscribe(In->new Re().x(In));
     /*Observable<Integer> obs=test("okok");
     obs.filter(pre->{
         if(pre>15)
            return true;
         return false;
     }).
        subscribe(item->{
         System.out.println(item);
     });*/
    }
    static Observable<Integer> test(String str)
    {
        Observable<Integer> obs=Observable.create(sbs->{
            System.out.println("okzzz");
            while(true)
            {
                sbs.onNext((int)((Math.random()+1)*10));
                Thread.sleep(1000);
            }
        
        });
        return obs;
    }
    
}
