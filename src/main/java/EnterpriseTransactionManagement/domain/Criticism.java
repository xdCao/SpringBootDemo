package EnterpriseTransactionManagement.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xdcao on 2017/5/1.
 */
@Entity
public class Criticism {
    private int id;
    private String criticismContent;
    private int employId;
    private Date criticismTime;
    private int messageId;
    private Employ employByEmployId;
    private Message messageByMessageId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "criticismContent", nullable = false, length = 255)
    public String getCriticismContent() {
        return criticismContent;
    }

    public void setCriticismContent(String criticismContent) {
        this.criticismContent = criticismContent;
    }

    @Basic
    @Column(name = "employId",insertable = false,updatable = false)
    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    @Basic
    @Column(name = "criticismTime", nullable = false)
    public Date getCriticismTime() {
        return criticismTime;
    }

    public void setCriticismTime(Date criticismTime) {
        this.criticismTime = criticismTime;
    }

    @Basic
    @Column(name = "messageId", nullable = false,insertable = false,updatable = false)
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Criticism criticism = (Criticism) o;

        if (id != criticism.id) return false;
        if (employId != criticism.employId) return false;
        if (messageId != criticism.messageId) return false;
        if (criticismContent != null ? !criticismContent.equals(criticism.criticismContent) : criticism.criticismContent != null)
            return false;
        if (criticismTime != null ? !criticismTime.equals(criticism.criticismTime) : criticism.criticismTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (criticismContent != null ? criticismContent.hashCode() : 0);
        result = 31 * result + employId;
        result = 31 * result + (criticismTime != null ? criticismTime.hashCode() : 0);
        result = 31 * result + messageId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employId", referencedColumnName = "id")
    public Employ getEmployByEmployId() {
        return employByEmployId;
    }

    public void setEmployByEmployId(Employ employByEmployId) {
        this.employByEmployId = employByEmployId;
    }

    @ManyToOne
    @JoinColumn(name = "messageId", referencedColumnName = "id", nullable = false)
    public Message getMessageByMessageId() {
        return messageByMessageId;
    }

    public void setMessageByMessageId(Message messageByMessageId) {
        this.messageByMessageId = messageByMessageId;
    }
}
