package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatEstimCosecha;
import co.com.arcosoft.modelo.dto.DatEstimCosechaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatEstimCosechaLogic {
	public List<DatEstimCosecha> getDatEstimCosecha() throws Exception;

	/**
	 * Save an new DatEstimCosecha entity
	 */
	public void saveDatEstimCosecha(DatEstimCosecha entity) throws Exception;

	/**
	 * Delete an existing DatEstimCosecha entity
	 *
	 */
	public void deleteDatEstimCosecha(DatEstimCosecha entity) throws Exception;

	/**
	 * Update an existing DatEstimCosecha entity
	 *
	 */
	public void updateDatEstimCosecha(DatEstimCosecha entity) throws Exception;

	/**
	 * Load an existing DatEstimCosecha entity
	 *
	 */
	public DatEstimCosecha getDatEstimCosecha(Long datEstimCosechaId) throws Exception;

	public List<DatEstimCosecha> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatEstimCosecha> findPageDatEstimCosecha(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatEstimCosecha() throws Exception;

	public List<DatEstimCosechaDTO> getDataDatEstimCosecha() throws Exception;

	public List<DatEstimCosechaDTO> findByCriteriaPageDatEstimCosecha(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatEstimCosecha(Map<String, Object> filters) throws Exception;

}
