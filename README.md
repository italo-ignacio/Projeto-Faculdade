# Projeto Java faculdade

Projeto da faculdade

# Requisitos

Obrigatório

- Ter o JDK instalado e configurado https://www.oracle.com/java/technologies/downloads/

- Ter o MySQL instalado https://dev.mysql.com/downloads/installer/

Opcional

- Ter o eclipse instalado https://www.eclipse.org/downloads/

# Baixe ou clone o projeto

- Baixe o zip

https://github.com/itilocao/Projeto-Faculdade/archive/refs/heads/main.zip

- Clone o projeto

```bash
git clone https://github.com/itilocao/Projeto-Faculdade.git
```

# Configurando o banco de dados

- Dentro da pasta "connection" tem o arquivo txt "SQL commands". Execute todos comandos no MySQL para criar o SCHEMA e as TABELAS

- Também dentro da pasta "connection" tem o arquivo "Conexao.java". Na linha 16 coloque sua senha do MySQL na variável "PASSWORD"

# Para rodar o projeto pelo cmd

- Abra o cmd na pasta do repositório

```bash
cd "Coloque o diretorio aqui"
```

- Compile o código com a biblioteca do MySQL utilizando o comando:

```bash
javac -cp ".;.\lib\mysql-connector-java-8.0.22.jar" Main.java
```

- Rode o projeto com o comando:

```bash
java -cp ".;.\lib\mysql-connector-java-8.0.22.jar" Main
```

- Obs:

Caso não apareça nada na tela do frame passe o mouse pelo meio dele;

Não esqueça de configurar o banco de dados

# Para rodar o projeto pelo eclipse

- Abra a pasta do projeto pelo eclipse

Adicionando a lib do MySQL

- Dentro da pasta "lib" selecione o arquivo "mysql-connector-java-8.0.22.jar"
- Clique com o botão direito e na opção "Build Path" selecione "Add to Build Path"

Para rodar

- Execute o arquivo Main.java "pode estar dentro do pacote (default package)"
