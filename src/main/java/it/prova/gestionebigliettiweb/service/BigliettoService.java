package it.prova.gestionebigliettiweb.service;

import java.util.List;

import it.prova.gestionebigliettiweb.dao.BigliettoDAO;
import it.prova.gestionebigliettiweb.model.Biglietto;

public interface BigliettoService {

	void setBigliettoDao(BigliettoDAO BIGLIETTO_DAO_INSTANCE);

	public List<Biglietto> listAll() throws Exception;

	public Biglietto findById(Long id) throws Exception;

	public void aggiorna(Biglietto input) throws Exception;

	public void inserisciNuovo(Biglietto input) throws Exception;

	public void rimuovi(Long id) throws Exception;

}
