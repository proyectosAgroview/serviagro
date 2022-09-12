package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ClaseTextSuelo;
import co.com.arcosoft.modelo.dto.ClaseTextSueloDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IClaseTextSueloLogic {
	public List<ClaseTextSuelo> getClaseTextSuelo() throws Exception;

	/**
	 * Save an new ClaseTextSuelo entity
	 */
	public void saveClaseTextSuelo(ClaseTextSuelo entity) throws Exception;

	/**
	 * Delete an existing ClaseTextSuelo entity
	 *
	 */
	public void deleteClaseTextSuelo(ClaseTextSuelo entity) throws Exception;

	/**
	 * Update an existing ClaseTextSuelo entity
	 *
	 */
	public void updateClaseTextSuelo(ClaseTextSuelo entity) throws Exception;

	/**
	 * Load an existing ClaseTextSuelo entity
	 *
	 */
	public ClaseTextSuelo getClaseTextSuelo(Long claseTextSueloId) throws Exception;

	public List<ClaseTextSuelo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ClaseTextSuelo> findPageClaseTextSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberClaseTextSuelo() throws Exception;

	public List<ClaseTextSueloDTO> getDataClaseTextSuelo() throws Exception;
}
