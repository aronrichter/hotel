# hotel

Para seguir o passo a passo são necessários as seguintes aplicações:
- terminal bash
- docker
- docker-compose
- maven
- java 11

Para testar a aplicação, siga os seguintes passos

1. no diretório do projeto, executar o comando "docker-compose up -d"

2. após a execuçao acesse: http://localhost:16543/ com usuario: hotel@hotel.com senha: hotel

3. adicione um novo servidor com os seguintes dados:
- Host name/address: hotel
- Username: postgres
- Senha: hotel
Salve

4. no lado esquerdo, abra o servidor criado, clique com o botão direito em Database para criar um novo, dê o nome: hotel

5. voltando ao terminal, digite o seguinte comando: "mvn clean package -U"

6. após a execução digite "java -Xmx256m -jar target/hotel-0.0.1-SNAPSHOT.jar

7. abra o insomnia e importe o arquivo JSON insomnia.json

8. inicie os testes =)
