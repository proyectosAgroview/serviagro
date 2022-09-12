package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.dto.AlmacenDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IAlmacenLogic {
	public List<Almacen> getAlmacen() throws Exception;

	/**
	 * Save an new Almacen entity
	 */
	public void saveAlmacen(Almacen entity) throws Exception;

	/**
	 * Delete an existing Almacen entity
	 *
	 */
	public void deleteAlmacen(Almacen entity) throws Exception;

	/**
	 * Update an existing Almacen entity
	 *
	 */
	public void updateAlmacen(Almacen entity) throws Exception;

	/**
	 * Load an existing Almacen entity
	 *
	 */
	public Almacen getAlmacen(Long almacenId) throws Exception;

	public List<Almacen> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Almacen> findPageAlmacen(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberAlmacen() throws Exception;

	public List<AlmacenDTO> getDataAlmacen(Long companiaUserId) throws Exception;
}
