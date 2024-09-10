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
public class TinhToanDonGian extends JFrame {
    private JLabel lbl1,lbl2,lbl3;
    private JTextField txtSo1,txtSo2,txtKq;
    private JButton btCong,btTru,btNhan,btChia;
    public TinhToanDonGian(){
        setTitle ("Tính toán đơn giản");
        taoGiaoDien();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void taoGiaoDien() {
        JPanel p1= new JPanel();
        p1.setLayout(new GridLayout(3,2,5,5));
        p1.add(lbl1 = new JLabel("Số 1"));
        p1.add(txtSo1= new JTextField());
        txtSo1.setPreferredSize(new Dimension(100,30));
        p1.add(lbl2 = new JLabel("Số 2"));
        p1.add(txtSo2 = new JTextField());
        p1.add(lbl3= new JLabel("Kết quả"));
        p1.add(txtKq= new JTextField());
        
        JPanel p2= new JPanel();
        p2.add(btCong= new JButton("Cộng"));
        p2.add(btTru= new JButton("Trừ"));
        p2.add(btNhan=new JButton("Nhân"));
        p2.add(btChia= new JButton("Chia"));
        
        //set bo cuc cho thua chứa chính của cửa sổ
        setLayout(new BorderLayout());
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
        // tiếp nhận và xử lú sự kiện
        btCong.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq= x+y;
                txtKq.setText(String.valueOf(kq));
            }
        }
        );
         btTru.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq= x-y;
                txtKq.setText(String.valueOf(kq));
            }
        }
        );
          btNhan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq= x*y;
                txtKq.setText(String.valueOf(kq));
            }
        }
        );
           btChia.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double x = Double.parseDouble(txtSo1.getText());
                double y = Double.parseDouble(txtSo2.getText());
                double kq= x/y;
                txtKq.setText(String.valueOf(kq));
            }
        }
        );
    }
    public static void main(String[] args) {
        TinhToanDonGian frm = new TinhToanDonGian();
        frm.setVisible(true);
    }
    
}
