package cn.zjc.entity;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * created by IntelliJ IDEA
 *
 * @author zjc
 * @time 2016/1/19-14:03
 */
@Table(name = "user")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 4888847856979510302L;
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    @Column
    private String name;
    private String phone;
    private Date birth;


    public User() {
    }

    public User(Integer id, String name, String phone, Date birth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}
