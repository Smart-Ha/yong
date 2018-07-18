package com.wangy.service;

import com.wangy.entity.UserOnline;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

public interface IUserOnlineService {
    Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, PageRequest pageRequest);

    /**
     * 批量下线
     * @param needOfflineIdList
     */
    void batchOffline(List<String> needOfflineIdList);

    UserOnline findOne(String s);

    /**
     * 同步用户上线
     * @param userOnline
     */
    void online(UserOnline userOnline);

    /**
     * 同步用户下线
     * @param s
     */
    void offline(String s);
}
