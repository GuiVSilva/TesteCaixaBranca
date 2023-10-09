# DOCUMENTAÇÃO DO CÓDIGO

### 1. Método `conectarBD()`:
Este método é responsável por estabelecer uma conexão com um banco de dados MySQL.
- Utiliza o driver JDBC do MySQL para estabelecer a conexão.
- Lança exceções se ocorrerem erros durante o processo de conexão.

### 2. Método `verificarUsuario(String login, String senha)`:
Este método recebe um nome de usuário (login) e uma senha (senha) como parâmetros.
- Constrói uma consulta SQL para verificar se um usuário com o nome de usuário e senha fornecidos existe no banco de dados.
- Executa a consulta no banco de dados e retorna `true` se um usuário correspondente for encontrado, indicando uma autenticação bem-sucedida.
- Lança exceções se ocorrerem erros durante o processo de execução da consulta SQL ou de autenticação.

### 3. Detalhes Importantes:
- Utiliza a classe `DriverManager` para estabelecer a conexão com o banco de dados.
- Utiliza `Statement` para executar a consulta SQL.
- Fecha a conexão com o banco de dados no bloco `finally` para garantir a liberação adequada dos recursos, mesmo em caso de exceção.
- Lança exceções específicas (`SQLException` e `ClassNotFoundException`) para indicar falhas específicas, o que facilita a identificação de problemas durante a execução do programa.

### 4. Notas Adicionais:
- O código foi estruturado de forma apropriada, com métodos bem definidos e uso de exceções para lidar com erros.
- A consulta SQL foi parametrizada, o que previne a injeção de SQL, uma prática importante para a segurança dos dados.

