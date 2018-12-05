package com.dell.coe.pts.vo;

/**
 * The Class ProjectTechnologyStackVO.
 */
public class ProjectTechnologyStackVO implements Comparable<ProjectTechnologyStackVO> {

    /** The technology stack id. */
    private Integer technologyStackId;

    /** The tech name. */
    private String techName;

    /** The tech version. */
    private String techVersion;

    /** The technologycategory. */
    private TechnologyCategoryVO technologycategory;

    /** The version. */
    private int version = 0;

    /**
     * Gets the technology stack id.
     *
     * @return the technology stack id
     */
    public Integer getTechnologyStackId() {
        return technologyStackId;
    }

    /**
     * Sets the technology stack id.
     *
     * @param technologyStackId the new technology stack id
     */
    public void setTechnologyStackId(Integer technologyStackId) {
        this.technologyStackId = technologyStackId;
    }

    /**
     * Gets the tech name.
     *
     * @return the tech name
     */
    public String getTechName() {
        return techName;
    }

    /**
     * Sets the tech name.
     *
     * @param techName the new tech name
     */
    public void setTechName(String techName) {
        this.techName = techName;
    }

    /**
     * Gets the tech version.
     *
     * @return the tech version
     */
    public String getTechVersion() {
        return techVersion;
    }

    /**
     * Sets the tech version.
     *
     * @param techVersion the new tech version
     */
    public void setTechVersion(String techVersion) {
        this.techVersion = techVersion;
    }

    /**
     * Gets the technologycategory.
     *
     * @return the technologycategory
     */
    public TechnologyCategoryVO getTechnologycategory() {
        return technologycategory;
    }

    /**
     * Sets the technologycategory.
     *
     * @param technologycategory the new technologycategory
     */
    public void setTechnologycategory(TechnologyCategoryVO technologycategory) {
        this.technologycategory = technologycategory;
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

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(ProjectTechnologyStackVO o) {
        int sort = this.getTechnologycategory().getCatName().compareTo(o.getTechnologycategory().getCatName());
        if (sort == 0) {
            sort = this.getTechName().compareTo(o.getTechName());
        }
        if (sort == 0) {
            sort = this.getTechVersion().compareTo(o.getTechVersion());
        }
        return sort;
    }

}
