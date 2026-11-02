# Sistema de Gerenciamento de Restaurante

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Arquitetura MVC](https://img.shields.io/badge/Arquitetura-MVC-blue?style=for-the-badge)

Um sistema completo de terminal para gerenciamento de pedidos de restaurante, desenvolvido em **Java**. Este projeto acadêmico aplica conceitos avançados de Programação Orientada a Objetos (POO), Padrões de Projeto, Estruturas de Dados e Tratamento de Exceções.

## Funcionalidades

- **Criação de Pedidos Personalizados:** Escolha lanches base e personalize retirando ingredientes (ex: sem cebola) ou adicionando extras (ex: cheddar, bacon).
- **Modificação de Comandas (CRUD):** Busca de pedidos via ID para adicionar novos itens, remover itens específicos ou cancelar o pedido inteiro.
- **Fechamento do Dia Inteligente:** Cálculo do faturamento total e relatório estatístico das combinações únicas de lanches vendidas no dia.
- **Sistema Resiliente:** Tratamento robusto de entradas de usuário com `InputMismatchException` para evitar quebras do sistema ou loops infinitos em caso de erros de digitação.

## Arquitetura e Padrões de Projeto

O código foi refatorado para seguir o princípio de responsabilidade única, assemelhando-se ao padrão **MVC**:
- **View (`MenuConsole`):** Responsável exclusiva pela interação de I/O com o usuário.
- **Controller (`GerenciadorFluxo`):** Orquestra a navegação de menus e o fluxo da aplicação.
- **Model (`RestauranteFacade`):** Centraliza as regras de negócio e o armazenamento temporário de dados.

### Padrão Decorator
O sistema resolve o problema de explosão de classes no cardápio utilizando o padrão **Decorator**. Um lanche base (ex: X-Bacon) e os adicionais (ex: Cheddar) implementam a mesma interface `ItemCardapio`. O adicional "embrulha" o lanche original, somando os preços e concatenando a descrição dinamicamente em tempo de execução.

### Estruturas de Dados (Collections)
- **`HashMap<Integer, Pedido>`**: Utilizado na Facade para armazenar os pedidos, garantindo busca instantânea pelo ID da comanda.
- **`HashSet<String>`**: Utilizado no fechamento do dia para identificar as combinações únicas de produtos vendidos, aproveitando a característica do Set de não permitir elementos duplicados.
- **`ArrayList<ItemCardapio>`**: Utilizado para gerenciar os itens dentro de um pedido, permitindo remoção fácil via índice numérico.

## Como Executar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/beatlls/nome-do-seu-repositorio.git](https://github.com/beatlls/nome-do-seu-repositorio.git)
2. Abra o projeto na sua IDE de preferência (IntelliJ IDEA, Eclipse, etc).

3. Execute a classe Main.java localizada no pacote org.example.app.
## 🧪 Como executar os testes

O projeto conta com testes unitários em **JUnit 5** para garantir a integridade do padrão Decorator. 

Para rodar os testes localmente, abra o terminal na raiz do projeto e execute o comando Maven:

```bash
mvn test
```

## 🎥 Demonstração do Projeto

Assista ao vídeo de apresentação detalhando a organização dos pacotes, o padrão Decorator em ação, o sistema rodando e a execução dos testes unitários:

👉 **[Clique aqui para assistir ao vídeo de apresentação]([(https://youtu.be/LIOP5AU4tvc?si=bwVL4P7Dp8-HicR3)])**
