/*
因为客户端需要一直处于读取状态来读取服务器发来的消息，所以需要使用线程
 */

package qq.client.view;

import qq.common.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import qq.client.back.*;
import qq.client.tools.*;

public class qqChat extends JFrame implements ActionListener {
    //设置组件
    JTextField jtf;
    JTextArea jta;
    JButton jb;
    JPanel jp;
    String ownerId,friendId;

    public qqChat(String owner,String friend){
        this.ownerId = owner;
        this.friendId = friend;

        jtf = new JTextField(15);
        jta = new JTextArea();      //显示框
           jta.setLineWrap(true);        //激活自动换行功能
           jta.setWrapStyleWord(true);            // 激活断行不断字功能
        jb = new JButton("发送");
        jb.addActionListener(this);
        jp = new JPanel();

        jp.add(jtf);
        jp.add(jb);

        this.add(jta,"Center");
        this.add(jp,"South");
        this.setTitle(owner+" 正在和 "+friend+"聊天。。。");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setVisible(true);
    }

    public static void main(String  args[]){
        //qqChat chat = new qqChat("mao");
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==jb){
            //用户点击后发送
            Message ms = new Message();
            ms.setSender(this.ownerId);
            ms.setGetter(this.friendId);
            ms.setCon(jtf.getText());
            ms.setSendTime(new java.util.Date().toString());
            //清空输入框
            this.jtf.setText("");

            //显示信息
            String info = "                                                      " + "我：" + ms.getCon() + "\n\r";
            this.jta.append(info);

            //发送给服务器
            try{
                ObjectOutputStream oos = new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
                oos.writeObject(ms);
            }catch (Exception e){
                e.printStackTrace();
            }finally{

            }

        }
    }

    //写一个方法，让他显示消息
    public void showMessage(Message m){
        String info = m.getSender()+" 对 "+m.getGetter()+" 说 "+m.getCon()+"\r\n";
        this.jta.append(info);
    }

    /*
    @Override
    public void run() {
        while(true){
            try{
                //读取信息
                ObjectInputStream oos = new ObjectInputStream(ClientToServer.s.getInputStream());
                Message m = (Message)oos.readObject();

                //显示信息
                String info = m.getSender() + "：" + m.getCon() + "\n\r";
                this.jta.append(info);

            }catch (Exception e){
                e.printStackTrace();
            }finally {

            }
        }
    }
    */
}
