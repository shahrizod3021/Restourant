package com.restorant.Restorant.Full.userFull;

import com.restorant.Restorant.pyload.ReqUser;
import com.restorant.Restorant.pyload.ResUser;
import com.restorant.Restorant.pyload.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface UsersFull {

    Result register(@RequestBody ReqUser reqUser);

    String getUser();

    List<ResUser> getUsersList();

}
