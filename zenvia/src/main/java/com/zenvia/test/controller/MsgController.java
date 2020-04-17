package com.zenvia.test.controller;

import com.zenvia.test.dao.MsgDAO;
import com.zenvia.test.exception.MissingHeaderException;
import com.zenvia.test.model.Msg;
import com.zenvia.test.model.Msgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@RestController
@RequestMapping(path = "/msg")
public class MsgController  {

    @Autowired
    private MsgDAO dao;

    @GetMapping(path="/list", produces = "application/json")
    public Msgs getMsgs(){
        return dao.getAllMsgs();
    }


    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public void addMsg(
            @RequestHeader(name = "token", required = true) String headerPersist,
            @RequestBody List<Msg> msg)
            throws Exception {
                //Generate resource id
                AtomicReference<Integer> id = new AtomicReference<>(dao.getAllMsgs().getMsgList().size() + 1);

                msg.forEach(destination -> {
                    //add msg
                    try {
                        validate(headerPersist, destination);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    destination.setId(id.get());
                    dao.addMsg(destination);

                    //Create resource location
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(destination.getId())
                            .toUri();
                    ResponseEntity.created(location).build();
                    id.getAndSet(id.get() + 1);
            });

    }

    private void validate(@RequestHeader(name = "token", required = true) String headerPersist, @RequestBody Msg msg) throws Exception {
        if(headerPersist.isEmpty()) {
            throw new MissingHeaderException("token is required");
        }
        if(null == msg.getMessageBody() || msg.getMessageBody().isEmpty()) {
            throw new Exception("body is required");
        }
    }



}
