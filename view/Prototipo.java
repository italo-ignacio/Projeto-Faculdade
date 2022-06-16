package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prototipo extends JFrame implements ActionListener {

	JLabel txt;
	JButton profC, cursoD, profD, alunoD, cursoP,back;

	public Prototipo() {
		setSize(720, 540);
		setTitle("Prototipo");
		setResizable(false);
		setLocation(300, 120);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(0, 147, 147));
		setVisible(true);

		back = new JButton("Voltar");
		back.setSize(150, 50);
		back.setLocation(290, 250);
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		back.addActionListener(this);

 
		txt = new JLabel("Em construção");
		txt.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		txt.setLocation(290, 100);
		txt.setSize(300, 30);
		txt.setForeground(Color.BLACK);

		getContentPane().setLayout(null);
		getContentPane().add(back);
		getContentPane().add(txt);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Tela();

	}
 

}
