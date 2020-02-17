/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import Model.Message;
import java.util.HashMap;

/**
 *
 * @author drging
 */
public class MessageDatabase {
    
    private final static HashMap<Integer,Message> Allmsg = new HashMap<Integer, Message>();

    
    
    public static HashMap getMessages()
    {
        return Allmsg;
    }
    
}
