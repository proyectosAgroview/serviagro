package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoMantenimiento;
import co.com.arcosoft.modelo.dto.TipoMantenimientoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoMantenimientoLogic {
	public List<TipoMantenimiento> getTipoMantenimiento() throws Exception;

	/**
	 * Save an new TipoMantenimiento entity
	 */
	public void saveTipoMantenimiento(TipoMantenimiento entity) throws Exception;

	/**
	 * Delete an existing TipoMantenimiento entity
	 *
	 */
	public void deleteTipoMantenimiento(TipoMantenimiento entity) throws Exception;

	/**
	 * Update an existing TipoMantenimiento entity
	 *
	 */
	public void updateTipoMantenimiento(TipoMantenimiento entity) throws Exception;

	/**
	 * Load an existing TipoMantenimiento entity
	 *
	 */
	public TipoMantenimiento getTipoMantenimiento(Long tipoMantenimientoId) throws Exception;

	public List<TipoMantenimiento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoMantenimiento> findPageTipoMantenimiento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoMantenimiento() throws Exception;

	public List<TipoMantenimientoDTO> getDataTipoMantenimiento() throws Exception;
}
