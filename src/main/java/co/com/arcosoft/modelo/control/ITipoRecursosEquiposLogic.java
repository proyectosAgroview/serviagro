package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoRecursosEquipos;
import co.com.arcosoft.modelo.dto.TipoRecursosEquiposDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoRecursosEquiposLogic {
	public List<TipoRecursosEquipos> getTipoRecursosEquipos() throws Exception;

	/**
	 * Save an new TipoRecursosEquipos entity
	 */
	public void saveTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception;

	/**
	 * Delete an existing TipoRecursosEquipos entity
	 *
	 */
	public void deleteTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception;

	/**
	 * Update an existing TipoRecursosEquipos entity
	 *
	 */
	public void updateTipoRecursosEquipos(TipoRecursosEquipos entity) throws Exception;

	/**
	 * Load an existing TipoRecursosEquipos entity
	 *
	 */
	public TipoRecursosEquipos getTipoRecursosEquipos(Long tipoRecursosEquiposId) throws Exception;

	public List<TipoRecursosEquipos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosEquipos> findPageTipoRecursosEquipos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosEquipos() throws Exception;

	public List<TipoRecursosEquiposDTO> getDataTipoRecursosEquipos() throws Exception;

	public List<TipoRecursosEquiposDTO> getDataTipoRecursosEquiposByEquipos(Long tipoRecursosEquiposId)
			throws Exception;

}
