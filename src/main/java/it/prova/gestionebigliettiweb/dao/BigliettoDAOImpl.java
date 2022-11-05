package it.prova.gestionebigliettiweb.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionebigliettiweb.model.Biglietto;

public class BigliettoDAOImpl implements BigliettoDAO {

	private EntityManager entityManager;

	@Override
	public List<Biglietto> list() throws Exception {
		return (List<Biglietto>) entityManager.createNativeQuery("select * from biglietto;", Biglietto.class)
				.getResultList();
	}

	@Override
	public Biglietto findOne(Long id) throws Exception {
		if (id == null || id < 1)
			throw new Exception("Id in input nullo invalido");
		return entityManager.createQuery("from biglietto", Biglietto.class).getResultStream().findFirst().orElse(null);
	}

	@Override
	public void update(Biglietto input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Errore durante l'aggiornamento, input non valido");
		input = entityManager.merge(input);

	}

	@Override
	public void insert(Biglietto input) throws Exception {
		if (input == null)
			throw new Exception("Errore durante l'inserimento, input non valido");
		entityManager.persist(input);

	}

	@Override
	public void delete(Biglietto input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Errore durante la rimozione, input non valido");
		input = entityManager.merge(input);
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
