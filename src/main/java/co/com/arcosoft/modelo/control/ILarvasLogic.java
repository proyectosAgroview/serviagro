package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Larvas;
import co.com.arcosoft.modelo.dto.LarvasDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILarvasLogic {
	public List<Larvas> getLarvas() throws Exception;

	/**
	 * Save an new Larvas entity
	 */
	public void saveLarvas(Larvas entity) throws Exception;

	/**
	 * Delete an existing Larvas entity
	 *
	 */
	public void deleteLarvas(Larvas entity) throws Exception;

	/**
	 * Update an existing Larvas entity
	 *
	 */
	public void updateLarvas(Larvas entity) throws Exception;

	/**
	 * Load an existing Larvas entity
	 *
	 */
	public Larvas getLarvas(Long larvasId) throws Exception;

	public List<Larvas> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Larvas> findPageLarvas(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberLarvas() throws Exception;

	public List<LarvasDTO> getDataLarvas() throws Exception;
}
