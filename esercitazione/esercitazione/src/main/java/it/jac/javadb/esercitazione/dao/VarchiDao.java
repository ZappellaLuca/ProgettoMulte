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
import it.jac.javadb.esercitazione.entity.Varchi;
import it.jac.javadb.esercitazione.util.HibernateUtil;

public class VarchiDao {

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

	public List<Varchi> findAll() {

		List<Varchi> result = new ArrayList<>();

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT IDVARCHI,NOMEVARCO");
		sql.append(" FROM LISTA_VARCHI");

		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			connection = getConnection();

			pstm = connection.prepareStatement(sql.toString());

			rs = pstm.executeQuery();

			while (rs.next()) {

				Varchi item = new Varchi();

				item.setId(rs.getInt("IDVARCHI"));
				item.setNomevarco(rs.getString("NOMEVARCO"));

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

	public void creaDocumento(Varchi varco) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.persist(varco);

			tx.commit();
		}
	}

	public void eliminaDocumento(Varchi varco) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();

			session.delete(varco);

			tx.commit();
		}
	}

}
