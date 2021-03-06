package it.jac.javadb.esercitazione.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.jac.javadb.esercitazione.entity.Multe;
import it.jac.javadb.esercitazione.util.HibernateUtil;

public class MulteDao {

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost/archivio_multe?serverTimezone=UTC", "root", "");
	}

	public boolean testConnessione() {

		Connection connection = null;
		try {

			connection = getConnection();

			return (connection != null);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					// non faccio nulla in questo caso
				}
			}
		}

		return false;
	}

	public List<Multe> findAll() {

		List<Multe> result = new ArrayList<>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ID, NOME, COGNOME, TARGA, VARCO, IDVARCO");
		sql.append(" FROM LISTAMULTE");

		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			pstm = connection.prepareStatement(sql.toString());

			rs = pstm.executeQuery();

			while (rs.next()) {

				Multe item = new Multe();

				item.setId(rs.getInt("ID"));
				item.setNome(rs.getString("NOME"));
				item.setCognome(rs.getString("COGNOME"));
				item.setTarga(rs.getString("TARGA"));
				item.setIdVarco(rs.getInt("IDVARCO"));

				result.add(item);
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// non faccio nulla
				}
			}

			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					// non faccio nulla
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// non faccio nulla
				}
			}
		}

		return result;

	}

	public void creaDocumento(Multe multa) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.persist(multa);

			tx.commit();
		}
	}

	public void eliminaDocumento(Multe multa) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.delete(multa);

			tx.commit();
		}
	}

}
