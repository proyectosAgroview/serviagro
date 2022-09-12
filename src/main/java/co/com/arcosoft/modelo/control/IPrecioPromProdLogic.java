package co.com.arcosoft.modelo.control;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IPrecioPromProdLogic {
	public List<PrecioPromProd> getPrecioPromProd() throws Exception;

	/**
	 * Save an new PrecioPromProd entity
	 */
	public void savePrecioPromProd(PrecioPromProd entity) throws Exception;

	/**
	 * Delete an existing PrecioPromProd entity
	 *
	 */
	public void deletePrecioPromProd(PrecioPromProd entity) throws Exception;

	/**
	 * Update an existing PrecioPromProd entity
	 *
	 */
	public void updatePrecioPromProd(PrecioPromProd entity) throws Exception;

	/**
	 * Load an existing PrecioPromProd entity
	 *
	 */
	public PrecioPromProd getPrecioPromProd(Long precioProdId) throws Exception;

	public List<PrecioPromProd> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PrecioPromProd> findPagePrecioPromProd(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPrecioPromProd() throws Exception;

	public List<PrecioPromProdDTO>getDataPrecioPromProd(Double cantidadCompra) throws Exception;

	public List<PrecioPromProdDTO> getDataProductosByPrecioPromProdId(Long productoId) throws Exception;

	public List<PrecioPromProdDTO> getDataProductosByInventarios(Long datOtrosMovInventarioId) throws Exception ;

	public List<PrecioPromProdDTO> getDataProductosByCompras(Long datOtrosMovInventarioId) throws Exception ;
	
	public List<PrecioPromProdDTO> getDataProductosByServRealizados(Long datServRealizadosEquipoId) throws Exception ;
}
