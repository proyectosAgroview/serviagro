package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.DatClimat;
import co.com.arcosoft.modelo.dto.DatClimatDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatClimatLogic {
	public List<DatClimat> getDatClimat() throws Exception;

	/**
	 * Save an new DatClimat entity
	 */
	public void saveDatClimat(DatClimat entity) throws Exception;

	/**
	 * Delete an existing DatClimat entity
	 *
	 */
	public void deleteDatClimat(DatClimat entity) throws Exception;

	/**
	 * Update an existing DatClimat entity
	 *
	 */
	public void updateDatClimat(DatClimat entity) throws Exception;

	/**
	 * Load an existing DatClimat entity
	 *
	 */
	public DatClimat getDatClimat(Long datsClimatoId) throws Exception;

	public List<DatClimat> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DatClimat> findPageDatClimat(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDatClimat() throws Exception;

	public List<DatClimatDTO> getDataDatClimat() throws Exception;

	public List<DatClimatDTO> findByCriteriaPageClima(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberClima(Map<String, Object> filters) throws Exception;

}
