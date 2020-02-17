/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author drging
 */
public class MessageService {
    
    private final static Map<Integer,Message> Allmsg = MessageDatabase.getMessages();
    
    public MessageService()
    {
        Allmsg.put(1, new Message(1, "msg1"));
        Allmsg.put(2, new Message(2, "msg2"));
    }
    public List<Message> getMessages()
    {
       return new ArrayList<Message> (Allmsg.values());
    }
    public Message getMessage(int id)
    {
        return Allmsg.get(id);
    }
    
    public void Addmsg(Message m)
    {
        Allmsg.put(Allmsg.size() + 1, new  Message(Allmsg.size()+1, m.getMsg()));
    }
}
