CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL
);

CREATE TABLE perfis (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    perfis INT,
    FOREIGN KEY (perfis) REFERENCES perfis(id) ON DELETE SET NULL
);


CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    dataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(255) NOT NULL,
    autor INT,
    curso INT,
    respostas INT,
    FOREIGN KEY (autor) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (curso) REFERENCES cursos(id) ON DELETE SET NULL
);

CREATE TABLE respostas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    topico INT,
    dataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autor INT,
    solucao VARCHAR(255) NOT NULL,
    FOREIGN KEY (topico) REFERENCES topicos(id) ON DELETE CASCADE,
    FOREIGN KEY (autor) REFERENCES usuarios(id) ON DELETE CASCADE
);

