package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LaborServicio;
import co.com.arcosoft.modelo.LaborServicioId;
import co.com.arcosoft.modelo.dto.LaborServicioDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ILaborServicioLogic {
	public List<LaborServicio> getLaborServicio() throws Exception;

	/**
	 * Save an new LaborServicio entity
	 */
	public void saveLaborServicio(LaborServicio entity) throws Exception;

	/**
	 * Delete an existing LaborServicio entity
	 *
	 */
	public void deleteLaborServicio(LaborServicio entity) throws Exception;

	/**
	 * Update an existing LaborServicio entity
	 *
	 */
	public void updateLaborServicio(LaborServicio entity) throws Exception;

	/**
	 * Load an existing LaborServicio entity
	 *
	 */
	public LaborServicio getLaborServicio(LaborServicioId id) throws Exception;

	public List<LaborServicio> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LaborServicio> findPageLaborServicio(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLaborServicio() throws Exception;

	public List<LaborServicioDTO> getDataLaborServicio() throws Exception;
}
