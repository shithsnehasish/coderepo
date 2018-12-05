package com.dell.coe.pts.vo;

/**
 * The Class SearchCriteriaVO.
 */
public class SearchCriteriaVO {

    /** The technology category id. */
    private Integer technologyCategoryId;

    /** The technology name. */
    private String technologyName;

    /** The technology version. */
    private String technologyVersion;

    /**
     * Instantiates a new search criteria vo.
     */
    public SearchCriteriaVO() {
        super();
    }

    /**
     * Instantiates a new search criteria vo.
     *
     * @param technologyCategoryId the technology category id
     * @param technologyName the technology name
     * @param technogyVersion the technogy version
     */
    public SearchCriteriaVO(Integer technologyCategoryId, String technologyName, String technogyVersion) {
        this.technologyCategoryId = technologyCategoryId;
        this.technologyName = technologyName;
        this.technologyVersion = technogyVersion;
    }

    /**
     * Gets the technology category id.
     *
     * @return the technologyCategoryId
     */
    public Integer getTechnologyCategoryId() {
        return technologyCategoryId;
    }

    /**
     * Sets the technology category id.
     *
     * @param technologyCategoryId            the technologyCategoryId to set
     */
    public void setTechnologyCategoryId(Integer technologyCategoryId) {
        this.technologyCategoryId = technologyCategoryId;
    }

    /**
     * Gets the technology name.
     *
     * @return the technologyName
     */
    public String getTechnologyName() {
        return technologyName;
    }

    /**
     * Sets the technology name.
     *
     * @param technologyName            the technologyName to set
     */
    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    /**
     * Gets the technology version.
     *
     * @return the technogyVersion
     */
    public String getTechnologyVersion() {
        return technologyVersion;
    }

    /**
     * Sets the technogy version.
     *
     * @param technologyVersion   the technogyVersion to set
     */
    public void setTechnologyVersion(String technologyVersion) {
        this.technologyVersion = technologyVersion;
    }

}
