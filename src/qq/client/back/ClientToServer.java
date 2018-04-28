/*
* qq连接服务器的后台
*/
package qq.client.back;

import qq.client.tools.ClientConServerThread;
import qq.client.tools.ManageClientConServerThread;
import qq.common.Message;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import qq.common.*;

public class ClientToServer {
    public Socket s;

    //发送第一次请求，单独发送，因为后面都是发送message了
    public boolean sendLoginInfoToServer(Object o){
        boolean b =false;
        try{
            s = new Socket("127.0.0.1",9000);
            //对象流传输
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(o);

            //获取信息
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Message ms = (Message)ois.readObject();

            //判断登录是否成功（验证用户登陆）
            if(ms.getMesType().equals("1")){
                //登陆成功就创建一个该QQ号和服务器保持通讯连接的线程
                ClientConServerThread ccst = new ClientConServerThread(s);
                //启动该通讯线程
                ccst.start();

                ManageClientConServerThread.addClientConServerThread(((User)o).getUserId(),ccst);
                b = true;
                System.out.print("登录成功");
            }
            else{
                //关闭Socket
                s.close();
            }
            }catch (Exception e){
                e.printStackTrace();
            }
        return b;
    }

    public void sendInfoToServer(){

    }

    public static void main(String args[]){

    }
}
