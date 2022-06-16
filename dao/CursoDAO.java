package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import model.Curso;

public class CursoDAO {

	public void add(Curso c) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"INSERT INTO curso (CodCurso,NomeCurso,TipoCurso,CargaHoraria,CodInstituto) VALUES (?,?,?,?,?)");
			ps.setString(1, c.getCodCurso());
			ps.setString(2, c.getNomeCurso());
			ps.setString(3, c.getTipoCurso());
			ps.setInt(4, c.getCargaHoraria());
			ps.setString(5, c.getCodInstituto());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}

	public List<Curso> lerNomeCurso() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Curso> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT NomeCurso FROM curso");
			rs = ps.executeQuery();

			while (rs.next()) {
				Curso c = new Curso();
				c.setNomeCurso(rs.getString("NomeCurso"));
				cur.add(c);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error : " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}

	public List<Curso> mostrarCursos() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Curso> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT * FROM curso");
			rs = ps.executeQuery();

			while (rs.next()) {
				Curso di = new Curso();
				di.setId(rs.getInt("id"));
				di.setCodCurso(rs.getString("CodCurso"));
				di.setNomeCurso(rs.getString("NomeCurso"));
				di.setTipoCurso(rs.getString("TipoCurso"));
				di.setCodInstituto(rs.getString("CodInstituto"));
				di.setCargaHoraria(rs.getInt("CargaHoraria"));
				cur.add(di);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}

	public void atualizar(Curso a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE curso SET CodCurso = ? ,NomeCurso = ? ,TipoCurso = ? ,CargaHoraria = ? ,CodInstituto = ? WHERE id = ? ");

			ps.setString(1, a.getCodCurso());
			ps.setString(2, a.getNomeCurso());
			ps.setString(3, a.getTipoCurso());
			ps.setInt(4, a.getCargaHoraria());
			ps.setString(5, a.getCodInstituto());
			ps.setInt(6, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}

	public void delete(Curso a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("DELETE FROM curso WHERE id = ? ");
			ps.setInt(1, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Deletado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}
	
	public List<Curso> mostrarDisciplinas() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Curso> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT id,CodCurso,NomeCurso,disciplinas FROM curso");
			rs = ps.executeQuery();

			while (rs.next()) {
				Curso di = new Curso();
				di.setId(rs.getInt("id"));
				di.setCodCurso(rs.getString("CodCurso"));
				di.setNomeCurso(rs.getString("NomeCurso"));
				di.setDisciplinas(rs.getString("disciplinas")); 
				cur.add(di);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}
	
	public void atualizarDisciplinas(Curso a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE curso SET disciplinas = ? WHERE id = ? ");

			ps.setString(1, a.getDisciplinas());
			ps.setInt(2, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}
	
	public List<Curso> mostrarProfessores() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Curso> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT id,CodCurso,NomeCurso,professores FROM curso");
			rs = ps.executeQuery();

			while (rs.next()) {
				Curso di = new Curso();
				di.setId(rs.getInt("id"));
				di.setCodCurso(rs.getString("CodCurso"));
				di.setNomeCurso(rs.getString("NomeCurso"));
				di.setProfessores(rs.getString("professores")); 
				cur.add(di);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}
	
	public void atualizarProfessores(Curso a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE curso SET professores = ? WHERE id = ? ");

			ps.setString(1, a.getProfessores());
			ps.setInt(2, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}
}
