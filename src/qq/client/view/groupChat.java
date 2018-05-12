package qq.client.view;

import javax.swing.*;

public class groupChat extends JFrame {
    //设置组件
    JTextField jtf;
    JTextArea jta;
    JButton jb;
    JPanel jp;

    public groupChat(){
        jtf = new JTextField(15);
        jta = new JTextArea();      //显示框
        jta.setLineWrap(true);        //激活自动换行功能
        jta.setWrapStyleWord(true);            // 激活断行不断字功能
        jb = new JButton("发送");
        //jb.addActionListener(this);
        jp = new JPanel();

        jp.add(jtf);
        jp.add(jb);

        this.add(jta,"Center");
        this.add(jp,"South");
        this.setTitle("群聊中。。。");
        this.setSize(300,200);
        this.setVisible(true);
    }

}