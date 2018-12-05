package com.dell.coe.pts.vo;

import java.util.Set;

/**
 * The Class TechnologyStackVO.
 */
public class TechnologyStackVO implements Comparable<TechnologyStackVO> {

    /** The technology stack id. */
    private Integer technologyStackId;

    /** The tech name. */
    //private String technologyCategoryName;
    private String techName;

    /** The tech version. */
    private String techVersion;

    /** The project. */
    private Set<TechnologyStackProjectVO> project;

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
     * Gets the project.
     *
     * @return the project
     */
    public Set<TechnologyStackProjectVO> getProject() {
        return project;
    }

    /**
     * Sets the project.
     *
     * @param project the new project
     */
    public void setProject(Set<TechnologyStackProjectVO> project) {
        this.project = project;
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

    /**
     * Instantiates a new technology stack vo.
     *
     * @param techName the tech name
     */
    public TechnologyStackVO(String techName) {
        super();
        this.techName = techName;
    }

    /**
     * Instantiates a new technology stack vo.
     */
    public TechnologyStackVO() {
        super();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((techName == null) ? 0 : techName.hashCode());
        result = prime * result + ((techVersion == null) ? 0 : techVersion.hashCode());
        result = prime * result + ((technologyStackId == null) ? 0 : technologyStackId.hashCode());
        result = prime * result + version;
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TechnologyStackVO other = (TechnologyStackVO) obj;
        if (techName == null) {
            if (other.techName != null)
                return false;
        } else if (!techName.equals(other.techName))
            return false;
        if (techVersion == null) {
            if (other.techVersion != null)
                return false;
        } else if (!techVersion.equals(other.techVersion))
            return false;
        if (technologyStackId == null) {
            if (other.technologyStackId != null)
                return false;
        } else if (!technologyStackId.equals(other.technologyStackId))
            return false;
        if (version != other.version)
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TechnologyStackVO o) {
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
