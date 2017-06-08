package com.ccit.bean;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/6/2.
 */
@Entity
@Table(name = "tb_item")
public class TBItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image;
    private Integer num;
    private Double price;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "cid")
    private TBItemCat tbItemCat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TBItemCat getTbItemCat() {
        return tbItemCat;
    }

    public void setTbItemCat(TBItemCat tbItemCat) {
        this.tbItemCat = tbItemCat;
    }

    @Override
    public String toString() {
        return "TBItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", tbItemCat=" + tbItemCat +
                '}';
    }
}
