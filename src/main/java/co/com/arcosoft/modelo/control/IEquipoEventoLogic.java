package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EquipoEvento;
import co.com.arcosoft.modelo.dto.EquipoEventoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEquipoEventoLogic {
	public List<EquipoEvento> getEquipoEvento() throws Exception;

	/**
	 * Save an new EquipoEvento entity
	 */
	public void saveEquipoEvento(EquipoEvento entity) throws Exception;

	/**
	 * Delete an existing EquipoEvento entity
	 *
	 */
	public void deleteEquipoEvento(EquipoEvento entity) throws Exception;

	/**
	 * Update an existing EquipoEvento entity
	 *
	 */
	public void updateEquipoEvento(EquipoEvento entity) throws Exception;

	/**
	 * Load an existing EquipoEvento entity
	 *
	 */
	public EquipoEvento getEquipoEvento(Long id) throws Exception;

	public List<EquipoEvento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EquipoEvento> findPageEquipoEvento(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberEquipoEvento() throws Exception;

	public List<EquipoEventoDTO> getDataEquipoEvento() throws Exception;

	public List<EquipoEventoDTO> getDataEquipoEventoByEquipoId(Long equipoId) throws Exception;

	public List<EquipoEventoDTO> getDataEquipoEventoByEquipoIdCompaniaId(Long equipoId, Long compania) throws Exception;

}
