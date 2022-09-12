package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EstClimat;
import co.com.arcosoft.modelo.dto.EstClimatDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEstClimatLogic {
	public List<EstClimat> getEstClimat() throws Exception;

	/**
	 * Save an new EstClimat entity
	 */
	public void saveEstClimat(EstClimat entity) throws Exception;

	/**
	 * Delete an existing EstClimat entity
	 *
	 */
	public void deleteEstClimat(EstClimat entity) throws Exception;

	/**
	 * Update an existing EstClimat entity
	 *
	 */
	public void updateEstClimat(EstClimat entity) throws Exception;

	/**
	 * Load an existing EstClimat entity
	 *
	 */
	public EstClimat getEstClimat(Long estClimatId) throws Exception;

	public List<EstClimat> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<EstClimat> findPageEstClimat(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstClimat() throws Exception;

	public List<EstClimatDTO> getDataEstClimat() throws Exception;
}
