package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dao.CursoDAO;
import model.Curso;

public class CadCurso extends JFrame implements ActionListener {

	JLabel txtCodCurso, txtNomeCurso, txtTipoCurso, txtCargaHoraria, txtCodInstituto;
	DefaultListModel<String> DNomeCurso;
	JList<String> nomeCurso;
	JTextField codCurso, codInstituto, cargaHoraria;
	ButtonGroup grupTipoCurso;
	JPanel panelTipoCurso, nomeC;
	JRadioButton jrb_1, jrb_2, jrb_3, jrb_4;
	JButton exit, add;

	public CadCurso() {
		setSize(600, 400);
		setTitle("Curso");
		setResizable(false);
		setLocation(400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setVisible(true);

		txtCodCurso = new JLabel("Codigo do curso: ");
		txtCodCurso.setSize(160, 30);
		txtCodCurso.setLocation(30, 40);
		txtCodCurso.setForeground(Color.CYAN);
		txtCodCurso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		codCurso = new JTextField();
		codCurso.setSize(200, 20);
		codCurso.setLocation(180, 43);

		txtCodInstituto = new JLabel("Codigo do instituto: ");
		txtCodInstituto.setSize(160, 30);
		txtCodInstituto.setLocation(30, 80);
		txtCodInstituto.setForeground(Color.CYAN);
		txtCodInstituto.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		codInstituto = new JTextField();
		codInstituto.setSize(200, 20);
		codInstituto.setLocation(180, 83);

		txtCargaHoraria = new JLabel("Carga horaria: ");
		txtCargaHoraria.setSize(160, 30);
		txtCargaHoraria.setLocation(30, 120);
		txtCargaHoraria.setForeground(Color.CYAN);
		txtCargaHoraria.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		cargaHoraria = new JTextField();
		cargaHoraria.setSize(35, 20);
		cargaHoraria.setLocation(135, 123);

		txtTipoCurso = new JLabel("Tipo do curso: ");
		txtTipoCurso.setSize(160, 30);
		txtTipoCurso.setLocation(30, 160);
		txtTipoCurso.setForeground(Color.CYAN);
		txtTipoCurso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		jrb_1 = new JRadioButton("Gestao");
		jrb_2 = new JRadioButton("Bacharelado");
		jrb_3 = new JRadioButton("Mestrado");
		jrb_4 = new JRadioButton("Doutorado");

		grupTipoCurso = new ButtonGroup();
		grupTipoCurso.add(jrb_1);
		grupTipoCurso.add(jrb_2);
		grupTipoCurso.add(jrb_3);
		grupTipoCurso.add(jrb_4);
		jrb_1.setBackground(Color.DARK_GRAY);
		jrb_1.setForeground(Color.cyan);
		jrb_2.setBackground(Color.DARK_GRAY);
		jrb_2.setForeground(Color.cyan);
		jrb_3.setBackground(Color.DARK_GRAY);
		jrb_3.setForeground(Color.cyan);
		jrb_4.setBackground(Color.DARK_GRAY);
		jrb_4.setForeground(Color.cyan);
		panelTipoCurso = new JPanel();
		panelTipoCurso.setBounds(150, 160, 120, 100);
		panelTipoCurso.setBackground(Color.DARK_GRAY);
		panelTipoCurso.setLayout(new GridLayout(6, 1));
		panelTipoCurso.add(jrb_1);
		panelTipoCurso.add(jrb_2);
		panelTipoCurso.add(jrb_3);
		panelTipoCurso.add(jrb_4);

		txtNomeCurso = new JLabel("Nome do curso: ");
		txtNomeCurso.setSize(160, 30);
		txtNomeCurso.setLocation(350, 100);
		txtNomeCurso.setForeground(Color.CYAN);
		txtNomeCurso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		DNomeCurso = new DefaultListModel();
		DNomeCurso.addElement("Ciencias da Computacao");
		DNomeCurso.addElement("Sistemas de Informacoes");
		DNomeCurso.addElement("Direito");
		DNomeCurso.addElement("Educacao Fisica");
		DNomeCurso.addElement("Analise e desenvolvimento");
		DNomeCurso.addElement("Engenharia de ciberseguranca");
		DNomeCurso.addElement("Gestao de recursoso humanos");
		DNomeCurso.addElement("Administracao");
		DNomeCurso.addElement("Fisioterapia");
		DNomeCurso.addElement("Enfermagem");
		DNomeCurso.addElement("Medicina veterinaria");
		DNomeCurso.addElement("Design de moda");
		DNomeCurso.addElement("Comercio exterior");
		DNomeCurso.addElement("Psicologia");
		DNomeCurso.addElement("Cosmetica e imagem pessoal");
		DNomeCurso.addElement("Arquitetura e urbanismo");
		DNomeCurso.addElement("Publicidade e propaganda");
		DNomeCurso.addElement("Consultor de investimentos");
		DNomeCurso.addElement("Artes visuais");
		DNomeCurso.addElement("Engenheiro de dados ");
		DNomeCurso.addElement("Agronomia");
		DNomeCurso.addElement("Letras");
		DNomeCurso.addElement("Jornalismo");
		DNomeCurso.addElement("Odontologia");
		DNomeCurso.addElement("Fotografia");
		DNomeCurso.addElement("Biomedicina");
		nomeCurso = new JList(DNomeCurso);

		nomeC = new JPanel();
		nomeC.setSize(210, 150);
		nomeC.setLocation(320, 130);
		nomeC.setBackground(Color.WHITE);
		nomeC.add(new JScrollPane(nomeCurso));

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

		getContentPane().add(txtCodCurso);
		getContentPane().add(codCurso);
		getContentPane().add(txtCodInstituto);
		getContentPane().add(codInstituto);
		getContentPane().add(txtCargaHoraria);
		getContentPane().add(cargaHoraria);
		getContentPane().add(exit);
		getContentPane().add(panelTipoCurso);
		getContentPane().add(txtTipoCurso);
		getContentPane().add(nomeC);
		getContentPane().add(txtNomeCurso);
		getContentPane().add(add);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Cadastrar();
	}

	public void addActionPerformed(ActionEvent evt) {

		Curso c = new Curso();
		CursoDAO dao = new CursoDAO();

		c.setCargaHoraria(Integer.parseInt(cargaHoraria.getText()));
		c.setCodCurso(codCurso.getText());
		c.setCodInstituto(codInstituto.getText());
		c.setNomeCurso(nomeCurso.getSelectedValue());
		String tp = null;
		if (jrb_1.isSelected()) {
			tp = "Gestao";
		} else if (jrb_2.isSelected()) {
			tp = "Bacharelado";
		} else if (jrb_3.isSelected()) {
			tp = "Mestrado";
		} else if (jrb_4.isSelected()) {
			tp = "Doutorado";
		} else
			tp = null;
		c.setTipoCurso(tp);

		dao.add(c);
	}

}
