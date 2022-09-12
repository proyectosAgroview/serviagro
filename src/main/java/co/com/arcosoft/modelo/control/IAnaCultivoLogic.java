package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AnaCultivo;
import co.com.arcosoft.modelo.dto.AnaCultivoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IAnaCultivoLogic {
	public List<AnaCultivo> getAnaCultivo() throws Exception;

	/**
	 * Save an new AnaCultivo entity
	 */
	public void saveAnaCultivo(AnaCultivo entity) throws Exception;

	/**
	 * Delete an existing AnaCultivo entity
	 *
	 */
	public void deleteAnaCultivo(AnaCultivo entity) throws Exception;

	/**
	 * Update an existing AnaCultivo entity
	 *
	 */
	public void updateAnaCultivo(AnaCultivo entity) throws Exception;

	/**
	 * Load an existing AnaCultivo entity
	 *
	 */
	public AnaCultivo getAnaCultivo(Long anaCultId) throws Exception;

	public List<AnaCultivo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AnaCultivo> findPageAnaCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAnaCultivo() throws Exception;

	public List<AnaCultivoDTO> getDataAnaCultivo() throws Exception;
}
