/*
* 客户端和服务器端保持通讯的线程
*/
package qq.client.tools;

import qq.common.Message;

import java.io.ObjectInputStream;
import java.net.Socket;
import qq.client.view.*;
import qq.common.MessageType;

import javax.swing.*;

public class ClientConServerThread extends Thread {


    private Socket s;

    //构造函数
    public ClientConServerThread(Socket s){
        this.s = s;
    }

    public void run(){
        /*qqFriendsList qfl0 = ManageFriendList.getqqFriendsList(getter);
        qfl0.doShutDownWork();*/
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
                else if(m.getMesType().equals(MessageType.message_group_chat)){
                    //把从服务器读来的消息，显示到群聊界面
                    groupChat gc = ManageGroupChat.getGroupChat(m.getGetter());
                    //显示消息
                    gc.showMessage(m);
                }
                else if(m.getMesType().equals(MessageType.message_ret_off_line)){
                    //如果收到此类消息类型，表明有人下线了，将该好友的头像变成灰色
                    System.out.println("客户端收到："+m.getCon()+" 的下线通知");
                    //获取好友列表并整理
                    String con = m.getCon();
                    String getter = m.getGetter();   //获取getter的id号
                    //修改相应的好友列表
                    //qqFriendsList qfl = new qqFriendsList(getter);
                    qqFriendsList qfl = ManageFriendList.getqqFriendsList(getter);//改用这种方式才不会出现每次更新后都新建一个好友列表
                    //更新在线好友
                    qfl.updateFriendsList2(m);
                }
                else if(m.getMesType().equals(MessageType.message_ret_onlineFriends)){
                    System.out.println("客户端收到："+m.getCon());
                    //获取好友列表并整理
                    String con = m.getCon();
                    String friends[] = con.split(" ");
                    String getter = m.getGetter();   //获取getter的id号
                    //修改相应的好友列表
                    //qqFriendsList qfl = new qqFriendsList(getter);
                    qqFriendsList qfl = ManageFriendList.getqqFriendsList(getter);//改用这种方式才不会出现每次更新后都新建一个好友列表
                    try{
                        qfl.doShutDownWork();
                    }catch(Exception e){
                        //e.printStackTrace();
                    }
                    if(qfl != null){
                        //更新在线好友
                        qfl.updateFriendsList(m);
                    }
                }
                else if(m.getMesType().equals(MessageType.message_to_all)){
                    if(m.getCon().equals("\n\r")){
                        System.out.println("空通知！");
                    }
                    else{
                        //把从服务器读来的消息，显示到所有用户的聊天界面
                        System.out.println("客户端收到服务器端的通知："+m.getCon());
                        String notify = "系统通知：" + m.getCon();
                        JOptionPane.showMessageDialog(null,notify);
                    }
                }
            }catch (Exception err){
                JOptionPane.showMessageDialog(null,"你已被强制下线！");
                System.exit(0);
                err.printStackTrace();
            }
        }
    }
    public Socket getS() {
        return s;
    }
}
