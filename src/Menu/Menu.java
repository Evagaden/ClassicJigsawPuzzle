package Menu;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


import GUI.ClassicJigsawPuzzle;
import Playmusic.sound;
public class Menu extends JFrame implements ActionListener
{
    int i = 0;
    int index = 60;
    int[] lev = {60,35,10};

    Timer timer;
    String[] s = {"Easy", "Medium", "Hard"};
    Container cn = this.getContentPane();
    JPanel pn = new JPanel();
    JButton start = new JButton("START");
    JButton next = new JButton();
    JButton pre = new JButton();

    JButton up = new JButton();
    JButton down = new JButton();
    JButton right = new JButton();
    JButton left = new JButton();

    Image img = getToolkit().getImage("C:\\For Code\\TestJava1\\src\\Background\\R.png");

    JLabel lblv = new JLabel();

    Font fo = new Font("Comic Sans MS", Font.BOLD, 18);
    Font f1 = new Font("Arial", Font.ITALIC, 22);
    public Menu() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        super("MENU");
        pn.setLayout(null);

        start.setFont(fo);
        start.setBackground(Color.decode("#3cd500"));
        start.setForeground(Color.decode("#ffffea"));
        start.setBounds(200,160,100,50);
        start.setBorder(BorderFactory.createRaisedBevelBorder());
        start.addActionListener(this);

        next.setBounds (320,260,30,30);
        next.setIcon(getIcon("Rc", 30, 30));
        next.addActionListener(this);

        pre.setBounds (150,260,30,30);
        pre.setIcon(getIcon("Lc", 30, 30));
        pre.addActionListener(this);

        up.setBounds (100,340,50,50);
        up.setIcon(getIcon("U", 50, 50));
        Label lbu = new Label("use to turn Right");
        lbu.setFont(f1);
        lbu.setForeground(Color.decode("#4ac2eb"));
        lbu.setBounds(175,340,225,50);

        down.setBounds (100,415,50,50);
        down.setIcon(getIcon("D", 50, 50));
        Label lbd = new Label("use to Down");
        lbd.setFont(f1);
        lbd.setForeground(Color.decode("#4ac2eb"));
        lbd.setBounds(175,415,225,50);

        right.setBounds (100,490,50,50);
        right.setIcon(getIcon("R", 50, 50));
        Label lbr = new Label("use to move to Right");
        lbr.setFont(f1);
        lbr.setForeground(Color.decode("#4ac2eb"));
        lbr.setBounds(175,490,225,50);

        left.setBounds (100,565,50,50);
        left.setIcon(getIcon("L", 50, 50));
        Label lbl = new Label("use to move to Left");
        lbl.setFont(f1);
        lbl.setForeground(Color.decode("#4ac2eb"));
        lbl.setBounds(175,565,225,50);

        lblv.setText(s[0]);
        lblv.setFont(fo);
        lblv.setHorizontalAlignment(JTextField.CENTER);
        lblv.setForeground(Color.decode("#4ac2eb"));
        lblv.setBounds(200,240,100,70);

        pn.add(start);
        pn.add(next);
        pn.add(pre);
        pn.add(up);
        pn.add(down);
        pn.add(right);
        pn.add(left);
        pn.add(lbu);
        pn.add(lbd);
        pn.add(lbr);
        pn.add(lbl);
        pn.add(lblv);
        cn.add(pn);

        new sound(5);
        timer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new sound(5);
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        timer.start();

        setSize(500,780);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == start)
        {
            new ClassicJigsawPuzzle(index);
            setVisible(false);
        }
        else if(e.getSource() == next)
        {
            if(i < 2)
            {
                i++;
            }
            else
            {
                i = 0;
            }
            lblv.setText(s[i]);
            index = lev[i];
        }
        else if(e.getSource() == pre)
        {
            if(i > 0)
            {
                i--;
            }
            else
            {
                i = 2;
            }
            lblv.setText(s[i]);
            index = lev[i];
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(img,0,0,this);
    }

    public Icon getIcon(String index, int w, int h) {
        Image image = new ImageIcon(getClass().getResource("/arrow/" + index + ".png")).getImage();
        Icon ic = new ImageIcon(image.getScaledInstance(w, h, image.SCALE_SMOOTH));
        return ic;
    }

}

