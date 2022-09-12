package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatPagosNotasClientes;
import co.com.arcosoft.modelo.dto.DatPagosNotasClientesDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatPagosNotasClientesLogic {
    public List<DatPagosNotasClientes> getDatPagosNotasClientes()
        throws Exception;

    /**
         * Save an new DatPagosNotasClientes entity
         */
    public void saveDatPagosNotasClientes(DatPagosNotasClientes entity)
        throws Exception;

    /**
         * Delete an existing DatPagosNotasClientes entity
         *
         */
    public void deleteDatPagosNotasClientes(DatPagosNotasClientes entity)
        throws Exception;

    /**
        * Update an existing DatPagosNotasClientes entity
        *
        */
    public void updateDatPagosNotasClientes(DatPagosNotasClientes entity)
        throws Exception;

    /**
         * Load an existing DatPagosNotasClientes entity
         *
         */
    public DatPagosNotasClientes getDatPagosNotasClientes(
        Long datPagosNotasClientesId) throws Exception;

    public List<DatPagosNotasClientes> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatPagosNotasClientes> findPageDatPagosNotasClientes(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatPagosNotasClientes()
        throws Exception;

    public List<DatPagosNotasClientesDTO> getDataDatPagosNotasClientes()
        throws Exception;
}
