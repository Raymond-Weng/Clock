package Frm;

import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TimeFrm {
    private static TimeFrm timefrm = null;

    private JFrame frame;
    private JLabel[] labels;

    private TimeFrm() {
        frame = new JFrame();
        frame.setVisible(false);
        frame.setLayout(new GridLayout(1, 5));
        labels = new JLabel[8];
        for (int i = 0; i < 8; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon("./numbers/0.png"));
            labels[i].setFocusable(false);
            frame.getContentPane().add(labels[i]);
        }
        labels[2].setIcon(new ImageIcon("./numbers/colon.png"));
        labels[5].setIcon(new ImageIcon("./numbers/colon.png"));
        frame.pack();
        frame.setTitle("Clock (Press S to open the setting ,and A is for alarm.)");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                SettingFrm.get().dispose();
            }
        });
        frame.setResizable(false);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    SettingFrm.get().show();
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    String string = JOptionPane.showInputDialog(null, "Input the time of the alarm ,and input nothing to set it off.(ex.10:10:00)", "Input", JOptionPane.INFORMATION_MESSAGE);
                    if (!(string.equals(""))) {
                        String strings[] = string.split(":");
                        boolean boolean1 = strings.length != 3 | strings[0].length() != 2 | strings[1].length() != 2 | strings[2].length() != 2;
                        boolean boolean2 = Integer.parseInt(strings[0]) > 24 | Integer.parseInt(strings[0]) < 0 | Integer.parseInt(strings[1]) > 60 | Integer.parseInt(strings[1]) < 0 | Integer.parseInt(strings[2]) > 60 | Integer.parseInt(strings[2]) < 0;
                        if (boolean1 | boolean2) {
                            JOptionPane.showMessageDialog(null, "Wrong input ,please try again.", "Wrong input", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            Main.get().setAlarmTime(string);
                            Main.get().setAlarmOn(true);
                        }
                    } else {
                        Main.get().setAlarmOn(false);
                    }
                }
            }
        });
        frame.setVisible(true);
        this.update();
    }

    public static TimeFrm get() {
        if (timefrm == null) {
            timefrm = new TimeFrm();
        }
        return timefrm;
    }

    public void update() {
        labels[0].setIcon(new ImageIcon("./numbers/" +
                (Main.get().getHour().substring(0, 1)) + ".png"));

        labels[1].setIcon(new ImageIcon("./numbers/" +
                (Main.get().getHour().substring(1, 2)) + ".png"));

        labels[3].setIcon(new ImageIcon("./numbers/" +
                (Main.get().getMin().substring(0, 1)) + ".png"));

        labels[4].setIcon(new ImageIcon("./numbers/" +
                (Main.get().getMin().substring(1, 2)) + ".png"));

        labels[6].setIcon(new ImageIcon("./numbers/" +
                (Main.get().getSec().substring(0, 1)) + ".png"));

        labels[7].setIcon(new ImageIcon("./numbers/" +
                (Main.get().getSec().substring(1, 2)) + ".png"));
    }
}
