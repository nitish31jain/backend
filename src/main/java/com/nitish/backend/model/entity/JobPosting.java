    package com.nitish.backend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "job_posting")
@Data
@ToString
public class JobPosting extends AuditableBaseEntity {
    private String jobName;
    private String companyName;
    private String jobType;
    private String jobLocation;
    private Date whenPosted;
    private String portalName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobPosting that = (JobPosting) o;
        return Objects.equals(jobName, that.jobName) &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(jobType, that.jobType) &&
                Objects.equals(jobLocation, that.jobLocation) &&
                Objects.equals(whenPosted, that.whenPosted) &&
                Objects.equals(portalName, that.portalName);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((jobName == null) ? 0 : jobName.hashCode());
        result = prime * result
                + ((companyName == null) ? 0 : companyName.hashCode());
        result = prime * result
                + ((jobType == null) ? 0 : jobType.hashCode());
        result = prime * result
                + ((jobLocation == null) ? 0 : jobLocation.hashCode());
        result = prime * result
                + ((whenPosted == null) ? 0 : whenPosted.hashCode());
        result = prime * result
                + ((portalName == null) ? 0 : portalName.hashCode());
        return result;
    }
}