package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import model.Aluno;

public class AlunoDAO {

	public void add(Aluno a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"INSERT INTO aluno (Matricula,Nome,DataNasc,CodCurso,NomeCurso,N1,N2,Media,Falta,CodNomeDiciplina) VALUES (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, a.getMatricula());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getDataNasc());
			ps.setString(4, a.getCodCurso());
			ps.setString(5, a.getNomeCurso());
			ps.setFloat(6, a.getN1());
			ps.setFloat(7, a.getN2());
			ps.setFloat(8, a.getMedia());
			ps.setInt(9, a.getF());
			ps.setString(10, a.getCodNome());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}

	public List<Aluno> mostrarAlunos() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Aluno> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT * FROM aluno");
			rs = ps.executeQuery();

			while (rs.next()) {
				Aluno di = new Aluno();
				di.setId(rs.getInt("id"));
				di.setMatricula(rs.getString("Matricula"));
				di.setNome(rs.getString("Nome"));
				di.setDataNasc(rs.getString("DataNasc"));
				di.setCodCurso(rs.getString("CodCurso"));
				di.setNomeCurso(rs.getString("NomeCurso"));
				di.setN1(rs.getFloat("N1"));
				di.setN2(rs.getFloat("N2"));
				di.setMedia(rs.getFloat("Media"));
				di.setF(rs.getInt("Falta"));
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

	public void atualizar(Aluno a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE aluno SET Matricula = ? , Nome = ? , DataNasc = ? , CodCurso = ? , NomeCurso = ? , N1 = ? , N2 = ? , Media = ? , Falta = ? , CodNomeDiciplina = ? WHERE id = ? ");
			ps.setString(1, a.getMatricula());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getDataNasc());
			ps.setString(4, a.getCodCurso());
			ps.setString(5, a.getNomeCurso());
			ps.setFloat(6, a.getN1());
			ps.setFloat(7, a.getN2());
			ps.setFloat(8, a.getMedia());
			ps.setInt(9, a.getF());
			ps.setString(10, a.getCodNome());
			ps.setInt(11, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}

	public void delete(Aluno a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("DELETE FROM aluno WHERE id = ? ");
			ps.setInt(1, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Deletado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}
	
	
	public List<Aluno> mostrarDisciplinas() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Aluno> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT id,Matricula,Nome,disciplinas FROM aluno");
			rs = ps.executeQuery();

			while (rs.next()) {
				Aluno di = new Aluno();
				di.setId(rs.getInt("id"));
				di.setMatricula(rs.getString("Matricula"));
				di.setNome(rs.getString("Nome"));
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

	public void atualizarDisciplinas(Aluno a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE aluno SET disciplinas = ? WHERE id = ? ");
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
}
