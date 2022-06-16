package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cadastrar extends JFrame implements ActionListener {

	JLabel txt;
	JButton curso, disciplina, aluno, prof, back;

	public Cadastrar() {
		setSize(720, 540);
		setTitle("Cadastro");
		setResizable(false);
		setLocation(300, 120);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(196, 052, 130));
		setVisible(true);

		back = new JButton("Voltar");
		back.setSize(150, 50);
		back.setLocation(280, 350);
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		back.addActionListener(this);

		curso = new JButton("Curso");
		curso.setSize(150, 50);
		curso.setLocation(280, 200);
		curso.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		curso.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		curso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cursoActionPerformed(evt);
			}
		});

		disciplina = new JButton("Disciplina");
		disciplina.setSize(150, 50);
		disciplina.setLocation(280, 50);
		disciplina.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		disciplina.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		disciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				disciplinaActionPerformed(evt);
			}
		});

		aluno = new JButton("Aluno");
		aluno.setSize(150, 50);
		aluno.setLocation(280, 125);
		aluno.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		aluno.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		aluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				alunoActionPerformed(evt);
			}
		});

		prof = new JButton("Professor");
		prof.setSize(150, 50);
		prof.setLocation(280, 275);
		prof.setFont(new Font("Arial", Font.BOLD, 20));
		prof.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		prof.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				profActionPerformed(evt);
			}
		});

		txt = new JLabel("O que voce deseja cadastar?");
		txt.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		txt.setLocation(230, 3);
		txt.setSize(300, 30);
		txt.setForeground(Color.BLACK);

		getContentPane().setLayout(null);
		getContentPane().add(back);
		getContentPane().add(aluno);
		getContentPane().add(disciplina);
		getContentPane().add(curso);
		getContentPane().add(prof);
		getContentPane().add(txt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Tela();

	}

	public void cursoActionPerformed(ActionEvent evt) {
		new CadCurso();
		this.dispose();
	}

	public void disciplinaActionPerformed(ActionEvent evt) {
		new CadDisciplina();
		this.dispose();
	}

	public void alunoActionPerformed(ActionEvent evt) {
		new CadAluno();
		this.dispose();
	}

	public void profActionPerformed(ActionEvent evt) {
		new CadProf();
		this.dispose();
	}
}
