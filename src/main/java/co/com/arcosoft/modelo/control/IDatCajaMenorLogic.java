package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatCajaMenor;
import co.com.arcosoft.modelo.dto.DatCajaMenorDTO;
import co.com.arcosoft.modelo.dto.DatCajaMenorDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatCajaMenorLogic {
    public List<DatCajaMenor> getDatCajaMenor() throws Exception;

    /**
         * Save an new DatCajaMenor entity
         */
 

    /**
         * Delete an existing DatCajaMenor entity
         *
         */
    public void deleteDatCajaMenor(DatCajaMenor entity)
        throws Exception;

    /**
        * Update an existing DatCajaMenor entity
        *
        */
   

    /**
         * Load an existing DatCajaMenor entity
         *
         */
    public DatCajaMenor getDatCajaMenor(Long datCajaMenorId)
        throws Exception;

    public List<DatCajaMenor> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatCajaMenor> findPageDatCajaMenor(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDatCajaMenor() throws Exception;

    public List<DatCajaMenorDTO> getDataDatCajaMenor()
        throws Exception;
    
    public void updateDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor)
            throws Exception ;
    		
      public void saveDatCajaMenor(DatCajaMenor entity, List<DatCajaMenorDetDTO> dataCajaMenor) throws Exception ;

}
