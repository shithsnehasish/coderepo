/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.technicalservice.business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dell.coe.pts.persistence.Project;
import com.dell.coe.pts.persistence.TechnologyCategory;
import com.dell.coe.pts.persistence.TechnologyStack;
import com.dell.coe.pts.persistence.dao.ProjectDaoImpl;
import com.dell.coe.pts.persistence.dao.TechnologyCategoryDaoImpl;

/**
 * The documentation of the class ProjectTechnicalBLTest
 * 
 * @author
 * @generated
 */

public class ProjectTechnicalBLTest {

    private static ProjectDaoImpl projectDaoImpl = new ProjectDaoImpl();
    private static TechnologyCategoryDaoImpl categoryDaoImpl = new TechnologyCategoryDaoImpl();

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    @Test
    public void createProjectTest() {

	/*
        em.getTransaction().begin();
        projectDaoImpl.setEm(em);
        categoryDaoImpl.setEm(em);
        //
        Project project = new Project();
        project.setProjName("Test_2");
        project.setProjType("Type_2");
        //
        TechnologyCategory catProgLang = categoryDaoImpl.findById(Integer.valueOf(1));
        TechnologyCategory catOperSys = categoryDaoImpl.findById(Integer.valueOf(2));
        //
        Set<TechnologyStack> newTechnologystack = new HashSet<TechnologyStack>();
        TechnologyStack stack1 = new TechnologyStack();
        stack1.setTechName("Nava");
        stack1.setTechnologycategory(catProgLang);
        stack1.setTechVersion("1.5");
        //
        TechnologyStack stack2 = new TechnologyStack();
        stack2.setTechName("Jinux");
        stack2.setTechnologycategory(catOperSys);
        stack2.setTechVersion("1.0.12");
        //
        newTechnologystack.add(stack1);
        newTechnologystack.add(stack2);
        //
        project.setTechnologystack(newTechnologystack);

        projectDaoImpl.save(project);

        em.flush();
        em.clear();
        em.getTransaction().commit();

        // Start of user code for the body of createProjectTest
        // TODO should be implemented
        // any more comments
        // End of user code
*/
    }

    @Test
    public void updateProjectTest() {

        // Start of user code for the body of updateProjectTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void getProjectByIdTest() {

        // Start of user code for the body of getProjectByIdTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void getAllProjectTest() {

        // Start of user code for the body of getAllProjectTest
        // TODO should be implemented
        // any more comments
        // End of user code
    }

    @Test
    public void removeProjectTest() {
        // projectDao.delete(project);
        // Start of user code for the body of removeProjectTest
        // TODO should be implemented
        // any more comments
        // End of user code
        em.getTransaction().begin();
        projectDaoImpl.setEm(em);

        Project project = new Project();
        project.setProjectId(27);
        project.setProjName("Test_2");
        project.setProjType("Type_2");
        projectDaoImpl.delete(project);
        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    // Start of user code For declaring your own operations for ProjectTest
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
