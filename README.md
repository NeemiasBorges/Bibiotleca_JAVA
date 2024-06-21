# Sistema de Gerenciamento de Estoque

Este repositório contém a documentação do Software de Gerenciamento de Estoque, uma aplicação desenvolvida em Java para facilitar o controle e a gestão de estoques de produtos em empresas.

## Funcionalidades

### Cadastro de Produtos
- Registro de novos produtos com nome, descrição, preço e quantidade.
- Edição e exclusão de produtos existentes.

### Cadastro de Fornecedores
- Adição e gerenciamento de informações de fornecedores como nome, telefone e e-mail.

### Cadastro de Depósitos
- Criação e gestão de depósitos com nome e localização.

### Login
- Autenticação de usuários para acesso ao sistema.

### Recuperação de Senha
- Funcionalidade para recuperar a senha através do portal.

### Registro de Novo Usuário
- Processo de criação de um novo usuário para acesso ao sistema.

## Arquitetura e Tecnologias Utilizadas
- **Linguagem de Programação:** Java
- **Interface Gráfica:** Swing
- **Persistência de Dados:** Utilização de classes e estruturas de dados para armazenamento temporário (não persistente em banco de dados para este exemplo).
- **Estrutura de Classes:**
  - `Main`: Classe principal que inicializa o aplicativo e gerencia a interação entre as diferentes telas (frames).
  - **Telas (Frames):** Implementação das interfaces gráficas para cada funcionalidade (ex: Cadastro de Produto, Cadastro de Fornecedor, Cadastro de Depósito).
  - **Modelos de Dados:** Representação das entidades do sistema (Produto, Fornecedor, Depósito) com seus respectivos atributos e métodos.

## Requisitos de Sistema
- **Java:** Versão compatível com JDK 7
- **Banco de Dados:** MSSQL
- **Driver:** Java JDBC Driver 7
- **Sistema Operacional:** Plataformas suportadas pelo Java, como Windows, Linux e macOS.

## Instruções de Uso
### Cadastro de Produtos
1. Clique no botão "Cadastrar Produto".
2. Preencha os campos solicitados (nome, descrição, preço, quantidade).
3. Clique em "Salvar" para registrar o produto no sistema.

### Cadastro de Fornecedores
1. Clique no botão "Cadastrar Fornecedor".
2. Insira as informações necessárias (nome, telefone, e-mail).
3. Clique em "Salvar" para adicionar o fornecedor ao sistema.

### Cadastro de Depósitos
1. Clique no botão "Cadastrar Depósito".
2. Informe o nome e a localização do depósito.
3. Clique em "Salvar" para criar o novo depósito.

### Login
1. Preencha o nome de usuário.
2. Preencha a senha.
3. Clique em "Acessar".

### Registro de Novo Usuário
1. Informe os dados do usuário.
2. Clique em "Cadastrar".

### Recuperação de Senha
1. Informe o e-mail vinculado ao usuário.
2. Clique em "Enviar".

## Repositório no Git
- [Link para o Repositório](coloque-aqui-o-link-do-seu-repositório)

## Script do Banco de Dados
```sql
CREATE DATABASE gerenciamento_estoque

USE [gerenciamento_estoque]
GO

CREATE TABLE [dbo].[fornecedor](
    [id] [int] IDENTITY(1,1) NOT NULL,
      NOT NULL,
      NULL,
      NULL,
    PRIMARY KEY CLUSTERED ([id] ASC)
) ON [PRIMARY]

CREATE TABLE [dbo].[movimentacao_estoque](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [id_produto] [int] NOT NULL,
    [quantidade] [int] NOT NULL,
      NOT NULL,
    [data_hora] [datetime] NOT NULL,
    PRIMARY KEY CLUSTERED ([id] ASC)
) ON [PRIMARY]

CREATE TABLE [dbo].[produto](
    [id] [int] IDENTITY(1,1) NOT NULL,
      NOT NULL,
    [descricao] [text] NULL,
    [preco] [decimal](10, 2) NOT NULL,
    [quantidade_estoque] [int] NOT NULL,
    [id_fornecedor] [int] NULL,
    PRIMARY KEY CLUSTERED ([id] ASC)
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
```

## Considerações Finais

O Sistema de Gerenciamento de Estoque é uma solução simples e eficaz para empresas que desejam manter um controle organizado e preciso de seus produtos e estoques. Sua interface intuitiva e funcionalidades diretas permitem uma fácil integração aos processos operacionais de pequenas e médias empresas.
