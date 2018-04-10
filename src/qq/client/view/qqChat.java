package qq.client.view;

import javax.swing.*;

public class qqChat extends JFrame {
    //设置组件
    JTextField jtf;
    JTextArea jta;
    JButton jb;
    JPanel jp;

    public qqChat(String friend){
        jtf = new JTextField(15);
        jta = new JTextArea();
        jb = new JButton("发送");
        jp = new JPanel();

        jp.add(jtf);
        jp.add(jb);

        this.add(jta,"Center");
        this.add(jp,"South");
        this.setTitle("You're chatting with "+friend+"...");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setVisible(true);
    }

    public static void main(String  args[]){
        qqChat chat = new qqChat("mao");
    }

}
