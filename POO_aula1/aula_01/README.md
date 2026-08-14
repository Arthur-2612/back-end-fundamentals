# Exercícios de Abstração

Diagramas de classe são utilizados para representar objetos que irão compor um sistema.

Veja abaixo um exemplo de uma Classe representada em diagrama:

```mermaid
    classDiagram
    class Nome{
        - atributos 
        + metodos():void
    }
```

1. Modele uma classe que represente um carro.


```mermaid
    classDiagram
    class Carro{
        - int x
        - int y
        - double velocidade
        - string cor

        + metodos():void
        + acelerar(): void
        + freiar(): void
        + darRé(): void
        + virar(): void
        + desligarCarro(): void
        + ligarCarro(): void
    }
```

2. Moedelar uma classe que represente uma Conta Bancária

```mermaid
    classDiagram
    class ContaBancaria{
        - double saldo
        - int cpf
        - double limite
        - string meiosPagamento
        + pix(): void
        + sacar(double valor): boolean
        + depositar(double valor): boolean
        + receber(): void
        + autenticar(): void
    }
```

3. Modele uma Classe que represente que represente um Post (de uma rede social).

```mermaid
    classDiagram
    class PostRedeSocial{
        - int numCurtidas
        - string comentario
        - int compartilhamento
        - image [] img
        - string usuario
        - string conteudo
        - datetime data
        + publicar(): boolean
        + excluir(): boolean
        + respostar(): boolean
        + comentar(String comentario): void
        + curtir(): boolean
    }
```

4. Modelar uma clsse que represente uma Branch

```mermaid
    classDiagram
    class Branch{
        - string categoriaBranch
        - datetime horario
        - string repositorio
        - string autor
        - string projeto
        + commitar(String msg): boolean
        + merge(Barnch Destino): boolean
        + pull(String url): boolean
        + push(String url): boolean
        + clone(String url): boolean
    }
```