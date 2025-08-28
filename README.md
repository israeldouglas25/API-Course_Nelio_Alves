# API-Course_Nelio_Alves

Projeto de **API REST** em Java com Spring Boot, desenvolvido como parte do curso do **Prof. Nelio Alves**.
Neste projeto utilizei as melhores práticas de desenvolvimento para criar uma API seguindo os padrões atuais.

---

##  Tecnologias utilizadas

- **Java 21**
- **Spring Boot** (versão conforme especificada no `pom.xml`)
- Maven como gerenciador de dependências
- Outras dependências podem incluir Spring Web, Spring Data JPA, H2 ou outros bancos de dados
- IDE recomendada: IntelliJ IDEA, Eclipse ou VS Code com suporte Java
- JDK 21 configurado com `JAVA_HOME` e `PATH`

## Estrutura do projeto

- `src/main/java`: Código-fonte da aplicação
- `src/main/resources`: Arquivos de configuração e recursos estáticos
- `pom.xml`: Arquivo de configuração do Maven
- `README.md`: Documentação do projeto

## Funcionalidades

- Endpoints REST para operações CRUD (Create, Read, Update, Delete)
- Validação de dados de entrada
- Tratamento de exceções
- Configuração de segurança (opcional)

## Objetivo do projeto

- Aprender a criar uma API RESTful usando Spring Boot
- Praticar conceitos de desenvolvimento web em Java
- Implementar boas práticas de desenvolvimento de software
- Familiarizar-se com o ecossistema Spring
- Desenvolver habilidades em manipulação de dados e persistência
- Entender a integração de diferentes camadas da aplicação (controladores, serviços, repositórios)

---

## Modelo de dominio
![img.png](img.png)

##  Instalação e execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/israeldouglas25/API-Course_Nelio_Alves.git
   cd API-Course_Nelio_Alves

2. Certifique-se de ter o JDK 21 instalado e configurado.

3. Compile o projeto usando Maven:
   ```bash
   mvn clean install
   ```
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. A API estará disponível em `http://localhost:8080` (ou a porta configurada).
6. Use ferramentas como Postman ou cURL para testar os endpoints da API.
7. Para parar a aplicação, use `Ctrl + C` no terminal onde a aplicação está rodando.
8. Para mais detalhes sobre os endpoints e funcionalidades, consulte a documentação da API (se disponível).
9. Sinta-se à vontade para contribuir com melhorias ou reportar issues no repositório.
10. Divirta-se explorando e aprendendo com este projeto!

