package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipProvee;
import co.com.arcosoft.modelo.dto.TipProveeDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipProveeLogic {
	public List<TipProvee> getTipProvee() throws Exception;

	/**
	 * Save an new TipProvee entity
	 */
	public void saveTipProvee(TipProvee entity) throws Exception;

	/**
	 * Delete an existing TipProvee entity
	 *
	 */
	public void deleteTipProvee(TipProvee entity) throws Exception;

	/**
	 * Update an existing TipProvee entity
	 *
	 */
	public void updateTipProvee(TipProvee entity) throws Exception;

	/**
	 * Load an existing TipProvee entity
	 *
	 */
	public TipProvee getTipProvee(Long tpProvId) throws Exception;

	public List<TipProvee> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipProvee> findPageTipProvee(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipProvee() throws Exception;

	public List<TipProveeDTO> getDataTipProvee() throws Exception;
}
