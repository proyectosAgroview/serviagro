package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.CuentaContable;
import co.com.arcosoft.modelo.dto.CuentaContableDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICuentaContableLogic {
	public List<CuentaContable> getCuentaContable() throws Exception;

	/**
	 * Save an new CuentaContable entity
	 */
	public void saveCuentaContable(CuentaContable entity) throws Exception;

	/**
	 * Delete an existing CuentaContable entity
	 *
	 */
	public void deleteCuentaContable(CuentaContable entity) throws Exception;

	/**
	 * Update an existing CuentaContable entity
	 *
	 */
	public void updateCuentaContable(CuentaContable entity) throws Exception;

	/**
	 * Load an existing CuentaContable entity
	 *
	 */
	public CuentaContable getCuentaContable(Long ccontableId) throws Exception;

	public List<CuentaContable> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CuentaContable> findPageCuentaContable(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCuentaContable() throws Exception;

	public List<CuentaContableDTO> getDataCuentaContable() throws Exception;
}
