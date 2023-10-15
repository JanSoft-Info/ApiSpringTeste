package br.com.jansoftinfo.apiteste.adapter.utils;

public interface Constants {
    String VERSION = "Versão 1.0";
    String TITLE_API = "API SPRING TESTE";
    String TERMS_OF_SERVICE = "Termos de Serviço";
    String LICENSE = "Apache License Version 2.0";
    String EMAIL_DEV = "janilton.barbosa@gmail.com";
    String JANSOFT = "http://www.jansoftinfo.com.br";
    String DESCRIPTION = "Api de Testes for Spring Boot";
    String AUTHOR = "Janilton Barbosa | JanSoft Informática";
    String LICENSE_LINK = "https://www.apache.org/licesen.html";
    String HTTP_CONTENT_TYPE = "application/json";
    String GET_CUSTOMERS = "Endpoint que lista todos os clientes cadastrados";
    String GET_CUSTOMERS_ID = "Endpoint que consulta um cliente por id";
    String GET_CUSTOMERS_QUERY = "Endpoint que consulta clientes por tipo";
    String PUT_CUSTOMERS_ID = "Endpoint que altera dados do cliente por id";
    String POST_CUSTOMERS = "Endpoint que grava um novo cliente";
    String POST_SALES = "Endpoint que produz uma mensagem kafka com uma venda";
    String GET_SALES = "Endpoint que lista todos as vendas";
    String GET_SALES_RESUME = "Endpoint que lista todas vendas com dados resumidos";
    String GET_SALES_ID = "Endpoint que consulta uma venda por id";
    String GET_SALES_QUERY = "Endpoint que consulta uma venda por status";
    String GET_SALES_ID_CUSTOMER = "Endpoint que consulta vendas pelo id do cliente";
    String MESSAGE_CODE200 = "Requisição realizada com sucesso";
    String MESSAGE_CODE201 = "Criado com sucesso";
    String MESSAGE_CODE204 = "Sem conteúdo";
    String MESSAGE_CODE400 = "Recurso não encontrado";
    String MESSAGE_CODE401 = "Requisição não autorizada";
    String MESSAGE_CODE403 = "Requisição não permitida";
    String MESSAGE_CODE404 = "Requisição inválida";
    String MESSAGE_CODE500 = "Erro interno";

}