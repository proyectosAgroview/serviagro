package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatRiego;
import co.com.arcosoft.modelo.dto.DatRiegoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatRiegoLogic {
	public List<DatRiego> getDatRiego() throws Exception;

	/**
	 * Save an new DatRiego entity
	 */
	public void saveDatRiego(DatRiego entity) throws Exception;

	/**
	 * Delete an existing DatRiego entity
	 *
	 */
	public void deleteDatRiego(DatRiego entity) throws Exception;

	/**
	 * Update an existing DatRiego entity
	 *
	 */
	public void updateDatRiego(DatRiego entity) throws Exception;

	/**
	 * Load an existing DatRiego entity
	 *
	 */
	public DatRiego getDatRiego(Long datRiegoId) throws Exception;

	public List<DatRiego> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DatRiego> findPageDatRiego(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatRiego() throws Exception;

	public List<DatRiegoDTO> getDataDatRiego() throws Exception;

	public List<DatRiegoDTO> findByCriteriaPageRiego(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberRiego(Map<String, Object> filters) throws Exception;

	public List<DatRiegoDTO> getDataDatRiegoByPlanillaNomina(Long planillaNominaId) throws Exception;

}
