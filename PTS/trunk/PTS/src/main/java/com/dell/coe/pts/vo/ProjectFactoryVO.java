package com.dell.coe.pts.vo;

import java.util.List;

/**
 * The Class ProjectFactoryVO.
 */
public class ProjectFactoryVO {

    /** The id. */
    private Integer id;

    /** The project vo list. */
    private List<ProjectVO> projectVOList;

    /**
     * Instantiates a new project factory vo.
     */
    public ProjectFactoryVO() {
    }

    /**
     * Instantiates a new project factory vo.
     *
     * @param id the id
     * @param projectVOList the project vo list
     */
    public ProjectFactoryVO(Integer id, List<ProjectVO> projectVOList) {
        super();
        this.id = id;
        this.projectVOList = projectVOList;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets the project vo list.
     *
     * @return the project vo list
     */
    public List<ProjectVO> getProjectVOList() {
        return projectVOList;
    }

    /**
     * Sets the project vo list.
     *
     * @param projectVOList the new project vo list
     */
    public void setProjectVOList(List<ProjectVO> projectVOList) {
        this.projectVOList = projectVOList;
    }

}
