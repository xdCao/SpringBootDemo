package voteManage.domain;

import javax.persistence.*;

/**
 * Created by xdcao on 2017/5/3.
 */
@Entity
public class Voteoption {
    private int id;
    private String name;
    private Integer ticketnum;
    private Voteinfo voteinfoByVoteId;

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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ticketnum", nullable = true)
    public Integer getTicketnum() {
        return ticketnum;
    }

    public void setTicketnum(Integer ticketnum) {
        this.ticketnum = ticketnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voteoption that = (Voteoption) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (ticketnum != null ? !ticketnum.equals(that.ticketnum) : that.ticketnum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (ticketnum != null ? ticketnum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "voteId", referencedColumnName = "id")
    public Voteinfo getVoteinfoByVoteId() {
        return voteinfoByVoteId;
    }

    public void setVoteinfoByVoteId(Voteinfo voteinfoByVoteId) {
        this.voteinfoByVoteId = voteinfoByVoteId;
    }
}
