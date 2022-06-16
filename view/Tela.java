package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tela extends JFrame implements ActionListener {

	JLabel txt;
	JButton cadastrar, mostrar, exit,prototipo;

	public Tela() {
		setSize(720, 540);
		setTitle("Trabalho");
		setResizable(false);
		setLocation(300, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(27, 45, 140));
		setVisible(true);

		exit = new JButton("Sair");
		exit.setSize(150, 50);
		exit.setLocation(280, 275);
		exit.setFont(new Font("Arial", Font.BOLD, 20));
		exit.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		exit.addActionListener(this);

		cadastrar = new JButton("Cadastrar");
		cadastrar.setSize(150, 50);
		cadastrar.setLocation(280, 50);
		cadastrar.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		cadastrar.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cadastrarActionPerformed(evt);
			}
		});

		mostrar = new JButton("Visualizar");
		mostrar.setSize(150, 50);
		mostrar.setLocation(280, 125);
		mostrar.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		mostrar.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mostrarActionPerformed(evt);
			}
		});
		
		prototipo = new JButton("Prototipos");
		prototipo.setSize(150, 50);
		prototipo.setLocation(280, 200);
		prototipo.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		
		prototipo.setCursor(new java.awt.Cursor(Cursor.HAND_CURSOR) {
		});
		prototipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				prototipoActionPerformed(evt);
			}
		});


		txt = new JLabel("O que voce deseja fazer ?");
		txt.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
		txt.setLocation(230, 3);
		txt.setSize(300, 30);
		txt.setForeground(Color.BLACK);

		getContentPane().setLayout(null);
		getContentPane().add(exit);
		getContentPane().add(cadastrar);
		getContentPane().add(mostrar);
		getContentPane().add(txt);
		getContentPane().add(prototipo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int i = JOptionPane.showConfirmDialog(null, "Deseja sair?");
		if(i == JOptionPane.YES_OPTION) {
		System.exit(0);
		}
	}

	public void cadastrarActionPerformed(ActionEvent evt) {

		new Cadastrar();
		this.dispose();
	}
	
	public void mostrarActionPerformed(ActionEvent evt) {
		new Mostrar();
		this.dispose();
	}

	public void prototipoActionPerformed(ActionEvent evt) {
		new Prototipo();
		this.dispose();
	}
}
