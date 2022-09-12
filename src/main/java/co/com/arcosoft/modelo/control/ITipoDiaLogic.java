package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoDia;
import co.com.arcosoft.modelo.dto.TipoDiaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoDiaLogic {
	public List<TipoDia> getTipoDia() throws Exception;

	/**
	 * Save an new TipoDia entity
	 */
	public void saveTipoDia(TipoDia entity) throws Exception;

	/**
	 * Delete an existing TipoDia entity
	 *
	 */
	public void deleteTipoDia(TipoDia entity) throws Exception;

	/**
	 * Update an existing TipoDia entity
	 *
	 */
	public void updateTipoDia(TipoDia entity) throws Exception;

	/**
	 * Load an existing TipoDia entity
	 *
	 */
	public TipoDia getTipoDia(Long tipDiaId) throws Exception;

	public List<TipoDia> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoDia> findPageTipoDia(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoDia() throws Exception;

	public List<TipoDiaDTO> getDataTipoDia() throws Exception;
}
