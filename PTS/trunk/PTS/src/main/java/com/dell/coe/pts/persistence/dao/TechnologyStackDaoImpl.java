/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.persistence.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.dell.coe.pts.common.dao.BaseDaoImpl;
import com.dell.coe.pts.persistence.Project;
import com.dell.coe.pts.persistence.TechnologyCategory;
import com.dell.coe.pts.persistence.TechnologyStack;
import com.dell.coe.pts.util.ConversionUtil;
import com.dell.coe.pts.vo.SearchCriteriaVO;
import com.dell.coe.pts.vo.SearchProjectResultVO;
import com.dell.coe.pts.vo.SearchResultVO;
import com.dell.coe.pts.vo.TechnologyStackVO;

/**
 * The documentation of the class TechnologyStackDaoImpl.
 *
 * @author 
 * @generated 
 */
@Repository
public class TechnologyStackDaoImpl extends BaseDaoImpl<TechnologyStack> implements TechnologyStackDao {

    /**
     * The documentation of the constructor.
     * 
     * @generated
     */
    public TechnologyStackDaoImpl() {
        super(TechnologyStack.class);
    }

    /* (non-Javadoc)
     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#retrieveProjectVsCategoryData(int)
     */
    @SuppressWarnings("unchecked")
    public Map<String, Integer> retrieveProjectVsCategoryData(int topValues) {
        String query = "select count(distinct(p.project_id)) as total, tc.cat_name "
                + "from project as p, technology_stack as ts, project_technology_stack as pts, technology_category as tc "
                + "where p.project_id = pts.project_id and ts.technology_stack_id = pts.technology_stack_id "
                + "and ts.technology_category_id = tc.technology_category_id " + "group by ts.technology_category_id "
                + "order by total desc limit ";
        List<Object[]> result = getEm().createNativeQuery(query + topValues).getResultList();
        Map<String, Integer> projVsCatMap = new LinkedHashMap<String, Integer>();
        for (Object[] objects : result) {
            projVsCatMap.put((String) objects[1], ((BigInteger) objects[0]).intValue());
        }
        return projVsCatMap;
    }

    /* (non-Javadoc)
     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#retrieveProjectVsTechnologyData(int)
     */
    @SuppressWarnings("unchecked")
    public Map<String, Integer> retrieveProjectVsTechnologyData(int topValues) {
        String query = "select count(distinct(p.project_id)) as total, ts.tech_name "
                + "from project as p, TECHNOLOGY_STACK as ts, project_technology_stack as pts " + "where p.project_id = pts.project_id "
                + "and ts.technology_stack_id = pts.technology_stack_id " + "group by ts.tech_name " + "order by total desc limit ";
        List<Object[]> result = getEm().createNativeQuery(query + topValues).getResultList();

        //        int totalTechnologies = 0;
        Map<String, Integer> projVsTechMap = new LinkedHashMap<String, Integer>();
        for (Object[] objects : result) {
            projVsTechMap.put((String) objects[1], ((BigInteger) objects[0]).intValue());
            //            totalTechnologies = totalTechnologies + ((BigInteger) objects[0]).intValue();
        }
        //        Map<String, Double> projVsTechPercentageMap = new HashMap<String, Double>();
        //        for (Map.Entry<String, Integer> entry : projVsTechMap.entrySet()) {
        //            projVsTechPercentageMap.put(entry.getKey(), (entry.getValue() * 100.0 / totalTechnologies));
        //        }
        return projVsTechMap;
    }

    /* (non-Javadoc)
     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#getAllTechnologyStackCount()
     */
    public Long getAllTechnologyStackCount() {
        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Long> countCriteriaQuery = cBuilder.createQuery(Long.class);
        Root<TechnologyStack> root = countCriteriaQuery.from(TechnologyStack.class);
        countCriteriaQuery.select(cBuilder.countDistinct(root.get("techName")));

        Query query = getEm().createQuery(countCriteriaQuery);
        Object count = query.getSingleResult();
        return (count == null) ? 0 : ((Long) count);
    }

    /* (non-Javadoc)
     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#getAllTechnologyStack()
     */
    public List<TechnologyStack> getAllTechnologyStack() {
        String query = "select ts FROM TechnologyStack as ts order by ts.techName";
        TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
        List<TechnologyStack> result = tq.getResultList();
        return result;
    }

    /* (non-Javadoc)
     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#retrieveTechnologybyKeyword(java.lang.String, java.lang.Integer)
     */
    public List<TechnologyStack> retrieveTechnologybyKeyword(String keyword, Integer technologyCatId) {
        if (null != technologyCatId && null != keyword) {
            String query = "select ts FROM TechnologyStack as ts where ts.technologycategory.technologyCategoryId = :techCatId and ts.techName LIKE :techName group by ts.techName";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            tq.setParameter("techCatId", technologyCatId);
            tq.setParameter("techName", "%" + keyword + "%");
            List<TechnologyStack> result = tq.getResultList();
            return result;
        } else if (null == technologyCatId && null != keyword) {
            String query = "select ts FROM TechnologyStack ts where ts.techName LIKE :searchKeyword group by ts.techName";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            tq.setParameter("searchKeyword", "%" + keyword + "%");
            List<TechnologyStack> result = tq.getResultList();
            return result;
        }
        return new ArrayList<TechnologyStack>();
    }

    /* (non-Javadoc)
     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#retrieveOrderedTechnologyStack(java.lang.Integer)
     */
    public List<TechnologyStack> retrieveOrderedTechnologyStack(Integer technologyCatId) {
        List<TechnologyStack> result = new ArrayList<TechnologyStack>();
        if (null != technologyCatId) {
            String query = "select ts from TechnologyStack as ts where ts.technologycategory.technologyCategoryId = :techCatId group by ts.techName order by ts.techName asc";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            tq.setParameter("techCatId", technologyCatId);
            result = tq.getResultList();
            return result;
        } else {
            String query = "select ts from TechnologyStack as ts group by ts.techName order by ts.techName asc";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            result = tq.getResultList();
            return result;
        }
    }

    /**
     * Retrieve technology by name and version.
     *
     * @param techName the tech name
     * @param techVersion the tech version
     * @return the technology stack
     */
    public TechnologyStack retrieveTechnologybyNameandVersion(String techName, String techVersion) {
        if ((null != techName) && (null != techVersion)) {
            String query = "select ts FROM TechnologyStack ts where ts.techName = :techName and ts.techVersion = :techVersion";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            tq.setParameter("techName", techName);
            tq.setParameter("techVersion", techVersion);
            List<TechnologyStack> result = tq.getResultList();
            return result.get(0);
        } else if (null != techName) {
            String query = "select ts FROM TechnologyStack ts where ts.techName = :techName";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            tq.setParameter("techName", techName);
            List<TechnologyStack> result = tq.getResultList();
            return result.get(0);
        } else {
            return null;
        }
    }

    /* (non-Javadoc)
     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#executeSearchCriteria(java.util.List, java.lang.Integer, java.lang.Integer)
     */
    public SearchResultVO executeSearchCriteria(List<SearchCriteriaVO> criteriaVOs, Boolean isPagedQuery, Integer totalCount,
            Integer pageNumber) {
        if (isPagedQuery) {
            //
            totalCount = (null == totalCount) ? executeCountQuery(criteriaVOs) : totalCount;
            pageNumber = (null == pageNumber) ? 1 : pageNumber;
            //
            List<SearchProjectResultVO> projectResultVOs = executePagedQuery(criteriaVOs, pageNumber - 1, 6);
            SearchResultVO resultVO = new SearchResultVO();
            resultVO.setTotalCount(totalCount);
            resultVO.setSearchProjectResultVOs(projectResultVOs);
            return resultVO;
        } else {
            //
            totalCount = executeCountQuery(criteriaVOs);
            pageNumber = 1;
            //
            List<SearchProjectResultVO> projectResultVOs = executePagedQuery(criteriaVOs, pageNumber - 1, totalCount);
            SearchResultVO resultVO = new SearchResultVO();
            resultVO.setTotalCount(totalCount);
            resultVO.setSearchProjectResultVOs(projectResultVOs);
            return resultVO;
        }
    }

    /**
     * Execute paged query.
     *
     * @param criteriaVOs the criteria v os
     * @param pageNumber the first result
     * @param pageSize the max results
     * @return the list
     */
    private List<SearchProjectResultVO> executePagedQuery(List<SearchCriteriaVO> criteriaVOs, Integer pageNumber, Integer pageSize) {
        // setup the criteria API to query User
        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Project> criteriaQuery = cBuilder.createQuery(Project.class);

        Root<Project> root = criteriaQuery.from(Project.class);
        //
        criteriaQuery.select(root);
        Join<Project, TechnologyStack> children = root.join("technologystack");

        Join<TechnologyStack, TechnologyCategory> associate = children.join("technologycategory");

        // predicates to match 
        List<Predicate> criteriaPredicates = new ArrayList<Predicate>();

        // Loop over parameters, adding predicates and parameters as needed
        int i = 0;
        for (SearchCriteriaVO param : criteriaVOs) {

            ParameterExpression<Integer> techCatIdParam = null;
            ParameterExpression<String> techNameParam = null;
            ParameterExpression<String> techVersionParam = null;
            Predicate predicate = null;
            if (null != param.getTechnologyCategoryId()) {
                techCatIdParam = cBuilder.parameter(Integer.class, "techCatId" + i);
            }
            if (null != param.getTechnologyName()) {
                techNameParam = cBuilder.parameter(String.class, "techName" + i);
            }
            if (null != param.getTechnologyVersion()) {
                techVersionParam = cBuilder.parameter(String.class, "techVersion" + i);
            }
            if (null != techCatIdParam && null != techNameParam && null != techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(associate.get("technologyCategoryId"), techCatIdParam), cBuilder.equal(children
                        .<String> get("techName"), techNameParam), cBuilder.like(children.<String> get("techVersion"), techVersionParam));
            } else if (null != techCatIdParam && null != techNameParam && null == techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(associate.get("technologyCategoryId"), techCatIdParam), cBuilder.equal(children
                        .<String> get("techName"), techNameParam));
            } else if (null == techCatIdParam && null != techNameParam && null != techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(children.<String> get("techName"), techNameParam), cBuilder.like(children
                        .<String> get("techVersion"), techVersionParam));
            } else if (null == techCatIdParam && null != techNameParam && null == techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(children.<String> get("techName"), techNameParam));
            } else if (null != techCatIdParam && null == techNameParam && null == techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(associate.get("technologyCategoryId"), techCatIdParam));
            }
            criteriaPredicates.add(predicate);
            i++;
        }

        // separate all generated predicates with an OR
        Predicate combinedPredicate = cBuilder.or(criteriaPredicates.toArray(new Predicate[criteriaPredicates.size()]));

        // Create Query and add parameters
        criteriaQuery.where(combinedPredicate);
        criteriaQuery.orderBy(cBuilder.asc(root.get("projectId")));
        criteriaQuery.distinct(true);
        Query query = getEm().createQuery(criteriaQuery);

        int x = 0;
        for (SearchCriteriaVO param : criteriaVOs) {
            if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
                query.setParameter("techName" + x, param.getTechnologyName());
                query.setParameter("techVersion" + x, param.getTechnologyVersion());
            } else if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
                query.setParameter("techName" + x, param.getTechnologyName());
            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
                query.setParameter("techName" + x, param.getTechnologyName());
                query.setParameter("techVersion" + x, param.getTechnologyVersion());
            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
                query.setParameter("techName" + x, param.getTechnologyName());
            } else if (null != param.getTechnologyCategoryId() && null == param.getTechnologyName() && null == param.getTechnologyVersion()) {
                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
            }
            x++;
        }
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        // execute query
        @SuppressWarnings("unchecked")
        List<Project> projectList = query.getResultList();

        List<SearchProjectResultVO> searchProjectResultVOs = new ArrayList<SearchProjectResultVO>();
        for (Project project : projectList) {
            SearchProjectResultVO searchProjectResultVO = new SearchProjectResultVO();
            //
            Set<TechnologyStackVO> stacks = new TreeSet<TechnologyStackVO>();
            for (TechnologyStack technologyStack : project.getTechnologystack()) {
                for (SearchCriteriaVO param : criteriaVOs) {
                    if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName()
                            && null != param.getTechnologyVersion()) {
                        if (technologyStack.getTechnologycategory().getTechnologyCategoryId().equals(param.getTechnologyCategoryId())
                                && technologyStack.getTechName().equals(param.getTechnologyName())
                                && technologyStack.getTechVersion().startsWith(param.getTechnologyVersion())) {
                            stacks.add(ConversionUtil.convertToTechnologyStackVo(technologyStack, true, true));
                        }
                    } else if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName()
                            && null == param.getTechnologyVersion()) {
                        if (technologyStack.getTechnologycategory().getTechnologyCategoryId().equals(param.getTechnologyCategoryId())
                                && technologyStack.getTechName().equals(param.getTechnologyName())) {
                            stacks.add(ConversionUtil.convertToTechnologyStackVo(technologyStack, true, true));
                        }
                    } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName()
                            && null != param.getTechnologyVersion()) {
                        if (technologyStack.getTechName().equals(param.getTechnologyName())
                                && technologyStack.getTechVersion().startsWith(param.getTechnologyVersion())) {
                            stacks.add(ConversionUtil.convertToTechnologyStackVo(technologyStack, true, true));
                        }
                    } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName()
                            && null == param.getTechnologyVersion()) {
                        if (technologyStack.getTechName().equals(param.getTechnologyName())) {
                            stacks.add(ConversionUtil.convertToTechnologyStackVo(technologyStack, true, true));
                        }
                    } else if (null != param.getTechnologyCategoryId() && null == param.getTechnologyName()
                            && null == param.getTechnologyVersion()) {
                        if (technologyStack.getTechnologycategory().getTechnologyCategoryId().equals(param.getTechnologyCategoryId())) {
                            stacks.add(ConversionUtil.convertToTechnologyStackVo(technologyStack, true, true));
                        }
                    }
                }
            }
            //
            searchProjectResultVO.setProject(ConversionUtil.convertToProjectVO(project, false));
            searchProjectResultVO.setTechnologyStackVOs(stacks);
            searchProjectResultVOs.add(searchProjectResultVO);
        }
        return searchProjectResultVOs;
    }

    /**
     * Execute count query.
     *
     * @param criteriaVOs the criteria v os
     * @return the integer
     */
    private Integer executeCountQuery(List<SearchCriteriaVO> criteriaVOs) {
        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
        CriteriaQuery<Long> countCriteriaQuery = cBuilder.createQuery(Long.class);
        Root<Project> root = countCriteriaQuery.from(Project.class);
        countCriteriaQuery.select(cBuilder.countDistinct(root));
        Join<Project, TechnologyStack> children = root.join("technologystack");
        Join<TechnologyStack, TechnologyCategory> associate = children.join("technologycategory");

        // predicates to match 
        List<Predicate> criteriaPredicates = new ArrayList<Predicate>();

        // Loop over parameters, adding predicates and parameters as needed
        int i = 0;
        for (SearchCriteriaVO param : criteriaVOs) {

            ParameterExpression<Integer> techCatIdParam = null;
            ParameterExpression<String> techNameParam = null;
            ParameterExpression<String> techVersionParam = null;
            Predicate predicate = null;
            if (null != param.getTechnologyCategoryId()) {
                techCatIdParam = cBuilder.parameter(Integer.class, "techCatId" + i);
            }
            if (null != param.getTechnologyName()) {
                techNameParam = cBuilder.parameter(String.class, "techName" + i);
            }
            if (null != param.getTechnologyVersion()) {
                techVersionParam = cBuilder.parameter(String.class, "techVersion" + i);
            }

            if (null != techCatIdParam && null != techNameParam && null != techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(associate.get("technologyCategoryId"), techCatIdParam), cBuilder.equal(children
                        .<String> get("techName"), techNameParam), cBuilder.like(children.<String> get("techVersion"), techVersionParam));
            } else if (null != techCatIdParam && null != techNameParam && null == techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(associate.get("technologyCategoryId"), techCatIdParam), cBuilder.equal(children
                        .<String> get("techName"), techNameParam));
            } else if (null == techCatIdParam && null != techNameParam && null != techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(children.<String> get("techName"), techNameParam), cBuilder.like(children
                        .<String> get("techVersion"), techVersionParam));
            } else if (null == techCatIdParam && null != techNameParam && null == techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(children.<String> get("techName"), techNameParam));
            } else if (null != techCatIdParam && null == techNameParam && null == techVersionParam) {
                predicate = cBuilder.and(cBuilder.equal(associate.get("technologyCategoryId"), techCatIdParam));
            }

            criteriaPredicates.add(predicate);
            i++;
        }

        // separate all generated predicates with an OR
        Predicate combinedPredicate = cBuilder.or(criteriaPredicates.toArray(new Predicate[criteriaPredicates.size()]));

        // Create Query and add parameters
        countCriteriaQuery.where(combinedPredicate);
        Query query = getEm().createQuery(countCriteriaQuery);
        int x = 0;
        for (SearchCriteriaVO param : criteriaVOs) {
            if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
                query.setParameter("techName" + x, param.getTechnologyName());
                query.setParameter("techVersion" + x, param.getTechnologyVersion());
            } else if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
                query.setParameter("techName" + x, param.getTechnologyName());
            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
                query.setParameter("techName" + x, param.getTechnologyName());
                query.setParameter("techVersion" + x, param.getTechnologyVersion());
            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
                query.setParameter("techName" + x, param.getTechnologyName());
            } else if (null != param.getTechnologyCategoryId() && null == param.getTechnologyName() && null == param.getTechnologyVersion()) {
                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
            }
            x++;
        }
        Object count = query.getSingleResult();
        return (count == null) ? 0 : ((Long) count).intValue();
    }

    /**
     * Retrieve technologyby Name.
     *
     * @param techName the tech name
     * @param technologyCatId the technology cat id
     * @return the list
     */
    public List<TechnologyStack> retrieveTechnologybyName(String techName, Integer technologyCatId) {
        if (null != technologyCatId && null != techName) {
            String query = "select ts FROM TechnologyStack as ts where ts.technologycategory.technologyCategoryId = :techCatId and ts.techName = :techName";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            tq.setParameter("techCatId", technologyCatId);
            tq.setParameter("techName", techName);
            List<TechnologyStack> result = tq.getResultList();
            return result;
        } else if (null == technologyCatId && null != techName) {
            String query = "select ts FROM TechnologyStack ts where ts.techName = :techName";
            TypedQuery<TechnologyStack> tq = getEm().createQuery(query, TechnologyStack.class);
            tq.setParameter("techName", techName);
            List<TechnologyStack> result = tq.getResultList();
            return result;
        }
        return new ArrayList<TechnologyStack>();
    }

    /**
     * Retrieve getTechnologyStackList .
     *
     * 
     * @return the list
     */
    public List<TechnologyStackVO> getTechnologyStackList() {

        String query = "select new com.dell.coe.pts.vo.TechnologyStackVO(ts.techName) FROM TechnologyStack as ts group by ts.techName order by ts.techName asc";
        TypedQuery<TechnologyStackVO> tq = getEm().createQuery(query, TechnologyStackVO.class);
        List<TechnologyStackVO> result = tq.getResultList();

        return result;
    }

    //    /* (non-Javadoc)
    //     * @see com.dell.coe.pts.persistence.dao.TechnologyStackDao#executeSearchCriteria(java.util.List, java.lang.Integer, java.lang.Integer)
    //     */
    //    public SearchResultVO executeSearchCriteria(List<SearchCriteriaVO> criteriaVOs, Integer totalCount, Integer pageNumber) {
    //        //
    //        totalCount = (null == totalCount) ? executeCountQuery(criteriaVOs) : totalCount;
    //        pageNumber = (null == pageNumber) ? 1 : pageNumber;
    //        //
    //        List<SearchProjectResultVO> projectResultVOs = executePagedQuery(criteriaVOs, pageNumber - 1, 5);
    //        SearchResultVO resultVO = new SearchResultVO();
    //        resultVO.setTotalCount(totalCount);
    //        resultVO.setSearchProjectResultVOs(projectResultVOs);
    //        return resultVO;
    //    }
    //
    //    /**
    //     * Execute paged query.
    //     *
    //     * @param criteriaVOs the criteria v os
    //     * @param pageNumber the first result
    //     * @param pageSize the max results
    //     * @return the list
    //     */
    //    private List<SearchProjectResultVO> executePagedQuery(List<SearchCriteriaVO> criteriaVOs, Integer pageNumber, Integer pageSize) {
    //        // setup the criteria API to query User
    //        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
    //        CriteriaQuery<TechnologyStack> criteriaQuery = cBuilder.createQuery(TechnologyStack.class);
    //
    //        Root<TechnologyStack> root = criteriaQuery.from(TechnologyStack.class);
    //        //
    //        criteriaQuery.select(root);
    //        Join<TechnologyStack, TechnologyCategory> children = root.join("technologycategory");
    //
    //        // predicates to match 
    //        List<Predicate> criteriaPredicates = new ArrayList<Predicate>();
    //
    //        // Loop over parameters, adding predicates and parameters as needed
    //        int i = 0;
    //        for (SearchCriteriaVO param : criteriaVOs) {
    //
    //            ParameterExpression<Integer> techCatIdParam = null;
    //            ParameterExpression<String> techNameParam = null;
    //            ParameterExpression<String> techVersionParam = null;
    //            Predicate predicate = null;
    //            if (null != param.getTechnologyCategoryId()) {
    //                techCatIdParam = cBuilder.parameter(Integer.class, "techCatId" + i);
    //            }
    //            if (null != param.getTechnologyName()) {
    //                techNameParam = cBuilder.parameter(String.class, "techName" + i);
    //            }
    //            if (null != param.getTechnologyVersion()) {
    //                techVersionParam = cBuilder.parameter(String.class, "techVersion" + i);
    //            }
    //            if (null != techCatIdParam && null != techNameParam && null != techVersionParam) {
    //                predicate = cBuilder.and(cBuilder.equal(children.get("technologyCategoryId"), techCatIdParam), cBuilder.like(root
    //                        .<String> get("techName"), techNameParam), cBuilder.like(root.<String> get("techVersion"), techVersionParam));
    //            } else if (null != techCatIdParam && null != techNameParam && null == techVersionParam) {
    //                predicate = cBuilder.and(cBuilder.equal(children.get("technologyCategoryId"), techCatIdParam), cBuilder.like(root
    //                        .<String> get("techName"), techNameParam));
    //            } else if (null == techCatIdParam && null != techNameParam && null != techVersionParam) {
    //                predicate = cBuilder.and(cBuilder.like(root.<String> get("techName"), techNameParam), cBuilder.like(root
    //                        .<String> get("techVersion"), techVersionParam));
    //            } else if (null == techCatIdParam && null != techNameParam && null == techVersionParam) {
    //                predicate = cBuilder.and(predicate = cBuilder.like(root.<String> get("techName"), techNameParam));
    //            }
    //            criteriaPredicates.add(predicate);
    //            i++;
    //        }
    //
    //        // separate all generated predicates with an OR
    //        Predicate combinedPredicate = cBuilder.or(criteriaPredicates.toArray(new Predicate[criteriaPredicates.size()]));
    //
    //        // Create Query and add parameters
    //        criteriaQuery.where(combinedPredicate);
    //        Query query = getEm().createQuery(criteriaQuery);
    //
    //        int x = 0;
    //        for (SearchCriteriaVO param : criteriaVOs) {
    //            if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
    //                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //                query.setParameter("techVersion" + x, param.getTechnologyVersion() + "%");
    //            } else if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
    //                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //                query.setParameter("techVersion" + x, param.getTechnologyVersion() + "%");
    //            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //            }
    //            x++;
    //        }
    //        query.setFirstResult(pageNumber * pageSize);
    //        query.setMaxResults(pageSize);
    //        // execute query
    //        @SuppressWarnings("unchecked")
    //        List<TechnologyStack> technologyStackList = query.getResultList();
    //
    //        Map<Integer, List<TechnologyStackVO>> techStackMap = new HashMap<Integer, List<TechnologyStackVO>>();
    //        Map<Integer, ProjectVO> projectMap = new HashMap<Integer, ProjectVO>();
    //        for (TechnologyStack technologyStack : technologyStackList) {
    //            Set<Project> projects = technologyStack.getProject();
    //            for (Project project : projects) {
    //                Integer key = project.getProjectId();
    //                projectMap.put(key, ConversionUtil.convertToProjectVO(project));
    //                if (techStackMap.containsKey(key)) {
    //                    List<TechnologyStackVO> list = techStackMap.get(key);
    //                    list.add(ConversionUtil.convertToTechnologyStackVo(technologyStack));
    //                } else {
    //                    List<TechnologyStackVO> list = new ArrayList<TechnologyStackVO>();
    //                    list.add(ConversionUtil.convertToTechnologyStackVo(technologyStack));
    //                    techStackMap.put(key, list);
    //                }
    //            }
    //        }
    //
    //        List<SearchProjectResultVO> searchProjectResultVOs = new ArrayList<SearchProjectResultVO>();
    //        for (Map.Entry<Integer, List<TechnologyStackVO>> entry : techStackMap.entrySet()) {
    //            SearchProjectResultVO searchProjectResultVO = new SearchProjectResultVO();
    //            searchProjectResultVO.setProject(projectMap.get(entry.getKey()));
    //            searchProjectResultVO.setTechnologyStackVOs(entry.getValue());
    //            searchProjectResultVOs.add(searchProjectResultVO);
    //        }
    //        return searchProjectResultVOs;
    //    }
    //
    //    /**
    //     * Execute count query.
    //     *
    //     * @param criteriaVOs the criteria v os
    //     * @return the integer
    //     */
    //    private Integer executeCountQuery(List<SearchCriteriaVO> criteriaVOs) {
    //        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
    //        CriteriaQuery<Long> countCriteriaQuery = cBuilder.createQuery(Long.class);
    //        Root<TechnologyStack> root = countCriteriaQuery.from(TechnologyStack.class);
    //        countCriteriaQuery.select(cBuilder.count(root));
    //        Join<TechnologyStack, TechnologyCategory> children = root.join("technologycategory");
    //
    //        // predicates to match 
    //        List<Predicate> criteriaPredicates = new ArrayList<Predicate>();
    //
    //        // Loop over parameters, adding predicates and parameters as needed
    //        int i = 0;
    //        for (SearchCriteriaVO param : criteriaVOs) {
    //
    //            ParameterExpression<Integer> techCatIdParam = null;
    //            ParameterExpression<String> techNameParam = null;
    //            ParameterExpression<String> techVersionParam = null;
    //            Predicate predicate = null;
    //            if (null != param.getTechnologyCategoryId()) {
    //                techCatIdParam = cBuilder.parameter(Integer.class, "techCatId" + i);
    //            }
    //            if (null != param.getTechnologyName()) {
    //                techNameParam = cBuilder.parameter(String.class, "techName" + i);
    //            }
    //            if (null != param.getTechnologyVersion()) {
    //                techVersionParam = cBuilder.parameter(String.class, "techVersion" + i);
    //            }
    //            if (null != techCatIdParam && null != techNameParam && null != techVersionParam) {
    //                predicate = cBuilder.and(cBuilder.equal(children.get("technologyCategoryId"), techCatIdParam), cBuilder.like(root
    //                        .<String> get("techName"), techNameParam), cBuilder.like(root.<String> get("techVersion"), techVersionParam));
    //            } else if (null != techCatIdParam && null != techNameParam && null == techVersionParam) {
    //                predicate = cBuilder.and(cBuilder.equal(children.get("technologyCategoryId"), techCatIdParam), cBuilder.like(root
    //                        .<String> get("techName"), techNameParam));
    //            } else if (null == techCatIdParam && null != techNameParam && null != techVersionParam) {
    //                predicate = cBuilder.and(cBuilder.like(root.<String> get("techName"), techNameParam), cBuilder.like(root
    //                        .<String> get("techVersion"), techVersionParam));
    //            } else if (null == techCatIdParam && null != techNameParam && null == techVersionParam) {
    //                predicate = cBuilder.and(predicate = cBuilder.like(root.<String> get("techName"), techNameParam));
    //            }
    //            criteriaPredicates.add(predicate);
    //            i++;
    //        }
    //
    //        // separate all generated predicates with an OR
    //        Predicate combinedPredicate = cBuilder.or(criteriaPredicates.toArray(new Predicate[criteriaPredicates.size()]));
    //
    //        // Create Query and add parameters
    //        countCriteriaQuery.where(combinedPredicate);
    //        Query query = getEm().createQuery(countCriteriaQuery);
    //        int x = 0;
    //        for (SearchCriteriaVO param : criteriaVOs) {
    //            if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
    //                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //                query.setParameter("techVersion" + x, param.getTechnologyVersion() + "%");
    //            } else if (null != param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
    //                query.setParameter("techCatId" + x, param.getTechnologyCategoryId());
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null != param.getTechnologyVersion()) {
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //                query.setParameter("techVersion" + x, param.getTechnologyVersion() + "%");
    //            } else if (null == param.getTechnologyCategoryId() && null != param.getTechnologyName() && null == param.getTechnologyVersion()) {
    //                query.setParameter("techName" + x, "%" + param.getTechnologyName() + "%");
    //            }
    //            x++;
    //        }
    //        Object count = query.getSingleResult();
    //        return (count == null) ? 0 : ((Long) count).intValue();
    //    }

}
