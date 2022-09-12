package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.dto.Nivel2DTO;
import co.com.arcosoft.modelo.dto.Nivel2PersemprDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface INivel2Logic {
	public List<Nivel2> getNivel2() throws Exception;

	/**
	 * Save an new Nivel2 entity
	 */
	public void saveNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception;

	/**
	 * Delete an existing Nivel2 entity
	 *
	 */
	public void deleteNivel2(Nivel2 entity) throws Exception;

	/**
	 * Update an existing Nivel2 entity
	 *
	 */
	public void updateNivel2(Nivel2 entity, List<Nivel2PersemprDTO> dataNivel2PersEmpr) throws Exception;

	/**
	 * Load an existing Nivel2 entity
	 *
	 */
	public Nivel2 getNivel2(Long nivel2Id) throws Exception;

	public List<Nivel2> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Nivel2> findPageNivel2(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel2() throws Exception;

	public List<Nivel2DTO> getDataNivel2() throws Exception;

	public List<Nivel2DTO> findByCriteriaPageNivel2(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel2(Map<String, Object> filters) throws Exception;

}
