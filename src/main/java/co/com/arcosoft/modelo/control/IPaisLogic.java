package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Pais;
import co.com.arcosoft.modelo.dto.PaisDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IPaisLogic {
	public List<Pais> getPais() throws Exception;

	/**
	 * Save an new Pais entity
	 */
	public void savePais(Pais entity) throws Exception;

	/**
	 * Delete an existing Pais entity
	 *
	 */
	public void deletePais(Pais entity) throws Exception;

	/**
	 * Update an existing Pais entity
	 *
	 */
	public void updatePais(Pais entity) throws Exception;

	/**
	 * Load an existing Pais entity
	 *
	 */
	public Pais getPais(Long paisId) throws Exception;

	public List<Pais> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Pais> findPagePais(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPais() throws Exception;

	public List<PaisDTO> getDataPais() throws Exception;
}
