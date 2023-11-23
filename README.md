<h1 align="center"> Desafio - Consulta de Vendas </h1>

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/henriquecesarjr/desafio-consulta-vendas/blob/main/LICENSE)

# Sobre o projeto

Trata-se de um sistema de vendas (Sale) e vendedores (Seller). Cada venda está para um vendedor, e um vendedor pode ter várias vendas.

<h2>Regras</h2>

- **Relatório de vendas**

  1. [IN] O usuário informa, opcionalmente, data inicial, data final e um trecho do nome do vendedor.

  2. [OUT] O sistema informa uma listagem paginada contendo id, data, quantia vendida e nome do
     vendedor, das vendas que se enquadrem nos dados informados.

     **Informações complementares**

     -  Se a data final não for informada, considerar a data atual do sistema. Para instanciar a data atual,

       utilize o comando:

     - Se a data inicial não for informada, considerar a data de 1 ano antes da data final. P

     - Se o nome não for informado, considerar o texto vazio.

     - Dica: receba todos os dados como String no controller, e faça os tratamentos

       

- **Sumário de vendas por vendedor**

  1. [IN] O usuário informa, opcionalmente, data inicial, data final.

  2. [OUT] O sistema informa uma listagem contendo nome do vendedor e soma de vendas deste vendedor
      no período informado.

    **Informações complementares:**

    -  As mesmas do caso de uso Relatório de vendas

 # Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- H2 Database
- Maven

# Autor

Henrique César Jr. C. Marques

<a href="https://www.linkedin.com/in/henrique-marques-376a50274/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>

