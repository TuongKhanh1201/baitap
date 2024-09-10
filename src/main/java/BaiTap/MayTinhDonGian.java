/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTap;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class MayTinhDonGian extends JFrame {

    private JTextField txtDisplay;
    private JButton btReset;
    private JButton[] bt = new JButton[16];
    private String[] str = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", ".", "=", "/"};
    private String operator = "";
    private double result = 0;
    private boolean start = true;

    public MayTinhDonGian() {
        setTitle("Máy tính");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1 = new JPanel();
        p1.add(txtDisplay = new JTextField());
        txtDisplay.setPreferredSize(new Dimension(200, 30));
        p1.add(btReset = new JButton("C"));

        btReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText("");
            }
        }
        );

         JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 4, 5, 5));
        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton(str[i]);
            p2.add(bt[i]);
            // tiếp nhận sự kiện các nút
            bt[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String command = e.getActionCommand();
                    if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.equals(".")) {
                        if (start) {
                            txtDisplay.setText("");
                            start = false;
                        }
                        txtDisplay.setText(txtDisplay.getText() + command);
                    } else if (command.charAt(0) == '=') {
                        calculate();
                        operator = "";
                        start = true;
                    } else { // operator
                        if (!operator.isEmpty()) {
                            calculate();
                        } else {
                            result = Double.parseDouble(txtDisplay.getText());
                        }
                        operator = command;
                        txtDisplay.setText("");
                        start = false;
                    }
                }
            });
        }
        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
    }

    private void calculate() {
        double number = Double.parseDouble(txtDisplay.getText());
        switch (operator) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                if (number != 0) {
                    result /= number;
                } else {
                    txtDisplay.setText("Error");
                    return;
                }
                break;
        }
        txtDisplay.setText(String.valueOf(result));
    }

    public static void main(String[] args) {
        MayTinhDonGian frm = new MayTinhDonGian();
        frm.setVisible(true);
    }
}
