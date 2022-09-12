package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Tag;
import co.com.arcosoft.modelo.dto.TagDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ITagLogic {
    public List<Tag> getTag() throws Exception;

    /**
         * Save an new Tag entity
         */
    public void saveTag(Tag entity) throws Exception;

    /**
         * Delete an existing Tag entity
         *
         */
    public void deleteTag(Tag entity) throws Exception;

    /**
        * Update an existing Tag entity
        *
        */
    public void updateTag(Tag entity) throws Exception;

    /**
         * Load an existing Tag entity
         *
         */
    public Tag getTag(Long tagId) throws Exception;

    public List<Tag> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Tag> findPageTag(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberTag() throws Exception;

    public List<TagDTO> getDataTag() throws Exception;
}
