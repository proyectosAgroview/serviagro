package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Nivel2Persempr;
import co.com.arcosoft.modelo.dto.Nivel2PersemprDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface INivel2PersemprLogic {
	public List<Nivel2Persempr> getNivel2Persempr() throws Exception;

	/**
	 * Save an new Nivel2Persempr entity
	 */
	public void saveNivel2Persempr(Nivel2Persempr entity) throws Exception;

	/**
	 * Delete an existing Nivel2Persempr entity
	 *
	 */
	public void deleteNivel2Persempr(Nivel2Persempr entity) throws Exception;

	/**
	 * Update an existing Nivel2Persempr entity
	 *
	 */
	public void updateNivel2Persempr(Nivel2Persempr entity) throws Exception;

	/**
	 * Load an existing Nivel2Persempr entity
	 *
	 */
	public Nivel2Persempr getNivel2Persempr(Long id) throws Exception;

	public List<Nivel2Persempr> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Nivel2Persempr> findPageNivel2Persempr(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberNivel2Persempr() throws Exception;

	public List<Nivel2PersemprDTO> getDataNivel2Persempr() throws Exception;

	public List<Nivel2PersemprDTO> getDataNivel2PersemprById(Long id) throws Exception;
}
