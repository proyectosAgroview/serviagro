package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Cultivo;
import co.com.arcosoft.modelo.dto.CultivoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICultivoLogic {
	public List<Cultivo> getCultivo() throws Exception;

	/**
	 * Save an new Cultivo entity
	 */
	public void saveCultivo(Cultivo entity) throws Exception;

	/**
	 * Delete an existing Cultivo entity
	 *
	 */
	public void deleteCultivo(Cultivo entity) throws Exception;

	/**
	 * Update an existing Cultivo entity
	 *
	 */
	public void updateCultivo(Cultivo entity) throws Exception;

	/**
	 * Load an existing Cultivo entity
	 *
	 */
	public Cultivo getCultivo(Long cultivoId) throws Exception;

	public List<Cultivo> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Cultivo> findPageCultivo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCultivo() throws Exception;

	public List<CultivoDTO> getDataCultivo() throws Exception;
}
