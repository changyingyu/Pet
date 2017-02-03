package com.yingpet.model;

import javax.persistence.*;

/**
 * Created by yingyuchang on 2017-01-18.
 */


@Entity
@Table(name = "pet", schema = "springdemo")
public class PetEntity {




    private String name;
    private String type;
    private String status;
    private String image;
    private String category;
    //private Collection<BlogEntity> blogsById;

    @Id
    @GeneratedValue
    @Column(name = "pet_id", nullable = false)
    private int id;
    public int getPetId() {
        return id;
    }

    @Basic
    @Column(name = "category")
    public String getCategoryS() {
        return category;
    }

    public void setCategoryS(String category) {
        this.category = category;
    }


    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String newname) {
        this.name = newname;
    }

    @Basic
    @Column(name = "type")
    public String getPetType() {
        return type;
    }

    public void setPetType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Basic
    @Column(name = "image")
    public String getImg() {
        return image;
    }

    public void setImg(String image) {
        this.image = image;
    }


    public void setId(Integer id) {
        this.id = id;
    }

/*

    @OneToMany(mappedBy = "userByUserId")
    public Collection<BlogEntity> getBlogsById() {
        return blogsById;
    }

    public void setBlogsById(Collection<BlogEntity> blogsById) {
        this.blogsById = blogsById;
    }

*/




}

