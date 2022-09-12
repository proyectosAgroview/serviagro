package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LaborRecursos;
import co.com.arcosoft.modelo.dto.LaborRecursosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILaborRecursosLogic {
	public List<LaborRecursos> getLaborRecursos() throws Exception;

	/**
	 * Save an new LaborRecursos entity
	 */
	public void saveLaborRecursos(LaborRecursos entity) throws Exception;

	/**
	 * Delete an existing LaborRecursos entity
	 *
	 */
	public void deleteLaborRecursos(LaborRecursos entity) throws Exception;

	/**
	 * Update an existing LaborRecursos entity
	 *
	 */
	public void updateLaborRecursos(LaborRecursos entity) throws Exception;

	/**
	 * Load an existing LaborRecursos entity
	 *
	 */
	public LaborRecursos getLaborRecursos(Long laborRecursosId) throws Exception;

	public List<LaborRecursos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LaborRecursos> findPageLaborRecursos(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLaborRecursos() throws Exception;

	public List<LaborRecursosDTO> getDataLaborRecursos() throws Exception;

	public List<LaborRecursosDTO> getDataLaborRecursosByLabor(Long laborRecursosId) throws Exception;
}
