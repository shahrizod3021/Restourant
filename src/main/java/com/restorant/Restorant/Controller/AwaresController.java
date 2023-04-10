package com.restorant.Restorant.Controller;

import com.restorant.Restorant.Service.AwaresService;
import com.restorant.Restorant.pyload.ReqAware;
import com.restorant.Restorant.pyload.ReqProduct;
import com.restorant.Restorant.pyload.ResAware;
import com.restorant.Restorant.pyload.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("dashboard/aware")
public class AwaresController {

    @Autowired
    AwaresService awareService;

    @GetMapping("awareList/0009792:2006:30:11/shahrizod")
    private String getAware() {
        return "Aware";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<ResAware> getAwareList() {
        return awareService.getAwareList();
    }

    @PostMapping
    @ResponseBody
    public Result addAware(@RequestBody ReqAware reqAware) {
        return awareService.addAware(reqAware);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public Result deleteAware(@PathVariable Integer id) {
        return awareService.deleteAware(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public Result editAware(@PathVariable Integer id, @RequestBody ReqAware reqAware){
        return awareService.editAware(id, reqAware);
    }
}
