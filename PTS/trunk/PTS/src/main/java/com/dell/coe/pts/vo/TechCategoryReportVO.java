package com.dell.coe.pts.vo;

import java.util.List;

/**
 * The Class TechCategoryReportVO.
 */
public class TechCategoryReportVO {

    /** The technology category vo. */
    private TechnologyCategoryVO technologyCategoryVO;

    /** The tech stack vo list. */
    private List<TechnologyStackVO> techStackVOList;

    /**
     * Gets the technology category vo.
     *
     * @return the technologyCategoryVO
     */
    public TechnologyCategoryVO getTechnologyCategoryVO() {
        return technologyCategoryVO;
    }

    /**
     * Sets the technology category vo.
     *
     * @param technologyCategoryVO the technologyCategoryVO to set
     */
    public void setTechnologyCategoryVO(TechnologyCategoryVO technologyCategoryVO) {
        this.technologyCategoryVO = technologyCategoryVO;
    }

    /**
     * Gets the tech stack vo list.
     *
     * @return the techStackVOList
     */
    public List<TechnologyStackVO> getTechStackVOList() {
        return techStackVOList;
    }

    /**
     * Sets the tech stack vo list.
     *
     * @param techStackVOList the techStackVOList to set
     */
    public void setTechStackVOList(List<TechnologyStackVO> techStackVOList) {
        this.techStackVOList = techStackVOList;
    }

}
