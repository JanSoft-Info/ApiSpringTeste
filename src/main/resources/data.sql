/* POPULANDO DADOS DA TABELA DE CLIENTE */
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('52571029000127', 'Mercado Livre', 'J');
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('80730785000197', 'Lojas Americanas', 'J');
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('60018943000173', 'Magazine Luiza', 'J');
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('44692576480', 'Maria José da Silva', 'F');
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('46887438828', 'Heitor Lopes Aguiar', 'F');
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('96945666492', 'Alice Souza Santos', 'F');
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('34632867934', 'José Ramon Freitas', 'F');
insert into cliente (cpf_cnpj_cliente, nome_cliente, tipo_cliente) values ('09878769453', 'Sofia Sales Amarantes', 'F');

/* POPULANDO DADOS DA TABELA DE VENDA */
insert into venda (id_cliente, valor_venda, data_hora_venda, status_venda) values (4, 67500.00, '2022-12-25 19:05:32', 'A');
insert into venda (id_cliente, valor_venda, data_hora_venda, status_venda) values (5, 124000.00, '2022-07-12 10:25:53', 'A');
insert into venda (id_cliente, valor_venda, data_hora_venda, status_venda) values (6, 87500.00, '2023-03-10 14:15:01', 'F');

/* POPULANDO DADOS DA TABELA DE TITULO */
insert into titulo (id_venda, id_cliente, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (1, 4, '2022-12-25 19:05:32', '2023-01-25', 33750.00, 'B' ,'L');
insert into titulo (id_venda, id_cliente, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (1, 4, '2022-12-25 19:05:32', '2023-02-25', 33750.00, 'B' ,'V');
insert into titulo (id_venda, id_cliente, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-08-12', 31000.00, 'C' ,'L');
insert into titulo (id_venda, id_cliente, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-09-12', 31000.00, 'C' ,'L');
insert into titulo (id_venda, id_cliente, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-10-12', 31000.00, 'C' ,'L');
insert into titulo (id_venda, id_cliente, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-11-12', 31000.00, 'C' ,'V');
insert into titulo (id_venda, id_cliente, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (3, 6, '2023-10-03 14:15:01', '2023-10-03', 87500.00, 'P' ,'L');

/* POPULANDO DADOS DA TABELA DE PRODUTO */
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('TABLET GALAXY 8"', 'UN', 2500.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('SMART PHONE SAMSUNG S20', 'UN', 5000.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('IPHONE 10X', 'UN', 6500.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('MOTOCLICLETA HONDA CG150', 'UN', 25000.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('AIR FRYER', 'UN', 700.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('SMART WATCH SAMSUNG', 'UN', 12000.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('SMART TV LG 32"', 'UN', 4000.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('MOTOCLICLETA HONDA POP 110I', 'UN', 12500.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('NOTEBOOK LENOVO 3I', 'UN', 3500.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('SMART PHONE MOTOROLA G4', 'UN', 1500.00);
insert into produto (descricao_produto, unidade_produto, valor_produto) values ('NOTEBOOK DELL 15"', 'UN', 8000.00);

/* POPULANDO DADOS DA TABELA DE ITENS VENDIDOS */
insert into item (id_venda, id_produto, quantidade) values (1, 1, 5);
insert into item (id_venda, id_produto, quantidade) values (1, 2, 3);
insert into item (id_venda, id_produto, quantidade) values (1, 7, 6);
insert into item (id_venda, id_produto, quantidade) values (1, 11, 2);
insert into item (id_venda, id_produto, quantidade) values (2, 4, 4);
insert into item (id_venda, id_produto, quantidade) values (2, 6, 2);
insert into item (id_venda, id_produto, quantidade) values (3, 8, 5);
insert into item (id_venda, id_produto, quantidade) values (3, 4, 1);