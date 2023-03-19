package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.dto.CategoriaDtoBody;
import com.dev.LojaVirtual.dto.CategoriaDtoPath;
import com.dev.LojaVirtual.entites.Categoria;
import com.dev.LojaVirtual.exceptions.EntityNotFound;
import com.dev.LojaVirtual.mapper.CategoriaMapper;
import com.dev.LojaVirtual.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaMapper categoriaMapper;

    @Transactional
    public Categoria save(CategoriaDtoBody categoriaDtoBody) {

        return categoriaRepository.save(categoriaMapper.convertDtoEmEntitySave(categoriaDtoBody));
    }


    public Object findById(Long id) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isEmpty()) {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("CATEGORIA NAO EXISTE");
        }

        return new CategoriaDtoPath(categoria.get());
    }

    @Transactional
    public Categoria update(CategoriaDtoBody newObj, Long id) {

        Categoria objPesquisado = (Categoria) this.findById(id);

        return categoriaMapper.convertDtoEmEntityUpdate(objPesquisado, newObj);
    }

    @Transactional
    public void delete(Long id) {

        Categoria categoria = (Categoria) this.findById(id);

        categoriaRepository.delete(categoria);
    }

    public CategoriaDtoPath findByNome(String nome) {

        Categoria categoria = categoriaRepository.findByNome(nome);

        if (categoria == null) throw new EntityNotFound("Categora Não Encontrada");

        return new CategoriaDtoPath(categoria);
    }

}