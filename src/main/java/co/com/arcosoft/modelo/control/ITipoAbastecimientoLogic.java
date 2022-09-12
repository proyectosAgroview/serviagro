package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoAbastecimiento;
import co.com.arcosoft.modelo.dto.TipoAbastecimientoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoAbastecimientoLogic {
	public List<TipoAbastecimiento> getTipoAbastecimiento() throws Exception;

	/**
	 * Save an new TipoAbastecimiento entity
	 */
	public void saveTipoAbastecimiento(TipoAbastecimiento entity) throws Exception;

	/**
	 * Delete an existing TipoAbastecimiento entity
	 *
	 */
	public void deleteTipoAbastecimiento(TipoAbastecimiento entity) throws Exception;

	/**
	 * Update an existing TipoAbastecimiento entity
	 *
	 */
	public void updateTipoAbastecimiento(TipoAbastecimiento entity) throws Exception;

	/**
	 * Load an existing TipoAbastecimiento entity
	 *
	 */
	public TipoAbastecimiento getTipoAbastecimiento(Long tipoAbastecimientoId) throws Exception;

	public List<TipoAbastecimiento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoAbastecimiento> findPageTipoAbastecimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoAbastecimiento() throws Exception;

	public List<TipoAbastecimientoDTO> getDataTipoAbastecimiento() throws Exception;
}
