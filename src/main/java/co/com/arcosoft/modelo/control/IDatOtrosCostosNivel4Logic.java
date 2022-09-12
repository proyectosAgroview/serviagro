package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatOtrosCostosNivel4;
import co.com.arcosoft.modelo.dto.DatOtrosCostosNivel4DTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatOtrosCostosNivel4Logic {
	public List<DatOtrosCostosNivel4> getDatOtrosCostosNivel4() throws Exception;

	/**
	 * Save an new DatOtrosCostosNivel4 entity
	 */
	public void saveDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception;

	/**
	 * Delete an existing DatOtrosCostosNivel4 entity
	 *
	 */
	public void deleteDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception;

	/**
	 * Update an existing DatOtrosCostosNivel4 entity
	 *
	 */
	public void updateDatOtrosCostosNivel4(DatOtrosCostosNivel4 entity) throws Exception;

	/**
	 * Load an existing DatOtrosCostosNivel4 entity
	 *
	 */
	public DatOtrosCostosNivel4 getDatOtrosCostosNivel4(Long datOtrosCostosNivel4Id) throws Exception;

	public List<DatOtrosCostosNivel4> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatOtrosCostosNivel4> findPageDatOtrosCostosNivel4(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatOtrosCostosNivel4() throws Exception;

	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4() throws Exception;

	public List<DatOtrosCostosNivel4DTO> getDataDatOtrosCostosNivel4ByNivel4(Long idOtrosCostos) throws Exception;
}
