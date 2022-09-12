package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Profesion;
import co.com.arcosoft.modelo.dto.ProfesionDTO;
import co.com.arcosoft.modelo.dto.TarifaProfesionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IProfesionLogic {
	public List<Profesion> getProfesion() throws Exception;

	/**
	 * Save an new Profesion entity
	 */
	public void saveProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion) throws Exception;

	/**
	 * Delete an existing Profesion entity
	 *
	 */
	public void deleteProfesion(Profesion entity) throws Exception;

	/**
	 * Update an existing Profesion entity
	 *
	 */
	public void updateProfesion(Profesion entity, List<TarifaProfesionDTO> dataTarifaProfesion) throws Exception;

	/**
	 * Load an existing Profesion entity
	 *
	 */
	public Profesion getProfesion(Long profId) throws Exception;

	public List<Profesion> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Profesion> findPageProfesion(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberProfesion() throws Exception;

	public List<ProfesionDTO> getDataProfesion() throws Exception;
}
