package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatProductosRelacionados;
import co.com.arcosoft.modelo.dto.DatProductosRelacionadosDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatProductosRelacionadosLogic {
    public List<DatProductosRelacionados> getDatProductosRelacionados()
        throws Exception;

    /**
         * Save an new DatProductosRelacionados entity
         */
    public void saveDatProductosRelacionados(DatProductosRelacionados entity)
        throws Exception;

    /**
         * Delete an existing DatProductosRelacionados entity
         *
         */
    public void deleteDatProductosRelacionados(DatProductosRelacionados entity)
        throws Exception;

    /**
        * Update an existing DatProductosRelacionados entity
        *
        */
    public void updateDatProductosRelacionados(DatProductosRelacionados entity)
        throws Exception;

    /**
         * Load an existing DatProductosRelacionados entity
         *
         */
    public DatProductosRelacionados getDatProductosRelacionados(
        Long datProductosAgregadosId) throws Exception;

    public List<DatProductosRelacionados> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatProductosRelacionados> findPageDatProductosRelacionados(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatProductosRelacionados()
        throws Exception;

    public List<DatProductosRelacionadosDTO> getDataDatProductosRelacionados()
        throws Exception;

    public List<DatProductosRelacionadosDTO> getDataDatProductosRelacionadosByProducto(Long productoId)
        throws Exception;
}
