package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoCliente;
import co.com.arcosoft.modelo.dto.TipoClienteDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoClienteLogic {
	public List<TipoCliente> getTipoCliente() throws Exception;

	/**
	 * Save an new TipoCliente entity
	 */
	public void saveTipoCliente(TipoCliente entity) throws Exception;

	/**
	 * Delete an existing TipoCliente entity
	 *
	 */
	public void deleteTipoCliente(TipoCliente entity) throws Exception;

	/**
	 * Update an existing TipoCliente entity
	 *
	 */
	public void updateTipoCliente(TipoCliente entity) throws Exception;

	/**
	 * Load an existing TipoCliente entity
	 *
	 */
	public TipoCliente getTipoCliente(Long tipoClienteId) throws Exception;

	public List<TipoCliente> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoCliente> findPageTipoCliente(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoCliente() throws Exception;

	public List<TipoClienteDTO> getDataTipoCliente() throws Exception;
}
