package com.nitish.backend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Data
@EntityListeners(AuditChangeListener.class)
@EqualsAndHashCode(callSuper=true)
public abstract class AuditableTimeEntity extends PersistableBaseEntity {

    @CreatedDate
    @Column(insertable = false)
    private Date createdDateTime;

    @LastModifiedDate
    @Column(insertable = false)
    private Date modifiedDateTime;


}