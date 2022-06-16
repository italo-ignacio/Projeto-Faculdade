package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import model.Disciplina;

public class DisciplinaDAO {

	public void add(Disciplina d) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"INSERT INTO disciplina (CodNomeDiciplina,CargaHoraria,AulasSemana) VALUES (?,?,?)");
			ps.setString(1, d.getCodNome());
			ps.setInt(2, d.getCargaHoraria());
			ps.setInt(3, d.getAulasSemanais());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error:" + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}

	public List<Disciplina> codNome() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Disciplina> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT CodNomeDiciplina FROM disciplina");
			rs = ps.executeQuery();

			while (rs.next()) {
				Disciplina di = new Disciplina();
				di.setCodNome(rs.getString("CodNomeDiciplina"));
				cur.add(di);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}

	public List<Disciplina> mostrarDisciplinas() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Disciplina> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT * FROM disciplina");
			rs = ps.executeQuery();

			while (rs.next()) {
				Disciplina di = new Disciplina();
				di.setId(rs.getInt("id"));
				di.setCodNome(rs.getString("CodNomeDiciplina"));
				di.setCargaHoraria(rs.getInt("CargaHoraria"));
				di.setAulasSemanais(rs.getInt("AulasSemana"));
				cur.add(di);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}

	public void atualizar(Disciplina a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE disciplina SET CodNomeDiciplina = ? , CargaHoraria = ? ,AulasSemana = ? WHERE id = ? ");
			ps.setString(1, a.getCodNome());
			ps.setInt(2, a.getCargaHoraria());
			ps.setInt(3, a.getAulasSemanais());
			ps.setInt(4, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}

	public void delete(Disciplina a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("DELETE FROM disciplina WHERE id = ? ");
			ps.setInt(1, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Deletado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}
}
