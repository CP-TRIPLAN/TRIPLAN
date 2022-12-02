package com.site.triplan.controller;

import com.site.triplan.service.MypageService;
import com.site.triplan.vo.PlanVo;
import com.site.triplan.vo.ReplyVo;
import com.site.triplan.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/triplan")
public class MypageController {

    private MypageService mypageService;
    private List<String> checkBoxArr;

    public MypageController(MypageService mypageService) {
        this.mypageService = mypageService;
    }


    @RequestMapping("/mypage/like")
    public String mypagelike(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            /*맨 위 닉네임 한글자 + 닉네임*/
            UserVo userProfile = mypageService.getMyProfile(id);
            //Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            //model.addAttribute("firstletterNickname", nicknameFirst);

            String nickname = (String)session.getAttribute("session_nickname");
            Character nicknameFirst = nickname.charAt(0);
            model.addAttribute("firstletterNickname",nicknameFirst);



            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);
            model.addAttribute("likecount", likeCount);
            List<PlanVo> likeList = mypageService.getAllLikeList(code);
            model.addAttribute("likelist",likeList);

            /*Integer placeCount = mypageService.getPlaceNum();
            model.addAttribute("placecount", placeCount);*/
            view = "user_mypage_like";
        }
        return view;
    }
    /*다가올 일정*/
    @GetMapping("/mypage")
    public String mypage(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);

            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);
            model.addAttribute("likecount", likeCount);
            /*Integer placeCount = mypageService.getPlaceNum();
            model.addAttribute("placecount", placeCount);*/

            /*List<PlanVo> planList = mypageService.getAllPlanList();
            model.addAttribute("planlist", planList);

            view = "user_mypage_main2";*/

            List<PlanVo> schPlanList = mypageService.getScheduledList(code);
            model.addAttribute("schplanlist",schPlanList);

            view = "user_mypage_scheduledplan";
        }
        return view;
    }

    @PostMapping("/mypage")
    public String mypagePost(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);

            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);
            model.addAttribute("likecount", likeCount);
            /*Integer placeCount = mypageService.getPlaceNum();
            model.addAttribute("placecount", placeCount);*/

            /*List<PlanVo> planList = mypageService.getAllPlanList();
            model.addAttribute("planlist", planList);

            view = "user_mypage_main2";*/

            List<PlanVo> schPlanList = mypageService.getScheduledList(code);
            model.addAttribute("schplanlist",schPlanList);

            view = "user_mypage_scheduledplan";
        }
        return view;
    }

    /*완료된 일정*/    /*@GetMapping("/mypage/completedPlans")*/
    @GetMapping("/mypage/completedplans")
    /*@GetMapping("mypage/completedPlans")*/
    public String mypageCompletedPlans(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);

            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);
            model.addAttribute("likecount", likeCount);
            /*Integer placeCount = mypageService.getPlaceNum();
            model.addAttribute("placecount", placeCount);*/

            List<PlanVo> comPlanList = mypageService.getCompletedList(code);
            model.addAttribute("complanlist",comPlanList);


            /*view = "user_mypage_completedplan";*/
            view = "user_mypage_completedplan";
        }
        return view;
    }

    @PostMapping("/mypage/completedplans")
    /*@GetMapping("mypage/completedPlans")*/
    public String mypageCompletedPlansPost(Model model, HttpServletRequest request/*, @RequestParam("mateEmail") String mateEmail*/) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);

            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);
            model.addAttribute("likecount", likeCount);
            /*Integer placeCount = mypageService.getPlaceNum();
            model.addAttribute("placecount", placeCount);*/

            List<PlanVo> comPlanList = mypageService.getCompletedList(code);
            model.addAttribute("complanlist",comPlanList);

            /*UserVo mate = mypageService.searchMate(mateEmail);// 검색만 해옴. 받은 이메일의 code, name, nickname,*/

            view = "user_mypage_completedplan";
        }
        return view;
    }


    @RequestMapping("/mypage/reply")
    public String mypagereply(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);

            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            List<ReplyVo> replyList = mypageService.getAllList(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);;
            model.addAttribute("likecount", likeCount);
            model.addAttribute("replies", replyList);
            view = "user_mypage_reply";
        }
        return view;
    }

    @PostMapping("/mypage/reply")
    public String mypagereplyPost(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);

            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            List<ReplyVo> replyList = mypageService.getAllList(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);;
            model.addAttribute("likecount", likeCount);
            model.addAttribute("replies", replyList);
            view = "user_mypage_reply";
        }
        return view;
    }

    //회원정보 수정(보여지는 화면)
    @RequestMapping("/myprofile")
    public String myprofile(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
//        String code = String.valueOf(session.getAttribute("session_id"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);//받아온 UserVo에서 닉네임만 string으로 넘김,[0]인덱스 한글자만 보여주려고

            /*view = "user_profile_edit";*/
            view="user_mypage_update";
        }
        return view;
    }
    @PostMapping("/myprofile")
    public String myprofilePost(Model model, HttpServletRequest request) {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
//        String code = String.valueOf(session.getAttribute("session_id"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);//받아온 UserVo에서 닉네임만 string으로 넘김,[0]인덱스 한글자만 보여주려고


            /*view = "user_profile_edit";*/
            view="user_mypage_update";
        }
        return view;
    }

    // 회원정보 수정
    @ResponseBody
    @PutMapping("/myprofile/update")
    public String replyDelete(HttpServletRequest request, @RequestParam String nickname, @RequestParam String pw) throws Exception {
        System.out.println("controller start");
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        /*        String code = String.valueOf(session.getAttribute("session_code"));*/
        mypageService.updateUser(nickname, pw, id);
        session.setAttribute("session_nickname", nickname);   // 세션에 새로 전달받은 nickname 넣음
        return "redirect:/triplan/myprofile";
    }
    // 회원정보 수정
    /*@PutMapping("/myprofile/update")
    public String replyDelete(HttpServletRequest request, ) throws Exception {
        System.out.println("controller start");
        String view = "";
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("session_id");


        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else if (errors.hasErrors()) {
            model.addAttribute("userDto", userDto);
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);//받아온 UserVo에서 닉네임만 string으로 넘김,[0]인덱스 한글자만 보여주려고
            //유효성 통과 못한 필드와 메세지를 핸들링
            Map<String, String> validateResult = mypageService.validateHandling(errors);
            for (String key : validateResult.keySet()) {
                model.addAttribute(key, validateResult.get(key));
            }
            return "/myprofile";
            return "user_mypage_update";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);//받아온 UserVo에서 닉네임만 string으로 넘김,[0]인덱스 한글자만 보여주려고
            mypageService.updateUser(userDto);

            view = "user_profile_edit";
            view="user_mypage_update";
        }
        return view;

 *//*       if (errors.hasErrors()) {
            //비밀번호 수정 실패시 입력 데이터 값 유지
            model.addAttribute("userDto", userDto);
            //유효성 통과 못한 필드와 메세지를 핸들링
            Map<String, String> validateResult = mypageService.validateHandling(errors);
            for (String key : validateResult.keySet()) {
                model.addAttribute(key, validateResult.get(key));
            }
            *//**//**//**//*return "/myprofile";*//**//**//**//*
            return "user_mypage_update";
        }



        mypageService.updateUser(userDto);
        return "redirect:/mypage";*//**//*



        *//**//*mypageService.updateUser(nickname, pw, id);*//**//*
        *//**//*session.setAttribute("session_nickname", nickname);   // 세션에 새로 전달받은 nickname 넣음
        return "redirect:/triplan/myprofile";*//**//*
    }*//*

    *//*@PostMapping("/myprofile/update")
    public String checkPw(@RequestBody String pw, HttpServletRequest request) {
        String result = null;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserVo
    }*//*
    *//*@PostMapping("/myprofile/update")
    public String validCheck(@Valid UserDto userDto, Errors errors, Model model) {
        if(errors.hasErrors()) {
            //유효성 통과 못한 필드와 메세지를 핸들링
            Map<String, String> validateResult = mypageService.validateHandling(errors);
            for (String key : validateResult.keySet()) {
                model.addAttribute(key, validateResult.get(key));
            }
            return "/myprofile";
        }
        return "/main";
    }*//*
*/
    //여행 제목 수정
    @PutMapping("/mypage/update")
    public @ResponseBody Integer updateTitle(@RequestParam String title, @RequestParam Integer code) { //vo로 바꾸는게 편할듯;;
        try {
            String endcodeTitle = URLEncoder.encode(title,"utf-8");
        } catch(Exception e) {
            e.printStackTrace();
        }
        mypageService.updateTitle(title, code);
        return 1;
    }
    //나의 일정 삭제
    @ResponseBody
    @PostMapping("/mypage/delete")
    public String deletePlans(@RequestParam Integer code, @RequestParam String urlpathname){
        System.out.println(code);
        System.out.println(urlpathname);
        mypageService.deletePlans(code);//삭제테이블에 insert
        System.out.println(code);
        return "redirect:" + urlpathname;
    }

    //좋아요한 일정 삭제
    @ResponseBody
    @PostMapping("/mypage/like/delete")
    public String likeDelete(HttpServletRequest request, @RequestParam(value = "checkBoxArr[]") List<Integer> checkBoxArr) throws Exception {
        System.out.println("controller start");
        HttpSession session = request.getSession();
        String code = String.valueOf(session.getAttribute("session_code"));

        System.out.println(checkBoxArr);
        for(Integer plan_code : checkBoxArr){
            mypageService.deleteLike(code, plan_code);
        }
        return "redirect:/triplan/mypage/like";
    }
    
    // 댓글 삭제
    @ResponseBody
    @PostMapping("/mypage/reply/delete")
    public String replyDelete(HttpServletRequest request, @RequestParam(value = "checkBoxArr[]") List<Integer> checkBoxArr) throws Exception {
        System.out.println("controller start");
        HttpSession session = request.getSession();
        String code = String.valueOf(session.getAttribute("session_code"));

        System.out.println(checkBoxArr);
        for(Integer reply_code : checkBoxArr){
            mypageService.deleteReply(code, reply_code);
        }
        return "redirect:/triplan/mypage/reply";
    }

/*
    // 회원정보 수정
    @ResponseBody
    @PutMapping("/myprofile/update")
    public String replyDelete(HttpServletRequest request, @RequestParam String nickname, @RequestParam String pw) throws Exception {
        System.out.println("controller start");
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
*//*        String code = String.valueOf(session.getAttribute("session_code"));*//*
        mypageService.updateUser(nickname, pw, id);
        session.setAttribute("session_nickname", nickname);   // 세션에 새로 전달받은 nickname 넣음
        return "redirect:/triplan/myprofile";
    }*/



    //회원 탈퇴
/*    @GetMapping("/myprofile/drop")
    public @ResponseBody String dropUser(HttpServletRequest request, @RequestParam String name, @RequestParam String nickname, @RequestParam Integer user_code) {
        System.out.println("dropUser controller start");
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("session_code").getClass().getName());


        String id = (String)session.getAttribute("session_id");
*//*        String nickname = (String)session.getAttribute("session_nickname");*//*
        System.out.println(name);
        System.out.println(nickname);
        System.out.println(user_code);
        *//*Integer code = (Integer)session.getAttribute("session_code");*//*
*//*        String code = String.valueOf(session.getAttribute("session_code"));*//*
*//*        System.out.println(code);*//*
        *//*String name2 = String.valueOf(name);*//*
       *//* String code = String.valueOf(session.getAttribute("session_code"));*//*

        mypageService.userToDropTbl(id, name, nickname, user_code);
        return "redirect:/triplan/mypage";
    }*/
    @PostMapping("/myprofile/drop")
    public String dropUserPost(HttpServletRequest request, @RequestBody UserVo uservo) {
        System.out.println("dropUser controller start");
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("session_code").getClass().getName());

        String id = (String)session.getAttribute("session_id");
        String nickname = (String)session.getAttribute("session_nickname");
        String name = uservo.getName();
        System.out.println(name);
        /*String nickname = uservo.getNickname();*/
        System.out.println(nickname);
        Integer user_code = uservo.getUser_code();
        System.out.println(user_code);

        /*mypageService.userToDropTbl(id, endcodeName, endcodeNickname, user_code);*/
        UserVo dropuser = new UserVo(id, name, nickname, user_code);
        mypageService.userToDropTbl(dropuser);
        /*mypageService.userToDropTbl(uservo);*/
        return "redirect:/triplan/mypage";
    }

    // 동행자 검색
    @ResponseBody
    @GetMapping("/mypage/searchMate")
    public UserVo searchMate(@RequestParam String mateEmail) {
        System.out.println(mateEmail);
        return mypageService.searchMate(mateEmail);
    }
    //동행자 추가
    @PostMapping("/mypage/addMate")
    public String addMate(HttpServletRequest request, @RequestBody PlanVo planvo) {
        System.out.println("addMate controller start!");
        Integer plan_code = planvo.getCode();
        System.out.println(plan_code);
        Integer user_code = planvo.getUser_code();
        System.out.println(user_code);
        mypageService.addMate(plan_code, user_code);
        return "redirect:/triplan/mypage";
    }


    // 동행자 검색
   /* @GetMapping("/addMateForm")
    public String searchMate() {
        String view = "";
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("session_id");
        String code = String.valueOf(session.getAttribute("session_code"));

        if (id == null) {
            model.addAttribute("errCode", "2");
            view = "redirect:/triplan/loginform?errCode=2";
        } else {
            UserVo userProfile = mypageService.getMyProfile(id);
            Character nicknameFirst = userProfile.getNickname().charAt(0);
            model.addAttribute("userprofile", userProfile);
            model.addAttribute("firstletterNickname", nicknameFirst);

            Integer planCount = mypageService.getAllPlanCount(code);
            Integer replyCount = mypageService.getAllReplyCount(code);
            Integer likeCount = mypageService.getAllLikeCount(code);
            List<ReplyVo> replyList = mypageService.getAllList(code);
            model.addAttribute("plancount", planCount);
            model.addAttribute("replycount", replyCount);;
            model.addAttribute("likecount", likeCount);
            model.addAttribute("replies", replyList);
            view = "user_mypage_reply";
        }
        return view;
    }*/

}

/*----캐쉬 사용함..보통은--------------------------------각뷰페이지마다 같은 거를 모델로 넘겨줘야하는데{{}} 따로 분리를 할까 했더니 url도 같고....---*/
/*그부분만 파일로 따로 뺴고 각 뷰에서그부분 지우고 include{{>}}해준 상태로*/
/*    @PutMapping("/mypage/completedplans")
    public String updateTitle(@RequestBody PlanVo planvo) {
        String plan = planvo.getTitle();
    }
    */
//    @PostMapping("/mypage/plan/delete")
//    public String
