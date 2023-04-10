package com.restorant.Restorant.Service;

import com.restorant.Restorant.Entity.Xabarlar;
import com.restorant.Restorant.Full.XabarlarFull.XabarlarFullControl;
import com.restorant.Restorant.Repository.XabarlarRepo;
import com.restorant.Restorant.pyload.ReqXabar;
import com.restorant.Restorant.pyload.ResProduct;
import com.restorant.Restorant.pyload.ResXabar;
import com.restorant.Restorant.pyload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class XabarlarService implements XabarlarFullControl {
    @Autowired
    XabarlarRepo xabarlarRepo;

    @Override
    public String xabarlar() {
        return null;
    }

    @Override
    public List<ResXabar> getXabarlarList() {
        List<ResXabar> resXabars = new ArrayList<>();
        for (Xabarlar xabarlar : xabarlarRepo.findAll()) {
            ResXabar resXabar = new ResXabar(
                    xabarlar.getId(),
                    xabarlar.getName(),
                    xabarlar.getMessage(),
                    xabarlar.getPhoneNumbers()
            );
            resXabars.add(resXabar);
        }
        return resXabars;
    }

    @Override
    public Result requstXabar(ReqXabar reqXabar) {
        if (reqXabar.getMessage().trim().length() != 0) {
            if (reqXabar.getPhoneNumbers().trim().length() != 0) {
                if (reqXabar.getPhoneNumbers().trim().length() == 9) {
                    Xabarlar xabarlar = new Xabarlar(reqXabar.getName(), reqXabar.getMessage(), reqXabar.getPhoneNumbers());
                    xabarlarRepo.save(xabarlar);
                    return new Result("Xabar yuborildi", true);
                }
                return new Result("Telefon raqam uzunligi 9taga teng bo'lisi shart", false);
            }
            return new Result("Telefon raqamingizni kiritmadingiz", true);
        }
        return new Result("Xabar qoldirmadingiz", true);
    }

    @Override
    public Result deleteXabar(Integer id) {
        Optional<Xabarlar> byId = xabarlarRepo.findById(id);
        if (byId.isPresent()) {
            Xabarlar xabarlar = byId.get();
            xabarlarRepo.delete(xabarlar);
            return new Result("Xabar o'chirildi", true);
        }
        return new Result("bunday xabar mavjud emas", false);
    }

    @Override
    public List<ResXabar> searchingSystem(String name) {
        List<ResXabar> resXabars = new ArrayList<>();
        for (Xabarlar xabarlar : xabarlarRepo.findAll()) {
            if (xabarlar.getName().equals(name)) {
                ResXabar resXabar = new ResXabar(
                        xabarlar.getId(),
                        xabarlar.getName(),
                        xabarlar.getMessage(),
                        xabarlar.getPhoneNumbers()
                );
                resXabars.add(resXabar);
            }
        }
        return resXabars;
    }
}
