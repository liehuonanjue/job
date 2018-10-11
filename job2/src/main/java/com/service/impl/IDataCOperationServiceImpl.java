package com.service.impl;

import com.dao.IDataCOperationMapper;
import com.dao.ISaleMapper;
import com.entity.Invitation;
import com.entity.ReplyDetail;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.IDataCOperationService;
import com.service.ISaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by FLC on 2018/8/24.
 */
@Service("iDataCOperationServiceImpl")
public class IDataCOperationServiceImpl implements IDataCOperationService {
    @Resource
    private IDataCOperationMapper iDataCOperationMapper;


    @Override
    public int AddAReply(ReplyDetail replyDetail) {
        return iDataCOperationMapper.AddAReply(replyDetail);
    }

    @Override
    public int DeletePosts(int uid) {
        return iDataCOperationMapper.DeletePosts(uid);
    }
}
