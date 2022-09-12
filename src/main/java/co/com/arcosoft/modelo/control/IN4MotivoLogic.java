package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.N4Motivo;
import co.com.arcosoft.modelo.dto.N4MotivoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IN4MotivoLogic {
	public List<N4Motivo> getN4Motivo() throws Exception;

	/**
	 * Save an new N4Motivo entity
	 */
	public void saveN4Motivo(N4Motivo entity) throws Exception;

	/**
	 * Delete an existing N4Motivo entity
	 *
	 */
	public void deleteN4Motivo(N4Motivo entity) throws Exception;

	/**
	 * Update an existing N4Motivo entity
	 *
	 */
	public void updateN4Motivo(N4Motivo entity) throws Exception;

	/**
	 * Load an existing N4Motivo entity
	 *
	 */
	public N4Motivo getN4Motivo(Long n4Mot) throws Exception;

	public List<N4Motivo> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<N4Motivo> findPageN4Motivo(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberN4Motivo() throws Exception;

	public List<N4MotivoDTO> getDataN4Motivo() throws Exception;
}
