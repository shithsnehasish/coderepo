/**
 * 
 */
package com.dell.coe.pts.vo;

import java.util.List;

/**
 * The Class TechCategoryFactoryVO.
 *
 * @author Santosh_Kumar14
 */
public class TechCategoryFactoryVO {

    /** The category report v os. */
    private List<TechCategoryReportVO> categoryReportVOs;

    /**
     * Instantiates a new tech category factory vo.
     */
    public TechCategoryFactoryVO() {
    }

    /**
     * Instantiates a new tech category factory vo.
     *
     * @param categoryReportVOs the category report vos
     */
    public TechCategoryFactoryVO(List<TechCategoryReportVO> categoryReportVOs) {
        super();
        this.categoryReportVOs = categoryReportVOs;
    }

    /**
     * Gets the category report vos.
     *
     * @return the category report vos
     */
    public List<TechCategoryReportVO> getCategoryReportVOs() {
        return categoryReportVOs;
    }

    /**
     * Sets the category report vos.
     *
     * @param categoryReportVOs the new category report v os
     */
    public void setCategoryReportVOs(List<TechCategoryReportVO> categoryReportVOs) {
        this.categoryReportVOs = categoryReportVOs;
    }

}
