package com.sinothk.user.service;

import com.sinothk.base.entity.PageData;
import com.sinothk.base.entity.ResultData;
import com.sinothk.user.domain.FriendEntity;
import com.sinothk.user.domain.UserEntity;

import java.util.ArrayList;

public interface FriendService {

    ResultData<PageData<ArrayList<FriendEntity>>> getFriendsList(String username, int pageNum);
}
