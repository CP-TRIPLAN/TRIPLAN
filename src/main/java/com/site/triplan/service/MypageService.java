package com.site.triplan.service;

import com.site.triplan.mapper.MypageMapper;
import com.site.triplan.vo.PlanVo;
import com.site.triplan.vo.ReplyVo;
import com.site.triplan.vo.UserVo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MypageService {
    private MypageMapper mypageMapper;

    public MypageService(MypageMapper mypageMapper) {
        this.mypageMapper = mypageMapper;
    }

    
    public List<ReplyVo> getAllList() { //댓글
        return mypageMapper.getAllReplies();
    }

    public Integer getAllReplyCount() {
        return mypageMapper.getReplyCount();
    }

    public Integer getAllPlanCount() {
        return mypageMapper.getPlanCount();
    }

    public Integer getAllLikeCount() {
        return mypageMapper.getLikeCount();
    }

    public List<PlanVo> getAllLikeList() { /*좋아요한 일정들*/
        return mypageMapper.getAllLikePlans();
    }

    public Integer getPlaceNum() {
        return mypageMapper.getPlaceCount();
    }

    public UserVo getMyProfile() {
        return mypageMapper.getUserProfile();
    }

    /*public List<PlanVo> getAllPlanList() {
        return mypageMapper.getAllMyPlans();
    }*/

    public List<PlanVo> getScheduledList() {
        return mypageMapper.getScheduledPlans();
    }

    public List<PlanVo> getCompletedList() {
        return mypageMapper.getCompletedPlans();
    }

}
