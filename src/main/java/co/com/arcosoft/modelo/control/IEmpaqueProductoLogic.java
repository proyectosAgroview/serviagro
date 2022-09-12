package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EmpaqueProducto;
import co.com.arcosoft.modelo.EmpaqueProductoId;
import co.com.arcosoft.modelo.dto.EmpaqueProductoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEmpaqueProductoLogic {
	public List<EmpaqueProducto> getEmpaqueProducto() throws Exception;

	/**
	 * Save an new EmpaqueProducto entity
	 */
	public void saveEmpaqueProducto(EmpaqueProducto entity) throws Exception;

	/**
	 * Delete an existing EmpaqueProducto entity
	 *
	 */
	public void deleteEmpaqueProducto(EmpaqueProducto entity) throws Exception;

	/**
	 * Update an existing EmpaqueProducto entity
	 *
	 */
	public void updateEmpaqueProducto(EmpaqueProducto entity) throws Exception;

	/**
	 * Load an existing EmpaqueProducto entity
	 *
	 */
	public EmpaqueProducto getEmpaqueProducto(EmpaqueProductoId id) throws Exception;

	public List<EmpaqueProducto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EmpaqueProducto> findPageEmpaqueProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEmpaqueProducto() throws Exception;

	public List<EmpaqueProductoDTO> getDataEmpaqueProducto() throws Exception;
}
