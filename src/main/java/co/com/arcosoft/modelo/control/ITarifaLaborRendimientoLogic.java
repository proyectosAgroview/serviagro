package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TarifaLaborRendimiento;
import co.com.arcosoft.modelo.dto.TarifaLaborRendimientoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITarifaLaborRendimientoLogic {
	public List<TarifaLaborRendimiento> getTarifaLaborRendimiento() throws Exception;

	/**
	 * Save an new TarifaLaborRendimiento entity
	 */
	public void saveTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception;

	/**
	 * Delete an existing TarifaLaborRendimiento entity
	 *
	 */
	public void deleteTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception;

	/**
	 * Update an existing TarifaLaborRendimiento entity
	 *
	 */
	public void updateTarifaLaborRendimiento(TarifaLaborRendimiento entity) throws Exception;

	/**
	 * Load an existing TarifaLaborRendimiento entity
	 *
	 */
	public TarifaLaborRendimiento getTarifaLaborRendimiento(Long tarifaLaborId) throws Exception;

	public List<TarifaLaborRendimiento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaLaborRendimiento> findPageTarifaLaborRendimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTarifaLaborRendimiento() throws Exception;

	public List<TarifaLaborRendimientoDTO> getDataTarifaLaborRendimiento() throws Exception;

	public List<TarifaLaborRendimientoDTO> getDataRendimientoByTarifaRendimientoId(Long laborId) throws Exception;
}
