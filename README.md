### README: Forum Hub

---

# Forum Hub 🚀

Bem-vindo ao **Forum Hub**, um projeto desenvolvido como parte do **Desafio do Programa One Oracle Next Education** em parceria com a **Alura**. Este projeto tem como objetivo criar um fórum onde pessoas interessadas em tecnologia possam compartilhar dicas, pedir recomendações e conversar sobre cursos e ferramentas do universo tech.

---

## 💡 **Sobre o Projeto**

O Forum Hub é um fórum web que permite a interação entre usuários sobre temas relacionados à tecnologia. Com funcionalidades CRUD (Create, Read, Update, Delete) completas, os usuários podem criar tópicos, gerenciar autores, cadastrar cursos e manter o conteúdo organizado e seguro. A autenticação e o controle de acesso garantem um ambiente protegido para todos os usuários.

---

## ✨ **Funcionalidades**

### 1. **Gerenciamento de Tópicos**
- **Cadastrar Tópicos**: Crie novos tópicos fornecendo título, mensagem, autor e curso relacionados.
- **Listar Tópicos**: Consulte todos os tópicos disponíveis no fórum, com paginação e ordenação.
- **Atualizar Tópicos**: Edite os detalhes de tópicos existentes, como título, mensagem ou status.
- **Excluir Tópicos**: Remova tópicos que não sejam mais relevantes.

### 2. **Interação com Respostas**
- **Adicionar Respostas**: Contribua com respostas nos tópicos, promovendo discussões.

### 3. **Gerenciamento de Autores**
- **Cadastrar Autores**: Registre novos autores que podem criar tópicos e interagir no fórum.
- **Excluir Autores**: Remova autores que não participam mais do fórum.

### 4. **Gerenciamento de Cursos**
- **Cadastrar Cursos**: Adicione novos cursos que podem ser associados aos tópicos.
- **Listar Cursos**: Consulte todos os cursos disponíveis no sistema.
- **Excluir Cursos**: Delete o curso quando quiser.

### 5. **Segurança e Autenticação**
- **Login**: Permita que os usuários façam login com credenciais para receber um token JWT.
- **Proteção de Rotas**: Apenas usuários autenticados podem criar, editar ou excluir tópicos, autores e respostas.
- **Criptografia**: Senhas são armazenadas com **BCrypt**, garantindo segurança e privacidade.

### 6. **Documentação Interativa**
- A API está documentada com **Swagger/OpenAPI**, permitindo a exploração e o teste de endpoints diretamente no navegador.
- Acesse a documentação em: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

---

## 🛠️ **Tecnologias Utilizadas**

### Backend
- **Java 17**: Linguagem principal do projeto.
- **Spring Boot 3.4.1**: Framework para desenvolvimento rápido e eficiente de aplicações.
  - **Spring Boot Starter Web**: Para construção de APIs RESTful.
  - **Spring Boot Starter Data JPA**: Para persistência de dados com Hibernate.
  - **Spring Boot Starter Validation**: Para validação de dados.
  - **Spring Boot Starter Security**: Para autenticação e controle de acesso.
- **Flyway**: Para controle de versões do banco de dados.
- **Swagger/OpenAPI**: Para documentação e testes da API.
- **Lombok**: Redução de boilerplate com geração automática de código.

### Banco de Dados
- **MySQL**: Banco de dados relacional para armazenamento de informações do sistema.

### Segurança
- **Spring Security**: Para autenticação e autorização.
- **JWT (JSON Web Token)**: Para autenticação de usuários.
- **BCrypt**: Para criptografia de senhas.

### Outros
- **DevTools**: Para agilizar o desenvolvimento com reinicializações automáticas.

---

## 🛡️ **Autenticação e Controle de Acesso**

- **JWT (JSON Web Token)**: Utilizado para autenticar e autorizar os usuários do sistema.
- **Rotas Protegidas**: Apenas usuários autenticados podem acessar funcionalidades de criação, edição e exclusão.
- **Rotas Públicas**: Endpoint como login acessível a todos.

---

 **Acesse a API**:
   - Acesse o Swagger para explorar a API: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

**Desenvolvido com ❤️ por Helen.**
