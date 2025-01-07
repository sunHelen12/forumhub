CREATE TABLE respostas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensagem TEXT NOT NULL,
    topico INT,
    dataCriacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    autor BIGINT,  
    solucao VARCHAR(255) NOT NULL,
    FOREIGN KEY (topico) REFERENCES topicos(id) ON DELETE CASCADE,
    FOREIGN KEY (autor) REFERENCES autores(id) ON DELETE CASCADE
);