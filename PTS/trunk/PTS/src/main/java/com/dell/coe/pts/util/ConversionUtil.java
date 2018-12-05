package com.dell.coe.pts.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.dell.coe.pts.persistence.Project;
import com.dell.coe.pts.persistence.TechnologyCategory;
import com.dell.coe.pts.persistence.TechnologyStack;
import com.dell.coe.pts.vo.ProjectTechnologyStackVO;
import com.dell.coe.pts.vo.ProjectVO;
import com.dell.coe.pts.vo.TechnologyCategoryVO;
import com.dell.coe.pts.vo.TechnologyStackProjectVO;
import com.dell.coe.pts.vo.TechnologyStackVO;

/**
 * The Class ConversionUtil.
 */
public class ConversionUtil {

    /**
     * Convert to technology category vo.
     *
     * @param technologyCategory the technology category
     * @return the technology category vo
     */
    public static TechnologyCategoryVO convertToTechnologyCategoryVO(TechnologyCategory technologyCategory) {

        if (null != technologyCategory) {
            TechnologyCategoryVO technologyCategoryVOObj = new TechnologyCategoryVO();
            if (null != technologyCategory.getTechnologyCategoryId()) {
                technologyCategoryVOObj.setTechnologyCategoryId(technologyCategory.getTechnologyCategoryId());
            }
            if (null != technologyCategory.getCatName()) {
                technologyCategoryVOObj.setCatName(technologyCategory.getCatName());
            }
            /*if (null != technologyCategory.getCreatedBy()) {
                technologyCategoryVOObj.setCreatedBy(technologyCategory.getCreatedBy());
            }
            if (null != technologyCategory.getCreatedDate()) {
                technologyCategoryVOObj.setCreatedDate(technologyCategory.getCreatedDate());
            }
            if (null != technologyCategory.getUpdatedBy()) {
                technologyCategoryVOObj.setUpdatedBy(technologyCategory.getUpdatedBy());
            }
            if (null != technologyCategory.getUpdatedDate()) {
                technologyCategoryVOObj.setUpdatedDate(technologyCategory.getUpdatedDate());
            }*/
            technologyCategoryVOObj.setVersion(technologyCategory.getVersion());
            return technologyCategoryVOObj;
        }

        return null;
    }

    /**
     * Convert list to technology category vo list.
     *
     * @param technologyCategoryList the technology category list
     * @return the list
     */
    public static List<TechnologyCategoryVO> convertListToTechnologyCategoryVOList(List<TechnologyCategory> technologyCategoryList) {

        if (!technologyCategoryList.isEmpty()) {
            List<TechnologyCategoryVO> technologyCategoryVOObjList = new ArrayList<TechnologyCategoryVO>();
            for (TechnologyCategory techCategoryObj : technologyCategoryList) {
                if (null != techCategoryObj) {
                    TechnologyCategoryVO technologyCategoryVOObj = convertToTechnologyCategoryVO(techCategoryObj);
                    technologyCategoryVOObjList.add(technologyCategoryVOObj);
                }
            }
            return technologyCategoryVOObjList;
        }

        return null;
    }

    /**
     * Convert from technology category vo.
     *
     * @param technologyCategoryVO the technology category vo
     * @return the technology category
     */
    public static TechnologyCategory convertFromTechnologyCategoryVO(TechnologyCategoryVO technologyCategoryVO) {

        if (null != technologyCategoryVO) {
            TechnologyCategory technologyCategoryObj = new TechnologyCategory();
            if (null != technologyCategoryVO.getTechnologyCategoryId()) {
                technologyCategoryObj.setTechnologyCategoryId(technologyCategoryVO.getTechnologyCategoryId());
            }
            if (null != technologyCategoryVO.getCatName()) {
                technologyCategoryObj.setCatName(technologyCategoryVO.getCatName());
            }
            /*if (null != technologyCategoryVO.getCreatedBy()) {
                technologyCategoryObj.setCreatedBy(technologyCategoryVO.getCreatedBy());
            }
            if (null != technologyCategoryVO.getCreatedDate()) {
                technologyCategoryObj.setCreatedDate(technologyCategoryVO.getCreatedDate());
            }
            if (null != technologyCategoryVO.getUpdatedBy()) {
                technologyCategoryObj.setUpdatedBy(technologyCategoryVO.getUpdatedBy());
            }
            if (null != technologyCategoryVO.getUpdatedDate()) {
                technologyCategoryObj.setUpdatedDate(technologyCategoryVO.getUpdatedDate());
            }*/
            technologyCategoryObj.setVersion(technologyCategoryVO.getVersion());
            return technologyCategoryObj;
        }

        return null;
    }

    /**
     * Convert to technology stack vo.
     *
     * @param technologyStack the technology stack
     * @return the technology stack vo
     */
    public static TechnologyStackVO convertToTechnologyStackVo(TechnologyStack technologyStack, boolean isSetTechCat, boolean isSetProj) {
        if (null != technologyStack) {
            TechnologyStackVO technologyStackVOObj = new TechnologyStackVO();
            if (null != technologyStack.getTechnologyStackId()) {
                technologyStackVOObj.setTechnologyStackId(technologyStack.getTechnologyStackId());
            }
            if (null != technologyStack.getTechName()) {
                technologyStackVOObj.setTechName(technologyStack.getTechName());
            }
            if (null != technologyStack.getTechVersion()) {
                technologyStackVOObj.setTechVersion(technologyStack.getTechVersion());
            }
            if (isSetTechCat && null != technologyStack.getTechnologycategory()) {
                technologyStackVOObj.setTechnologycategory(convertToTechnologyCategoryVO(technologyStack.getTechnologycategory()));
            }
            if (isSetProj && !technologyStack.getProject().isEmpty()) {
                technologyStackVOObj.setProject(populatetoTechnologyStackProjectVOList(technologyStack.getProject()));
            }
            /*if (null != technologyStack.getCreatedBy()) {
                technologyStackVOObj.setCreatedBy(technologyStack.getCreatedBy());
            }
            if (null != technologyStack.getCreatedDate()) {
                technologyStackVOObj.setCreatedDate(technologyStack.getCreatedDate());
            }
            if (null != technologyStack.getUpdatedBy()) {
                technologyStackVOObj.setUpdatedBy(technologyStack.getUpdatedBy());
            }
            if (null != technologyStack.getUpdatedDate()) {
                technologyStackVOObj.setUpdatedDate(technologyStack.getUpdatedDate());
            }*/

            technologyStackVOObj.setVersion(technologyStack.getVersion());
            return technologyStackVOObj;
        }
        return null;

    }

    /**
     * Convert list to technology stack vo list.
     *
     * @param technologyStackList the technology stack list
     * @return the list
     */
    public static List<TechnologyStackVO> convertListToTechnologyStackVOList(List<TechnologyStack> technologyStackList,
            boolean isSetTechCat, boolean isSetProj) {
        if (!technologyStackList.isEmpty()) {
            List<TechnologyStackVO> technologyStackVOObjList = new ArrayList<TechnologyStackVO>();
            for (TechnologyStack technologyStackObj : technologyStackList) {
                if (null != technologyStackObj) {
                    TechnologyStackVO technologyStackVOObj = convertToTechnologyStackVo(technologyStackObj, isSetTechCat, isSetProj);
                    technologyStackVOObjList.add(technologyStackVOObj);
                }
            }
            return technologyStackVOObjList;
        }

        return null;
    }

    /**
     * Convert from technology stack vo.
     *
     * @param technologyStackVO the technology stack vo
     * @return the technology stack
     */
    public static TechnologyStack convertFromTechnologyStackVo(TechnologyStackVO technologyStackVO) {

        if (null != technologyStackVO) {
            TechnologyStack technologyStackObj = new TechnologyStack();
            if (null != technologyStackVO.getTechnologyStackId()) {
                technologyStackObj.setTechnologyStackId(technologyStackVO.getTechnologyStackId());
            }
            if (null != technologyStackVO.getTechName()) {
                technologyStackObj.setTechName(technologyStackVO.getTechName());
            }
            if (null != technologyStackVO.getTechVersion()) {
                technologyStackObj.setTechVersion(technologyStackVO.getTechVersion());
            }
            if (null != technologyStackVO.getTechnologycategory()) {
                technologyStackObj.setTechnologycategory(convertFromTechnologyCategoryVO(technologyStackVO.getTechnologycategory()));
            }
            if (!technologyStackVO.getProject().isEmpty()) {
                technologyStackObj.setProject(populatefromTechnologyStackProjectVOList(technologyStackVO.getProject()));
            }

            /*if (null != technologyStackVO.getCreatedBy()) {
                technologyStackObj.setCreatedBy(technologyStackVO.getCreatedBy());
            }
            if (null != technologyStackVO.getCreatedDate()) {
                technologyStackObj.setCreatedDate(technologyStackVO.getCreatedDate());
            }
            if (null != technologyStackVO.getUpdatedBy()) {
                technologyStackObj.setUpdatedBy(technologyStackVO.getUpdatedBy());
            }
            if (null != technologyStackVO.getUpdatedDate()) {
                technologyStackObj.setUpdatedDate(technologyStackVO.getUpdatedDate());
            }*/

            technologyStackObj.setVersion(technologyStackVO.getVersion());
            return technologyStackObj;

        }
        return null;

    }

    /**
     * Convert to project vo.
     *
     * @param project the project
     * @return the project vo
     */
    public static ProjectVO convertToProjectVO(Project project, Boolean isSetTechnology) {

        if (null != project) {
            ProjectVO projectVOObj = new ProjectVO();
            if (null != project.getProjectId()) {
                projectVOObj.setProjectId(project.getProjectId());
            }
            if (null != project.getProjName()) {
                projectVOObj.setProjName(project.getProjName());
            }
            if (null != project.getProjType()) {
                projectVOObj.setProjType(project.getProjType());
            }
            if (isSetTechnology) {
                if (!project.getTechnologystack().isEmpty()) {
                    projectVOObj.setTechnologystack(populatetoProjectTechnologyStackVOList(project.getTechnologystack()));
                }
            }
            /*if (null != project.getCreatedBy()) {
                projectVOObj.setCreatedBy(project.getCreatedBy());
            }
            if (null != project.getCreatedDate()) {
                projectVOObj.setCreatedDate(project.getCreatedDate());
            }
            if (null != project.getUpdatedBy()) {
                projectVOObj.setUpdatedBy(project.getUpdatedBy());
            }
            if (null != project.getUpdatedDate()) {
                projectVOObj.setUpdatedDate(project.getUpdatedDate());
            }*/

            projectVOObj.setVersion(project.getVersion());
            return projectVOObj;
        }

        return null;
    }

    /**
     * Convert list to project vo list.
     *
     * @param projectList the project list
     * @return the list
     */
    public static List<ProjectVO> convertListToProjectVOList(List<Project> projectList, Boolean isSetTechnology) {
        if (!projectList.isEmpty()) {
            List<ProjectVO> projectVOObjList = new ArrayList<ProjectVO>();
            for (Project projectObj : projectList) {
                if (null != projectObj) {
                    ProjectVO projectVOObj = convertToProjectVO(projectObj, isSetTechnology);
                    projectVOObjList.add(projectVOObj);
                }
            }
            return projectVOObjList;
        }

        return null;
    }

    /**
     * Convert from project vo.
     *
     * @param projectVO the project vo
     * @return the project
     */
    public static Project convertFromProjectVO(ProjectVO projectVO) {

        //populatefromProjectTechnologyStackVOList
        if (null != projectVO) {
            Project projectObj = new Project();

            if (null != projectVO.getProjectId()) {
                projectObj.setProjectId(projectVO.getProjectId());
            }
            if (null != projectVO.getProjName()) {
                projectObj.setProjName(projectVO.getProjName());
            }
            if (null != projectVO.getProjType()) {
                projectObj.setProjType(projectVO.getProjType());
            }
            if (!projectVO.getTechnologystack().isEmpty()) {
                projectObj.setTechnologystack(populatefromProjectTechnologyStackVOList(projectVO.getTechnologystack()));
            }

            /*if (null != projectVO.getCreatedBy()) {
                projectObj.setCreatedBy(projectVO.getCreatedBy());
            }
            if (null != projectVO.getCreatedDate()) {
                projectObj.setCreatedDate(projectVO.getCreatedDate());
            }
            if (null != projectVO.getUpdatedBy()) {
                projectObj.setUpdatedBy(projectVO.getUpdatedBy());
            }
            if (null != projectVO.getUpdatedDate()) {
                projectObj.setUpdatedDate(projectVO.getUpdatedDate());
            }
            */
            projectObj.setVersion(projectVO.getVersion());
            return projectObj;

        }
        return null;
    }

    /**
     * Populateto project technology stack vo list.
     *
     * @param technologyStackList the technology stack list
     * @return the sets the
     */
    public static Set<ProjectTechnologyStackVO> populatetoProjectTechnologyStackVOList(Set<TechnologyStack> technologyStackList) {

        if (!technologyStackList.isEmpty()) {
            Set<ProjectTechnologyStackVO> projectTechnologyStackVOList = new TreeSet<ProjectTechnologyStackVO>();
            for (TechnologyStack technologyStackObj : technologyStackList) {
                ProjectTechnologyStackVO projectTechnologyStackVOObj = populatetoProjectTechnologyStackVO(technologyStackObj);
                projectTechnologyStackVOList.add(projectTechnologyStackVOObj);
            }
            return projectTechnologyStackVOList;
        }

        return null;

    }

    /**
     * Populateto project technology stack vo.
     *
     * @param technologyStackobj the technology stackobj
     * @return the project technology stack vo
     */
    public static ProjectTechnologyStackVO populatetoProjectTechnologyStackVO(TechnologyStack technologyStackobj) {

        if (null != technologyStackobj) {
            ProjectTechnologyStackVO projectTechnologyStackVOObj = new ProjectTechnologyStackVO();
            if (null != technologyStackobj.getTechnologyStackId()) {
                projectTechnologyStackVOObj.setTechnologyStackId(technologyStackobj.getTechnologyStackId());
            }
            if (null != technologyStackobj.getTechName()) {
                projectTechnologyStackVOObj.setTechName(technologyStackobj.getTechName());
            }
            if (null != technologyStackobj.getTechVersion()) {
                projectTechnologyStackVOObj.setTechVersion(technologyStackobj.getTechVersion());
            }
            if (null != technologyStackobj.getTechnologycategory()) {
                projectTechnologyStackVOObj
                        .setTechnologycategory(convertToTechnologyCategoryVO(technologyStackobj.getTechnologycategory()));
            }
            /*if (null != technologyStackobj.getCreatedBy()) {
                projectTechnologyStackVOObj.setCreatedBy(technologyStackobj.getCreatedBy());
            }
            if (null != technologyStackobj.getCreatedDate()) {
                projectTechnologyStackVOObj.setCreatedDate(technologyStackobj.getCreatedDate());
            }
            if (null != technologyStackobj.getUpdatedBy()) {
                projectTechnologyStackVOObj.setUpdatedBy(technologyStackobj.getUpdatedBy());
            }
            if (null != technologyStackobj.getUpdatedDate()) {
                projectTechnologyStackVOObj.setUpdatedDate(technologyStackobj.getUpdatedDate());
            }*/

            projectTechnologyStackVOObj.setVersion(technologyStackobj.getVersion());
            return projectTechnologyStackVOObj;
        }
        return null;

    }

    /**
     * Populatefrom project technology stack vo list.
     *
     * @param projectTechnologyStackVOList the project technology stack vo list
     * @return the sets the
     */
    public static Set<TechnologyStack> populatefromProjectTechnologyStackVOList(Set<ProjectTechnologyStackVO> projectTechnologyStackVOList) {

        if (!projectTechnologyStackVOList.isEmpty()) {
            Set<TechnologyStack> technologyStackList = new HashSet<TechnologyStack>();
            for (ProjectTechnologyStackVO projectTechnologyStackVOObj : projectTechnologyStackVOList) {
                TechnologyStack technologyStackObj = populatefromProjectTechnologyStackVO(projectTechnologyStackVOObj);
                technologyStackList.add(technologyStackObj);
            }
            return technologyStackList;
        }

        return null;

    }

    /**
     * Populatefrom project technology stack vo.
     *
     * @param projectTechnologyStackVOobj the project technology stack v oobj
     * @return the technology stack
     */
    public static TechnologyStack populatefromProjectTechnologyStackVO(ProjectTechnologyStackVO projectTechnologyStackVOobj) {

        if (null != projectTechnologyStackVOobj) {
            TechnologyStack technologyStackObj = new TechnologyStack();
            if (null != projectTechnologyStackVOobj.getTechnologyStackId()) {
                technologyStackObj.setTechnologyStackId(projectTechnologyStackVOobj.getTechnologyStackId());
            }
            if (null != projectTechnologyStackVOobj.getTechName()) {
                technologyStackObj.setTechName(projectTechnologyStackVOobj.getTechName());
            }
            if (null != projectTechnologyStackVOobj.getTechVersion()) {
                technologyStackObj.setTechVersion(projectTechnologyStackVOobj.getTechVersion());
            }
            if (null != projectTechnologyStackVOobj.getTechnologycategory()) {
                technologyStackObj.setTechnologycategory(convertFromTechnologyCategoryVO(projectTechnologyStackVOobj
                        .getTechnologycategory()));
            }
            /*if (null != projectTechnologyStackVOobj.getCreatedBy()) {
                technologyStackObj.setCreatedBy(projectTechnologyStackVOobj.getCreatedBy());
            }
            if (null != projectTechnologyStackVOobj.getCreatedDate()) {
                technologyStackObj.setCreatedDate(projectTechnologyStackVOobj.getCreatedDate());
            }
            if (null != projectTechnologyStackVOobj.getUpdatedBy()) {
                technologyStackObj.setUpdatedBy(projectTechnologyStackVOobj.getUpdatedBy());
            }
            if (null != projectTechnologyStackVOobj.getUpdatedDate()) {
                technologyStackObj.setUpdatedDate(projectTechnologyStackVOobj.getUpdatedDate());
            }*/

            technologyStackObj.setVersion(projectTechnologyStackVOobj.getVersion());
            return technologyStackObj;
        }
        return null;

    }

    /**
     * Populateto technology stack project vo list.
     *
     * @param projectList the project list
     * @return the sets the
     */
    public static Set<TechnologyStackProjectVO> populatetoTechnologyStackProjectVOList(Set<Project> projectList) {

        if (!projectList.isEmpty()) {
            Set<TechnologyStackProjectVO> technologyStackProjectVOList = new HashSet<TechnologyStackProjectVO>();
            for (Project projectObj : projectList) {
                TechnologyStackProjectVO technologyStackProjectVOObj = populatetoTechnologyStackProjectVO(projectObj);
                technologyStackProjectVOList.add(technologyStackProjectVOObj);
            }
            return technologyStackProjectVOList;
        }

        return null;

    }

    /**
     * Populateto technology stack project vo.
     *
     * @param projectobj the projectobj
     * @return the technology stack project vo
     */
    public static TechnologyStackProjectVO populatetoTechnologyStackProjectVO(Project projectobj) {

        if (null != projectobj) {
            TechnologyStackProjectVO technologyStackProjectVOObj = new TechnologyStackProjectVO();
            if (null != projectobj.getProjectId()) {
                technologyStackProjectVOObj.setProjectId(projectobj.getProjectId());
            }
            if (null != projectobj.getProjType()) {
                technologyStackProjectVOObj.setProjType(projectobj.getProjType());
            }
            if (null != projectobj.getProjName()) {
                technologyStackProjectVOObj.setProjName(projectobj.getProjName());
            }
            /*if (null != projectobj.getCreatedBy()) {
                technologyStackProjectVOObj.setCreatedBy(projectobj.getCreatedBy());
            }
            if (null != projectobj.getCreatedDate()) {
                technologyStackProjectVOObj.setCreatedDate(projectobj.getCreatedDate());
            }
            if (null != projectobj.getUpdatedBy()) {
                technologyStackProjectVOObj.setUpdatedBy(projectobj.getUpdatedBy());
            }
            if (null != projectobj.getUpdatedDate()) {
                technologyStackProjectVOObj.setUpdatedDate(projectobj.getUpdatedDate());
            }*/

            technologyStackProjectVOObj.setVersion(projectobj.getVersion());
            return technologyStackProjectVOObj;
        }
        return null;

    }

    /**
     * Populatefrom technology stack project vo list.
     *
     * @param technologyStackProjectVOList the technology stack project vo list
     * @return the sets the
     */
    public static Set<Project> populatefromTechnologyStackProjectVOList(Set<TechnologyStackProjectVO> technologyStackProjectVOList) {

        if (!technologyStackProjectVOList.isEmpty()) {
            Set<Project> projectList = new HashSet<Project>();
            for (TechnologyStackProjectVO technologyStackProjectVOObj : technologyStackProjectVOList) {
                Project projectObj = populatefromTechnologyStackProjectVO(technologyStackProjectVOObj);
                projectList.add(projectObj);
            }
            return projectList;
        }

        return null;

    }

    /**
     * Populatefrom technology stack project vo.
     *
     * @param technologyStackProjectVOobj the technology stack project v oobj
     * @return the project
     */
    public static Project populatefromTechnologyStackProjectVO(TechnologyStackProjectVO technologyStackProjectVOobj) {

        if (null != technologyStackProjectVOobj) {
            Project projectObj = new Project();
            if (null != technologyStackProjectVOobj.getProjectId()) {
                projectObj.setProjectId(technologyStackProjectVOobj.getProjectId());
            }
            if (null != technologyStackProjectVOobj.getProjType()) {
                projectObj.setProjType(technologyStackProjectVOobj.getProjType());
            }
            if (null != technologyStackProjectVOobj.getProjName()) {
                projectObj.setProjName(technologyStackProjectVOobj.getProjName());
            }
            /*if (null != technologyStackProjectVOobj.getCreatedBy()) {
                projectObj.setCreatedBy(technologyStackProjectVOobj.getCreatedBy());
            }
            if (null != technologyStackProjectVOobj.getCreatedDate()) {
                projectObj.setCreatedDate(technologyStackProjectVOobj.getCreatedDate());
            }
            if (null != technologyStackProjectVOobj.getUpdatedBy()) {
                projectObj.setUpdatedBy(technologyStackProjectVOobj.getUpdatedBy());
            }
            if (null != technologyStackProjectVOobj.getUpdatedDate()) {
                projectObj.setUpdatedDate(technologyStackProjectVOobj.getUpdatedDate());
            }*/

            projectObj.setVersion(technologyStackProjectVOobj.getVersion());
            return projectObj;
        }
        return null;

    }
}
