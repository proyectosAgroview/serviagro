package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatNominaTrabajadorMq;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqdetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatNominaTrabajadorMqLogic {
    public List<DatNominaTrabajadorMq> getDatNominaTrabajadorMq()
        throws Exception;

    /**
         * Save an new DatNominaTrabajadorMq entity
         */
    public void saveDatNominaTrabajadorMq(DatNominaTrabajadorMq entity, List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador)
        throws Exception;

    /**
         * Delete an existing DatNominaTrabajadorMq entity
         *
         */
    public void deleteDatNominaTrabajadorMq(DatNominaTrabajadorMq entity)
        throws Exception;

    /**
        * Update an existing DatNominaTrabajadorMq entity
        *
        */
    public void updateDatNominaTrabajadorMq(DatNominaTrabajadorMq entity, List<DatNominaTrabajadorMqdetDTO> dataNominaTrabajador)
        throws Exception;

    /**
         * Load an existing DatNominaTrabajadorMq entity
         *
         */
    public DatNominaTrabajadorMq getDatNominaTrabajadorMq(
        Long datNominaTrabajadorMqId) throws Exception;

    public List<DatNominaTrabajadorMq> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatNominaTrabajadorMq> findPageDatNominaTrabajadorMq(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatNominaTrabajadorMq()
        throws Exception;

    public List<DatNominaTrabajadorMqDTO> getDataDatNominaTrabajadorMq()
        throws Exception;


}
