/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.persistence.dao;

import java.util.List;
import java.util.Map;

import com.dell.coe.pts.common.dao.BaseDao;
import com.dell.coe.pts.persistence.TechnologyStack;
import com.dell.coe.pts.vo.SearchCriteriaVO;
import com.dell.coe.pts.vo.SearchResultVO;
import com.dell.coe.pts.vo.TechnologyStackVO;

/**
 * The documentation of the class TechnologyStackDao.
 *
 * @author 
 * @generated 
 */
public interface TechnologyStackDao extends BaseDao<TechnologyStack> {

    /**
     * Retrieve project vs category data.
     *
     * @param topValues the top values
     * @return the map
     */
    Map<String, Integer> retrieveProjectVsCategoryData(int topValues);

    /**
     * Retrieve project vs technology data.
     *
     * @param topValues the top values
     * @return the map
     */
    Map<String, Integer> retrieveProjectVsTechnologyData(int topValues);

    /**
     * Execute search criteria.
     *
     * @param criteriaVOs the criteria v os
     * @param isPagedQuery the is paged query
     * @param totalCount the total count
     * @param pageNumber the page number
     * @return the search result vo
     */
    SearchResultVO executeSearchCriteria(List<SearchCriteriaVO> criteriaVOs, Boolean isPagedQuery, Integer totalCount, Integer pageNumber);

    /**
     * Gets the all technology stack count.
     *
     * @return the all technology stack count
     */
    Long getAllTechnologyStackCount();

    /**
     * Gets the all technology stack.
     *
     * @return the all technology stack
     */
    List<TechnologyStack> getAllTechnologyStack();

    /**
     * Retrieve technology by keyword.
     *
     * @param keyword the keyword
     * @param technologyCatId the technology cat id
     * @return the list
     */
    List<TechnologyStack> retrieveTechnologybyKeyword(String keyword, Integer technologyCatId);

    /**
     * Retrieve technology by nameand version.
     *
     * @param techName the tech name
     * @param techVersion the tech version
     * @return the technology stack
     */
    TechnologyStack retrieveTechnologybyNameandVersion(String techName, String techVersion);

    /**
     * Retrieve technology by Name.
     *
     * @param techName the tech name
     * @param technologyCatId the technology cat id
     * @return the list
     */
    List<TechnologyStack> retrieveTechnologybyName(String techName, Integer technologyCatId);

    /**
     * Retrieve ordered technology stack collection.
     *
     * @param technologyCatId the technology cat id
     * @return the list
     */
    List<TechnologyStack> retrieveOrderedTechnologyStack(Integer technologyCatId);

    /**
     * Retrieve getTechnologyStackList .
     *
     * 
     * @return the list
     */
    List<TechnologyStackVO> getTechnologyStackList();

}
