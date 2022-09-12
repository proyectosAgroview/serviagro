package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoProducto;
import co.com.arcosoft.modelo.dto.TipoProductoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoProductoLogic {
	public List<TipoProducto> getTipoProducto() throws Exception;

	/**
	 * Save an new TipoProducto entity
	 */
	public void saveTipoProducto(TipoProducto entity) throws Exception;

	/**
	 * Delete an existing TipoProducto entity
	 *
	 */
	public void deleteTipoProducto(TipoProducto entity) throws Exception;

	/**
	 * Update an existing TipoProducto entity
	 *
	 */
	public void updateTipoProducto(TipoProducto entity) throws Exception;

	/**
	 * Load an existing TipoProducto entity
	 *
	 */
	public TipoProducto getTipoProducto(Long tipoProdId) throws Exception;

	public List<TipoProducto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoProducto> findPageTipoProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoProducto() throws Exception;

	public List<TipoProductoDTO> getDataTipoProducto() throws Exception;
}
