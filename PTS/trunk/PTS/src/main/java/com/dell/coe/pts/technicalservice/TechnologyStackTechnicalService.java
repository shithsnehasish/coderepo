/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.technicalservice;

import java.util.List;

import com.dell.coe.pts.vo.TechCategoryReportVO;
import com.dell.coe.pts.vo.TechnologyStackVO;
import com.dell.coe.virtuoso.common.service.AbstractService;

/**
 * The documentation of the interface TechnologyStackSerivce.
 *
 * @author 
 * @generated 
 */
public interface TechnologyStackTechnicalService extends AbstractService {

    /**
     * Creates the technology stack.
     *
     * @param technologystack the technologystack
     * @return the technology stack vo
     */
    TechnologyStackVO createTechnologyStack(TechnologyStackVO technologystack);

    /**
     * Update technology stack.
     *
     * @param technologystack the technologystack
     * @return the technology stack vo
     */
    TechnologyStackVO updateTechnologyStack(TechnologyStackVO technologystack);

    /**
     * Gets the technology stack by id.
     *
     * @param id the id
     * @return the technology stack by id
     */
    TechnologyStackVO getTechnologyStackById(Integer id);

    /**
     * Gets the all technology stack.
     *
     * @return the all technology stack
     */
    List<TechnologyStackVO> getAllTechnologyStack();

    /**
     * Removes the technology stack.
     *
     * @param technologystack the technologystack
     */
    void removeTechnologyStack(TechnologyStackVO technologystack);

    /**
     * Gets the all technology stack grouped by technology category.
     *
     * @return the all technology stack grouped by technology category
     */
    List<TechCategoryReportVO> getAllTechnologyStackGroupedByTechnologyCategory();
}
