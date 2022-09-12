package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ModalidadCosecha;
import co.com.arcosoft.modelo.dto.ModalidadCosechaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IModalidadCosechaLogic {
	public List<ModalidadCosecha> getModalidadCosecha() throws Exception;

	/**
	 * Save an new ModalidadCosecha entity
	 */
	public void saveModalidadCosecha(ModalidadCosecha entity) throws Exception;

	/**
	 * Delete an existing ModalidadCosecha entity
	 *
	 */
	public void deleteModalidadCosecha(ModalidadCosecha entity) throws Exception;

	/**
	 * Update an existing ModalidadCosecha entity
	 *
	 */
	public void updateModalidadCosecha(ModalidadCosecha entity) throws Exception;

	/**
	 * Load an existing ModalidadCosecha entity
	 *
	 */
	public ModalidadCosecha getModalidadCosecha(Long modalidadCosId) throws Exception;

	public List<ModalidadCosecha> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ModalidadCosecha> findPageModalidadCosecha(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberModalidadCosecha() throws Exception;

	public List<ModalidadCosechaDTO> getDataModalidadCosecha() throws Exception;
}
