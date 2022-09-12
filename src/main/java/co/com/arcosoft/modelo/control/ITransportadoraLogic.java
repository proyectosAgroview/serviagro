package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Transportadora;
import co.com.arcosoft.modelo.dto.TransportadoraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITransportadoraLogic {
	public List<Transportadora> getTransportadora() throws Exception;

	/**
	 * Save an new Transportadora entity
	 */
	public void saveTransportadora(Transportadora entity) throws Exception;

	/**
	 * Delete an existing Transportadora entity
	 *
	 */
	public void deleteTransportadora(Transportadora entity) throws Exception;

	/**
	 * Update an existing Transportadora entity
	 *
	 */
	public void updateTransportadora(Transportadora entity) throws Exception;

	/**
	 * Load an existing Transportadora entity
	 *
	 */
	public Transportadora getTransportadora(Long transpId) throws Exception;

	public List<Transportadora> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<Transportadora> findPageTransportadora(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTransportadora() throws Exception;

	public List<TransportadoraDTO> getDataTransportadora() throws Exception;
}
