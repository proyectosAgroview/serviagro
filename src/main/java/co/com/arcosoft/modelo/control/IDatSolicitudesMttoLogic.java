package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatSolicitudesMtto;
import co.com.arcosoft.modelo.dto.DatSolicitudesMttoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatSolicitudesMttoLogic {
    public List<DatSolicitudesMtto> getDatSolicitudesMtto()
        throws Exception;

    /**
         * Save an new DatSolicitudesMtto entity
         */
    public void saveDatSolicitudesMtto(DatSolicitudesMtto entity)
        throws Exception;

    /**
         * Delete an existing DatSolicitudesMtto entity
         *
         */
    public void deleteDatSolicitudesMtto(DatSolicitudesMtto entity)
        throws Exception;

    /**
        * Update an existing DatSolicitudesMtto entity
        *
        */
    public void updateDatSolicitudesMtto(DatSolicitudesMtto entity)
        throws Exception;

    /**
         * Load an existing DatSolicitudesMtto entity
         *
         */
    public DatSolicitudesMtto getDatSolicitudesMtto(Long datSolicitudesMttoId)
        throws Exception;

    public List<DatSolicitudesMtto> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatSolicitudesMtto> findPageDatSolicitudesMtto(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatSolicitudesMtto() throws Exception;

    public List<DatSolicitudesMttoDTO> getDataDatSolicitudesMtto()
        throws Exception;
}
