package com.ccit.bean;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/6/2.
 */
@Entity
@Table(name = "tb_item_cat")
public class TBItemCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "")

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TBItemCat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
