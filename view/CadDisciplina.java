package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dao.DisciplinaDAO;
import model.Disciplina;

public class CadDisciplina extends JFrame implements ActionListener {

	JLabel txtCodDisc, txtNomeDisc, txtCargaHoraria, txtAulasSemana;
	JTextField codDisc, nomeDisc, cargaHoraria;
	ButtonGroup grupAulasSemanais;
	JPanel panelAulasSemanais;
	JRadioButton jrb_1, jrb_2, jrb_3, jrb_4, jrb_5, jrb_6;
	JButton exit, add;

	public CadDisciplina() {
		setSize(600, 400);
		setTitle("Disciplina");
		setResizable(false);
		setLocation(400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setVisible(true);

		txtCodDisc = new JLabel("Codigo da disciplina: ");
		txtCodDisc.setSize(160, 30);
		txtCodDisc.setLocation(30, 40);
		txtCodDisc.setForeground(Color.CYAN);
		txtCodDisc.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		codDisc = new JTextField();
		codDisc.setSize(200, 20);
		codDisc.setLocation(180, 43);

		txtNomeDisc = new JLabel("Nome da disciplina: ");
		txtNomeDisc.setSize(160, 30);
		txtNomeDisc.setLocation(30, 80);
		txtNomeDisc.setForeground(Color.CYAN);
		txtNomeDisc.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		nomeDisc = new JTextField();
		nomeDisc.setSize(200, 20);
		nomeDisc.setLocation(180, 83);

		txtCargaHoraria = new JLabel("Carga horaria: ");
		txtCargaHoraria.setSize(160, 30);
		txtCargaHoraria.setLocation(30, 120);
		txtCargaHoraria.setForeground(Color.CYAN);
		txtCargaHoraria.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		cargaHoraria = new JTextField();
		cargaHoraria.setSize(35, 20);
		cargaHoraria.setLocation(135, 123);

		txtAulasSemana = new JLabel("Aulas semanais: ");
		txtAulasSemana.setSize(160, 30);
		txtAulasSemana.setLocation(30, 160);
		txtAulasSemana.setForeground(Color.CYAN);
		txtAulasSemana.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		jrb_1 = new JRadioButton("1");
		jrb_2 = new JRadioButton("2");
		jrb_3 = new JRadioButton("3");
		jrb_4 = new JRadioButton("4");
		jrb_5 = new JRadioButton("5");
		jrb_6 = new JRadioButton("6");

		grupAulasSemanais = new ButtonGroup();
		grupAulasSemanais.add(jrb_1);
		grupAulasSemanais.add(jrb_2);
		grupAulasSemanais.add(jrb_3);
		grupAulasSemanais.add(jrb_4);
		grupAulasSemanais.add(jrb_5);
		grupAulasSemanais.add(jrb_6);
		jrb_1.setBackground(Color.DARK_GRAY);
		jrb_1.setForeground(Color.cyan);
		jrb_2.setBackground(Color.DARK_GRAY);
		jrb_2.setForeground(Color.cyan);
		jrb_3.setBackground(Color.DARK_GRAY);
		jrb_3.setForeground(Color.cyan);
		jrb_4.setBackground(Color.DARK_GRAY);
		jrb_4.setForeground(Color.cyan);
		jrb_5.setBackground(Color.DARK_GRAY);
		jrb_5.setForeground(Color.cyan);
		jrb_6.setBackground(Color.DARK_GRAY);
		jrb_6.setForeground(Color.cyan);
		panelAulasSemanais = new JPanel();
		panelAulasSemanais.setBounds(160, 160, 50, 100);
		panelAulasSemanais.setBackground(Color.DARK_GRAY);
		panelAulasSemanais.setLayout(new GridLayout(6, 1));
		panelAulasSemanais.add(jrb_1);
		panelAulasSemanais.add(jrb_2);
		panelAulasSemanais.add(jrb_3);
		panelAulasSemanais.add(jrb_4);
		panelAulasSemanais.add(jrb_5);
		panelAulasSemanais.add(jrb_6);

		exit = new JButton("Voltar");
		exit.setSize(70, 25);
		exit.setLocation(50, 300);
		exit.setFont(new Font("Arial", Font.BOLD, 10));
		exit.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		exit.addActionListener(this);

		add = new JButton("Add");
		add.setSize(70, 25);
		add.setLocation(450, 300);
		add.setFont(new Font("Arial", Font.BOLD, 10));
		add.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addActionPerformed(evt);
			}
		});

		getContentPane().add(txtCodDisc);
		getContentPane().add(txtNomeDisc);
		getContentPane().add(txtCargaHoraria);
		getContentPane().add(txtAulasSemana);
		getContentPane().add(codDisc);
		getContentPane().add(nomeDisc);
		getContentPane().add(cargaHoraria);
		getContentPane().add(exit);
		getContentPane().add(add);
		getContentPane().add(panelAulasSemanais);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Cadastrar();
	}

	public void addActionPerformed(ActionEvent evt) {

		Disciplina d = new Disciplina();

		DisciplinaDAO dao = new DisciplinaDAO();

		d.setCargaHoraria(Integer.parseInt(cargaHoraria.getText()));
		d.setCodNome(codDisc.getText() + "//" + nomeDisc.getText());
		int as = 0;
		if (jrb_1.isSelected()) {
			as = 1;
		} else if (jrb_2.isSelected()) {
			as = 2;
		} else if (jrb_3.isSelected()) {
			as = 3;
		} else if (jrb_4.isSelected()) {
			as = 4;
		} else if (jrb_5.isSelected()) {
			as = 5;
		} else if (jrb_6.isSelected()) {
			as = 6;
		} else
			as = 0;
		d.setAulasSemanais(as);
		dao.add(d);

	}
}
