package com.zenvia.test.model;

import java.util.ArrayList;
import java.util.List;

public class Msgs {
    private List<Msg> msgList;

    public List<Msg> getMsgList(){
        if(msgList == null) {
            msgList = new ArrayList<>();
        }
        return msgList;
    }
}
