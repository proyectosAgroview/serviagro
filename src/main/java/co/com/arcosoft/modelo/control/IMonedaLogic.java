package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Moneda;
import co.com.arcosoft.modelo.dto.MonedaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IMonedaLogic {
	public List<Moneda> getMoneda() throws Exception;

	/**
	 * Save an new Moneda entity
	 */
	public void saveMoneda(Moneda entity) throws Exception;

	/**
	 * Delete an existing Moneda entity
	 *
	 */
	public void deleteMoneda(Moneda entity) throws Exception;

	/**
	 * Update an existing Moneda entity
	 *
	 */
	public void updateMoneda(Moneda entity) throws Exception;

	/**
	 * Load an existing Moneda entity
	 *
	 */
	public Moneda getMoneda(Long monedaId) throws Exception;

	public List<Moneda> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Moneda> findPageMoneda(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMoneda() throws Exception;

	public List<MonedaDTO> getDataMoneda() throws Exception;
}
