package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LimiteCeptoNomina;
import co.com.arcosoft.modelo.LimiteCeptoNominaId;
import co.com.arcosoft.modelo.dto.LimiteCeptoNominaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILimiteCeptoNominaLogic {
	public List<LimiteCeptoNomina> getLimiteCeptoNomina() throws Exception;

	/**
	 * Save an new LimiteCeptoNomina entity
	 */
	public void saveLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception;

	/**
	 * Delete an existing LimiteCeptoNomina entity
	 *
	 */
	public void deleteLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception;

	/**
	 * Update an existing LimiteCeptoNomina entity
	 *
	 */
	public void updateLimiteCeptoNomina(LimiteCeptoNomina entity) throws Exception;

	/**
	 * Load an existing LimiteCeptoNomina entity
	 *
	 */
	public LimiteCeptoNomina getLimiteCeptoNomina(LimiteCeptoNominaId id) throws Exception;

	public List<LimiteCeptoNomina> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LimiteCeptoNomina> findPageLimiteCeptoNomina(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLimiteCeptoNomina() throws Exception;

	public List<LimiteCeptoNominaDTO> getDataLimiteCeptoNomina() throws Exception;
}
