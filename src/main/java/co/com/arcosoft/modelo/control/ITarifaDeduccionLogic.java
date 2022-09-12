package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TarifaDeduccion;
import co.com.arcosoft.modelo.dto.TarifaDeduccionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITarifaDeduccionLogic {
	public List<TarifaDeduccion> getTarifaDeduccion() throws Exception;

	/**
	 * Save an new TarifaDeduccion entity
	 */
	public void saveTarifaDeduccion(TarifaDeduccion entity) throws Exception;

	/**
	 * Delete an existing TarifaDeduccion entity
	 *
	 */
	public void deleteTarifaDeduccion(TarifaDeduccion entity) throws Exception;

	/**
	 * Update an existing TarifaDeduccion entity
	 *
	 */
	public void updateTarifaDeduccion(TarifaDeduccion entity) throws Exception;

	/**
	 * Load an existing TarifaDeduccion entity
	 *
	 */
	public TarifaDeduccion getTarifaDeduccion(Long deduccionId) throws Exception;

	public List<TarifaDeduccion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaDeduccion> findPageTarifaDeduccion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaDeduccion() throws Exception;

	public List<TarifaDeduccionDTO> getDataTarifaDeduccion() throws Exception;

	public List<TarifaDeduccionDTO> getDataTarifaDeduccionByTrabajador(Long Trabajador) throws Exception;

}
