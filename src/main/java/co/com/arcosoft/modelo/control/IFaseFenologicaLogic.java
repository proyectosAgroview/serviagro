package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.FaseFenologica;
import co.com.arcosoft.modelo.dto.FaseFenologicaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IFaseFenologicaLogic {
	public List<FaseFenologica> getFaseFenologica() throws Exception;

	/**
	 * Save an new FaseFenologica entity
	 */
	public void saveFaseFenologica(FaseFenologica entity) throws Exception;

	/**
	 * Delete an existing FaseFenologica entity
	 *
	 */
	public void deleteFaseFenologica(FaseFenologica entity) throws Exception;

	/**
	 * Update an existing FaseFenologica entity
	 *
	 */
	public void updateFaseFenologica(FaseFenologica entity) throws Exception;

	/**
	 * Load an existing FaseFenologica entity
	 *
	 */
	public FaseFenologica getFaseFenologica(Long faseFenoId) throws Exception;

	public List<FaseFenologica> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FaseFenologica> findPageFaseFenologica(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFaseFenologica() throws Exception;

	public List<FaseFenologicaDTO> getDataFaseFenologica() throws Exception;
}
