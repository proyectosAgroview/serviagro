package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatHerramienta;
import co.com.arcosoft.modelo.dto.DatHerramientaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatHerramientaLogic {
	public List<DatHerramienta> getDatHerramienta() throws Exception;

	/**
	 * Save an new DatHerramienta entity
	 */
	public void saveDatHerramienta(DatHerramienta entity) throws Exception;

	/**
	 * Delete an existing DatHerramienta entity
	 *
	 */
	public void deleteDatHerramienta(DatHerramienta entity) throws Exception;

	/**
	 * Update an existing DatHerramienta entity
	 *
	 */
	public void updateDatHerramienta(DatHerramienta entity) throws Exception;

	/**
	 * Load an existing DatHerramienta entity
	 *
	 */
	public DatHerramienta getDatHerramienta(Long datHerramientaId)
			throws Exception;

	public List<DatHerramienta> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DatHerramienta> findPageDatHerramienta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatHerramienta() throws Exception;

	public List<DatHerramientaDTO> getDataDatHerramienta() throws Exception;
}
