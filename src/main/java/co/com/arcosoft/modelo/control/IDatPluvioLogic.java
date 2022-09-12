package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatPluvio;
import co.com.arcosoft.modelo.dto.DatPluvioDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatPluvioLogic {
	public List<DatPluvio> getDatPluvio() throws Exception;

	/**
	 * Save an new DatPluvio entity
	 */
	public void saveDatPluvio(DatPluvio entity) throws Exception;

	/**
	 * Delete an existing DatPluvio entity
	 *
	 */
	public void deleteDatPluvio(DatPluvio entity) throws Exception;

	/**
	 * Update an existing DatPluvio entity
	 *
	 */
	public void updateDatPluvio(DatPluvio entity) throws Exception;

	/**
	 * Load an existing DatPluvio entity
	 *
	 */
	public DatPluvio getDatPluvio(Long datPluvioId) throws Exception;

	public List<DatPluvio> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DatPluvio> findPageDatPluvio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatPluvio() throws Exception;

	public List<DatPluvioDTO> getDataDatPluvio() throws Exception;

	public List<DatPluvioDTO> findByCriteriaPageDatPluvio(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberDatPluvio(Map<String, Object> filters) throws Exception;

}
