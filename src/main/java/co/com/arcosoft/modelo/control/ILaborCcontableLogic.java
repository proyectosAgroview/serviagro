package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LaborCcontable;
import co.com.arcosoft.modelo.dto.LaborCcontableDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILaborCcontableLogic {
	public List<LaborCcontable> getLaborCcontable() throws Exception;

	/**
	 * Save an new LaborCcontable entity
	 */
	public void saveLaborCcontable(LaborCcontable entity) throws Exception;

	/**
	 * Delete an existing LaborCcontable entity
	 *
	 */
	public void deleteLaborCcontable(LaborCcontable entity) throws Exception;

	/**
	 * Update an existing LaborCcontable entity
	 *
	 */
	public void updateLaborCcontable(LaborCcontable entity) throws Exception;

	/**
	 * Load an existing LaborCcontable entity
	 *
	 */
	public LaborCcontable getLaborCcontable(Long id) throws Exception;

	public List<LaborCcontable> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LaborCcontable> findPageLaborCcontable(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLaborCcontable() throws Exception;

	public List<LaborCcontableDTO> getDataLaborCcontable() throws Exception;
	public List<LaborCcontableDTO> getDataLaborCcontableByLabor(Long laborId) throws Exception ;
}
