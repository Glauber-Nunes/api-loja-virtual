package com.dev.LojaVirtual.services;

import com.dev.LojaVirtual.entites.Pessoa;
import com.dev.LojaVirtual.exceptions.CodigoNotFound;
import com.dev.LojaVirtual.exceptions.EntityNotFound;
import com.dev.LojaVirtual.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecuperaSenhaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EmailService emailService;

    public String solicitarCodigoRecuperacaoSenha(String email) {

        Pessoa cliente = pessoaRepository.findByEmail(email);

        if (cliente == null) throw new EntityNotFound("Cliente Não Encontrado");

        cliente.setCodigoRecuperacaoSenha(this.geradorCodigo());
        cliente.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(cliente);
        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("nome", cliente.getNome());
        propriedades.put("mensagem", "SEU CODIGO PARA RECUPERAR SUA SENHA É: " + cliente.getCodigoRecuperacaoSenha());
        emailService.enviarEmailTemplate(cliente.getEmail(), "CODIGO PARA RECUPERAÇAO DE SENHA", propriedades);

        return "SEU CODIGO FOI ENVIADO PARA O SEU EMAIL: " + cliente.getEmail();//mostrado no postman


    }

    public String recuperarSenha(Pessoa pessoa) {

        Pessoa clienteBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());

        if (clienteBanco == null) throw new CodigoNotFound("Codigo ou Email invalido");

        Date diferenca = new Date(new Date().getTime() - clienteBanco.getDataEnvioCodigo().getTime());

        if (diferenca.getTime() / 1000 < 900) { // 15 minutos
            clienteBanco.setSenha(pessoa.getSenha());
            clienteBanco.setCodigoRecuperacaoSenha(null);
            clienteBanco.setDataEnvioCodigo(null);
            pessoaRepository.saveAndFlush(clienteBanco);

            Map<String, Object> prop = new HashMap<>();
            prop.put("nome", clienteBanco.getNome());
            prop.put("mensagem", "Sua Nova Senha É " + clienteBanco.getSenha());
            emailService.enviarEmailTemplate(pessoa.getEmail(), "NOVA SENHA", prop);

            return "SENHA ALTERADA COM SUCESSO";
        } else {
            clienteBanco.setCodigoRecuperacaoSenha(null);
            pessoaRepository.saveAndFlush(clienteBanco);
            return "TEMPO DO CODIGO, EXPIROU SOLICITE UM NOVO CODIGO";
        }
    }

    //GERA UM CODIGO AUTOMATICO COM ATE 8 CACATERES CONCATENANDO COM O ID
    private String geradorCodigo() {
        String CHARACTERS = "0123456789";
        int CODE_LENGTH = 6;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
