package com.restorant.Restorant.Full.userFull;

import com.restorant.Restorant.pyload.ReqUser;
import com.restorant.Restorant.pyload.ResUser;
import com.restorant.Restorant.pyload.Result;

import java.util.List;

public interface UsersFullService {

    Result addUser(ReqUser reqUser);

    List<ResUser> getUsersList();
}
