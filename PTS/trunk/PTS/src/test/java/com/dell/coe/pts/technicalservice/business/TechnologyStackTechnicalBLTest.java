/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.technicalservice.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dell.coe.pts.persistence.TechnologyStack;
import com.dell.coe.pts.persistence.dao.TechnologyStackDaoImpl;
import com.dell.coe.pts.vo.SearchCriteriaVO;
import com.dell.coe.pts.vo.SearchResultVO;
import com.dell.coe.pts.vo.TechnologyStackVO;

/**
 * The documentation of the class TechnologyStackTechnicalBLTest
 * 
 * @author
 * @generated
 */

public class TechnologyStackTechnicalBLTest {

    private static TechnologyStackDaoImpl technologyStackDaoImpl = new TechnologyStackDaoImpl();

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    @Test
    public void createTechnologyStackTest() {

        //        em.getTransaction().begin();
        //        technologyStackDaoImpl.setEm(em);
        //
        //        TechnologyStack technologyStack = new TechnologyStack();
        //
        //        technologyStackDaoImpl.save(technologyStack);
        //
        //        em.flush();
        //        em.clear();
        //        em.getTransaction().commit();

        // Start of user code for the body of createTechnologyStackTest
        // TODO should be implemented
        // any more comments
        // End of user code

    }

    @Test
    public void retrieveProjectVsCategoryDataTest() {
        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        technologyStackDaoImpl.retrieveProjectVsCategoryData(10);

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void retrieveProjectVsTechnologyDataTest() {
        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        technologyStackDaoImpl.retrieveProjectVsTechnologyData(10);

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void executeSearchCriteriaTest() {
        List<SearchCriteriaVO> criteriaVOs = new ArrayList<SearchCriteriaVO>();
        //        criteriaVOs.add(new SearchCriteriaVO(1, "JDK", "1"));
        //                criteriaVOs.add(new SearchCriteriaVO(null, "Maven", "3.1.4"));
        //        criteriaVOs.add(new SearchCriteriaVO(null, "Lin", null));
        //        criteriaVOs.add(new SearchCriteriaVO(1, null, null));
        criteriaVOs.add(new SearchCriteriaVO(8, null, null));
        //        criteriaVOs.add(new SearchCriteriaVO(4, "JBoss", null));
        //        criteriaVOs.add(new SearchCriteriaVO(4, null, null));
        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        SearchResultVO resultVO = technologyStackDaoImpl.executeSearchCriteria(criteriaVOs, false, null, 1);
        System.out.println(resultVO.getTotalCount());

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void retrieveOrderedTechnologyStackTest() {
        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        List<TechnologyStack> technologyStacks = technologyStackDaoImpl.retrieveOrderedTechnologyStack(1);
        System.out.println(technologyStacks.size());
        //
        technologyStacks = technologyStackDaoImpl.retrieveOrderedTechnologyStack(null);
        System.out.println(technologyStacks.size());

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void getTechnologyStackListTest() {
        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        List<TechnologyStackVO> technologyStacks = technologyStackDaoImpl.getTechnologyStackList();
        System.out.println(technologyStacks.size());
        //

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void updateTechnologyStackTest() {

        // Start of user code for the body of updateTechnologyStackTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void getTechnologyStackByIdTest() {

        // Start of user code for the body of getTechnologyStackByIdTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void getAllTechnologyStackTest() {

        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        List<TechnologyStack> list = technologyStackDaoImpl.listAll();
        for (TechnologyStack technologyStack : list) {
            System.out.println(technologyStack.toString());
        }

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void retrieveTechnologybyKeywordTest() {
        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        List<TechnologyStack> list = technologyStackDaoImpl.retrieveTechnologybyKeyword("Maven", null);
        for (TechnologyStack technologyStack : list) {
            System.out.println(technologyStack.toString());
        }

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void retrieveTechnologybyNameTest() {
        em.getTransaction().begin();
        technologyStackDaoImpl.setEm(em);

        List<TechnologyStack> technologyStackObj = technologyStackDaoImpl.retrieveTechnologybyName("Maven", null);
        technologyStackObj.size();
        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    @Test
    public void removeTechnologyStackTest() {
        // technologyStackDao.delete(technologystack);
        // Start of user code for the body of removeTechnologyStackTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    // Start of user code For declaring your own operations for TechnologyStackTest
    // add addtional operations here
    // any more comments

    // End of user code

    /**
     * The documentation of the method setUpBeforeClass
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

        if (em == null) {
            emf = Persistence.createEntityManagerFactory("PTSUnit");
            em = emf.createEntityManager();
        }
        // Start of user code for the body of setUpBeforeClass
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    /**
     * The documentation of the method tearDownAfterClass
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {

        em.close();
        emf.close();
        // Start of user code for the body of tearDownAfterClass
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    /**
     * The documentation of the method setUp
     */
    @Before
    public void setUp() throws Exception {
        // Start of user code for the body of setUp
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    /**
     * The documentation of the method tearDown
     */
    @After
    public void tearDown() throws Exception {
        // Start of user code for the body of tearDown
        // TODO should be implemented
        // any more comments
        // End of user code
    }

}