package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.FliaTextSuelo;
import co.com.arcosoft.modelo.dto.FliaTextSueloDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IFliaTextSueloLogic {
	public List<FliaTextSuelo> getFliaTextSuelo() throws Exception;

	/**
	 * Save an new FliaTextSuelo entity
	 */
	public void saveFliaTextSuelo(FliaTextSuelo entity) throws Exception;

	/**
	 * Delete an existing FliaTextSuelo entity
	 *
	 */
	public void deleteFliaTextSuelo(FliaTextSuelo entity) throws Exception;

	/**
	 * Update an existing FliaTextSuelo entity
	 *
	 */
	public void updateFliaTextSuelo(FliaTextSuelo entity) throws Exception;

	/**
	 * Load an existing FliaTextSuelo entity
	 *
	 */
	public FliaTextSuelo getFliaTextSuelo(Long fliaTextSueloId) throws Exception;

	public List<FliaTextSuelo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FliaTextSuelo> findPageFliaTextSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFliaTextSuelo() throws Exception;

	public List<FliaTextSueloDTO> getDataFliaTextSuelo() throws Exception;
}
