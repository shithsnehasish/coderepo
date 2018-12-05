/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.technicalservice.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dell.coe.pts.persistence.TechnologyCategory;
import com.dell.coe.pts.persistence.dao.TechnologyCategoryDaoImpl;

/**
 * The documentation of the class TechnologyCategoryTechnicalBLTest
 * 
 * @author
 * @generated
 */

public class TechnologyCategoryTechnicalBLTest {

    private static TechnologyCategoryDaoImpl technologyCategoryDaoImpl = new TechnologyCategoryDaoImpl();

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    @Test
    public void createTechnologyCategoryTest() {

        em.getTransaction().begin();
        technologyCategoryDaoImpl.setEm(em);

        TechnologyCategory technologyCategory = new TechnologyCategory();

        technologyCategoryDaoImpl.save(technologyCategory);

        em.flush();
        em.clear();
        em.getTransaction().commit();

        // Start of user code for the body of createTechnologyCategoryTest
        // TODO should be implemented
        // any more comments
        // End of user code

    }

    @Test
    public void updateTechnologyCategoryTest() {

        // Start of user code for the body of updateTechnologyCategoryTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void getTechnologyCategoryByIdTest() {

        // Start of user code for the body of getTechnologyCategoryByIdTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void getAllTechnologyCategoryTest() {

        // Start of user code for the body of getAllTechnologyCategoryTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void removeTechnologyCategoryTest() {
        // technologyCategoryDao.delete(technologycategory);
        // Start of user code for the body of removeTechnologyCategoryTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    // Start of user code For declaring your own operations for TechnologyCategoryTest
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
