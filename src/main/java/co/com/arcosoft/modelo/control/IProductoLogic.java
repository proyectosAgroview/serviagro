package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.dto.DatProductosRelacionadosDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.modelo.dto.ProductoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IProductoLogic {
	public List<Producto> getProducto() throws Exception;

	/**
	 * Save an new Producto entity
	 */
	public void saveProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> dataProdRelacionado) throws Exception;

	/**
	 * Delete an existing Producto entity
	 *
	 */
	public void deleteProducto(Producto entity) throws Exception;

	/**
	 * Update an existing Producto entity
	 *
	 */
	public void updateProducto(Producto entity, List<PrecioPromProdDTO> dataDetPrecioProductos, List<DatProductosRelacionadosDTO> dataProdRelacionado) throws Exception;

	/**
	 * Load an existing Producto entity
	 *
	 */
	public Producto getProducto(Long productoId) throws Exception;

	public List<Producto> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Producto> findPageProducto(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberProducto() throws Exception;

	public List<ProductoDTO> getDataProducto() throws Exception;

	public List<ProductoDTO> findByCriteriaPageProducto(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberProducto(Map<String, Object> filters) throws Exception;

}
