package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.dto.Nivel3DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface INivel3Logic {
	public List<Nivel3> getNivel3() throws Exception;

	/**
	 * Save an new Nivel3 entity
	 */
	public void saveNivel3(Nivel3 entity) throws Exception;

	/**
	 * Delete an existing Nivel3 entity
	 *
	 */
	public void deleteNivel3(Nivel3 entity) throws Exception;

	/**
	 * Update an existing Nivel3 entity
	 *
	 */
	public void updateNivel3(Nivel3 entity) throws Exception;

	/**
	 * Load an existing Nivel3 entity
	 *
	 */
	public Nivel3 getNivel3(Long nivel3Id) throws Exception;

	public List<Nivel3> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Nivel3> findPageNivel3(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel3() throws Exception;

	public List<Nivel3DTO> getDataNivel3() throws Exception;

	public List<Nivel3DTO> findByCriteriaPageNivel3(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel3(Map<String, Object> filters) throws Exception;
}
