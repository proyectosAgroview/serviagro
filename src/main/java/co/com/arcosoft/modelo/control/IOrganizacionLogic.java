package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Organizacion;
import co.com.arcosoft.modelo.dto.OrganizacionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IOrganizacionLogic {
	public List<Organizacion> getOrganizacion() throws Exception;

	/**
	 * Save an new Organizacion entity
	 */
	public void saveOrganizacion(Organizacion entity) throws Exception;

	/**
	 * Delete an existing Organizacion entity
	 *
	 */
	public void deleteOrganizacion(Organizacion entity) throws Exception;

	/**
	 * Update an existing Organizacion entity
	 *
	 */
	public void updateOrganizacion(Organizacion entity) throws Exception;

	/**
	 * Load an existing Organizacion entity
	 *
	 */
	public Organizacion getOrganizacion(Long organizId) throws Exception;

	public List<Organizacion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Organizacion> findPageOrganizacion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberOrganizacion() throws Exception;

	public List<OrganizacionDTO> getDataOrganizacion() throws Exception;
}
