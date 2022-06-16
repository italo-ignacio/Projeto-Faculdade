package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.Aluno;

public class MostrarAluno extends JFrame implements ActionListener {

	JScrollPane scroll = new JScrollPane();
	JTable table;
	JPanel panel;
	JButton back, update, delete;

	public MostrarAluno() {

		setSize(1300, 437);
		setTitle("Aluno");
		setResizable(false);
		setLocation(39, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setVisible(true);

		mostrar();
		panel = new JPanel();
		panel.setSize(1300, 300);
		panel.setLocation(0, 100);
		panel.setBackground(Color.WHITE);

		back = new JButton("Voltar");
		back.setSize(120, 30);
		back.setLocation(50, 50);
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		back.addActionListener(this);

		update = new JButton("Atualizar");
		update.setSize(120, 30);
		update.setLocation(900, 50);
		update.setFont(new Font("Arial", Font.BOLD, 20));
		update.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateActionPerformed(evt);
			}
		});

		delete = new JButton("Deletar");
		delete.setSize(120, 30);
		delete.setLocation(1050, 50);
		delete.setFont(new Font("Arial", Font.BOLD, 20));
		delete.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteActionPerformed(evt);
			}
		});

		getContentPane().add(scroll);
		getContentPane().add(back);
		getContentPane().add(update);
		getContentPane().add(delete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new Mostrar();
	}

	public void mostrar() {

		AlunoDAO dao = new AlunoDAO();

		DefaultTableModel dft = new DefaultTableModel();
		dft.setNumRows(0);
		dft.addColumn("Id");
		dft.addColumn("Matricula");
		dft.addColumn("Nome");
		dft.addColumn("Nascimento");
		dft.addColumn("Codigo do curso");
		dft.addColumn("Nome do curso");
		dft.addColumn("N1");
		dft.addColumn("N2");
		dft.addColumn("Media");
		dft.addColumn("Falta");
		dft.addColumn("Cod/Nome da diciplina");
		table = new JTable(dft);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(100);
		table.getColumnModel().getColumn(1).setMaxWidth(100);
		table.getColumnModel().getColumn(4).setMinWidth(100);
		table.getColumnModel().getColumn(4).setMaxWidth(100);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(3).setMaxWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(50);
		table.getColumnModel().getColumn(6).setMaxWidth(50);
		table.getColumnModel().getColumn(7).setMinWidth(50);
		table.getColumnModel().getColumn(7).setMaxWidth(50);
		table.getColumnModel().getColumn(8).setMinWidth(50);
		table.getColumnModel().getColumn(8).setMaxWidth(50);
		table.getColumnModel().getColumn(9).setMinWidth(50);
		table.getColumnModel().getColumn(9).setMaxWidth(50);
		scroll.setViewportView(table);
		scroll.setBounds(0, 100, 1290, 300);
		int i = 0;
		for (Aluno d : dao.mostrarAlunos()) {

			dft.insertRow(i, new Object[] { d.getId(), d.getMatricula(), d.getNome(), d.getDataNasc(), d.getCodCurso(),
					d.getNomeCurso(), d.getN1(), d.getN2(), d.getMedia(), d.getF(), d.getCodNome() });
			i++;
		}
	}

	public void updateActionPerformed(ActionEvent evt) {

		if (table.getSelectedRow() != -1) {

			Aluno a = new Aluno();
			AlunoDAO dao = new AlunoDAO();

			a.setMatricula(table.getValueAt(table.getSelectedRow(), 1).toString());
			a.setNome(table.getValueAt(table.getSelectedRow(), 2).toString());
			a.setDataNasc(table.getValueAt(table.getSelectedRow(), 3).toString());
			a.setCodCurso(table.getValueAt(table.getSelectedRow(), 4).toString());
			a.setNomeCurso(table.getValueAt(table.getSelectedRow(), 5).toString());
			a.setN1(Float.parseFloat(table.getValueAt(table.getSelectedRow(), 6).toString()));
			a.setN2(Float.parseFloat(table.getValueAt(table.getSelectedRow(), 7).toString()));
			a.setMedia(Float.parseFloat(table.getValueAt(table.getSelectedRow(), 8).toString()));
			a.setF(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 9).toString()));
			a.setCodNome(table.getValueAt(table.getSelectedRow(), 10).toString());
			a.setId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));

			dao.atualizar(a);

			mostrar();
		}

	}

	public void deleteActionPerformed(ActionEvent evt) {

		if (table.getSelectedRow() != -1) {

			Aluno a = new Aluno();
			AlunoDAO dao = new AlunoDAO();

			a.setId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));

			dao.delete(a);

			mostrar();
		}

	}
}
