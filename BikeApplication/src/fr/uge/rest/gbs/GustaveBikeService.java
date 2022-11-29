package fr.uge.rest.gbs;

import fr.uge.rest.bike.IBike;

import java.rmi.RemoteException;
import java.util.*;

public class GustaveBikeService {
    private final List<IBike> bikes;
    private HashMap<Long, IBike> rentedAtleastOnce;
    private ArrayList<IBike> basket;

    public GustaveBikeService(IBike[] bikeService) throws RemoteException {
        this.bikes = Arrays.asList(bikeService);
        getRentedOnce(bikeService);
    }

    public void getRentedOnce(IBike[] bike) {
        for (IBike b : bike) {
            try {
                if (b.getTimesRented() > 0) {
                    rentedAtleastOnce.put(b.getId(), b);
                }
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Map.Entry[] getRentedOnce() {
        return rentedAtleastOnce.entrySet().toArray(new Map.Entry[0]);
    }

    public void setPriceOnIdBike(Long id, int price) {
        rentedAtleastOnce.forEach((k, v) -> {
            try {
                if (Objects.equals(k, id)) {
                    v.setPrice(price);
                }
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void addBasket(IBike bike) {
        basket.add(bike);
    }

    public void removeBasket(IBike bike) {
        basket.remove(bike);
    }

    public void boughtBasket() {
        basket.forEach(b -> {
            try {
                b.setAvailable(false);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
        basket.clear();
    }
}
