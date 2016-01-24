package cn.zjc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zjc on 2016/1/24.
 */
@Table(name="address")
public class Address implements java.io.Serializable {

    private static final long serialVersionUID = -4888847856979510302L;
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column
    private Integer uId;
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
