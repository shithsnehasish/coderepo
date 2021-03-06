/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.technicalservice.business;

import java.util.List;

import com.dell.coe.pts.vo.ProjectVO;

/**
 * The documentation of the interface ProjectTechnicalBL.
 *
 * @author 
 * @generated 
 */
public interface ProjectTechnicalBL {

    /**
     * Creates the project.
     *
     * @param project the project
     * @return the project vo
     */
    ProjectVO createProject(ProjectVO project);

    /**
     * Update project.
     *
     * @param project the project
     * @return the project vo
     */
    ProjectVO updateProject(ProjectVO project);

    /**
     * Gets the project by id.
     *
     * @param id the id
     * @return the project by id
     */
    ProjectVO getProjectById(Integer id);

    /**
     * Gets the all project.
     *
     * @return the all project
     */
    List<ProjectVO> getAllProject();

    /**
     * Removes the project.
     *
     * @param project the project
     */
    void removeProject(ProjectVO project);
}
