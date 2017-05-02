package EnterpriseTransactionManagement.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xdcao on 2017/5/1.
 */
@Entity
public class Message {
    private int id;
    private String messageTitle;
    private String messageContent;
    private Date publishTime;
    private Employ employByEmployId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "messageTitle", nullable = false, length = 255)
    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    @Basic
    @Column(name = "messageContent", nullable = false, length = 255)
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Basic
    @Column(name = "publishTime", nullable = false)
    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (messageTitle != null ? !messageTitle.equals(message.messageTitle) : message.messageTitle != null)
            return false;
        if (messageContent != null ? !messageContent.equals(message.messageContent) : message.messageContent != null)
            return false;
        if (publishTime != null ? !publishTime.equals(message.publishTime) : message.publishTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (messageTitle != null ? messageTitle.hashCode() : 0);
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employId", referencedColumnName = "id", nullable = false)
    public Employ getEmployByEmployId() {
        return employByEmployId;
    }

    public void setEmployByEmployId(Employ employByEmployId) {
        this.employByEmployId = employByEmployId;
    }
}
