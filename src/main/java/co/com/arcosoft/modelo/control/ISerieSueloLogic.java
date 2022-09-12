package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.SerieSuelo;
import co.com.arcosoft.modelo.dto.SerieSueloDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ISerieSueloLogic {
	public List<SerieSuelo> getSerieSuelo() throws Exception;

	/**
	 * Save an new SerieSuelo entity
	 */
	public void saveSerieSuelo(SerieSuelo entity) throws Exception;

	/**
	 * Delete an existing SerieSuelo entity
	 *
	 */
	public void deleteSerieSuelo(SerieSuelo entity) throws Exception;

	/**
	 * Update an existing SerieSuelo entity
	 *
	 */
	public void updateSerieSuelo(SerieSuelo entity) throws Exception;

	/**
	 * Load an existing SerieSuelo entity
	 *
	 */
	public SerieSuelo getSerieSuelo(Long serieSueloId) throws Exception;

	public List<SerieSuelo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SerieSuelo> findPageSerieSuelo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSerieSuelo() throws Exception;

	public List<SerieSueloDTO> getDataSerieSuelo() throws Exception;
}
