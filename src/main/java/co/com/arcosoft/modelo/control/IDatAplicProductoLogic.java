package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatAplicProducto;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;
import co.com.arcosoft.modelo.dto.DatAplicProductoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatAplicProductoLogic {
	public List<DatAplicProducto> getDatAplicProducto() throws Exception;

	/**
	 * Save an new DatAplicProducto entity
	 */
	public void saveDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception;

	/**
	 * Delete an existing DatAplicProducto entity
	 *
	 */
	public void deleteDatAplicProducto(DatAplicProducto entity) throws Exception;

	/**
	 * Update an existing DatAplicProducto entity
	 *
	 */
	public void updateDatAplicProducto(DatAplicProducto entity, List<DatAplicProdDetDTO> dataDetProductos)
			throws Exception;

	/**
	 * Load an existing DatAplicProducto entity
	 *
	 */
	public DatAplicProducto getDatAplicProducto(Long datAplicProdId) throws Exception;

	public List<DatAplicProducto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAplicProducto> findPageDatAplicProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatAplicProducto() throws Exception;

	public List<DatAplicProductoDTO> getDataDatAplicProducto() throws Exception;

	public List<DatAplicProductoDTO> getDataDetProductosByDatAplicProdId(Long datAplicProdId) throws Exception;

	public List<DatAplicProductoDTO> findByCriteriaPageAplicProducto(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberAplicProducto(Map<String, Object> filters) throws Exception;

}
