package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.dto.Nivel1DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface INivel1Logic {
	public List<Nivel1> getNivel1() throws Exception;

	/**
	 * Save an new Nivel1 entity
	 */
	public void saveNivel1(Nivel1 entity) throws Exception;

	/**
	 * Delete an existing Nivel1 entity
	 *
	 */
	public void deleteNivel1(Nivel1 entity) throws Exception;

	/**
	 * Update an existing Nivel1 entity
	 *
	 */
	public void updateNivel1(Nivel1 entity) throws Exception;

	/**
	 * Load an existing Nivel1 entity
	 *
	 */
	public Nivel1 getNivel1(Long nivel1Id) throws Exception;

	public List<Nivel1> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Nivel1> findPageNivel1(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel1() throws Exception;

	public List<Nivel1DTO> getDataNivel1() throws Exception;
}
