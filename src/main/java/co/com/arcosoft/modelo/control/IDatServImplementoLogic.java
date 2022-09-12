package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatServImplemento;
import co.com.arcosoft.modelo.dto.DatServImplementoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatServImplementoLogic {
	public List<DatServImplemento> getDatServImplemento() throws Exception;

	/**
	 * Save an new DatServImplemento entity
	 */
	public void saveDatServImplemento(DatServImplemento entity) throws Exception;

	/**
	 * Delete an existing DatServImplemento entity
	 *
	 */
	public void deleteDatServImplemento(DatServImplemento entity) throws Exception;

	/**
	 * Update an existing DatServImplemento entity
	 *
	 */
	public void updateDatServImplemento(DatServImplemento entity) throws Exception;

	/**
	 * Load an existing DatServImplemento entity
	 *
	 */
	public DatServImplemento getDatServImplemento(Long datServImpleId) throws Exception;

	public List<DatServImplemento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatServImplemento> findPageDatServImplemento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatServImplemento() throws Exception;

	public List<DatServImplementoDTO> getDataDatServImplemento() throws Exception;
}
