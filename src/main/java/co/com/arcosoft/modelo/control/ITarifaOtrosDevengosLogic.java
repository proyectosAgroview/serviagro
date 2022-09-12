package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TarifaOtrosDevengos;
import co.com.arcosoft.modelo.dto.TarifaOtrosDevengosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITarifaOtrosDevengosLogic {
	public List<TarifaOtrosDevengos> getTarifaOtrosDevengos() throws Exception;

	/**
	 * Save an new TarifaOtrosDevengos entity
	 */
	public void saveTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception;

	/**
	 * Delete an existing TarifaOtrosDevengos entity
	 *
	 */
	public void deleteTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception;

	/**
	 * Update an existing TarifaOtrosDevengos entity
	 *
	 */
	public void updateTarifaOtrosDevengos(TarifaOtrosDevengos entity) throws Exception;

	/**
	 * Load an existing TarifaOtrosDevengos entity
	 *
	 */
	public TarifaOtrosDevengos getTarifaOtrosDevengos(Long odevengosId) throws Exception;

	public List<TarifaOtrosDevengos> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaOtrosDevengos> findPageTarifaOtrosDevengos(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTarifaOtrosDevengos() throws Exception;

	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengos() throws Exception;

	public List<TarifaOtrosDevengosDTO> getDataTarifaOtrosDevengosByTrabajador(Long Trabajador) throws Exception;

}
