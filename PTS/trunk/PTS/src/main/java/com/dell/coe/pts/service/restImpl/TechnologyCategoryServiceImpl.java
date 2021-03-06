/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.service.restImpl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.dell.coe.pts.service.TechnologyCategoryService;
import com.dell.coe.pts.service.business.TechnologyCategoryServiceBL;
import com.dell.coe.pts.vo.ProjectTechCategoryVO;
import com.dell.coe.pts.vo.TechnologyCategoryVO;
import com.dell.coe.virtuoso.common.service.AbstractServiceImpl;

/**
 * The documentation of the class TechnologyCategoryServiceImpl.
 *
 * @author 
 * @generated 
 */
@Path("/technologyCategoryService")
public class TechnologyCategoryServiceImpl extends AbstractServiceImpl implements TechnologyCategoryService {

    /** The technology category service bl. */
    @Autowired
    private TechnologyCategoryServiceBL technologyCategoryServiceBL;

    /**
     * The documentation of the constructor.
     * 
     * @generated
     */
    public TechnologyCategoryServiceImpl() {
        super();
    }

    /**
     * The documentation of the method retrieveTechnologyCategorybyName. * @param categoryName
     *
     * @param categoryName the category name
     * @return the technology category vo
     * @generated 
     */
    @GET
    @Path("/retrieveTechnologyCategorybyName/{categoryName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TechnologyCategoryVO retrieveTechnologyCategorybyName(@PathParam("categoryName") String categoryName) {
        return technologyCategoryServiceBL.retrieveTechnologyCategorybyName(categoryName);
    }

    /**
     * The documentation of the method retrieveTechnologyCategoryDistribution. * @return
     *
     * @return the list
     * @generated 
     */
    @GET
    @Path("/retrieveTechnologyDistribution")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectTechCategoryVO> retrieveTechnologyCategoryDistribution() {
        return technologyCategoryServiceBL.retrieveTechnologyCategoryDistribution();
    }

    /**
     * Retrieve retrieveTechnologyCategoryList .
     *
     * 
     * @return the list
     */
    @GET
    @Path("/retrieveTechnologyCategoryList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TechnologyCategoryVO> retrieveTechnologyCategoryList() {
        return technologyCategoryServiceBL.retrieveTechnologyCategoryList();
    }

    /**
     * The documentation of the getter getTechnologyCategoryServiceBL.
     *
     * @return the technology category service bl
     * @generated 
     */
    public TechnologyCategoryServiceBL getTechnologyCategoryServiceBL() {
        return technologyCategoryServiceBL;
    }

    /**
     * The documentation of the setter setTechnologyCategoryServiceBL.
     *
     * @param technologyCategoryServiceBL the new technology category service bl
     * @generated 
     */
    public void setTechnologyCategoryServiceBL(TechnologyCategoryServiceBL technologyCategoryServiceBL) {
        this.technologyCategoryServiceBL = technologyCategoryServiceBL;
    }
}
