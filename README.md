# restaurant-rest-api

### Abaixo, seguem as instruções para autenticar o usuário e ter acesso às demais APIs

- Acessar a API de criação de novo usuário em /api/services/controller/user
- Utilizar o template abaixo para criar novo usuário (todos os campos são obrigatórios)
    ```json
    {
        "username": "nome",
        "password": "senha",
        "email": "nome@teste.com"
    }
    ```
- Depois, utilizar o username e o password para fazer login em /api/services/controller/user/login, usando o mesmo template anterior, porém, sem o e-mail.
  - Após fazer o login, um token JWT será informado no body da resposta.
  - Copiar as 3 partes do token
  - No Postman, siga para Headers e adicione um novo header
    - Use o nome Authorization como Key
    - Para value, escreva Bearer, dê espaço e cole o token que copiou
  - Caso o header que você criou ainda não esteja marcado com um check, marque-o.
  - Atenção: caso haja um erro no cadastro de usuário, o sistema executa um rollback. Também, se demorar muito tempo, o sistema exigirá um novo login.
    - Para fazer um novo login, desative o header Authorization e volte para a etapa de login, em /api/services/controller/user/login.

### Se você chegou até aqui, poderá acessar as demais APIs por 15 minutos, antes do token expirar

#### API de Clientes
- Acesse a API em /clientes
  - Criação de clientes
    - Usando método POST, crie um cliente seguindo o template abaixo (apenas nome e cpfDoCliente são obrigatórios)
  ```json
      {
        "nome": "*****",
        "cpfDoCliente": "*********",
        "cepDoCliente": "*********",
        "pedidos": [
            {
                "descricaoDoPedido": "*********",
                "entrega":
                    {
                        "endereco": "***********"
                    }                   
            } 
        ]
      }
    ```
  - Consulta de clientes específicos
    - Usando método GET, acesse /clientes/buscar/{nome} e substitua {nome} pelo nome do cliente
  - Deletar cliente
    - Seguindo a mesma lógica do item anterior (porém, como o método DELETE), acesse /clientes/deletar/{nome}

#### API de Pedidos
- Acesse a API em /pedidos
  - Criação de pedidos
    - Usando o método POST, crie pedidos seguindo o template abaixo (nenhum atributo é obrigatório)
    ```json
      {
        "descricaoDoPedido": "*****",
        "entrega":
            {
                "endereco": "***********"       
            }
      }
    ```
  - Consulta de pedidos específicos
    - Usando o método GET, acesse /pedidos/buscar/{id} e substitua {id} pelo número do id do pedido
  - Deletar pedido
    - Seguindo a mesma  lógica do item anterior (porém, como o método DELETE), acesse pedidos/deletar/{id}

#### API de Entregas
- Acesse a API em /entregas
  - Criação de entregas
    - Usando o método POST, crie entregas seguindo o template abaixo (nenhum atributo é obrigatório)
    ```json
      {
        "endereco": "*****"
      }
    ```
  - Consulta de entregas específicas
    - Usando o método GET, acesse /entregas/buscar/{id} e substitua {id} pelo número do id da entrega
  - Deletar entrega
    - Seguindo a mesma  lógica do item anterior (porém, como o método DELETE), acesse entregas/deletar/{id}


