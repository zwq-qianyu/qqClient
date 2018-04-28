/*
* 客户端和服务器端保持通讯的线程
*/
package qq.client.tools;

import qq.common.Message;

import java.io.ObjectInputStream;
import java.net.Socket;
import qq.client.view.*;

public class ClientConServerThread extends Thread {
    public Socket getS() {
        return s;
    }

    private Socket s;

    //构造函数
    public ClientConServerThread(Socket s){
        this.s = s;
    }

    public void run(){
        while (true){
            //不停地读取从服务器端发来的消息
            try{
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                Message m = (Message)ois.readObject();
                System.out.println("读取到消息" + m.getSender() + "给" + m.getGetter() + " 内容：" + m.getCon());
                //把从服务器读来的消息，显示到该显示的聊天界面
                qqChat qc = ManageQqChat.getQqChat(m.getSender()+" "+m.getGetter());
                //显示
                qc.showMessage(m);
            }catch (Exception err){
                err.printStackTrace();
            }
        }
    }
}
