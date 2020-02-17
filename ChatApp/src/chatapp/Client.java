
package chatapp;

import java.net.Socket;


public class Client {

    private Socket socket;
    private int id;
    private String user;

    public Client(Socket socket, int id,String user) {
        this.socket = socket;
        this.id = id;
        this.user=user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Socket getSocket() {
        return socket;
    }

    public int getId() {
        return id;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
