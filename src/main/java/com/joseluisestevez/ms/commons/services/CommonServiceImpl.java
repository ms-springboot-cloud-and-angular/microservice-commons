package com.joseluisestevez.ms.commons.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonServiceImpl<E, R extends PagingAndSortingRepository<E, Long>> implements CommonService<E> {

    @Autowired
    protected R repository;

    @Transactional(readOnly = true)
    @Override
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<E> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

}
