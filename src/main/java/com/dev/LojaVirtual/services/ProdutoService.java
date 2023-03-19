package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.dto.ProdutoDtoBody;
import com.dev.LojaVirtual.entites.Categoria;
import com.dev.LojaVirtual.entites.Marca;
import com.dev.LojaVirtual.entites.Produto;
import com.dev.LojaVirtual.exceptions.EntityNotFound;
import com.dev.LojaVirtual.mapper.MarcaMapper;
import com.dev.LojaVirtual.mapper.ProdutoMapper;
import com.dev.LojaVirtual.repository.CategoriaRepository;
import com.dev.LojaVirtual.repository.MarcaRepository;
import com.dev.LojaVirtual.repository.PessoaRepository;
import com.dev.LojaVirtual.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private ProdutoMapper produtoMapper;


    @Transactional
    public Produto save(Long id_cat, Long id_marca, ProdutoDtoBody produtoDtoBody) {

        Optional<Categoria> categoria = categoriaRepository.findById(id_cat);
        Optional<Marca> marca = marcaRepository.findById(id_marca);

        return produtoRepository.save(produtoMapper.convertDtoEmEntidadeSave(categoria.get(), marca.get(), produtoDtoBody));

    }

    public Produto findById(Long id) {

       Produto produto = produtoRepository.findById(id).get();

        if(produto==null) throw new EntityNotFound("Produto Não Encontrado");

        return produto;

    }

    public void delete(Long id_produto,Produto prod) {

        Produto produto = produtoRepository.findById(id_produto).get();

        produtoRepository.delete(produto);
    }
}
