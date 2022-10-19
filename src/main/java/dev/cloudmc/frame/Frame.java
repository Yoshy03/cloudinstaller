package dev.cloudmc.frame;

import dev.cloudmc.utils.FileUtils;
import dev.cloudmc.utils.ReferenceUtils;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Frame extends JFrame {

    private boolean installed;

    public Frame() {
        initComponents();
    }

    public static void create() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Frame frame = new Frame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle(ReferenceUtils.name + " Client Installer");
        frame.setSize(700, 380);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new Color(0, 0, 0));
        panel.setLayout(null);

        button.setFont(new Font("Product Sans", Font.BOLD, 36));
        button.setText("Install");
        button.setFocusPainted(false);
        button.setFocusable(false);
        button.setRequestFocusEnabled(false);
        button.setRolloverEnabled(false);
        panel.add(button);
        button.setBounds(170, 130, 360, 90);
        button.addActionListener(e -> actionPerformed());

        label1.setFont(new Font("Product Sans", Font.PLAIN, 12));
        label1.setForeground(new Color(255, 255, 255));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label1);
        label1.setBounds(170, 220, 360, 20);

        label2.setBackground(new Color(0, 0, 0));

        label3.setBackground(new Color(0, 0, 0));

        label4.setBackground(new Color(29, 29, 29));
        label4.setForeground(new Color(51, 51, 51));

        GroupLayout layout1 = new GroupLayout(label4);
        label4.setLayout(layout1);
        layout1.setHorizontalGroup(
                layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        layout1.setVerticalGroup(
                layout1.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 89, Short.MAX_VALUE)
        );

        GroupLayout layout2 = new GroupLayout(label3);
        label3.setLayout(layout2);
        layout2.setHorizontalGroup(
                layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout2.setVerticalGroup(
                layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout2.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        label5.setBackground(new Color(0, 0, 0));
        label5.setFont(new Font("Product Sans", Font.PLAIN, 18));
        label5.setForeground(new Color(60, 60, 60));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setText("Cloud Client, cloudmc.dev 2022");

        label6.setBackground(new Color(0, 0, 0));
        label6.setFont(new Font("Product Sans", Font.PLAIN, 18));
        label6.setForeground(new Color(60, 60, 60));
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setText("Not affiliated with Mojang Studios");

        GroupLayout layout3 = new GroupLayout(label2);
        label2.setLayout(layout3);
        layout3.setHorizontalGroup(
                layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout3.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 232, Short.MAX_VALUE))
        );
        layout3.setVerticalGroup(
                layout3.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout3.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout3.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout3.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.add(label2);
        label2.setBounds(0, 260, 900, 80);

        label7.setIcon(new ImageIcon(ClassLoader.getSystemResource("panorama.png")));
        label7.setText("jLabel1");
        panel.add(label7);
        label7.setBounds(0, 87, 690, 690);

        label8.setBackground(new Color(0, 0, 0));
        label8.setFont(new Font("Product Sans", Font.BOLD, 36)); // NOI18N
        label8.setForeground(new Color(255, 255, 255));
        label8.setHorizontalAlignment(SwingConstants.CENTER);
        label8.setText("Cloud Client Installer");
        panel.add(label8);
        label8.setBounds(150, 20, 390, 50);

        getContentPane().add(panel, BorderLayout.CENTER);

        pack();
    }

    JPanel panel = new JPanel();
    JButton button = new JButton();
    JLabel label1 = new JLabel();
    JPanel label2 = new JPanel();
    JPanel label3 = new JPanel();
    JPanel label4 = new JPanel();
    JLabel label5 = new JLabel();
    JLabel label6 = new JLabel();
    JLabel label7 = new JLabel();
    JLabel label8 = new JLabel();

    private void actionPerformed(){
        if(!installed){
            try {
                FileUtils.saveFile(
                        ReferenceUtils.clientJar,
                        ReferenceUtils.clientJarName,
                        ReferenceUtils.getModsDirectory()
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            installed = true;
            button.setEnabled(false);

            label1.setText("Installed mod in " + ReferenceUtils.getModsDirectory());
        }
    }
}