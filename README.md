# Este projeto consiste em um desafio técnico, que foi uma das etapas de um processo de recrutamento e seleção feito uma empresa de Bauru/SP.

## Divisão do projeto
O projeto foi divido em três partes:
- servico-api: API RestFull utilizada para disponibilizar os dados para outras aplicações;
- servico-client: client Web da API servico-api;
- servico-mysql-server: projeto Maven utilizado para criar uma imagem Docker contendo o banco de dados MySQL. Ao iniciar um container a partir dessa imagem será criado o banco servico, que é utilizado pela aplicação servico-api para persistir os dados.

## Tecnologias utilizadas no projeto:

# Spring Framework
Módulos utilizados:
- Spring Web: utilizado para a criação da API RestFull servico-api e do client servico-client;
- Spring Data: usado para persistir os dados no banco MySQL;
- Thymeleaf: utilizado para criar as views do client;
- Devtools: ferramenta usada para fazer HotDeploy da aplicação após cada alteração do projeto;
- LiveReload: plugin usado para recarregar o navegador a cada alteração das views;
- Spring Test: módulo utilizado para a criação dos Testes de Integração de recursos e repositórios;
- Spring Boot Maven Plugin: plugin Maven utilizado para criar o artefato executável de projetos Spring.
- Spring Feign: módulo utilizado no projeto servico-client para consumir os recursos da API servico-api;

# Maven:
Plugins utilizados:
- Docker Maven Plugin: plugin utilizado para criar imagens de projetos Maven;
- Jacoco Maven Plugin: plugin usado para criar relatórios de testes e validar se a porcentagem de cobertura de testes foi alcançada;
- Spring Boot Maven Plugin: este plugin é utilizado para criar artefatos executáveis de projetos Spring.

Perfis disponíveis:
- docker: este perfil permite criar uma imagem Docker;
- test: ao ativar esse perfil a axecução dos testes será habilitada, e o plugin Jacoco irá criar relatórios de testes e validar se a porcentagem de cobertura de testes foi alcançada;

# Swager
Framework utilizado para documentar a API servico-client. Para visualizar a documentação, basta acessar o recurso /api-doc.

# Obtendo as imagens Docker
As imagens dos três projetos encontram se armazenadas no Dockerhub, com os nomes: helciodasilva/servico-api, helciodasilva/servico-client e helciodasilva/servico-mysql-server.

Para cloná-las basta executar o comando git pull helciodasilva/<imagem>

Além de clonar as imagens também é possível criar imagens a partir dos projetos.

Para os projetos servico-api e servico-client será necessário ativar o perfil docker.

mvn docker:buid -P docker

Já para o projeto servico-mysql-server basta executar o plugin.

mvn docker:buid

Para acessar o perfil de helciodasilva basta acessar: https://hub.docker.com/u/helciodasilva/

# Criando container a partir das imagens

- servico-mysql-server:
- servico-api:
- servico-client:
