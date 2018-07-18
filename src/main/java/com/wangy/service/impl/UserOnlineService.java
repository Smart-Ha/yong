package com.wangy.service.impl;

import com.wangy.entity.UserOnline;
import com.wangy.service.IUserOnlineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserOnlineService implements IUserOnlineService {
    @Override
    public Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, PageRequest pageRequest) {
        return null;
    }

    @Override
    public void batchOffline(List<String> needOfflineIdList) {

    }

    @Override
    public UserOnline findOne(String s) {
        return null;
    }

    @Override
    public void online(UserOnline userOnline) {

    }

    @Override
    public void offline(String s) {

    }
}
