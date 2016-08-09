package com.fovoy.daemon.controller;

import com.fovoy.daemon.common.APIResponse;
import com.fovoy.daemon.service.JournalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by zxz.zhang on 16/8/9.
 */
@Controller
@RequestMapping(value = "/journal")
public class JournalController {

    @Resource
    private JournalService journalService;


    private APIResponse<Boolean> test(){

        return APIResponse.returnSuccess(true);
    }

    private APIResponse<Boolean> save(){
//        journalService.save();
        return APIResponse.returnSuccess(true);
    }

    private APIResponse<Boolean> remove(){

        return APIResponse.returnSuccess(true);
    }


}
