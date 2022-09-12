package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.FlotaTransporte;
import co.com.arcosoft.modelo.dto.FlotaTransporteDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IFlotaTransporteLogic {
	public List<FlotaTransporte> getFlotaTransporte() throws Exception;

	/**
	 * Save an new FlotaTransporte entity
	 */
	public void saveFlotaTransporte(FlotaTransporte entity) throws Exception;

	/**
	 * Delete an existing FlotaTransporte entity
	 *
	 */
	public void deleteFlotaTransporte(FlotaTransporte entity) throws Exception;

	/**
	 * Update an existing FlotaTransporte entity
	 *
	 */
	public void updateFlotaTransporte(FlotaTransporte entity) throws Exception;

	/**
	 * Load an existing FlotaTransporte entity
	 *
	 */
	public FlotaTransporte getFlotaTransporte(Long flotaTranspId) throws Exception;

	public List<FlotaTransporte> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FlotaTransporte> findPageFlotaTransporte(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFlotaTransporte() throws Exception;

	public List<FlotaTransporteDTO> getDataFlotaTransporte() throws Exception;

	public List<FlotaTransporteDTO> findByCriteriaPageFlotaTransporte(int startRow, int pageSize, String sortField,
			boolean sortOrder, Map<String, Object> filters) throws Exception;

	public Long findTotalNumberFlotaTransporte(Map<String, Object> filters) throws Exception;

}
