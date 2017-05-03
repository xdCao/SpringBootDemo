package voteManage.domain;

import javax.persistence.*;

/**
 * Created by xdcao on 2017/5/3.
 */
@Entity
public class Voteinfo {
    private int id;
    private String name;
    private Channelinfo channelinfoByChannelId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voteinfo voteinfo = (Voteinfo) o;

        if (id != voteinfo.id) return false;
        if (name != null ? !name.equals(voteinfo.name) : voteinfo.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "channelId", referencedColumnName = "id")
    public Channelinfo getChannelinfoByChannelId() {
        return channelinfoByChannelId;
    }

    public void setChannelinfoByChannelId(Channelinfo channelinfoByChannelId) {
        this.channelinfoByChannelId = channelinfoByChannelId;
    }
}
