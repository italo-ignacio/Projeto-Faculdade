package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/faculdade?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() {

		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (ClassNotFoundException | SQLException e) {

			JOptionPane.showMessageDialog(null, e);
			throw new RuntimeException("Erro na conexao: ", e);
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro na conexao: ", e);
		}

	}

	public static void closeConnection(Connection con, PreparedStatement ps) {
		closeConnection(con);
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro na conexao: ", e);
		}

	}

	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) {
		closeConnection(con, ps);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException("Erro na conexao: ", e);
		}
	}

}
