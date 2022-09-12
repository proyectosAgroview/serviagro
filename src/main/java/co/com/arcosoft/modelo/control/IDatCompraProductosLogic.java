package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatCompraProductos;
import co.com.arcosoft.modelo.dto.DatCompraProductosDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatCompraProductosLogic {
	public List<DatCompraProductos> getDatCompraProductos() throws Exception;

	/**
	 * Save an new DatCompraProductos entity
	 */

	/**
	 * Delete an existing DatCompraProductos entity
	 *
	 */
	public void deleteDatCompraProductos(DatCompraProductos entity) throws Exception;

	/**
	 * Update an existing DatCompraProductos entity
	 *
	 */

	/**
	 * Load an existing DatCompraProductos entity
	 *
	 */
	public DatCompraProductos getDatCompraProductos(Long datCompraProductosId) throws Exception;

	public List<DatCompraProductos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatCompraProductos> findPageDatCompraProductos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatCompraProductos() throws Exception;

	public List<DatCompraProductosDTO> getDataDatCompraProductos() throws Exception;

	public void saveDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos, Double valorFactura, Double totalSuma)
			throws Exception;

	public void updateDatCompraProductos(DatCompraProductos entity, List<PrecioPromProdDTO> dataDetPrecioProductos)
			throws Exception;

}
