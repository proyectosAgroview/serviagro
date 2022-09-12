package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Empaque;
import co.com.arcosoft.modelo.dto.EmpaqueDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEmpaqueLogic {
	public List<Empaque> getEmpaque() throws Exception;

	/**
	 * Save an new Empaque entity
	 */
	public void saveEmpaque(Empaque entity) throws Exception;

	/**
	 * Delete an existing Empaque entity
	 *
	 */
	public void deleteEmpaque(Empaque entity) throws Exception;

	/**
	 * Update an existing Empaque entity
	 *
	 */
	public void updateEmpaque(Empaque entity) throws Exception;

	/**
	 * Load an existing Empaque entity
	 *
	 */
	public Empaque getEmpaque(Long empaqueId) throws Exception;

	public List<Empaque> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Empaque> findPageEmpaque(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEmpaque() throws Exception;

	public List<EmpaqueDTO> getDataEmpaque() throws Exception;
}
