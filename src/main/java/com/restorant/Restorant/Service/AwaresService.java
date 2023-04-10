package com.restorant.Restorant.Service;

import com.restorant.Restorant.Entity.Aware;
import com.restorant.Restorant.Repository.AwaresRepository;
import com.restorant.Restorant.pyload.ReqAware;
import com.restorant.Restorant.pyload.ReqProduct;
import com.restorant.Restorant.pyload.ResAware;
import com.restorant.Restorant.pyload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class AwaresService {

    @Autowired
    AwaresRepository awareRepository;

    public List<ResAware> getAwareList() {
        List<ResAware> resAwares = new ArrayList<>();
        for (Aware aware : awareRepository.findAll()) {
            ResAware resAware = new ResAware(
                    aware.getId(),
                    aware.getName(),
                    aware.getLink(),
                    aware.getColor()
            );
            resAwares.add(resAware);
        }
        return resAwares;
    }

    public Result addAware(ReqAware reqAware) {
        if (reqAware.getName().trim().length() != 0) {
            if (reqAware.getLink().trim().length() != 0) {
                if (reqAware.getColor().trim().length() != 0) {
                    if (!awareRepository.existsAwareByName(reqAware.getName())) {
                        Aware aware = new Aware(reqAware.getName(), reqAware.getLink(), reqAware.getColor());
                        awareRepository.save(aware);
                        return new Result("Aware saqlandi", true);
                    }
                    return new Result("bunday aware bizda mavjud", false);
                }
                return new Result("rangini kritimadingiz", false);
            }
            return new Result("linkini kiritmadingiz", false);
        }
        return new Result("nomini kiritimadingiz", false);
    }

    public Result deleteAware(Integer id){
        Optional<Aware> byId = awareRepository.findById(id);
        if (byId.isPresent()){
            Aware aware = byId.get();
            awareRepository.delete(aware);
            return new Result("Aware uchirildi", true);
        }
        return new Result("Bunday Aware topilmadi uzur", true);
    }

    public Result editAware(Integer id, ReqAware reqAware){
        Optional<Aware> byId = awareRepository.findById(id);
        if (byId.isPresent()){
            Aware aware = byId.get();
            aware.setName(reqAware.getName());
            aware.setLink(reqAware.getLink());
            aware.setColor(reqAware.getColor());
            awareRepository.save(aware);
            return new Result("aware taxrirlandi", true);
        }
        return new Result("aware taxrirlanmadi", true);
    }
}
