package com.hau.huylong.graduation_proejct.entity.hau;

import com.hau.huylong.graduation_proejct.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "industries_posts")
public class IndustryPost extends BaseEntity {
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "industry_id")
    private Long industryId;
}
