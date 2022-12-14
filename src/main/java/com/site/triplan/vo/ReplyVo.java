package com.site.triplan.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVo {
    String content; //reply.content
    String write_dt; //reply.write_dt
    String title; //plan.title
    String name; //area.name

    String code, user_code, nickname, plan_code, id;


    public ReplyVo(String content, String write_dt, String title, String name, String plan_code) {
        this.content = content;
        this.write_dt = write_dt;
        this.title = title;
        this.name = name;
        this.plan_code = plan_code;
    }
}
