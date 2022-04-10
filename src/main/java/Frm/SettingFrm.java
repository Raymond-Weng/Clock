package Frm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SettingFrm {
    private static SettingFrm settingfrm = null;

    private JFrame frame;
    private JButton buttons[][];

    private SettingFrm() {

        frame = new JFrame();
        frame.setVisible(false);
        frame.setLayout(new GridLayout(3, 5));

        String texts[][] = {{"Hour +5", "Hour +1", "Hour reset", "Hour -1", "Hour -5"}, {"Minute +5", "Minute +1", "Minute reset", "Minute -1", "Minute -5"}, {"Second +5", "Second +1", "Second reset", "Second -1", "Second -5"}};

        buttons = new JButton[3][5];
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 5; k++) {
                buttons[i][k] = new JButton();
                buttons[i][k].setText(texts[i][k]);
                buttons[i][k].addActionListener(new SettingButtonListener(i, k));
                frame.getContentPane().add(buttons[i][k]);
            }
        }

        frame.pack();
        frame.setTitle("Clock Setting");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(false);
            }
        });
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static SettingFrm get() {
        if (settingfrm == null) {
            settingfrm = new SettingFrm();
        }
        return settingfrm;
    }

    public void dispose() {
        frame.dispose();
    }

    public void show() {
        frame.setVisible(true);
    }
}
