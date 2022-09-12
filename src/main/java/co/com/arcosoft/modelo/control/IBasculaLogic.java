package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Bascula;
import co.com.arcosoft.modelo.dto.BasculaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IBasculaLogic {
	public List<Bascula> getBascula() throws Exception;

	/**
	 * Save an new Bascula entity
	 */
	public void saveBascula(Bascula entity) throws Exception;

	/**
	 * Delete an existing Bascula entity
	 *
	 */
	public void deleteBascula(Bascula entity) throws Exception;

	/**
	 * Update an existing Bascula entity
	 *
	 */
	public void updateBascula(Bascula entity) throws Exception;

	/**
	 * Load an existing Bascula entity
	 *
	 */
	public Bascula getBascula(Long basculaId) throws Exception;

	public List<Bascula> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Bascula> findPageBascula(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberBascula() throws Exception;

	public List<BasculaDTO> getDataBascula() throws Exception;
}
