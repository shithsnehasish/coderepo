/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.service.restImpl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.dell.coe.pts.service.ProjectService;
import com.dell.coe.pts.service.business.ProjectServiceBL;
import com.dell.coe.pts.vo.ProjectTechnologyVO;
import com.dell.coe.pts.vo.ProjectVO;
import com.dell.coe.pts.vo.SearchCriteriaVO;
import com.dell.coe.pts.vo.SearchResultVO;
import com.dell.coe.virtuoso.common.pagination.PagingResponse;
import com.dell.coe.virtuoso.common.service.AbstractServiceImpl;

/**
 * The documentation of the class ProjectServiceImpl.
 *
 * @author 
 * @generated 
 */
@Path("/projectService")
public class ProjectServiceImpl extends AbstractServiceImpl implements ProjectService {

    /** The project service bl. */
    @Autowired
    private ProjectServiceBL projectServiceBL;

    /**
     * The documentation of the constructor.
     * 
     * @generated
     */
    public ProjectServiceImpl() {
        super();
    }

    /**
     * The documentation of the method retrieveProjectCategoryDistribution. * @return
     *
     * @return the list
     * @generated 
     */
    @GET
    @Path("/retrieveProjectCategoryDistribution")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectTechnologyVO> retrieveProjectCategoryDistribution() {
        return projectServiceBL.retrieveProjectCategoryDistribution();
    }

    /**
     * The documentation of the method findProjectbyTechnologyList. * @param technologyList
     *
     * @param criteriaVOs the criteria v os
     * @param pageNumber the page number
     * @param totalCount the total count
     * @return the paging response
     * @generated 
     */
    @POST
    @Path("/findProjectbyTechnologyList")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PagingResponse<SearchResultVO> findProjectbyTechnologyList(@RequestBody List<SearchCriteriaVO> criteriaVOs,
            @QueryParam("isPagedQuery") Integer isPagedQuery, @QueryParam("pageNumber") Integer pageNumber,
            @QueryParam("totalCount") Integer totalCount) {
        return projectServiceBL.findProjectbyTechnologyList(criteriaVOs, isPagedQuery, pageNumber, totalCount);
    }

    /**
     * Retrieve retrieveProjectList .
     *
     * 
     * @return the list
     */
    @GET
    @Path("/retrieveProjectList")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProjectVO> retrieveProjectList() {
        return projectServiceBL.retrieveProjectList();
    }

    /**
     * The documentation of the getter getProjectServiceBL.
     *
     * @return the project service bl
     * @generated 
     */
    public ProjectServiceBL getProjectServiceBL() {
        return projectServiceBL;
    }

    /**
     * The documentation of the setter setProjectServiceBL.
     *
     * @param projectServiceBL the new project service bl
     * @generated 
     */
    public void setProjectServiceBL(ProjectServiceBL projectServiceBL) {
        this.projectServiceBL = projectServiceBL;
    }
}
