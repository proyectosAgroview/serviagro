package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoDrenaje;
import co.com.arcosoft.modelo.dto.TipoDrenajeDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoDrenajeLogic {
	public List<TipoDrenaje> getTipoDrenaje() throws Exception;

	/**
	 * Save an new TipoDrenaje entity
	 */
	public void saveTipoDrenaje(TipoDrenaje entity) throws Exception;

	/**
	 * Delete an existing TipoDrenaje entity
	 *
	 */
	public void deleteTipoDrenaje(TipoDrenaje entity) throws Exception;

	/**
	 * Update an existing TipoDrenaje entity
	 *
	 */
	public void updateTipoDrenaje(TipoDrenaje entity) throws Exception;

	/**
	 * Load an existing TipoDrenaje entity
	 *
	 */
	public TipoDrenaje getTipoDrenaje(Long tipoDrenajeId) throws Exception;

	public List<TipoDrenaje> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoDrenaje> findPageTipoDrenaje(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoDrenaje() throws Exception;

	public List<TipoDrenajeDTO> getDataTipoDrenaje() throws Exception;
}
