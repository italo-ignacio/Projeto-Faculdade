package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import dao.AlunoDAO;
import dao.DisciplinaDAO;
import model.Aluno;
import model.Disciplina;

public class CadAluno extends JFrame implements ActionListener {

	JLabel txtMatricula, txtNome, txtDataNasc, txtCodCurso, txtNomeCurso, txtNotas, txtn1, txtn2, txtm, txtf,
			txtCodDisc;
	JTextField matricula, nome, dataNasc, codCurso, nomeCurso, n1, n2, m, f;
	DefaultListModel<String> DNomeDisciplina;
	JPanel disc;
	JList<String> nomeDisciplina;
	JButton exit, add;

	public CadAluno() {
		setSize(600, 400);
		setTitle("Aluno");
		setResizable(false);
		setLocation(400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setVisible(true);

		txtMatricula = new JLabel("Matricula: ");
		txtMatricula.setSize(160, 30);
		txtMatricula.setLocation(30, 40);
		txtMatricula.setForeground(Color.CYAN);
		txtMatricula.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		matricula = new JTextField();
		matricula.setSize(100, 20);
		matricula.setLocation(100, 43);

		txtNome = new JLabel("Nome: ");
		txtNome.setSize(160, 30);
		txtNome.setLocation(230, 40);
		txtNome.setForeground(Color.CYAN);
		txtNome.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		nome = new JTextField();
		nome.setSize(150, 20);
		nome.setLocation(275, 43);

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

		txtCodCurso = new JLabel("Cod. Curso: ");
		txtCodCurso.setSize(100, 30);
		txtCodCurso.setLocation(30, 80);
		txtCodCurso.setForeground(Color.CYAN);
		txtCodCurso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		codCurso = new JTextField();
		codCurso.setSize(100, 20);
		codCurso.setLocation(115, 83);

		txtNomeCurso = new JLabel("Nome curso: ");
		txtNomeCurso.setSize(100, 30);
		txtNomeCurso.setLocation(240, 80);
		txtNomeCurso.setForeground(Color.CYAN);
		txtNomeCurso.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		nomeCurso = new JTextField();
		nomeCurso.setSize(145, 20);
		nomeCurso.setLocation(330, 83);

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

		txtNotas = new JLabel("Notas:");
		txtNotas.setSize(100, 30);
		txtNotas.setLocation(30, 120);
		txtNotas.setForeground(Color.CYAN);
		txtNotas.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		txtf = new JLabel("Faltas:");
		txtf.setSize(100, 30);
		txtf.setLocation(150, 120);
		txtf.setForeground(Color.CYAN);
		txtf.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		f = new JTextField();
		f.setSize(35, 20);
		f.setLocation(160, 153);

		txtn1 = new JLabel("NP1: ");
		txtn1.setSize(100, 30);
		txtn1.setLocation(60, 150);
		txtn1.setForeground(Color.CYAN);
		txtn1.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		n1 = new JTextField();
		n1.setSize(35, 20);
		n1.setLocation(100, 153);

		txtn2 = new JLabel("NP2: ");
		txtn2.setSize(100, 30);
		txtn2.setLocation(60, 190);
		txtn2.setForeground(Color.CYAN);
		txtn2.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		n2 = new JTextField();
		n2.setSize(35, 20);
		n2.setLocation(100, 193);

		txtm = new JLabel("Media: ");
		txtm.setSize(100, 30);
		txtm.setLocation(50, 230);
		txtm.setForeground(Color.CYAN);
		txtm.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		m = new JTextField();
		m.setSize(35, 20);
		m.setLocation(100, 233);

		txtCodDisc = new JLabel("Cod.disciplina:         Nome disciplina: ");
		txtCodDisc.setSize(300, 30);
		txtCodDisc.setLocation(240, 115);
		txtCodDisc.setForeground(Color.CYAN);
		txtCodDisc.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));

		DNomeDisciplina = new DefaultListModel();

		DNomeDisciplina.addElement("24586/Programacao Java");
		DNomeDisciplina.addElement("75964/Educacao fisica");
		DNomeDisciplina.addElement("14682/Programacao C");
		DNomeDisciplina.addElement("23549/Direito humanos");
		DNomeDisciplina.addElement("35485/Programacao Python");
		DNomeDisciplina.addElement("12597/Interface humano pc");
		DNomeDisciplina.addElement("32847/Ciencias sociais");
		DNomeDisciplina.addElement("25491/Educacao ambiental");
		DNomeDisciplina.addElement("26591/Estrutura de dados");
		DNomeDisciplina.addElement("32657/Matematica discreta");
		DNomeDisciplina.addElement("25491/Calculo para computacao");
		DNomeDisciplina.addElement("26591/Qualidade de software");
		DNomeDisciplina.addElement("32657/Sistemas operacionais");
		DNomeDisciplina.addElement("25498/Topicos de matematica aplicada");
		mostrarCod();
		nomeDisciplina = new JList<String>(DNomeDisciplina);

		disc = new JPanel();
		disc.setSize(260, 150);
		disc.setLocation(310, 145);
		disc.setBackground(Color.WHITE);
		disc.add(new JScrollPane(nomeDisciplina));

		getContentPane().add(add);
		getContentPane().add(exit);
		getContentPane().add(txtMatricula);
		getContentPane().add(txtNome);
		getContentPane().add(nome);
		getContentPane().add(txtDataNasc);
		getContentPane().add(dataNasc);
		getContentPane().add(matricula);
		getContentPane().add(txtCodCurso);
		getContentPane().add(codCurso);
		getContentPane().add(txtNomeCurso);
		getContentPane().add(nomeCurso);
		getContentPane().add(txtNotas);
		getContentPane().add(txtn1);
		getContentPane().add(n1);
		getContentPane().add(txtn2);
		getContentPane().add(n2);
		getContentPane().add(txtm);
		getContentPane().add(m);
		getContentPane().add(f);
		getContentPane().add(txtf);
		getContentPane().add(txtCodDisc);
		getContentPane().add(disc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Cadastrar();
	}

	public void addActionPerformed(ActionEvent evt) {

		Aluno a = new Aluno();
		AlunoDAO dao = new AlunoDAO();

		a.setNome(nome.getText());
		a.setMatricula(matricula.getText());
		a.setCodCurso(codCurso.getText());
		a.setDataNasc(dataNasc.getText());
		a.setNomeCurso(nomeCurso.getText());
		a.setF(Integer.parseInt(f.getText()));
		a.setN1(Float.parseFloat(n1.getText()));
		a.setN1(Float.parseFloat(n2.getText()));
		a.setMedia(Float.parseFloat(m.getText()));
		a.setCodNome(nomeDisciplina.getSelectedValue());
		dao.add(a);
	}

	public void mostrarCod() {
		DisciplinaDAO dDAO = new DisciplinaDAO();

		for (Disciplina di : dDAO.codNome()) {
			DNomeDisciplina.addElement(di.getCodNome());
		}

	}
}
