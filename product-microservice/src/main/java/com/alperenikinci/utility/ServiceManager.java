package com.alperenikinci.utility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @param <T>  -> Bu sınıfı miras almak isteyen bir servis hangi entity e
 *           hizmet ediyor ise onu Type olarak verecek.
 * @param <ID> -> Bu sınıfı miras alan servisin kullanmakta olduğu id tipini
 *            belirlemesi gerekir, Long,String,Integer...
 */

public class ServiceManager<T extends BaseEntity, ID> implements IService<T,ID>{
    /**
     * Tüm Servisler için ortak bir kullanım sunacak ise, burada repository
     * üzerinden işlem yapabiliyor olmalı.
     * @param t
     * @return
     */

    private final JpaRepository<T,ID> repository;
    public ServiceManager(JpaRepository<T,ID> repository){
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        t.setCreateDate(System.currentTimeMillis());
        t.setUpdateDate(System.currentTimeMillis());
        t.setActive(true);
        return repository.save(t);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> t) {
        t.forEach(p -> {
            p.setActive(true);
            p.setUpdateDate(System.currentTimeMillis());
            p.setCreateDate(System.currentTimeMillis());
        });
        return repository.saveAll(t);
    }

    @Override
    public T update(T t) {
        t.setUpdateDate(System.currentTimeMillis());
        return repository.save(t);
    }

    @Override
    public void delete(T t) {

        t.setActive(false);
        repository.save(t);
    }

    @Override
    public void deleteById(ID id) {
        Optional<T> t = repository.findById(id);
        if(t.isPresent()){
            t.get().setActive(false);
            repository.save(t.get());
        }

    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAllActive(){
        /**
         * Eğer veritabanında hiç kayıt yok ise ya da, genellikle bigData, MongoDB gibi db lerde
         * mevcut olmayan alanlarda (Referenced DataType'larda) filtreleme yapıldığında NullPointerException fırlatır.
         * Bunun önüne geçmek için en genel tanımı ile ilgili kaydın null olup olmadığına bakılır.
         */

        return repository.findAll().stream()
                //.filter(x -> x.isActive()!=null)
                .filter( x -> x.isActive()
        ).collect(Collectors.toList());
    }
}
