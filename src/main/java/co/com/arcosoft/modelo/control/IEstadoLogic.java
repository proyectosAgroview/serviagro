package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Estado;
import co.com.arcosoft.modelo.dto.EstadoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEstadoLogic {
	public List<Estado> getEstado() throws Exception;

	/**
	 * Save an new Estado entity
	 */
	public void saveEstado(Estado entity) throws Exception;

	/**
	 * Delete an existing Estado entity
	 *
	 */
	public void deleteEstado(Estado entity) throws Exception;

	/**
	 * Update an existing Estado entity
	 *
	 */
	public void updateEstado(Estado entity) throws Exception;

	/**
	 * Load an existing Estado entity
	 *
	 */
	public Estado getEstado(Long estadoId) throws Exception;

	public List<Estado> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Estado> findPageEstado(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstado() throws Exception;

	public List<EstadoDTO> getDataEstado() throws Exception;
}
