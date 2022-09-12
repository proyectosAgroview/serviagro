package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.dto.MedidorDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IMedidorLogic {
	public List<Medidor> getMedidor() throws Exception;

	/**
	 * Save an new Medidor entity
	 */
	public void saveMedidor(Medidor entity) throws Exception;

	/**
	 * Delete an existing Medidor entity
	 *
	 */
	public void deleteMedidor(Medidor entity) throws Exception;

	/**
	 * Update an existing Medidor entity
	 *
	 */
	public void updateMedidor(Medidor entity) throws Exception;

	/**
	 * Load an existing Medidor entity
	 *
	 */
	public Medidor getMedidor(Long medidorId) throws Exception;

	public List<Medidor> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Medidor> findPageMedidor(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMedidor() throws Exception;

	public List<MedidorDTO> getDataMedidor() throws Exception;
}
