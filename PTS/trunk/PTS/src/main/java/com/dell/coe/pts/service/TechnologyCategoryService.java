/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.service;

import java.util.List;

import com.dell.coe.pts.vo.ProjectTechCategoryVO;
import com.dell.coe.pts.vo.TechnologyCategoryVO;
import com.dell.coe.virtuoso.common.service.AbstractService;

/**
 * The documentation of the interface TechnologyCategoryService.
 *
 * @author 
 * @generated 
 */
public interface TechnologyCategoryService extends AbstractService {

    /**
     * Retrieve technology categoryby name.
     *
     * @param categoryName the category name
     * @return the technology category vo
     */
    TechnologyCategoryVO retrieveTechnologyCategorybyName(String categoryName);

    /**
     * Retrieve technology category distribution.
     *
     * @return the list
     */
    List<ProjectTechCategoryVO> retrieveTechnologyCategoryDistribution();

    /**
     * Retrieve retrieveTechnologyCategoryList .
     *
     * 
     * @return the list
     */
    List<TechnologyCategoryVO> retrieveTechnologyCategoryList();

}
