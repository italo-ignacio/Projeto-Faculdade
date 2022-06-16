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
import dao.ProfessorDAO;
import model.Aluno;
import model.Professor;

public class MostrarProf extends JFrame implements ActionListener {

	JScrollPane scroll = new JScrollPane();
	JTable table;
	JPanel panel;
	JButton back, update, delete;

	public MostrarProf() {

		setSize(1300, 437);
		setTitle("Professor");
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

		ProfessorDAO dao = new ProfessorDAO();

		DefaultTableModel dft = new DefaultTableModel();
		dft.setNumRows(0);
		dft.addColumn("Id");
		dft.addColumn("Identidade");
		dft.addColumn("Nome");
		dft.addColumn("Rua");
		dft.addColumn("Numero");
		dft.addColumn("Bairro");
		dft.addColumn("Cidade");
		dft.addColumn("Estado");
		dft.addColumn("Telefone");
		dft.addColumn("Celular");
		dft.addColumn("Nascimento");
		dft.addColumn("Especialidades");
		dft.addColumn("TituloProf");
		table = new JTable(dft);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(80);
		table.getColumnModel().getColumn(1).setMaxWidth(80);
		table.getColumnModel().getColumn(4).setMinWidth(50);
		table.getColumnModel().getColumn(4).setMaxWidth(50);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(6).setMaxWidth(75);
		table.getColumnModel().getColumn(7).setMinWidth(75);
		table.getColumnModel().getColumn(7).setMaxWidth(75);
		table.getColumnModel().getColumn(8).setMinWidth(97);
		table.getColumnModel().getColumn(8).setMaxWidth(97);
		table.getColumnModel().getColumn(9).setMinWidth(97);
		table.getColumnModel().getColumn(9).setMaxWidth(97);
		table.getColumnModel().getColumn(10).setMinWidth(72);
		table.getColumnModel().getColumn(10).setMaxWidth(72);
		scroll.setViewportView(table);
		scroll.setBounds(0, 100, 1290, 300);
		int i = 0;
		for (Professor d : dao.mostrarProfessores()) {
			dft.insertRow(i,
					new Object[] { d.getId(), d.getIdentidade(), d.getNome(), d.getRua(), d.getNum(), d.getBairro(),
							d.getCidade(), d.getEstado(), d.getTel(), d.getCel(), d.getDataNasc(),
							d.getEspecialidades(), d.getTitulos() });
			i++;
		}
	}

	public void updateActionPerformed(ActionEvent evt) {

		if (table.getSelectedRow() != -1) {

			Professor a = new Professor();
			ProfessorDAO dao = new ProfessorDAO();

			a.setIdentidade(table.getValueAt(table.getSelectedRow(), 1).toString());
			a.setNome(table.getValueAt(table.getSelectedRow(), 2).toString());
			a.setRua(table.getValueAt(table.getSelectedRow(), 3).toString());
			a.setNum(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString()));
			a.setBairro(table.getValueAt(table.getSelectedRow(), 5).toString());
			a.setCidade(table.getValueAt(table.getSelectedRow(), 6).toString());
			a.setEstado(table.getValueAt(table.getSelectedRow(), 7).toString());
			a.setTel(table.getValueAt(table.getSelectedRow(), 8).toString());
			a.setCel(table.getValueAt(table.getSelectedRow(), 9).toString());
			a.setDataNasc(table.getValueAt(table.getSelectedRow(), 10).toString());
			a.setEspecialidades(table.getValueAt(table.getSelectedRow(), 11).toString());
			a.setTitulos(table.getValueAt(table.getSelectedRow(), 12).toString());
			a.setId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));

			dao.atualizar(a);

			mostrar();
		}

	}

	public void deleteActionPerformed(ActionEvent evt) {

		if (table.getSelectedRow() != -1) {

			Professor a = new Professor();
			ProfessorDAO dao = new ProfessorDAO();

			a.setId(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));

			dao.delete(a);

			mostrar();
		}

	}

}
