package com.nitish.backend.model.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter
public abstract class PersistableBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    protected long id;

}