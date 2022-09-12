package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EquipoTrabajo;
import co.com.arcosoft.modelo.dto.EquipoTrabajoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEquipoTrabajoLogic {
	public List<EquipoTrabajo> getEquipoTrabajo() throws Exception;

	/**
	 * Save an new EquipoTrabajo entity
	 */
	public void saveEquipoTrabajo(EquipoTrabajo entity) throws Exception;

	/**
	 * Delete an existing EquipoTrabajo entity
	 *
	 */
	public void deleteEquipoTrabajo(EquipoTrabajo entity) throws Exception;

	/**
	 * Update an existing EquipoTrabajo entity
	 *
	 */
	public void updateEquipoTrabajo(EquipoTrabajo entity) throws Exception;

	/**
	 * Load an existing EquipoTrabajo entity
	 *
	 */
	public EquipoTrabajo getEquipoTrabajo(Long eqpTrabId) throws Exception;

	public List<EquipoTrabajo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EquipoTrabajo> findPageEquipoTrabajo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEquipoTrabajo() throws Exception;

	public List<EquipoTrabajoDTO> getDataEquipoTrabajo() throws Exception;
}
