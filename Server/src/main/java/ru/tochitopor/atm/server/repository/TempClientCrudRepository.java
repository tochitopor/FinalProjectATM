package ru.tochitopor.atm.server.repository;

import ru.tochitopor.atm.server.entity.Score;
import ru.tochitopor.atm.server.entity.Client;

import java.util.*;

public class TempClientCrudRepository implements ClientCRUDRepository{

    private static List<Client> dataBase = new ArrayList<>();
    static{
        Score a1 = new Score();
        a1.setBalance(1000);
        a1.setId(101L);

        Score a2 = new Score();
        a2.setBalance(2000);
        a2.setId(102L);

        Score a3 = new Score();
        a3.setBalance(3000);
        a3.setId(103L);

        List<Score> set1 = new ArrayList<>();
        set1.add(a1);
        set1.add(a2);

        List<Score> set2 = new ArrayList<>();
        set1.add(a3);


        Client c1 = new Client();
        c1.setId(1L);
        c1.setPIN(1234);
        c1.setScores(set1);

        Client c2 = new Client();
        c1.setId(2L);
        c1.setPIN(5678);
        c1.setScores(set2);

        dataBase.add(c1);
        dataBase.add(c2);
    }

    @Override
    public <S extends Client> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Client> findById(Long aLong) {
        Optional<Client> optional = Optional.empty();
        for(Client c : dataBase){
            if(c.getId() == aLong){
                optional = Optional.of(c);
            }
        }
        return optional;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    @Override
    public Iterable<Client> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Client entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Client> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
