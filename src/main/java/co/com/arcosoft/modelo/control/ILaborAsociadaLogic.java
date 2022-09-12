package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LaborAsociada;
import co.com.arcosoft.modelo.LaborAsociadaId;
import co.com.arcosoft.modelo.dto.LaborAsociadaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILaborAsociadaLogic {
	public List<LaborAsociada> getLaborAsociada() throws Exception;

	/**
	 * Save an new LaborAsociada entity
	 */
	public void saveLaborAsociada(LaborAsociada entity) throws Exception;

	/**
	 * Delete an existing LaborAsociada entity
	 *
	 */
	public void deleteLaborAsociada(LaborAsociada entity) throws Exception;

	/**
	 * Update an existing LaborAsociada entity
	 *
	 */
	public void updateLaborAsociada(LaborAsociada entity) throws Exception;

	/**
	 * Load an existing LaborAsociada entity
	 *
	 */
	public LaborAsociada getLaborAsociada(LaborAsociadaId id) throws Exception;

	public List<LaborAsociada> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LaborAsociada> findPageLaborAsociada(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLaborAsociada() throws Exception;

	public List<LaborAsociadaDTO> getDataLaborAsociada() throws Exception;
}
