package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Tenencia;
import co.com.arcosoft.modelo.dto.TenenciaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITenenciaLogic {
	public List<Tenencia> getTenencia() throws Exception;

	/**
	 * Save an new Tenencia entity
	 */
	public void saveTenencia(Tenencia entity) throws Exception;

	/**
	 * Delete an existing Tenencia entity
	 *
	 */
	public void deleteTenencia(Tenencia entity) throws Exception;

	/**
	 * Update an existing Tenencia entity
	 *
	 */
	public void updateTenencia(Tenencia entity) throws Exception;

	/**
	 * Load an existing Tenencia entity
	 *
	 */
	public Tenencia getTenencia(Long tenenId) throws Exception;

	public List<Tenencia> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Tenencia> findPageTenencia(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTenencia() throws Exception;

	public List<TenenciaDTO> getDataTenencia() throws Exception;
}
