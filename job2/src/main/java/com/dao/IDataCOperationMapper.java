package com.dao;

import com.entity.ReplyDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataCOperationMapper {
    public int AddAReply(ReplyDetail replyDetail);

    public int DeletePosts(int uid);
}
