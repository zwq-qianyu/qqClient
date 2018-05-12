package qq.client.view;

import qq.client.tools.ManageClientConServerThread;
import qq.common.Message;
import qq.common.MessageType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;

public class groupChat extends JFrame implements ActionListener {
    //设置组件
    JTextField jtf;
    JTextArea jta;
    JButton jb;
    JPanel jp;
    String ownerId;

    public groupChat(String owner) {
        this.ownerId = owner;
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
        this.setTitle(ownerId+" 群聊中。。。");
        this.setSize(300,200);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        if (action.getSource() == jb) {
            //用户点击后发送
            Message ms = new Message();
            ms.setSender(this.ownerId);
            ms.setMesType(MessageType.message_group_chat);
            ms.setCon(jtf.getText());
            ms.setSendTime(new java.util.Date().toString());
            //清空输入框
            this.jtf.setText("");

            //显示信息
            String info = "                                                      " + "我：" + ms.getCon() + "\n\r";
            this.jta.append(info);

            //发送给服务器
            try {
                ObjectOutputStream oos = new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(
                        ownerId).getS().getOutputStream());
                oos.writeObject(ms);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //写一个方法，显示群聊消息
    public void showMessage(Message m){
        try{
            String info = m.getCon() + "\n\r";
            System.out.println("写一个方法，让他显示消息");
            this.jta.append(info);
        }catch(Exception e){
            System.out.println("出错了");
            e.printStackTrace();
        }

    }

}