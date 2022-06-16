package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.ProfessorDAO;
import model.Professor;

public class CadProf extends JFrame implements ActionListener {

	JLabel txtIdentProf, txtNomeProf, txtDataNasc, txtRua, txtNum, txtTel, txtBairro, txtEstado, txtCel,
			txtEspecialidade, txtTitulo, txtCidade;
	JTextField identProf, dataNasc, nomeProf, rua, tel, cel, bairro, estado, num, cidade;
	JPanel panelEspecProf, panelTituloProf;
	JCheckBox jrb_1, jrb_2, jrb_3, jrb_4, jrb_5, jrb_6, jrb_7, jrb_8;
	JButton exit, add;

	public CadProf() {
		setSize(600, 400);
		setTitle("Professor");
		setResizable(false);
		setLocation(400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
		getContentPane().setLayout(null);

		txtIdentProf = new JLabel("Identidade: ");
		txtIdentProf.setSize(160, 30);
		txtIdentProf.setLocation(30, 40);
		txtIdentProf.setForeground(Color.CYAN);
		txtIdentProf.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		try {
			identProf = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		identProf.setSize(100, 20);
		identProf.setLocation(120, 43);

		txtBairro = new JLabel("Bairro: ");
		txtBairro.setSize(60, 30);
		txtBairro.setLocation(290, 80);
		txtBairro.setForeground(Color.CYAN);
		txtBairro.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		bairro = new JTextField();
		bairro.setSize(100, 20);
		bairro.setLocation(340, 83);

		txtNomeProf = new JLabel("Nome: ");
		txtNomeProf.setSize(160, 30);
		txtNomeProf.setLocation(230, 40);
		txtNomeProf.setForeground(Color.CYAN);
		txtNomeProf.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		nomeProf = new JTextField();
		nomeProf.setSize(150, 20);
		nomeProf.setLocation(275, 43);

		txtDataNasc = new JLabel("Nasc: ");
		txtDataNasc.setSize(160, 30);
		txtDataNasc.setLocation(445, 40);
		txtDataNasc.setForeground(Color.CYAN);
		txtDataNasc.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		try {
			dataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dataNasc.setSize(70, 20);
		dataNasc.setLocation(485, 43);

		txtRua = new JLabel("Rua: ");
		txtRua.setSize(40, 30);
		txtRua.setLocation(30, 80);
		txtRua.setForeground(Color.CYAN);
		txtRua.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		rua = new JTextField();
		rua.setSize(130, 20);
		rua.setLocation(65, 83);

		txtNum = new JLabel("Num: ");
		txtNum.setSize(60, 30);
		txtNum.setLocation(208, 80);
		txtNum.setForeground(Color.CYAN);
		txtNum.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		num = new JTextField();
		num.setSize(35, 20);
		num.setLocation(250, 83);

		txtEstado = new JLabel("Estado: ");
		txtEstado.setSize(60, 30);
		txtEstado.setLocation(30, 120);
		txtEstado.setForeground(Color.CYAN);
		txtEstado.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		estado = new JTextField();
		estado.setSize(100, 20);
		estado.setLocation(90, 123);

		txtCidade = new JLabel("Cidade: ");
		txtCidade.setSize(60, 30);
		txtCidade.setLocation(200, 120);
		txtCidade.setForeground(Color.CYAN);
		txtCidade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		cidade = new JTextField();
		cidade.setSize(100, 20);
		cidade.setLocation(260, 123);

		txtTel = new JLabel("tel: ");
		txtTel.setSize(60, 30);
		txtTel.setLocation(400, 120);
		txtTel.setForeground(Color.CYAN);
		txtTel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		try {
			tel = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		tel.setSize(100, 20);
		tel.setLocation(430, 123);

		txtCel = new JLabel("cel: ");
		txtCel.setSize(60, 30);
		txtCel.setLocation(400, 150);
		txtCel.setForeground(Color.CYAN);
		txtCel.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		try {
			cel = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cel.setSize(100, 20);
		cel.setLocation(430, 153);

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

		txtEspecialidade = new JLabel("Especialidade: ");
		txtEspecialidade.setSize(130, 30);
		txtEspecialidade.setLocation(40, 160);
		txtEspecialidade.setForeground(Color.CYAN);
		txtEspecialidade.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		jrb_1 = new JCheckBox("Matematica");
		jrb_2 = new JCheckBox("Fisica");
		jrb_3 = new JCheckBox("Informatica");
		jrb_4 = new JCheckBox("Medicina");
		jrb_1.setBackground(Color.DARK_GRAY);
		jrb_1.setForeground(Color.cyan);
		jrb_2.setBackground(Color.DARK_GRAY);
		jrb_2.setForeground(Color.cyan);
		jrb_3.setBackground(Color.DARK_GRAY);
		jrb_3.setForeground(Color.cyan);
		jrb_4.setBackground(Color.DARK_GRAY);
		jrb_4.setForeground(Color.cyan);
		panelEspecProf = new JPanel();
		panelEspecProf.setBounds(100, 200, 120, 100);
		panelEspecProf.setBackground(Color.DARK_GRAY);
		panelEspecProf.setLayout(new GridLayout(6, 1));
		panelEspecProf.add(jrb_1);
		panelEspecProf.add(jrb_2);
		panelEspecProf.add(jrb_3);
		panelEspecProf.add(jrb_4);

		txtTitulo = new JLabel("Titulos: ");
		txtTitulo.setSize(130, 30);
		txtTitulo.setLocation(250, 160);
		txtTitulo.setForeground(Color.CYAN);
		txtTitulo.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		jrb_5 = new JCheckBox("Bacharelado");
		jrb_6 = new JCheckBox("Lato sensu");
		jrb_7 = new JCheckBox("Mestrado");
		jrb_8 = new JCheckBox("Doutorado");
		jrb_5.setBackground(Color.DARK_GRAY);
		jrb_5.setForeground(Color.cyan);
		jrb_6.setBackground(Color.DARK_GRAY);
		jrb_6.setForeground(Color.cyan);
		jrb_7.setBackground(Color.DARK_GRAY);
		jrb_7.setForeground(Color.cyan);
		jrb_8.setBackground(Color.DARK_GRAY);
		jrb_8.setForeground(Color.cyan);
		panelTituloProf = new JPanel();
		panelTituloProf.setBounds(280, 200, 120, 100);
		panelTituloProf.setBackground(Color.DARK_GRAY);
		panelTituloProf.setLayout(new GridLayout(6, 1));
		panelTituloProf.add(jrb_5);
		panelTituloProf.add(jrb_6);
		panelTituloProf.add(jrb_7);
		panelTituloProf.add(jrb_8);

		getContentPane().add(txtIdentProf);
		getContentPane().add(add);
		getContentPane().add(exit);
		getContentPane().add(identProf);
		getContentPane().add(nomeProf);
		getContentPane().add(txtNomeProf);
		getContentPane().add(rua);
		getContentPane().add(num);
		getContentPane().add(txtRua);
		getContentPane().add(txtNum);
		getContentPane().add(txtBairro);
		getContentPane().add(bairro);
		getContentPane().add(txtEstado);
		getContentPane().add(estado);
		getContentPane().add(txtTel);
		getContentPane().add(tel);
		getContentPane().add(txtCel);
		getContentPane().add(cel);
		getContentPane().add(panelEspecProf);
		getContentPane().add(txtDataNasc);
		getContentPane().add(dataNasc);
		getContentPane().add(txtEspecialidade);
		getContentPane().add(panelTituloProf);
		getContentPane().add(txtTitulo);
		getContentPane().add(txtCidade);
		getContentPane().add(cidade);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Cadastrar();
	}

	public void addActionPerformed(ActionEvent evt) {

		Professor p = new Professor();

		ProfessorDAO dao = new ProfessorDAO();

		p.setIdentidade(identProf.getText());
		p.setNome(nomeProf.getText());
		p.setDataNasc(dataNasc.getText());
		p.setRua(rua.getText());
		p.setNum(Integer.parseInt(num.getText()));
		p.setBairro(bairro.getText());
		p.setEstado(estado.getText());
		p.setCidade(cidade.getText());
		p.setTel(tel.getText());
		p.setCel(cel.getText());
		String es = "";
		if (jrb_1.isSelected()) {
			es += "/Matematica";
		}
		if (jrb_2.isSelected()) {
			es += "/Fisica";
		}
		if (jrb_3.isSelected()) {
			es += "/Informatica";
		}
		if (jrb_4.isSelected()) {
			es += "/Medicina";
		}
		p.setEspecialidades(es);

		String ti = "";
		if (jrb_5.isSelected()) {
			ti += "/Bacharelado";
		}
		if (jrb_6.isSelected()) {
			ti += "/Lato sensu";
		}
		if (jrb_7.isSelected()) {
			ti += "/Mestrado";
		}
		if (jrb_8.isSelected()) {
			ti += "/Doutorado";
		}
		p.setTitulos(ti);
		dao.add(p);
	}
}
