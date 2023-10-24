/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TARUC
 */
@Entity
@Table(name = "REGISTERED_SUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegisteredSubject.findAll", query = "SELECT r FROM RegisteredSubject r")
    , @NamedQuery(name = "RegisteredSubject.findByRegSubjectId", query = "SELECT r FROM RegisteredSubject r WHERE r.regSubjectId = :regSubjectId")})
public class RegisteredSubject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REG_SUBJECT_ID")
    private Integer regSubjectId;
    @JoinColumn(name = "REG_ID", referencedColumnName = "REG_ID")
    @ManyToOne
    private Registration regId;
    @JoinColumn(name = "SUBJECT_CODE", referencedColumnName = "SUBJECT_CODE")
    @ManyToOne
    private Subject subjectCode;

    public RegisteredSubject() {
    }

    public RegisteredSubject(Integer regSubjectId) {
        this.regSubjectId = regSubjectId;
    }

    public RegisteredSubject(Subject subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Integer getRegSubjectId() {
        return regSubjectId;
    }

    public void setRegSubjectId(Integer regSubjectId) {
        this.regSubjectId = regSubjectId;
    }

    public Registration getRegId() {
        return regId;
    }

    public void setRegId(Registration regId) {
        this.regId = regId;
    }

    public Subject getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(Subject subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regSubjectId != null ? regSubjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisteredSubject)) {
            return false;
        }
        RegisteredSubject other = (RegisteredSubject) object;
        if ((this.regSubjectId == null && other.regSubjectId != null) || (this.regSubjectId != null && !this.regSubjectId.equals(other.regSubjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RegisteredSubject[ regSubjectId=" + regSubjectId + " ]";
    }
    
}
