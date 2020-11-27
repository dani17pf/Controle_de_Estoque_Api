
INSERT INTO CategoriaDTO(nome, descricao, codigo) VALUES('Teclado','Instrumento musical','222444');
INSERT INTO CategoriaDTO(nome, descricao, codigo) VALUES('Bateria','Instrumento musical','1113344');
INSERT INTO CategoriaDTO(nome, descricao, codigo) VALUES('Violao','Instrumento musical','222');
INSERT INTO CategoriaDTO(nome, descricao, codigo) VALUES('Flauta','Instrumento musical','2444');

INSERT INTO ProdutoDTO(nome, codigo, preco_unitario, quantidade, descricao, categoria_id) VALUES('daniel','122333', 100, 20,'Musicas', 1);
INSERT INTO ProdutoDTO(nome, codigo, preco_unitario, quantidade, descricao, categoria_id) VALUES('maria','321', 400, 10,'Musicas', 2);
INSERT INTO ProdutoDTO(nome, codigo, preco_unitario, quantidade, descricao, categoria_id) VALUES('pedro','567', 500, 70,'Musicas',3);
INSERT INTO ProdutoDTO(nome, codigo, preco_unitario, quantidade, descricao, categoria_id) VALUES('joao','53', 900, 80,'Musicas',4);

INSERT INTO ClienteDTO(nome, cpf, endereco, cidade) VALUES('Paula', '035950978509', 'AV. Brasil', 'Passo Fundo');
INSERT INTO ClienteDTO(nome, cpf, endereco, cidade) VALUES('Pedro', '111222333445', 'Rua X', 'Marau');
INSERT INTO ClienteDTO(nome, cpf, endereco, cidade) VALUES('Mario', '987654322221', 'Rua Y', 'Carazinho');

INSERT INTO LojaDTO(nome, endereco, cidade, cnpj) VALUES('BUFFET RIEGEL', 'Rua Batista peira', 'Passo Fundo', '07.890.158/0001-23');
INSERT INTO LojaDTO(nome, endereco, cidade, cnpj) VALUES('PANIFICADORA', 'Rua madeira', 'Passo Fundo', '45.170.149/0001-57');
INSERT INTO LojaDTO(nome, endereco, cidade, cnpj) VALUES('PADARIA', 'Rua pedrita', 'Passo Fundo', '74.152.114/0001-93');

INSERT INTO VendedorDTO(nome, salario, comissao, loja_id) VALUES('Ana', '2.500', '1', 1);
INSERT INTO VendedorDTO(nome, salario, comissao, loja_id) VALUES('Maria', '1.500', '1', 2);

INSERT INTO FornecedorDTO(nome, endereco) VALUES('Carlos','Rua Teixeira');
INSERT INTO FornecedorDTO(nome, endereco) VALUES('Uriel','Rua Soares');


--INSERT INTO PeditoFornecedorDTO(valorTotal, dataPedido, loja_id, Fornecedor_id) VALUES('3000', '2020-11-24', 1, 1);

INSERT INTO PedidoF_DTO(valor_total, data_pedido, loja_id, fornecedor_id) VALUES(200,'2020-11-24',1,1);
INSERT INTO PedidoF_DTO(valor_total, data_pedido, loja_id, fornecedor_id) VALUES(400,'2020-11-25',1,2);

INSERT INTO PEDIDO_FORNECEDOR_PRODUTO(pedido_id, produto_id) VALUES(1, 1);
INSERT INTO PEDIDO_FORNECEDOR_PRODUTO(pedido_id, produto_id) VALUES(1, 2);

INSERT INTO PEDIDO_VENDADTO(data_pedido, valor_total, cliente_id, vendedor_id) VALUES('2020-11-25', 400, 1, 1);
INSERT INTO PEDIDO_VENDADTO(data_pedido, valor_total, cliente_id, vendedor_id) VALUES('2020-11-26', 800, 1, 2);

INSERT INTO PEDIDO_VENDA_PRODUTO(pedido_id, produto_id) VALUES(1, 1);
INSERT INTO PEDIDO_VENDA_PRODUTO(pedido_id, produto_id) VALUES(1, 2);













