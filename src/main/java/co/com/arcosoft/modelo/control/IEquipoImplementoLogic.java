package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.EquipoImplemento;
import co.com.arcosoft.modelo.dto.EquipoImplementoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IEquipoImplementoLogic {
    public List<EquipoImplemento> getEquipoImplemento()
        throws Exception;

    /**
         * Save an new EquipoImplemento entity
         */
    public void saveEquipoImplemento(EquipoImplemento entity)
        throws Exception;

    /**
         * Delete an existing EquipoImplemento entity
         *
         */
    public void deleteEquipoImplemento(EquipoImplemento entity)
        throws Exception;

    /**
        * Update an existing EquipoImplemento entity
        *
        */
    public void updateEquipoImplemento(EquipoImplemento entity)
        throws Exception;

    /**
         * Load an existing EquipoImplemento entity
         *
         */
    public EquipoImplemento getEquipoImplemento(Long equipoImplementoId)
        throws Exception;

    public List<EquipoImplemento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EquipoImplemento> findPageEquipoImplemento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberEquipoImplemento() throws Exception;

    public List<EquipoImplementoDTO> getDataEquipoImplemento()
        throws Exception;
}
