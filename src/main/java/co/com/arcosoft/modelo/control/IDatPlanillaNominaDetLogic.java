package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPlanillaNominaDet;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatPlanillaNominaDetLogic {
	public List<DatPlanillaNominaDet> getDatPlanillaNominaDet() throws Exception;

	/**
	 * Save an new DatPlanillaNominaDet entity
	 */
	public void saveDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception;

	/**
	 * Delete an existing DatPlanillaNominaDet entity
	 *
	 */
	public void deleteDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception;

	/**
	 * Update an existing DatPlanillaNominaDet entity
	 *
	 */
	public void updateDatPlanillaNominaDet(DatPlanillaNominaDet entity) throws Exception;

	/**
	 * Load an existing DatPlanillaNominaDet entity
	 *
	 */
	public DatPlanillaNominaDet getDatPlanillaNominaDet(Long detPlanillaNominaId) throws Exception;

	public List<DatPlanillaNominaDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatPlanillaNominaDet> findPageDatPlanillaNominaDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatPlanillaNominaDet() throws Exception;

	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDet() throws Exception;

	public List<DatPlanillaNominaDetDTO> getDataDatPlanillaNominaDetByNomina(Long planillaNominaId) throws Exception;

}
