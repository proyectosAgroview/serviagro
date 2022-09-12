package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipCultivo;
import co.com.arcosoft.modelo.dto.TipCultivoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipCultivoLogic {
	public List<TipCultivo> getTipCultivo() throws Exception;

	/**
	 * Save an new TipCultivo entity
	 */
	public void saveTipCultivo(TipCultivo entity) throws Exception;

	/**
	 * Delete an existing TipCultivo entity
	 *
	 */
	public void deleteTipCultivo(TipCultivo entity) throws Exception;

	/**
	 * Update an existing TipCultivo entity
	 *
	 */
	public void updateTipCultivo(TipCultivo entity) throws Exception;

	/**
	 * Load an existing TipCultivo entity
	 *
	 */
	public TipCultivo getTipCultivo(Long tipoCultivoId) throws Exception;

	public List<TipCultivo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipCultivo> findPageTipCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipCultivo() throws Exception;

	public List<TipCultivoDTO> getDataTipCultivo() throws Exception;
}
