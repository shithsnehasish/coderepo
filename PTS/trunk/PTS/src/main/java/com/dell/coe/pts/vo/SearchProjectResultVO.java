/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.vo;

import java.util.Set;

/**
 * The documentation of the class SearchResultVO.
 *
 * @author 
 * @generated 
 */
public class SearchProjectResultVO {

    /** The project vo. */
    private ProjectVO projectVO;

    /** The technology stack v os. */
    private Set<TechnologyStackVO> technologyStackVOs;

    /**
     * The documentation of the constructor.
     * 
     * @generated
     */
    public SearchProjectResultVO() {
        super();
    }

    /**
     * Gets the project.
     *
     * @return the project
     */
    public ProjectVO getProject() {
        return projectVO;
    }

    /**
     * Sets the project.
     *
     * @param project the project to set
     */
    public void setProject(ProjectVO project) {
        this.projectVO = project;
    }

    /**
     * Gets the technology stack v os.
     *
     * @return the technologyStacks
     */
    public Set<TechnologyStackVO> getTechnologyStackVOs() {
        return technologyStackVOs;
    }

    /**
     * Sets the technology stack v os.
     *
     * @param technologyStackVOs the technologyStacks to set
     */
    public void setTechnologyStackVOs(Set<TechnologyStackVO> technologyStackVOs) {
        this.technologyStackVOs = technologyStackVOs;
    }

}
