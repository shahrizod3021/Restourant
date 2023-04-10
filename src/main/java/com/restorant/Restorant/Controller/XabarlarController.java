package com.restorant.Restorant.Controller;

import com.restorant.Restorant.Full.XabarlarFull.XabarlarFullControl;
import com.restorant.Restorant.Service.XabarlarService;
import com.restorant.Restorant.pyload.ReqXabar;
import com.restorant.Restorant.pyload.ResXabar;
import com.restorant.Restorant.pyload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("dashboard/xabarlar")
public class XabarlarController implements XabarlarFullControl {

    @Autowired
    XabarlarService xabarlarService;

    @Override
    @GetMapping("/0009792:2006:30:11/shahrizod")
    public String xabarlar() {
        return "Xabarlar";
    }

    @Override
    @GetMapping("/list")
    @ResponseBody
    public List<ResXabar> getXabarlarList() {
        return xabarlarService.getXabarlarList();
    }

    @Override
    @PostMapping("/send")
    @ResponseBody
    public Result requstXabar(@RequestBody ReqXabar reqXabar) {
        return xabarlarService.requstXabar(reqXabar);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteXabar(@PathVariable Integer id) {
        return xabarlarService.deleteXabar(id);
    }

    @Override
    @GetMapping("/0009792:2006:30:11/shahrizod/{name}")
    @ResponseBody
    public List<ResXabar> searchingSystem(@PathVariable String name) {
        return xabarlarService.searchingSystem(name);
    }

}
