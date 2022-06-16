package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.Conexao;
import model.Professor;

public class ProfessorDAO {

	public void add(Professor p) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"INSERT INTO professor (IdentProf,NomeProf,Rua,Numero,Bairro,Cidade,Estado,Tel,Cel,Data,Especialidades,TituloProf) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, p.getIdentidade());
			ps.setString(2, p.getNome());
			ps.setString(3, p.getRua());
			ps.setInt(4, p.getNum());
			ps.setString(5, p.getBairro());
			ps.setString(6, p.getCidade());
			ps.setString(7, p.getEstado());
			ps.setString(8, p.getTel());
			ps.setString(9, p.getCel());
			ps.setString(10, p.getDataNasc());
			ps.setString(11, p.getEspecialidades());
			ps.setString(12, p.getTitulos());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Salvo com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar" + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}

	}

	public List<Professor> mostrarProfessores() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Professor> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT * FROM professor");
			rs = ps.executeQuery();

			while (rs.next()) {
				Professor di = new Professor();
				di.setId(rs.getInt("id"));
				di.setIdentidade(rs.getString("IdentProf"));
				di.setNome(rs.getString("NomeProf"));
				di.setRua(rs.getString("Rua"));
				di.setNum(rs.getInt("Numero"));
				di.setBairro(rs.getString("Bairro"));
				di.setCidade(rs.getString("Cidade"));
				di.setEstado(rs.getString("Estado"));
				di.setTel(rs.getString("Tel"));
				di.setCel(rs.getString("Cel"));
				di.setDataNasc(rs.getString("Data"));
				di.setEspecialidades(rs.getString("Especialidades"));
				di.setTitulos(rs.getString("TituloProf"));
				cur.add(di);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}

	public void atualizar(Professor a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE professor SET IdentProf = ? ,NomeProf = ? ,Rua = ? ,Numero = ? ,Bairro = ? ,Cidade = ? ,Estado = ? ,Tel = ? ,Cel = ? ,Data = ? ,Especialidades = ? ,TituloProf = ? WHERE id = ? ");
			ps.setString(1, a.getIdentidade());
			ps.setString(2, a.getNome());
			ps.setString(3, a.getRua());
			ps.setInt(4, a.getNum());
			ps.setString(5, a.getBairro());
			ps.setString(6, a.getCidade());
			ps.setString(7, a.getEstado());
			ps.setString(8, a.getTel());
			ps.setString(9, a.getCel());
			ps.setString(10, a.getDataNasc());
			ps.setString(11, a.getEspecialidades());
			ps.setString(12, a.getTitulos());
			ps.setInt(13, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}
	}

	public void delete(Professor a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("DELETE FROM professor WHERE id = ? ");
			ps.setInt(1, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Deletado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}
	}

	
	public List<Professor> mostrarCursos() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Professor> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT id,IdentProf,NomeProf,cursos  FROM professor");
			rs = ps.executeQuery();

			while (rs.next()) {
				Professor di = new Professor();
				di.setId(rs.getInt("id"));
				di.setIdentidade(rs.getString("IdentProf"));
				di.setNome(rs.getString("NomeProf"));
				di.setCursos(rs.getString("cursos")); 
				cur.add(di);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps, rs);
		}

		return cur;
	}
	public void atualizarCursos(Professor a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE professor SET cursos = ? WHERE id = ? ");
			ps.setString(1, a.getCursos());
			ps.setInt(2, a.getId());

			ps.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e);

		} finally {
			Conexao.closeConnection(con, ps);
		}
	}
	
	public List<Professor> mostrarDisciplinas() {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<Professor> cur = new ArrayList<>();

		try {
			ps = con.prepareStatement("SELECT id,IdentProf,NomeProf,disciplinas  FROM professor");
			rs = ps.executeQuery();

			while (rs.next()) {
				Professor di = new Professor();
				di.setId(rs.getInt("id"));
				di.setIdentidade(rs.getString("IdentProf"));
				di.setNome(rs.getString("NomeProf"));
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
	public void atualizarDisciplinas(Professor a) {

		Connection con = Conexao.getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"UPDATE professor SET disciplinas = ? WHERE id = ? ");
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
