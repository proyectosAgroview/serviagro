package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.TipoCotizante;
import co.com.arcosoft.modelo.dto.TipoCotizanteDTO;

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
public interface ITipoCotizanteLogic {
    public List<TipoCotizante> getTipoCotizante() throws Exception;

    /**
         * Save an new TipoCotizante entity
         */
    public void saveTipoCotizante(TipoCotizante entity)
        throws Exception;

    /**
         * Delete an existing TipoCotizante entity
         *
         */
    public void deleteTipoCotizante(TipoCotizante entity)
        throws Exception;

    /**
        * Update an existing TipoCotizante entity
        *
        */
    public void updateTipoCotizante(TipoCotizante entity)
        throws Exception;

    /**
         * Load an existing TipoCotizante entity
         *
         */
    public TipoCotizante getTipoCotizante(Long tipoCotizanteId)
        throws Exception;

    public List<TipoCotizante> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<TipoCotizante> findPageTipoCotizante(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTipoCotizante() throws Exception;

    public List<TipoCotizanteDTO> getDataTipoCotizante()
        throws Exception;
}
