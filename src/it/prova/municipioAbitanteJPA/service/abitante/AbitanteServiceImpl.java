package it.prova.municipioAbitanteJPA.service.abitante;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.municipioAbitanteJPA.dao.EntityManagerUtil;
import it.prova.municipioAbitanteJPA.dao.abitante.AbitanteDAO;
import it.prova.municipioAbitanteJPA.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> listAllAbitanti() throws Exception {

		// questo Ã¨ come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Abitante caricaSingoloAbitante(Long id) throws Exception {

		// questo Ã¨ come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public void inserisciNuovo(Abitante abitanteInstance) throws Exception {
		// questo Ã¨ come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo Ã¨ come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.insert(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Abitante abitanteInstance) throws Exception {
		// questo Ã¨ come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo Ã¨ come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.update(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Abitante abitanteInstance) throws Exception {
		// questo Ã¨ come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo Ã¨ come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			abitanteDAO.delete(abitanteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Abitante> cercaTuttiGliAbitantiConNome(String nome) throws Exception {
		// questo Ã¨ come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			abitanteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return abitanteDAO.findAllByNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Abitante> findAllByCognome(String cognome) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			
			abitanteDAO.setEntityManager(entityManager);
			
			return abitanteDAO.findAllByCognome(cognome);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Abitante> findAllByCodiceMunicipioIniziaCon(String codice) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			
			abitanteDAO.setEntityManager(entityManager);
			
			return abitanteDAO.findAllByCodiceMunicipioIniziaCon(codice);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
}
