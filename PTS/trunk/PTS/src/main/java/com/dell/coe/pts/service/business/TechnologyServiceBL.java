/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.service.business;

import java.util.List;

import com.dell.coe.pts.vo.TechnologyStackVO;

/**
 * The documentation of the interface TechnologyServiceBL.
 *
 * @author 
 * @generated 
 */
public interface TechnologyServiceBL {

    /**
     * The documentation of the method retrieveTechnologybyKeyword. 
     *
     * @param keyword the keyword
     * @param technologyCatId the technology cat id
     * @return the list
     * @generated 
     */
    List<TechnologyStackVO> retrieveTechnologybyKeyword(String keyword, Integer technologyCatId);

    // Start of user code For declaring your own operations for TechnologyService
    // add addtional operations here
    // any more comments
    TechnologyStackVO retrieveTechnologybyNameandVersion(String name, String version);

    /**
     * Retrieve technology by Name.
     *
     * @param keyword the technology Name
     * @param technologyCatId the technology cat id
     * @return the list
     */
    List<TechnologyStackVO> retrieveTechVersionbyTechName(String techName, Integer technologyCatId);

    /**
     * Retrieve retrieveTechnologyStackList .
     *
     * 
     * @return the list
     */
    List<TechnologyStackVO> retrieveTechnologyStackList();
    // End of user code

    List<TechnologyStackVO> retrieveOrderedTechnologyStack(Integer technologyCatId);
}