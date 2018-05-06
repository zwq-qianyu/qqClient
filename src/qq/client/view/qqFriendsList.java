package qq.client.view;

import qq.client.tools.ManageQqChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ObjectOutputStream;

import qq.client.tools.*;
import qq.common.Message;
import qq.common.MessageType;

public class qqFriendsList extends JFrame implements ActionListener,MouseListener {
    //处理第一张卡片
    JPanel jphy1,jphy2,jphy3;
    JButton jphy_jb1,jphy_jb2,jphy_jb3;
    JScrollPane jsp1;
    JLabel []jlbs1;

    //处理第二张卡片（陌生人）
    JPanel jpmsr1,jpmsr2,jpmsr3;
    JButton jpmsr_jb1,jpmsr_jb2,jpmsr_jb3;
    JScrollPane jsp2;
    JLabel []jlbs2;

    //处理第三张卡片（陌生人）
    JPanel jphmd1,jphmd2,jphmd3;
    JButton jphmd_jb1,jphmd_jb2,jphmd_jb3;
    JScrollPane jsp3;
    JLabel []jlbs3;

    //对整个JFrame进行卡片布局
    CardLayout cl;

    String owner;
    public qqFriendsList(String ownerId){
        this.owner = ownerId;
        //处理第一张卡片（好友列表）
        jphy_jb1 = new JButton("特别关心");
        jphy_jb2 = new JButton("我的好友");
        jphy_jb2.addActionListener(this);  //监听
        jphy_jb3 = new JButton("陌生人");
        jphy_jb3.addActionListener(this);
        jphy1 = new JPanel(new BorderLayout());

        //假设有12个特别关心好友
        jphy2 = new JPanel((new GridLayout(12,1,4,4)));
        //给jphy2初始化1个特别关心好友
        jlbs1 = new JLabel[12];
        for(int i = 0;i < jlbs1.length;i++){
            jlbs1[i] = new JLabel(i+1+"",new ImageIcon("image/mine.jpg"),JLabel.LEFT);
            jlbs1[i].setEnabled(false);
            if(jlbs1[i].getText().equals(ownerId)){
                jlbs1[i].setEnabled(true);
            }
            jlbs1[i].addMouseListener(this);
            jphy2.add(jlbs1[i]);
        }

        jphy3 = new JPanel(new GridLayout(2,1));
        //把两个按钮加到jphy3中
        jphy3.add(jphy_jb2);
        jphy3.add(jphy_jb3);

        jsp1 = new JScrollPane(jphy2);

        //将所有组件加到最大的jphy1中去（对jph1初始化）
        jphy1.add(jphy_jb1,"North");
        jphy1.add(jsp1,"Center");
        jphy1.add(jphy3,"South");


        /* 处理第二张卡片（我的好友）*/
        jpmsr_jb1 = new JButton("特别关心");
        jpmsr_jb1.addActionListener(this);
        jpmsr_jb2 = new JButton("我的好友");
        jpmsr_jb3 = new JButton("陌生人");
        jpmsr_jb3.addActionListener(this);
        jpmsr1 = new JPanel(new BorderLayout());

        //假设有50个好友
        jpmsr2 = new JPanel((new GridLayout(50,1,4,4)));
        //给jpmsr2初始化20个好友
        jlbs2 = new JLabel[50];
        for(int i = 0;i < jlbs2.length;i++){
            jlbs2[i] = new JLabel(i+1+"",new ImageIcon("image/mine.jpg"),JLabel.LEFT);
            jlbs2[i].addMouseListener(this);
            jpmsr2.add(jlbs2[i]);
        }

        jpmsr3 = new JPanel(new GridLayout(2,1));
        //把两个按钮加到jpmsr3中
        jpmsr3.add(jpmsr_jb1);
        jpmsr3.add(jpmsr_jb2);

        jsp2 = new JScrollPane(jpmsr2);

        //将所有组件加到最大的jpmsr1中去（对jpmsr1初始化）
        jpmsr1.add(jpmsr3,"North");
        jpmsr1.add(jsp2,"Center");
        jpmsr1.add(jpmsr_jb3,"South");


        /* 处理第三张卡片（陌生人）*/
        jphmd_jb1 = new JButton("特别关心");
        jphmd_jb1.addActionListener(this);
        jphmd_jb2 = new JButton("我的好友");
        jphmd_jb2.addActionListener(this);
        jphmd_jb3 = new JButton("陌生人");
        jphmd1 = new JPanel(new BorderLayout());

        //假设有25个陌生人人员
        jphmd2 = new JPanel((new GridLayout(25,1,4,4)));
        //给jphmd2初始化5个陌生人人员
        jlbs3 = new JLabel[25];
        for(int i = 0;i < jlbs3.length;i++){
            jlbs3[i] = new JLabel(i+1+"",new ImageIcon("image/mine.jpg"),JLabel.LEFT);
            jlbs3[i].addMouseListener(this);
            jphmd2.add(jlbs3[i]);
        }

        jphmd3 = new JPanel(new GridLayout(3,1));
        //把两个按钮加到jphmd3中
        jphmd3.add(jphmd_jb1);
        jphmd3.add(jphmd_jb2);
        jphmd3.add(jphmd_jb3);


        jsp3 = new JScrollPane(jphmd2);

        //将所有组件加到最大的jpmsr1中去（对jpmsr1初始化）
        jphmd1.add(jphmd3,"North");
        jphmd1.add(jsp3,"Center");



        //添加到JFrame上
        cl = new CardLayout();
        this.setLayout(cl);
        this.add(jphy1,"1");
        this.add(jpmsr1,"2");
        this.add(jphmd1,"3");

        this.setVisible(true);
        this.setSize(200,400);
        this.setTitle(ownerId);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jphy_jb2||e.getSource()==jphmd_jb2){
            cl.show(this.getContentPane(),"2");
        }
        else if(e.getSource()==jpmsr_jb1||e.getSource()==jphmd_jb1){
            cl.show(this.getContentPane(),"1");
        }
        else if(e.getSource()==jphy_jb3||e.getSource()==jpmsr_jb3){
            cl.show(this.getContentPane(),"3");
        }
    }

    public void mouseClicked(MouseEvent e){
        //相应用户双击事件，并得到好友的名字
        if(e.getClickCount()==2){
            //获取好友的姓名
            String friendName = ((JLabel)e.getSource()).getText();
            //System.out.println("你将和" + friendName + "聊天！");
            qqChat qc = new qqChat(this.owner,friendName);
            //把聊天界面加入到管理类
            ManageQqChat.addQqChat(this.owner+" "+friendName, qc);
            /*
            Thread t = new Thread(qc);
            t.start();
            */
        }
    }
    public void mouseEntered(MouseEvent e){
        JLabel jl = (JLabel)e.getSource();
        jl.setForeground(Color.red);
    }
    public void mouseExited(MouseEvent e){
        JLabel jl = (JLabel)e.getSource();
        jl.setForeground(Color.black);
    }
    public void mousePressed(MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){

    }

    //添加新的在线好友
    public void updateFriendsList(Message m){
        //获取需要更新的好友列表信息
        String online_friends[] = m.getCon().split(" ");
        //遍历进行状态更新
        for(int i=0;i<online_friends.length;i++){
            //尝试对特别关心列表进行更新
            try {
                jlbs1[Integer.parseInt(online_friends[i]) - 1].setEnabled(true);
            }catch (Exception e){
                e.printStackTrace();
            }
            //尝试对好友列表进行更新（有待修改，需要加上用户名的基数）
            try {
                jlbs2[Integer.parseInt(online_friends[i]) - 1].setEnabled(true);
            }catch (Exception e){
                e.printStackTrace();
            }
            //尝试对黑名单列表进行更新（有待修改，需要加上用户名的基数）
            try {
                jlbs3[Integer.parseInt(online_friends[i]) - 1].setEnabled(true);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //变灰下线好友头像
    public void updateFriendsList2(Message m){
        //获取需要更新的好友列表信息
        String offline_friend = m.getCon();
        //尝试对特别关心列表进行更新
        try {
            jlbs1[Integer.parseInt(offline_friend)].setEnabled(false);
        }catch (Exception e){
            e.printStackTrace();
        }
        //尝试对好友列表进行更新（有待修改，需要加上用户名的基数）
        try {
            jlbs3[Integer.parseInt(offline_friend)].setEnabled(false);
        }catch (Exception e){
            e.printStackTrace();
        }
        //尝试对黑名单列表进行更新（有待修改，需要加上用户名的基数）
        try {
            jlbs3[Integer.parseInt(offline_friend)].setEnabled(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //退出时执行的操作Runtime类的addShutdownHook函数，参考：https://blog.csdn.net/qq7342272/article/details/6852734
    //添加需要在应用程序结束前执行的操作，例如关闭网络连接，关闭数据库等等
    //在这里我们向服务器发送一个下线操作
    public void doShutDownWork() {
        Runtime run=Runtime.getRuntime();//当前 Java 应用程序相关的运行时对象。
        run.addShutdownHook(new Thread(){ //注册新的虚拟机来关闭钩子
            @Override
            public void run() {
                //程序结束时进行的操作
                Message ms = new Message();
                ms.setSender(owner);
                ms.setMesType(MessageType.message_off_line);   //客户结束时，发送给服务器下线通知
                try{
                    ObjectOutputStream oos = new ObjectOutputStream(ManageClientConServerThread.getClientConServerThread(
                            owner).getS().getOutputStream());
                    oos.writeObject(ms);
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("程序结束调用");
            }
        });
    }

    public static void main(String args[]){
        //qqFriendsList qqfl = new qqFriendsList();
    }
}
