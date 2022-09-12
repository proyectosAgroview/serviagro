package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.dto.DatPlanLaborDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatPlanLaborDetLogic {
	public List<DatPlanLaborDet> getDatPlanLaborDet() throws Exception;

	/**
	 * Save an new DatPlanLaborDet entity
	 */
	public void saveDatPlanLaborDet(DatPlanLaborDet entity) throws Exception;

	/**
	 * Delete an existing DatPlanLaborDet entity
	 *
	 */
	public void deleteDatPlanLaborDet(DatPlanLaborDet entity) throws Exception;

	/**
	 * Update an existing DatPlanLaborDet entity
	 *
	 */
	public void updateDatPlanLaborDet(DatPlanLaborDet entity) throws Exception;

	/**
	 * Load an existing DatPlanLaborDet entity
	 *
	 */
	public DatPlanLaborDet getDatPlanLaborDet(Long planLaborDetId) throws Exception;

	public List<DatPlanLaborDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanLaborDet> findPageDatPlanLaborDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatPlanLaborDet() throws Exception;

	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDet() throws Exception;

	public List<DatPlanLaborDetDTO> getDataDatPlanLaborDetByPlan(Long planLaborId) throws Exception;
}
