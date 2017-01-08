# Este projeto consiste em um desafio técnico, que foi uma das etapas de um processo de recrutamento e seleção feito uma empresa de Bauru/SP.

## Divisão do projeto
O projeto foi divido em três partes:
- servico-api: API RestFull utilizada para disponibilizar os dados para outras aplicações;
- servico-client: client Web da API servico-api;
- servico-mysql-server: projeto Maven utilizado para criar uma imagem Docker contendo o banco de dados MySQL. Ao iniciar um container a partir dessa imagem o banco de dados servico será criado automaticamente.

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

# Maven;
Plugins utilizados:
- Docker Maven Plugin: plugin utilizado para criar imagens de projetos Maven;
- Jacoco Maven Plugin: plugin usado para criar relatórios de testes e validar se a porcentagem de cobertura de testes foi alcançada;
- Spring Boot Maven Plugin: este plugin é utilizado para criar artefatos executáveis de projetos Spring.

Perfis:
- docker: ao selecionar esse perfil  uma imagem Docker do projeto será criada;
- test: ao ativar esse perfil a axecução dos testes será habilitada, e o plugin Jacoco irá criar relatórios de testes e validar se a porcentagem de cobertura de testes foi alcançada;

# Swager
Framework utilizado para documentar a API servico-client. Para visualizar a documentação, basta acessar http:<host>:8080/api-doc.

# Criando Containers a partis das imagens
- servico-mysql-server:
- servico-api:
- servico-client:
