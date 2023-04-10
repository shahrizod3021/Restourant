package com.restorant.Restorant.Full.XabarlarFull;

import com.restorant.Restorant.pyload.ReqXabar;
import com.restorant.Restorant.pyload.ResXabar;
import com.restorant.Restorant.pyload.Result;

import java.util.List;

public interface XabarlarFullControl {

    String xabarlar();

    List<ResXabar> getXabarlarList();

    Result requstXabar(ReqXabar reqXabar);

    Result deleteXabar(Integer id);

     List<ResXabar> searchingSystem(String name);

}
