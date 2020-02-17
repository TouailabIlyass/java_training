/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author drging
 */
public class testdb {
    public static void main(String[] args) throws InterruptedException {
        
        Observable<Client> s=test();
        s.subscribe(x->{
            System.out.println(x);
        });
       /* new Thread(()->{
        //Observable<Client> s1=test();
        s.subscribe(x->{
            System.out.println(x);
        });
        
        }).start();
        */
        Thread.sleep(10000);
        Observable<Client> s1=test();
        s1.subscribe(x->{
            System.out.println(x);
        });
    }
    
    public static Observable<Client> test()
    {
        ConnectableObservable<Client> obs = Observable.<Client>create(s->{
            System.out.println("START");
            Client c=new Client();
            PreparedStatement st= Databases.MysqlCon.getInstance().getConnexion().prepareStatement("select * from client");
            ResultSet rst=st.executeQuery();
            while(rst.next())
            {
                c.setId(rst.getInt("id"));
                c.setNom(rst.getString("nom"));
                c.setSalaire(rst.getDouble("salaire"));
                s.onNext(c);
            }
        
        }).publish();
        return obs.refCount();
    }
}
