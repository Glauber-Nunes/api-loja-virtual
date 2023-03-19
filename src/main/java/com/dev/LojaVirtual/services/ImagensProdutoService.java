package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.entites.ImagensProduto;
import com.dev.LojaVirtual.entites.Produto;
import com.dev.LojaVirtual.repository.ImagensRepository;
import com.dev.LojaVirtual.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;

@Service
public class ImagensProdutoService {

    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ImagensRepository imagensRepository;

    @Transactional
    public ImagensProduto inserir(Long id_produto, MultipartFile file) {

        Produto produto = produtoService.findById(id_produto);

        ImagensProduto imagensProduto = new ImagensProduto();
        imagensProduto.setProduto(produto);
        imagensProduto.setDataCriacao(Instant.now());

        try {
            if (!file.isEmpty()) { //VERIFICA SE O ARQUIVO NAO ESTA VAZIO
                byte[] bytes = file.getBytes();  //Retorna o conteúdo do arquivo como uma matriz de bytes.
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths.get("c:/imagensProjetoJava/" + nomeImagem);
                Files.write(caminho, bytes);
                imagensProduto.setNomeUrl(nomeImagem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return imagensRepository.save(imagensProduto);

    }
}
