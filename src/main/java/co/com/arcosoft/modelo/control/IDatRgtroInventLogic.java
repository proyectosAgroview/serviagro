package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatRgtroInvent;
import co.com.arcosoft.modelo.dto.DatRgtroInventDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatRgtroInventLogic {
	public List<DatRgtroInvent> getDatRgtroInvent() throws Exception;

	/**
	 * Save an new DatRgtroInvent entity
	 */
	public void saveDatRgtroInvent(DatRgtroInvent entity) throws Exception;

	/**
	 * Delete an existing DatRgtroInvent entity
	 *
	 */
	public void deleteDatRgtroInvent(DatRgtroInvent entity) throws Exception;

	/**
	 * Update an existing DatRgtroInvent entity
	 *
	 */
	public void updateDatRgtroInvent(DatRgtroInvent entity) throws Exception;

	/**
	 * Load an existing DatRgtroInvent entity
	 *
	 */
	public DatRgtroInvent getDatRgtroInvent(Long datRgtroInventId) throws Exception;

	public List<DatRgtroInvent> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatRgtroInvent> findPageDatRgtroInvent(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatRgtroInvent() throws Exception;

	public List<DatRgtroInventDTO> getDataDatRgtroInvent() throws Exception;
}
