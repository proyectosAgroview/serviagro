package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.SubTipoCotizante;
import co.com.arcosoft.modelo.dto.SubTipoCotizanteDTO;

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
public interface ISubTipoCotizanteLogic {
    public List<SubTipoCotizante> getSubTipoCotizante()
        throws Exception;

    /**
         * Save an new SubTipoCotizante entity
         */
    public void saveSubTipoCotizante(SubTipoCotizante entity)
        throws Exception;

    /**
         * Delete an existing SubTipoCotizante entity
         *
         */
    public void deleteSubTipoCotizante(SubTipoCotizante entity)
        throws Exception;

    /**
        * Update an existing SubTipoCotizante entity
        *
        */
    public void updateSubTipoCotizante(SubTipoCotizante entity)
        throws Exception;

    /**
         * Load an existing SubTipoCotizante entity
         *
         */
    public SubTipoCotizante getSubTipoCotizante(Long subTipoCotizanteId)
        throws Exception;

    public List<SubTipoCotizante> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<SubTipoCotizante> findPageSubTipoCotizante(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberSubTipoCotizante() throws Exception;

    public List<SubTipoCotizanteDTO> getDataSubTipoCotizante()
        throws Exception;
}
