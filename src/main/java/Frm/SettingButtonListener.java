package Frm;

import Main.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingButtonListener implements ActionListener {
    private int rows;
    private int cols;

    public SettingButtonListener(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (rows) {
            case 0:
                switch (cols) {
                    case 0:
                        Main.get().setHour(Integer.parseInt(Main.get().getHour()) + 5);
                        break;
                    case 1:
                        Main.get().setHour(Integer.parseInt(Main.get().getHour()) + 1);
                        break;
                    case 2:
                        Main.get().setHour(0);
                        break;
                    case 3:
                        Main.get().setHour(Integer.parseInt(Main.get().getHour()) - 1);
                        break;
                    case 4:
                        Main.get().setHour(Integer.parseInt(Main.get().getHour()) - 5);
                        break;
                }
                break;
            case 1:
                switch (cols) {
                    case 0:
                        Main.get().setMin(Integer.parseInt(Main.get().getMin()) + 5);
                        break;
                    case 1:
                        Main.get().setMin(Integer.parseInt(Main.get().getMin()) + 1);
                        break;
                    case 2:
                        Main.get().setMin(0);
                        break;
                    case 3:
                        Main.get().setMin(Integer.parseInt(Main.get().getMin()) - 1);
                        break;
                    case 4:
                        Main.get().setMin(Integer.parseInt(Main.get().getMin()) - 5);
                        break;
                }
                break;
            case 2:
                switch (cols) {
                    case 0:
                        Main.get().setSec(Integer.parseInt(Main.get().getSec()) + 5);
                        break;
                    case 1:
                        Main.get().setSec(Integer.parseInt(Main.get().getSec()) + 1);
                        break;
                    case 2:
                        Main.get().setSec(0);
                        break;
                    case 3:
                        Main.get().setSec(Integer.parseInt(Main.get().getSec()) - 1);
                        break;
                    case 4:
                        Main.get().setSec(Integer.parseInt(Main.get().getSec()) - 5);
                        break;
                }
                break;
        }
    }
}
