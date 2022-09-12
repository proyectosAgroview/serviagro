package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.VehiculosTransp;
import co.com.arcosoft.modelo.dto.VehiculosTranspDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IVehiculosTranspLogic {
	public List<VehiculosTransp> getVehiculosTransp() throws Exception;

	/**
	 * Save an new VehiculosTransp entity
	 */
	public void saveVehiculosTransp(VehiculosTransp entity) throws Exception;

	/**
	 * Delete an existing VehiculosTransp entity
	 *
	 */
	public void deleteVehiculosTransp(VehiculosTransp entity) throws Exception;

	/**
	 * Update an existing VehiculosTransp entity
	 *
	 */
	public void updateVehiculosTransp(VehiculosTransp entity) throws Exception;

	/**
	 * Load an existing VehiculosTransp entity
	 *
	 */
	public VehiculosTransp getVehiculosTransp(Long vehiTranspId) throws Exception;

	public List<VehiculosTransp> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<VehiculosTransp> findPageVehiculosTransp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberVehiculosTransp() throws Exception;

	public List<VehiculosTranspDTO> getDataVehiculosTransp() throws Exception;
}
