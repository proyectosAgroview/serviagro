package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CostoRecurso;
import co.com.arcosoft.modelo.CostoRecursoId;
import co.com.arcosoft.modelo.dto.CostoRecursoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICostoRecursoLogic {
	public List<CostoRecurso> getCostoRecurso() throws Exception;

	/**
	 * Save an new CostoRecurso entity
	 */
	public void saveCostoRecurso(CostoRecurso entity) throws Exception;

	/**
	 * Delete an existing CostoRecurso entity
	 *
	 */
	public void deleteCostoRecurso(CostoRecurso entity) throws Exception;

	/**
	 * Update an existing CostoRecurso entity
	 *
	 */
	public void updateCostoRecurso(CostoRecurso entity) throws Exception;

	/**
	 * Load an existing CostoRecurso entity
	 *
	 */
	public CostoRecurso getCostoRecurso(CostoRecursoId id) throws Exception;

	public List<CostoRecurso> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CostoRecurso> findPageCostoRecurso(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCostoRecurso() throws Exception;

	public List<CostoRecursoDTO> getDataCostoRecurso() throws Exception;
}
