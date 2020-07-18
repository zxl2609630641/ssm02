package com.ssm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//实体对应的表是tab_employee
@Table(name = "tab_employee")
public class TabEmployee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    @Column(name = "employeeid")
    private Integer employeeid;
    @Column(name = "accountid")
    private Integer accountid;
    @Column(name = "departmentid")
    private Integer departmentid;

    private String employeename;

    private String employeesex;

    private Integer employeeage;

    private String employeephone;

    private Date jointime;

    private String employeestate;

    private String province;

    private String city;

    private Integer chinaId;

    private Integer shopid;

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename == null ? null : employeename.trim();
    }

    public String getEmployeesex() {
        return employeesex;
    }

    public void setEmployeesex(String employeesex) {
        this.employeesex = employeesex == null ? null : employeesex.trim();
    }

    public Integer getEmployeeage() {
        return employeeage;
    }

    public void setEmployeeage(Integer employeeage) {
        this.employeeage = employeeage;
    }

    public String getEmployeephone() {
        return employeephone;
    }

    public void setEmployeephone(String employeephone) {
        this.employeephone = employeephone == null ? null : employeephone.trim();
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public String getEmployeestate() {
        return employeestate;
    }

    public void setEmployeestate(String employeestate) {
        this.employeestate = employeestate == null ? null : employeestate.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getChinaId() {
        return chinaId;
    }

    public void setChinaId(Integer chinaId) {
        this.chinaId = chinaId;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }
}