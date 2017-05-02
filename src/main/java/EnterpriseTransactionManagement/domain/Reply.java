package EnterpriseTransactionManagement.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xdcao on 2017/5/1.
 */
@Entity
public class Reply {
    private int id;
    private String replyContent;
    private Date replyTime;
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
    @Column(name = "replyContent", nullable = false, length = 255)
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Basic
    @Column(name = "replyTime", nullable = false)
    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reply reply = (Reply) o;

        if (id != reply.id) return false;
        if (replyContent != null ? !replyContent.equals(reply.replyContent) : reply.replyContent != null) return false;
        if (replyTime != null ? !replyTime.equals(reply.replyTime) : reply.replyTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
        result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "messageId", referencedColumnName = "id", nullable = false)
    public Message getMessageByMessageId() {
        return messageByMessageId;
    }

    public void setMessageByMessageId(Message messageByMessageId) {
        this.messageByMessageId = messageByMessageId;
    }
}
