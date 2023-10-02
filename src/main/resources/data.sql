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
insert into venda (id_cliente_venda, valor_venda, data_hora_venda, status_venda) values (4, 50000.00, '2022-12-25 19:05:32', 'A');
insert into venda (id_cliente_venda, valor_venda, data_hora_venda, status_venda) values (5, 120000.00, '2022-07-12 10:25:53', 'A');
insert into venda (id_cliente_venda, valor_venda, data_hora_venda, status_venda) values (6, 85000.00, '2023-03-10 14:15:01', 'F');

/* POPULANDO DADOS DA TABELA DE TITULO */
insert into titulo (id_venda_titulo, id_cliente_titulo, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (1, 4, '2022-12-25 19:05:32', '2023-01-25', 25000.00, 'B' ,'L');
insert into titulo (id_venda_titulo, id_cliente_titulo, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (1, 4, '2022-12-25 19:05:32', '2023-02-25', 25000.00, 'B' ,'V');
insert into titulo (id_venda_titulo, id_cliente_titulo, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-08-12', 40000.00, 'C' ,'L');
insert into titulo (id_venda_titulo, id_cliente_titulo, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-09-12', 40000.00, 'C' ,'L');
insert into titulo (id_venda_titulo, id_cliente_titulo, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-10-12', 40000.00, 'C' ,'L');
insert into titulo (id_venda_titulo, id_cliente_titulo, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (2, 5, '2022-07-12 10:25:53', '2022-11-12', 40000.00, 'C' ,'V');
insert into titulo (id_venda_titulo, id_cliente_titulo, data_hora_titulo, data_vencimento_titulo, valor_titulo, tipo_titulo, status_titulo) values (3, 6, '2023-10-03 14:15:01', '2023-10-03', 85000.00, 'P' ,'L');