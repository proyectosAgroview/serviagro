package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.Nivel4DTO;
import co.com.arcosoft.modelo.dto.VariedadNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface INivel4Logic {
	public List<Nivel4> getNivel4() throws Exception;

	/**
	 * Save an new Nivel4 entity
	 */
	public void saveNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception;

	/**
	 * Delete an existing Nivel4 entity
	 *
	 */
	public void deleteNivel4(Nivel4 entity) throws Exception;

	/**
	 * Update an existing Nivel4 entity
	 *
	 */
	public void updateNivel4(Nivel4 entity, List<String> restriccionDeQuema, List<String> restriccionDeMadurante,
			List<VariedadNivel4DTO> dataVariedad) throws Exception;

	/**
	 * Load an existing Nivel4 entity
	 *
	 */
	public Nivel4 getNivel4(Long nivel4Id) throws Exception;

	public List<Nivel4> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Nivel4> findPageNivel4(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberNivel4() throws Exception;

	public List<Nivel4DTO> getDataNivel4() throws Exception;

	public List<Nivel4DTO> findByCriteriaPageNivel4(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberNivel4(Map<String, Object> filters) throws Exception;

}
