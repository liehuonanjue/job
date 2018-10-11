package com.service;

import com.entity.ReplyDetail;
import org.springframework.stereotype.Repository;

public interface IDataCOperationService {
    public int AddAReply(ReplyDetail replyDetail);

    public int DeletePosts(int uid);
}
