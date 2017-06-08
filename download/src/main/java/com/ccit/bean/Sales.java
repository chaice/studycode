package com.ccit.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/2.
 */
@Entity
@Table(name = "sales")
public class Sales implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String year;
    private String season;
    private Integer sale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "year='" + year + '\'' +
                ", season='" + season + '\'' +
                ", sale=" + sale +
                '}';
    }
}
