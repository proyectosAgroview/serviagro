package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatNominaTrabajadorMqdet;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorMqdetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatNominaTrabajadorMqdetLogic {
    public List<DatNominaTrabajadorMqdet> getDatNominaTrabajadorMqdet()
        throws Exception;

    /**
         * Save an new DatNominaTrabajadorMqdet entity
         */
    public void saveDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity)
        throws Exception;

    /**
         * Delete an existing DatNominaTrabajadorMqdet entity
         *
         */
    public void deleteDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity)
        throws Exception;

    /**
        * Update an existing DatNominaTrabajadorMqdet entity
        *
        */
    public void updateDatNominaTrabajadorMqdet(DatNominaTrabajadorMqdet entity)
        throws Exception;

    /**
         * Load an existing DatNominaTrabajadorMqdet entity
         *
         */
    public DatNominaTrabajadorMqdet getDatNominaTrabajadorMqdet(
        Long datNominaTrabajadorMqdetId) throws Exception;

    public List<DatNominaTrabajadorMqdet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatNominaTrabajadorMqdet> findPageDatNominaTrabajadorMqdet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatNominaTrabajadorMqdet()
        throws Exception;

    public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdet()
        throws Exception;
    
    public List<DatNominaTrabajadorMqdetDTO> getDataDatNominaTrabajadorMqdetByNomina(Long idNomina) throws Exception;
}
