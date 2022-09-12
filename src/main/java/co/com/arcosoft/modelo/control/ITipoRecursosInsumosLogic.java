package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoRecursosInsumos;
import co.com.arcosoft.modelo.dto.TipoRecursosInsumosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoRecursosInsumosLogic {
	public List<TipoRecursosInsumos> getTipoRecursosInsumos() throws Exception;

	/**
	 * Save an new TipoRecursosInsumos entity
	 */
	public void saveTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception;

	/**
	 * Delete an existing TipoRecursosInsumos entity
	 *
	 */
	public void deleteTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception;

	/**
	 * Update an existing TipoRecursosInsumos entity
	 *
	 */
	public void updateTipoRecursosInsumos(TipoRecursosInsumos entity) throws Exception;

	/**
	 * Load an existing TipoRecursosInsumos entity
	 *
	 */
	public TipoRecursosInsumos getTipoRecursosInsumos(Long tipoRecursosInsumosId) throws Exception;

	public List<TipoRecursosInsumos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosInsumos> findPageTipoRecursosInsumos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosInsumos() throws Exception;

	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumos() throws Exception;

	public List<TipoRecursosInsumosDTO> getDataTipoRecursosInsumosByInsumos(Long tipoRecursosInsumosId)
			throws Exception;

}
