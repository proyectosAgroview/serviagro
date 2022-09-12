package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.modelo.dto.EstPluvioDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEstPluvioLogic {
	public List<EstPluvio> getEstPluvio() throws Exception;

	/**
	 * Save an new EstPluvio entity
	 */
	public void saveEstPluvio(EstPluvio entity) throws Exception;

	/**
	 * Delete an existing EstPluvio entity
	 *
	 */
	public void deleteEstPluvio(EstPluvio entity) throws Exception;

	/**
	 * Update an existing EstPluvio entity
	 *
	 */
	public void updateEstPluvio(EstPluvio entity) throws Exception;

	/**
	 * Load an existing EstPluvio entity
	 *
	 */
	public EstPluvio getEstPluvio(Long estPluvioId) throws Exception;

	public List<EstPluvio> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<EstPluvio> findPageEstPluvio(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstPluvio() throws Exception;

	public List<EstPluvioDTO> getDataEstPluvio() throws Exception;

	public List<EstPluvioDTO> findByCriteriaPageEstPluvio(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberEstPluvio(Map<String, Object> filters) throws Exception;

}
