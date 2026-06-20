package com.entrevista.attusDemo.core.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {
    private final CrudRepository<T, ID> repository;

    public CrudServiceImpl(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<T> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Resource not found with id: " + id);
        }
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
