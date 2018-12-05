package com.dell.coe.pts.vo;

import java.util.Set;

/**
 * The Class ProjectVO.
 */
public class ProjectVO {

    /** The project id. */
    private Integer projectId;

    /** The proj type. */
    private String projType;

    /** The proj name. */
    private String projName;

    /** The technologystack. */
    private Set<ProjectTechnologyStackVO> technologystack;

    /** The version. */
    private int version = 0;

    /**
     * Gets the project id.
     *
     * @return the project id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * Sets the project id.
     *
     * @param projectId the new project id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * Gets the proj type.
     *
     * @return the proj type
     */
    public String getProjType() {
        return projType;
    }

    /**
     * Sets the proj type.
     *
     * @param projType the new proj type
     */
    public void setProjType(String projType) {
        this.projType = projType;
    }

    /**
     * Gets the proj name.
     *
     * @return the proj name
     */
    public String getProjName() {
        return projName;
    }

    /**
     * Sets the proj name.
     *
     * @param projName the new proj name
     */
    public void setProjName(String projName) {
        this.projName = projName;
    }

    /**
     * Gets the technologystack.
     *
     * @return the technologystack
     */
    public Set<ProjectTechnologyStackVO> getTechnologystack() {
        return technologystack;
    }

    /**
     * Sets the technologystack.
     *
     * @param technologystack the new technologystack
     */
    public void setTechnologystack(Set<ProjectTechnologyStackVO> technologystack) {
        this.technologystack = technologystack;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version the new version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * 
     */
    public ProjectVO() {
        super();
    }

    /**
     * @param projectId
     * @param projName
     */
    public ProjectVO(Integer projectId, String projName) {
        super();
        this.projectId = projectId;
        this.projName = projName;
    }

}
