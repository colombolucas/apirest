package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api") // URI Padrão
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")  //Buscar todos
    public List<Produto> listProduto(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")  //Buscar por ID
    public Produto listProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto") //Postar produto
    public Produto salvarProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produto") //Deletar produto
    public void deletarProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }


    @PutMapping("/produto") // atualizar produto
    public Produto atualizaProduto(@RequestBody Produto produto){
       return produtoRepository.save(produto);
    }
}
