package voteManage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import voteManage.dao.ChannelRepository;
import voteManage.dao.VoteInfoRepository;
import voteManage.dao.VoteOptionRepository;
import voteManage.domain.Channelinfo;
import voteManage.domain.Voteinfo;
import voteManage.domain.Voteoption;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdcao on 2017/5/3.
 */
@Controller
public class VoteController {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private VoteInfoRepository voteInfoRepository;

    @Autowired
    private VoteOptionRepository voteOptionRepository;

    @RequestMapping(value = "/newVote")
    public String newVote(){
        return "addVote";
    }

    @RequestMapping(value = "/addVote",method = RequestMethod.POST)
    public ModelAndView addVote(@RequestParam int channel, @RequestParam String[] voteOption,@RequestParam String voteName){

        System.out.println(channel+", options: "+voteOption.length+", voteName: "+voteName);

        Channelinfo channelinfo=channelRepository.findOne(channel);

        Voteinfo voteinfo=new Voteinfo();
        voteinfo.setName(voteName);
        voteinfo.setChannelinfoByChannelId(channelinfo);
        Voteinfo back=voteInfoRepository.save(voteinfo);

        List<Voteoption> voteoptions=new ArrayList<Voteoption>();
        for (String op:voteOption){
            Voteoption voteoption=new Voteoption();
            voteoption.setName(op);
            voteoption.setVoteinfoByVoteId(back);
            voteOptionRepository.save(voteoption);
            voteoptions.add(voteoption);
        }


        return new ModelAndView("option","voteOptions",voteoptions);

    }


}
