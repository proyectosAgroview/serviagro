package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Infraestructura;
import co.com.arcosoft.modelo.dto.InfraestructuraDTO;
import co.com.arcosoft.modelo.dto.TarifaInfraestructuraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IInfraestructuraLogic {
	public List<Infraestructura> getInfraestructura() throws Exception;

	/**
	 * Save an new Infraestructura entity
	 */
	public void saveInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> dataTarifaInfraestructura)
			throws Exception;

	/**
	 * Delete an existing Infraestructura entity
	 *
	 */
	public void deleteInfraestructura(Infraestructura entity) throws Exception;

	/**
	 * Update an existing Infraestructura entity
	 *
	 */
	public void updateInfraestructura(Infraestructura entity, List<TarifaInfraestructuraDTO> dataTarifaInfraestructura)
			throws Exception;

	/**
	 * Load an existing Infraestructura entity
	 *
	 */
	public Infraestructura getInfraestructura(Long infraId) throws Exception;

	public List<Infraestructura> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Infraestructura> findPageInfraestructura(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberInfraestructura() throws Exception;

	public List<InfraestructuraDTO> getDataInfraestructura() throws Exception;
}
