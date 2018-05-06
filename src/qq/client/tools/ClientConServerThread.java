/*
* 客户端和服务器端保持通讯的线程
*/
package qq.client.tools;

import qq.common.Message;

import java.io.ObjectInputStream;
import java.net.Socket;
import qq.client.view.*;
import qq.common.MessageType;

public class ClientConServerThread extends Thread {


    private Socket s;

    //构造函数
    public ClientConServerThread(Socket s){
        this.s = s;
    }

    public void run(){
        while (true){
            //不停地读取从服务器端发来的消息
            try{
                //System.out.println("1111111");
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                //System.out.println("222222");
                Message m = (Message)ois.readObject();
                //System.out.println("读取到消息" + m.getSender() + "给" + m.getGetter() + " 内容：" + m.getCon());
                if(m.getMesType().equals(MessageType.message_common_mes)){
                    //把从服务器读来的消息，显示到该显示的聊天界面
                    qqChat qc = ManageQqChat.getQqChat(m.getGetter()+" "+m.getSender());
                    //显示
                    qc.showMessage(m);
                }
                else if(m.getMesType().equals(MessageType.messag_ret_onlineFriends)){
                    System.out.println("客户端收到："+m.getCon());
                    //获取好友列表并整理
                    String con = m.getCon();
                    String friends[] = con.split(" ");
                    String getter = m.getGetter();   //获取getter的id号
                    //修改相应的好友列表
                    //qqFriendsList qfl = new qqFriendsList(getter);
                    qqFriendsList qfl = ManageFriendList.getqqFriendsList(getter);//改用这种方式才不会出现每次更新后都新建一个好友列表

                    if(qfl != null){
                        //更新在线好友
                        qfl.updateFriendsList(m);
                    }
                }
            }catch (Exception err){
                err.printStackTrace();
            }
        }
    }
    public Socket getS() {
        return s;
    }
}
