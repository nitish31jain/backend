package com.nitish.backend.model.entity;

import com.nitish.backend.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@Configurable
public class AuditChangeListener {
    @PrePersist
    public void onCreate(AuditableTimeEntity target) {
        Date now = DateTimeUtil.getCurrentDate();
        target.setCreatedDateTime(now);
        target.setModifiedDateTime(now);
    }

    @PreUpdate
    public void onUpdate(AuditableTimeEntity target) {
        target.setModifiedDateTime(DateTimeUtil.getCurrentDate());
    }
}