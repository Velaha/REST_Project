package fr.uge.rest.webservice.shop;


import fr.uge.rest.serviceweb.banque.Banque;
import fr.uge.rest.serviceweb.banque.BanqueServiceLocator;
import fr.uge.rest.serviceweb.shop.Shop;
import fr.uge.rest.serviceweb.shop.ShopServiceLocator;
import org.springframework.context.annotation.Bean;

import javax.xml.rpc.ServiceException;

public class ShopClient  {
    @Bean
    public Shop getShop() throws ServiceException {
        return new ShopServiceLocator().getShop();
    }

    @Bean
    public Banque getBanque() throws ServiceException {
        return new BanqueServiceLocator().getBanque();
    }
}
