package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EstEvaporimetro;
import co.com.arcosoft.modelo.dto.EstEvaporimetroDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEstEvaporimetroLogic {
	public List<EstEvaporimetro> getEstEvaporimetro() throws Exception;

	/**
	 * Save an new EstEvaporimetro entity
	 */
	public void saveEstEvaporimetro(EstEvaporimetro entity) throws Exception;

	/**
	 * Delete an existing EstEvaporimetro entity
	 *
	 */
	public void deleteEstEvaporimetro(EstEvaporimetro entity) throws Exception;

	/**
	 * Update an existing EstEvaporimetro entity
	 *
	 */
	public void updateEstEvaporimetro(EstEvaporimetro entity) throws Exception;

	/**
	 * Load an existing EstEvaporimetro entity
	 *
	 */
	public EstEvaporimetro getEstEvaporimetro(Long estEvaporimetroId) throws Exception;

	public List<EstEvaporimetro> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstEvaporimetro> findPageEstEvaporimetro(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEstEvaporimetro() throws Exception;

	public List<EstEvaporimetroDTO> getDataEstEvaporimetro() throws Exception;
}
