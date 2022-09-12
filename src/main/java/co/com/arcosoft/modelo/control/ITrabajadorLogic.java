package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.dto.TarifaDeduccionDTO;
import co.com.arcosoft.modelo.dto.TarifaOtrosDevengosDTO;
import co.com.arcosoft.modelo.dto.TrabajadorDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITrabajadorLogic {
	public List<Trabajador> getTrabajador() throws Exception;

	/**
	 * Save an new Trabajador entity
	 */
	public void saveTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception;

	/**
	 * Delete an existing Trabajador entity
	 *
	 */
	public void deleteTrabajador(Trabajador entity) throws Exception;

	/**
	 * Update an existing Trabajador entity
	 *
	 */
	public void updateTrabajador(Trabajador entity, List<TarifaDeduccionDTO> dataTarifaDeduccion,
			List<TarifaOtrosDevengosDTO> dataTarifaDevengos) throws Exception;

	/**
	 * Load an existing Trabajador entity
	 *
	 */
	public Trabajador getTrabajador(Long trabId) throws Exception;

	public List<Trabajador> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Trabajador> findPageTrabajador(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTrabajador() throws Exception;

	public List<TrabajadorDTO> getDataTrabajador() throws Exception;

	public List<TrabajadorDTO> findByCriteriaPageTrabajador(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters, String modulo) throws Exception;

	public Long findTotalNumberTrabajador(Map<String, Object> filters) throws Exception;

}
