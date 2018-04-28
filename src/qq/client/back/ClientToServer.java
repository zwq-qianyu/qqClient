package qq.client.back;

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

            //判断登录是否成功
            if(ms.getMesType().equals("1"))
                b = true;
                System.out.print("登录成功");
            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        return b;
    }

    public void sendInfoToServer(){

    }

    public static void main(String args[]){

    }
}
