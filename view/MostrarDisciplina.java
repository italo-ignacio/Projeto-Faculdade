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
import dao.DisciplinaDAO;
import model.Aluno;
import model.Disciplina;

public class MostrarDisciplina extends JFrame implements ActionListener {

	JScrollPane scroll = new JScrollPane();
	JTable table;
	JPanel panel;
	JButton back, update, delete;

	public MostrarDisciplina() {

		setSize(600, 437);
		setTitle("Disciplina");
		setResizable(false);
		setLocation(400, 250);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setVisible(true);

		mostrar();
		panel = new JPanel();
		panel.setSize(600, 300);
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
		update.setLocation(250, 50);
		update.setFont(new Font("Arial", Font.BOLD, 20));
		update.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateActionPerformed(evt);
			}
		});

		delete = new JButton("deletar");
		delete.setSize(120, 30);
		delete.setLocation(400, 50);
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

		DisciplinaDAO dao = new DisciplinaDAO();

		DefaultTableModel dft = new DefaultTableModel();
		dft.setNumRows(0);
		dft.addColumn("Id");
		dft.addColumn("Cod//Nome da disciplina");
		dft.addColumn("Carga Horaria");
		dft.addColumn("Aulas semanais");

		table = new JTable(dft);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(125);
		table.getColumnModel().getColumn(2).setMaxWidth(125);
		table.getColumnModel().getColumn(3).setMinWidth(125);
		table.getColumnModel().getColumn(3).setMaxWidth(125);
		scroll.setViewportView(table);
		scroll.setBounds(0, 100, 590, 300);
		int i = 0;
		for (Disciplina d : dao.mostrarDisciplinas()) {

			dft.insertRow(i, new Object[] { d.getId(), d.getCodNome(), d.getCargaHoraria(), d.getAulasSemanais() });
			i++;
		}
	}

	public void updateActionPerformed(ActionEvent evt) {

		if (table.getSelectedRow() != -1) {

			Disciplina a = new Disciplina();
			DisciplinaDAO dao = new DisciplinaDAO();

			a.setCodNome(table.getValueAt(table.getSelectedRow(), 1).toString());
			a.setCargaHoraria(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 2).toString()));
			a.setAulasSemanais(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 3).toString()));
			a.setId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));

			dao.atualizar(a);

			mostrar();
		}

	}

	public void deleteActionPerformed(ActionEvent evt) {

		if (table.getSelectedRow() != -1) {

			Disciplina a = new Disciplina();
			DisciplinaDAO dao = new DisciplinaDAO();

			a.setId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));

			dao.delete(a);

			mostrar();
		}

	}

}
