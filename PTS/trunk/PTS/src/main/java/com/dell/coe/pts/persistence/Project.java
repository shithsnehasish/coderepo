/**
 * Generated by Dell Virtuoso
 * All rights reserved.
 */
package com.dell.coe.pts.persistence;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.dell.coe.pts.common.dao.AuditVersionEntity;
import com.dell.coe.pts.common.dao.PersistentEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The documentation of the class Project.
 *
 * @author 
 * @generated 
 */
@Entity
@Table(name = "PROJECT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "projectId")
public class Project extends AuditVersionEntity implements PersistentEntity {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3533550292810732896L;

    /** The project id. */
    @Id
    @GeneratedValue(generator = "PROJECT_GEN")
    @SequenceGenerator(name = "PROJECT_GEN", sequenceName = "PROJECT_SEQ")
    @Column(name = "PROJECT_ID")
    // PROJECT_ID
    private Integer projectId;

    /**
     * The documentation of the getter getProjectId.
     *
     * @return the project id
     * @generated 
     */
    public Integer getProjectId() {
        return this.projectId;
    }

    /**
     * The documentation of the setter setProjectId.
     *
     * @param projectId the new project id
     * @generated 
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * The documentation of the attribute projType.
     * 
     * @generated
     */
    @Column(name = "PROJ_TYPE")
    private String projType;
    /**
     * The documentation of the attribute projName.
     * 
     * @generated
     */
    @Column(name = "PROJ_NAME")
    private String projName;

    /**
     * The documentation of the attribute technologystack.
     * 
     * @generated
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "PROJECT_TECHNOLOGY_STACK", joinColumns = @JoinColumn(name = "PROJECT_ID"), inverseJoinColumns = @JoinColumn(name = "TECHNOLOGY_STACK_ID"))
    private Set<TechnologyStack> technologystack;

    /**
     * The documentation of the constructor.
     * 
     * @generated
     */
    public Project() {
        super();
    }

    // Start of user code For declaring your own attributes and operations for Project
    // TODO should be implemented
    // any more comments

    // End of user code

    /**
     * The documentation of the getter getProjType.
     *
     * @return the proj type
     * @generated 
     */
    public String getProjType() {
        return this.projType;
    }

    /**
     * The documentation of the setter setProjType.
     *
     * @param newProjType the new proj type
     * @generated 
     */
    public void setProjType(String newProjType) {
        this.projType = newProjType;
    }

    /**
     * The documentation of the getter getProjName.
     *
     * @return the proj name
     * @generated 
     */
    public String getProjName() {
        return this.projName;
    }

    /**
     * The documentation of the setter setProjName.
     *
     * @param newProjName the new proj name
     * @generated 
     */
    public void setProjName(String newProjName) {
        this.projName = newProjName;
    }

    /**
     * The documentation of the getter getTechnologystack.
     *
     * @return the technologystack
     * @generated 
     */
    public Set<TechnologyStack> getTechnologystack() {
        return this.technologystack;
    }

    /**
     * The documentation of the setter setTechnologystack.
     *
     * @param newTechnologystack the new technologystack
     * @generated 
     */
    public void setTechnologystack(Set<TechnologyStack> newTechnologystack) {
        this.technologystack = newTechnologystack;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((projName == null) ? 0 : projName.hashCode());
        result = prime * result + ((projType == null) ? 0 : projType.hashCode());
        result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        if (projName == null) {
            if (other.projName != null)
                return false;
        } else if (!projName.equals(other.projName))
            return false;
        if (projType == null) {
            if (other.projType != null)
                return false;
        } else if (!projType.equals(other.projType))
            return false;
        if (projectId == null) {
            if (other.projectId != null)
                return false;
        } else if (!projectId.equals(other.projectId))
            return false;
        return true;
    }

    /**
     * The documentation of the method toString().
     *
     * @return the string
     * @generated 
     */
    @Override
    public String toString() {
        StringBuilder retValue = new StringBuilder();
        retValue.append("Project [ ");
        if (projType != null) {
            retValue.append(" projType = ");
            retValue.append(projType);
        }
        if (projName != null) {
            retValue.append(" projName = ");
            retValue.append(projName);
        }
        if (technologystack != null) {
            retValue.append(" technologystack = ");
            retValue.append(technologystack.toString());
        }
        if (projectId != null) {
            retValue.append(" projectId = ");
            retValue.append(projectId.toString());
        }
        retValue.append(" ] ");
        return retValue.toString();
    }
}