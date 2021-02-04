package com.nitish.backend.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper=true)
public abstract class AuditableBaseEntity extends AuditableTimeEntity {
    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
}