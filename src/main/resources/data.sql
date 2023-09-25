/* POPULANDO DADOS DA TABELA DE CLIENTES */
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('52571029000127', 'Mercado Livre', 'JURIDICA');
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('80730785000197', 'Lojas Americanas', 'JURIDICA');
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('60018943000173', 'Magazine Luiza', 'JURIDICA');
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('44692576480', 'Maria José da Silva', 'FISICA');
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('46887438828', 'Heitor Lopes Aguiar', 'FISICA');
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('96945666492', 'Alice Souza Santos', 'FISICA');
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('34632867934', 'José Ramon Freitas', 'FISICA');
insert into cliente (cpf_cnpj, nome_cliente, tipo_cliente) values ('09878769453', 'Sofia Sales Amarantes', 'FISICA');

/* POPULANDO DADOS DA TABELA DE OPERAÇÕES */
insert into operacao (id_cliente, valor_operacao, data_hora_operacao, status_operacao) values (4, 50000.00, '2022-12-25 19:05:32', 'ABERTA');
insert into operacao (id_cliente, valor_operacao, data_hora_operacao, status_operacao) values (5, 120000.00, '2022-07-12 10:25:53', 'ABERTA');
insert into operacao (id_cliente, valor_operacao, data_hora_operacao, status_operacao) values (6, 85000.00, '2023-03-10 14:15:01', 'FECHADA');

/* POPULANDO DADOS DA TABELA DE RECEBÍVEIS */
insert into recebivel (id_operacao, id_cliente, data_hora_recebivel, data_vencimento_recebivel, valor_operacao, tipo_recebivel, status_recebivel) values (1, 4, '2022-12-25 19:05:32', '2023-01-25', 25000.00, 'BOLETO' ,'LIQUIDADO');
insert into recebivel (id_operacao, id_cliente, data_hora_recebivel, data_vencimento_recebivel, valor_operacao, tipo_recebivel, status_recebivel) values (1, 4, '2022-12-25 19:05:32', '2023-02-25', 25000.00, 'BOLETO' ,'VENCIDO');
insert into recebivel (id_operacao, id_cliente, data_hora_recebivel, data_vencimento_recebivel, valor_operacao, tipo_recebivel, status_recebivel) values (2, 5, '2022-07-12 10:25:53', '2022-08-12', 40000.00, 'CARTAO' ,'LIQUIDADO');
insert into recebivel (id_operacao, id_cliente, data_hora_recebivel, data_vencimento_recebivel, valor_operacao, tipo_recebivel, status_recebivel) values (2, 5, '2022-07-12 10:25:53', '2022-09-12', 40000.00, 'CARTAO' ,'LIQUIDADO');
insert into recebivel (id_operacao, id_cliente, data_hora_recebivel, data_vencimento_recebivel, valor_operacao, tipo_recebivel, status_recebivel) values (2, 5, '2022-07-12 10:25:53', '2022-10-12', 40000.00, 'CARTAO' ,'LIQUIDADO');
insert into recebivel (id_operacao, id_cliente, data_hora_recebivel, data_vencimento_recebivel, valor_operacao, tipo_recebivel, status_recebivel) values (2, 5, '2022-07-12 10:25:53', '2022-11-12', 40000.00, 'CARTAO' ,'VENCIDO');
insert into recebivel (id_operacao, id_cliente, data_hora_recebivel, data_vencimento_recebivel, valor_operacao, tipo_recebivel, status_recebivel) values (3, 6, '2023-10-03 14:15:01', '2023-10-03', 85000.00, 'PIX' ,'LIQUIDADO');