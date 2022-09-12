package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Calendario;
import co.com.arcosoft.modelo.dto.CalendarioDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ICalendarioLogic {
	public List<Calendario> getCalendario() throws Exception;

	/**
	 * Save an new Calendario entity
	 */
	public void saveCalendario(Calendario entity) throws Exception;

	/**
	 * Delete an existing Calendario entity
	 *
	 */
	public void deleteCalendario(Calendario entity) throws Exception;

	/**
	 * Update an existing Calendario entity
	 *
	 */
	public void updateCalendario(Calendario entity) throws Exception;

	/**
	 * Load an existing Calendario entity
	 *
	 */
	public Calendario getCalendario(Long calendarId) throws Exception;

	public List<Calendario> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Calendario> findPageCalendario(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCalendario() throws Exception;

	public List<CalendarioDTO> getDataCalendario() throws Exception;
}
