package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.FrenteCos;
import co.com.arcosoft.modelo.dto.FrenteCosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IFrenteCosLogic {
	public List<FrenteCos> getFrenteCos() throws Exception;

	/**
	 * Save an new FrenteCos entity
	 */
	public void saveFrenteCos(FrenteCos entity) throws Exception;

	/**
	 * Delete an existing FrenteCos entity
	 *
	 */
	public void deleteFrenteCos(FrenteCos entity) throws Exception;

	/**
	 * Update an existing FrenteCos entity
	 *
	 */
	public void updateFrenteCos(FrenteCos entity) throws Exception;

	/**
	 * Load an existing FrenteCos entity
	 *
	 */
	public FrenteCos getFrenteCos(Long frtCosId) throws Exception;

	public List<FrenteCos> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<FrenteCos> findPageFrenteCos(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberFrenteCos() throws Exception;

	public List<FrenteCosDTO> getDataFrenteCos() throws Exception;
}
