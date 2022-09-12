package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.MaduranteProducto;
import co.com.arcosoft.modelo.MaduranteProductoId;
import co.com.arcosoft.modelo.dto.MaduranteProductoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IMaduranteProductoLogic {
	public List<MaduranteProducto> getMaduranteProducto() throws Exception;

	/**
	 * Save an new MaduranteProducto entity
	 */
	public void saveMaduranteProducto(MaduranteProducto entity) throws Exception;

	/**
	 * Delete an existing MaduranteProducto entity
	 *
	 */
	public void deleteMaduranteProducto(MaduranteProducto entity) throws Exception;

	/**
	 * Update an existing MaduranteProducto entity
	 *
	 */
	public void updateMaduranteProducto(MaduranteProducto entity) throws Exception;

	/**
	 * Load an existing MaduranteProducto entity
	 *
	 */
	public MaduranteProducto getMaduranteProducto(MaduranteProductoId id) throws Exception;

	public List<MaduranteProducto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MaduranteProducto> findPageMaduranteProducto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMaduranteProducto() throws Exception;

	public List<MaduranteProductoDTO> getDataMaduranteProducto() throws Exception;
}
