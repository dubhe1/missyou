package com.missyou.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class SpuDetailImg extends BaseEntity {
    @Id
    private Long id;

    private String img;

    private Long spuId;

    private Long index;
}

