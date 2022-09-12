package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatPlanLabor;
import co.com.arcosoft.modelo.dto.DatPlanLaborDTO;
import co.com.arcosoft.modelo.dto.DatPlanLaborDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatPlanLaborLogic {
	public List<DatPlanLabor> getDatPlanLabor() throws Exception;

	/**
	 * Save an new DatPlanLabor entity
	 */
	public void saveDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception;

	/**
	 * Delete an existing DatPlanLabor entity
	 *
	 */
	public void deleteDatPlanLabor(DatPlanLabor entity) throws Exception;

	/**
	 * Update an existing DatPlanLabor entity
	 *
	 */
	public void updateDatPlanLabor(DatPlanLabor entity, List<DatPlanLaborDetDTO> dataPlanLaborDet) throws Exception;

	/**
	 * Load an existing DatPlanLabor entity
	 *
	 */
	public DatPlanLabor getDatPlanLabor(Long planLaborId) throws Exception;

	public List<DatPlanLabor> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanLabor> findPageDatPlanLabor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatPlanLabor() throws Exception;

	public List<DatPlanLaborDTO> getDataDatPlanLabor() throws Exception;

	public List<DatPlanLaborDTO> findByCriteriaPagePlanLabor(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberPlanLabor(Map<String, Object> filters) throws Exception;
}
