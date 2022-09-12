package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TarifaContratista;
import co.com.arcosoft.modelo.dto.TarifaContratistaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITarifaContratistaLogic {
	public List<TarifaContratista> getTarifaContratista() throws Exception;

	/**
	 * Save an new TarifaContratista entity
	 */
	public void saveTarifaContratista(TarifaContratista entity) throws Exception;

	/**
	 * Delete an existing TarifaContratista entity
	 *
	 */
	public void deleteTarifaContratista(TarifaContratista entity) throws Exception;

	/**
	 * Update an existing TarifaContratista entity
	 *
	 */
	public void updateTarifaContratista(TarifaContratista entity) throws Exception;

	/**
	 * Load an existing TarifaContratista entity
	 *
	 */
	public TarifaContratista getTarifaContratista(Long tarifaCtrId) throws Exception;

	public List<TarifaContratista> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaContratista> findPageTarifaContratista(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaContratista() throws Exception;

	public List<TarifaContratistaDTO> getDataTarifaContratista() throws Exception;

	public List<TarifaContratistaDTO> getDataContratistaByTarifaContratistaId(Long persEmprId) throws Exception;
}
