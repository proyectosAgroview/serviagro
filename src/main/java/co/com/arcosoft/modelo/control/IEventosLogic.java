package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Eventos;
import co.com.arcosoft.modelo.dto.EventosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEventosLogic {
	public List<Eventos> getEventos() throws Exception;

	/**
	 * Save an new Eventos entity
	 */
	public void saveEventos(Eventos entity) throws Exception;

	/**
	 * Delete an existing Eventos entity
	 *
	 */
	public void deleteEventos(Eventos entity) throws Exception;

	/**
	 * Update an existing Eventos entity
	 *
	 */
	public void updateEventos(Eventos entity) throws Exception;

	/**
	 * Load an existing Eventos entity
	 *
	 */
	public Eventos getEventos(Long eventosId) throws Exception;

	public List<Eventos> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Eventos> findPageEventos(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEventos() throws Exception;

	public List<EventosDTO> getDataEventos() throws Exception;
}
