package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AgenteCausadorParada;
import co.com.arcosoft.modelo.dto.AgenteCausadorParadaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IAgenteCausadorParadaLogic {
	public List<AgenteCausadorParada> getAgenteCausadorParada() throws Exception;

	/**
	 * Save an new AgenteCausadorParada entity
	 */
	public void saveAgenteCausadorParada(AgenteCausadorParada entity) throws Exception;

	/**
	 * Delete an existing AgenteCausadorParada entity
	 *
	 */
	public void deleteAgenteCausadorParada(AgenteCausadorParada entity) throws Exception;

	/**
	 * Update an existing AgenteCausadorParada entity
	 *
	 */
	public void updateAgenteCausadorParada(AgenteCausadorParada entity) throws Exception;

	/**
	 * Load an existing AgenteCausadorParada entity
	 *
	 */
	public AgenteCausadorParada getAgenteCausadorParada(Long agenteCausadorParadaId) throws Exception;

	public List<AgenteCausadorParada> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AgenteCausadorParada> findPageAgenteCausadorParada(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberAgenteCausadorParada() throws Exception;

	public List<AgenteCausadorParadaDTO> getDataAgenteCausadorParada() throws Exception;
}
