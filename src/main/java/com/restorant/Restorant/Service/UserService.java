package com.restorant.Restorant.Service;

import com.restorant.Restorant.Entity.BuyProduct;
import com.restorant.Restorant.Entity.Product;
import com.restorant.Restorant.Entity.User;
import com.restorant.Restorant.Full.userFull.UsersFullService;
import com.restorant.Restorant.Repository.BuyProductRepo;
import com.restorant.Restorant.Repository.ProductRepository;
import com.restorant.Restorant.Repository.UsersRepo;
import com.restorant.Restorant.pyload.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class UserService implements UsersFullService {
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    BuyProductRepo buyProductRepo;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Result addUser(ReqUser reqUser) {
        if (reqUser.getPhoneNumber().trim().length() != 0) {
            if (!usersRepo.existsUserByPhoneNumber(reqUser.getPhoneNumber())) {
                User user = new User(reqUser.getPhoneNumber());
                usersRepo.save(user);
                return new Result("saqlandi oka", true);
            }
            return new Result("bunday user mavjud", false);
        }
        return new Result("Telefon raqam bo'sh", false);
    }

    @Override
    public List<ResUser> getUsersList() {
        List<ResUser> resUsers = new ArrayList<>();
        for (User user : usersRepo.findAll()) {
            ResUser resUser = new ResUser(
                    user.getId(),
                    user.getPhoneNumber(),
                    user.getCreateAt(),
                    user.getUpdateAt()
            );
            resUsers.add(resUser);
        }

        return resUsers;
    }

    public Result buyProduct(Integer id, ReqBuy reqBuy) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()) {
            if (usersRepo.existsUserByPhoneNumber(reqBuy.getPhoneNumber())) {
                User byPhoneNumber = usersRepo.findByPhoneNumber(reqBuy.getPhoneNumber());
                Product product = byId.get();
                double v = product.getPrice() * reqBuy.getNechta();
                BuyProduct buyProduct = new BuyProduct(byPhoneNumber, product, reqBuy.getNechta(), v);
                buyProductRepo.save(buyProduct);
                return new Result("zakaz berildi", true);
            }else {
                User user = new User(reqBuy.getPhoneNumber());
                usersRepo.save(user);
                Product product = byId.get();
                double v = product.getPrice() * reqBuy.getNechta();
                BuyProduct buyProduct = new BuyProduct(user, product, reqBuy.getNechta(), v);
                buyProductRepo.save(buyProduct);
                return new Result("zakaz berildi", true);
            }
        }
        return new Result("bunday product topilmadi", true);
    }

    public List<ResBuy> getZakaz(){
        List<ResBuy> resBuys = new ArrayList<>();
        for (BuyProduct buyProduct : buyProductRepo.findAll()) {
                ResBuy resBuy = new ResBuy(
                    buyProduct.getUser(),
                    buyProduct.getProduct(),
                    buyProduct.getNechta(),
                    buyProduct.getPrice(),
                    buyProduct.getZakazVaqti()
            );
            resBuys.add(resBuy);
        }
        return resBuys;
    }
}
