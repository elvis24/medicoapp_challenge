package com.papudev.medicoapp_challenge.impl;

import com.papudev.medicoapp_challenge.model.Medico;
import com.papudev.medicoapp_challenge.repository.IGenericRepository;
import com.papudev.medicoapp_challenge.service.ICRUD;

import java.util.List;
import java.util.Optional;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected  abstract IGenericRepository<T, ID> getRepo();

    @Override
    public T registrar(T obj) throws Exception {
        return getRepo().save(obj);
    }

    @Override
    public T modificar(T obj)  throws Exception{
        return getRepo().save(obj);
    }

    @Override
    public List<T> listar() throws Exception{
        return getRepo().findAll();
    }

    @Override
    public T listarPorId(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void eliminar(ID id) throws Exception{
        getRepo().deleteById(id);

    }

}
