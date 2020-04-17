package com.zenvia.test.dao;


import com.zenvia.test.model.Msg;
import com.zenvia.test.model.Msgs;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class MsgDAO {
    private static Msgs list = new Msgs();

    static {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        list.getMsgList().add(new Msg(1,"Lorem Ipsum is simply dummy text of the printing and typesetting industry.","brazil"));
        list.getMsgList().add(new Msg(2, "t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout","Autralia"));
        list.getMsgList().add(new Msg(3, "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old","Argentina"));
    }

    public Msgs getAllMsgs() {
        return list;
    }

    public void addMsg(Msg msg) {
        list.getMsgList().add(msg);
    }
}
