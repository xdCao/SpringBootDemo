package EnterpriseTransactionManagement.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


/**
 * Created by xdcao on 2017/5/1.
 */
@Entity
public class Employ {
    private int id;
    private String employName;
    private byte employSex;
    private Date employBirth;
    private String employPhone;
    private String employAddress;
    private Date joinTime;
    private String password;
    private byte isLeader;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false, length = 30)
    public String getEmployName() {
        return employName;
    }

    public void setEmployName(String employName) {
        this.employName = employName;
    }

    @Basic
    @Column(nullable = false)
    public byte getEmploySex() {
        return employSex;
    }

    public void setEmploySex(byte employSex) {
        this.employSex = employSex;
    }

    @Basic
    @Column(nullable = false)
    public Date getEmployBirth() {
        return employBirth;
    }

    public void setEmployBirth(Date employBirth) {
        this.employBirth = employBirth;
    }

    @Basic
    @Column(nullable = false, length = 20)
    public String getEmployPhone() {
        return employPhone;
    }

    public void setEmployPhone(String employPhone) {
        this.employPhone = employPhone;
    }

    @Basic
    @Column(nullable = false, length = 255)
    public String getEmployAddress() {
        return employAddress;
    }

    public void setEmployAddress(String employAddress) {
        this.employAddress = employAddress;
    }

    @Basic
    @Column(nullable = false)
    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    @Basic
    @Column(nullable = false, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(nullable = false)
    public byte getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(byte isLeader) {
        this.isLeader = isLeader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employ employ = (Employ) o;

        if (id != employ.id) return false;
        if (employSex != employ.employSex) return false;
        if (isLeader != employ.isLeader) return false;
        if (employName != null ? !employName.equals(employ.employName) : employ.employName != null) return false;
        if (employBirth != null ? !employBirth.equals(employ.employBirth) : employ.employBirth != null) return false;
        if (employPhone != null ? !employPhone.equals(employ.employPhone) : employ.employPhone != null) return false;
        if (employAddress != null ? !employAddress.equals(employ.employAddress) : employ.employAddress != null)
            return false;
        if (joinTime != null ? !joinTime.equals(employ.joinTime) : employ.joinTime != null) return false;
        if (password != null ? !password.equals(employ.password) : employ.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (employName != null ? employName.hashCode() : 0);
        result = 31 * result + (int) employSex;
        result = 31 * result + (employBirth != null ? employBirth.hashCode() : 0);
        result = 31 * result + (employPhone != null ? employPhone.hashCode() : 0);
        result = 31 * result + (employAddress != null ? employAddress.hashCode() : 0);
        result = 31 * result + (joinTime != null ? joinTime.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) isLeader;
        return result;
    }
}
