package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.dto.LaborCcontableDTO;
import co.com.arcosoft.modelo.dto.LaborDTO;
import co.com.arcosoft.modelo.dto.LaborRecursosDTO;
import co.com.arcosoft.modelo.dto.TarifaLaborRendimientoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILaborLogic {
	public List<Labor> getLabor() throws Exception;

	/**
	 * Save an new Labor entity
	 * 
	 * @param dataTarifaRendimiento
	 */
	public void saveLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos,	List<LaborCcontableDTO> dataCcontable) throws Exception;

	/**
	 * Delete an existing Labor entity
	 *
	 */
	public void deleteLabor(Labor entity) throws Exception;

	/**
	 * Update an existing Labor entity
	 * 
	 * @param dataTarifaRendimiento
	 *
	 */
	public void updateLabor(Labor entity, List<TarifaLaborRendimientoDTO> dataTarifaRendimiento,
			List<LaborRecursosDTO> dataLaborRecursos,	List<LaborCcontableDTO> dataCcontable) throws Exception;

	/**
	 * Load an existing Labor entity
	 *
	 */
	public Labor getLabor(Long laborId) throws Exception;

	public List<Labor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Labor> findPageLabor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberLabor() throws Exception;

	public List<LaborDTO> getDataLabor() throws Exception;


}
