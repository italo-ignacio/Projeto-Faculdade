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
		back.setLocation(290, 425);
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		back.addActionListener(this);

		profC = new JButton("Professores e seus cursos");
		profC.setSize(330, 50);
		profC.setLocation(200, 50);
		profC.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		profC.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		profC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				profCActionPerformed(evt);
			}
		});

		cursoD = new JButton("Cursos e suas disciplinas");
		cursoD.setSize(330, 50);
		cursoD.setLocation(200, 125);
		cursoD.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		cursoD.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		cursoD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cursoDActionPerformed(evt);
			}
		});

		profD = new JButton("Professores e suas disciplinas");
		profD.setSize(330, 50);
		profD.setLocation(200, 200);
		profD.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		profD.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		profD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				profDActionPerformed(evt);
			}
		});

		alunoD = new JButton("Aluno e suas disciplinas");
		alunoD.setSize(330, 50);
		alunoD.setLocation(200, 275);
		alunoD.setFont(new Font("Arial", Font.BOLD, 20));
		alunoD.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		alunoD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				alunoDActionPerformed(evt);
			}
		});
		
		cursoP = new JButton("Cursos e seus professores");
		cursoP.setSize(330, 50);
		cursoP.setLocation(200, 350);
		cursoP.setFont(new Font("Arial", Font.BOLD, 20));
		cursoP.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		cursoP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cursoPActionPerformed(evt);
			}
		});

		txt = new JLabel("O que voce deseja ver?");
		txt.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		txt.setLocation(230, 3);
		txt.setSize(300, 30);
		txt.setForeground(Color.BLACK);

		getContentPane().setLayout(null);
		getContentPane().add(back);
		getContentPane().add(profD);
		getContentPane().add(cursoD);
		getContentPane().add(profC);
		getContentPane().add(alunoD);
		getContentPane().add(cursoP);
		//getContentPane().add(txt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Tela();

	}

	public void profCActionPerformed(ActionEvent evt) {
		this.dispose();
		new ProtProfC();
	}

	public void cursoDActionPerformed(ActionEvent evt) {
		this.dispose();
		new ProtCursoD();
		 

	}

	public void profDActionPerformed(ActionEvent evt) {
		this.dispose();
		new ProtProfD();
	}

	public void alunoDActionPerformed(ActionEvent evt) {
		this.dispose();
		new ProtAlunoD();
		 
	}
	public void cursoPActionPerformed(ActionEvent evt) {
		this.dispose();
		new ProtCursoP();
		 
	}


}
