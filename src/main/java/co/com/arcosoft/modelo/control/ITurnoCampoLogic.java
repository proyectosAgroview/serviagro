package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TurnoCampo;
import co.com.arcosoft.modelo.dto.TurnoCampoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITurnoCampoLogic {
	public List<TurnoCampo> getTurnoCampo() throws Exception;

	/**
	 * Save an new TurnoCampo entity
	 */
	public void saveTurnoCampo(TurnoCampo entity) throws Exception;

	/**
	 * Delete an existing TurnoCampo entity
	 *
	 */
	public void deleteTurnoCampo(TurnoCampo entity) throws Exception;

	/**
	 * Update an existing TurnoCampo entity
	 *
	 */
	public void updateTurnoCampo(TurnoCampo entity) throws Exception;

	/**
	 * Load an existing TurnoCampo entity
	 *
	 */
	public TurnoCampo getTurnoCampo(Long turnoCampoId) throws Exception;

	public List<TurnoCampo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TurnoCampo> findPageTurnoCampo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTurnoCampo() throws Exception;

	public List<TurnoCampoDTO> getDataTurnoCampo() throws Exception;
}
