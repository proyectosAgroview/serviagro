package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatAbastCombustible;
import co.com.arcosoft.modelo.dto.DatAbastCombustibleDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatAbastCombustibleLogic {
	public List<DatAbastCombustible> getDatAbastCombustible() throws Exception;

	/**
	 * Save an new DatAbastCombustible entity
	 */
	public void saveDatAbastCombustible(DatAbastCombustible entity) throws Exception;

	/**
	 * Delete an existing DatAbastCombustible entity
	 *
	 */
	public void deleteDatAbastCombustible(DatAbastCombustible entity) throws Exception;

	/**
	 * Update an existing DatAbastCombustible entity
	 *
	 */
	public void updateDatAbastCombustible(DatAbastCombustible entity) throws Exception;

	/**
	 * Load an existing DatAbastCombustible entity
	 *
	 */
	public DatAbastCombustible getDatAbastCombustible(Long datAbastCombustibleId) throws Exception;

	public List<DatAbastCombustible> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAbastCombustible> findPageDatAbastCombustible(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatAbastCombustible() throws Exception;

	public List<DatAbastCombustibleDTO> getDataDatAbastCombustible() throws Exception;
}
