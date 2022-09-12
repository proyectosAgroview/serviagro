package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Conductor;
import co.com.arcosoft.modelo.dto.ConductorDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IConductorLogic {
	public List<Conductor> getConductor() throws Exception;

	/**
	 * Save an new Conductor entity
	 */
	public void saveConductor(Conductor entity) throws Exception;

	/**
	 * Delete an existing Conductor entity
	 *
	 */
	public void deleteConductor(Conductor entity) throws Exception;

	/**
	 * Update an existing Conductor entity
	 *
	 */
	public void updateConductor(Conductor entity) throws Exception;

	/**
	 * Load an existing Conductor entity
	 *
	 */
	public Conductor getConductor(Long conductorId) throws Exception;

	public List<Conductor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Conductor> findPageConductor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberConductor() throws Exception;

	public List<ConductorDTO> getDataConductor() throws Exception;
}
