# Documentação do Sistema de Catálogo de Filmes

## Visão Geral
Este sistema implementa um catálogo de filmes similar ao IMDB, desenvolvido em Java utilizando conceitos de Programação Orientada a Objetos.

## Arquitetura do Sistema

### Estrutura de Diretórios
```
imdb-catalog/
├── src/
│   ├── model/
│   │   ├── Pessoa.java      (Classe abstrata base)
│   │   ├── Ator.java        (Herda de Pessoa)
│   │   ├── Diretor.java     (Herda de Pessoa)
│   │   └── Filme.java       (Classe de entidade)
│   ├── service/
│   │   └── CatalogoFilmes.java (Classe de serviço)
│   └── Main.java            (Interface do usuário)
├── docs/
│   └── doc.md
└── README.md
```

## Conceitos de POO Implementados

### 1. Encapsulamento
- Todos os atributos das classes são privados
- Acesso aos dados através de métodos getters e setters
- Validações nos métodos de acesso

### 2. Herança
- `Pessoa` é a classe abstrata base
- `Ator` e `Diretor` herdam de `Pessoa`
- Reutilização de código e estrutura hierárquica

### 3. Polimorfismo
- Método abstrato `getDescricao()` implementado diferentemente em cada subclasse
- Comportamento específico para cada tipo de pessoa

### 4. Classes Abstratas
- `Pessoa` é uma classe abstrata que não pode ser instanciada
- Define a estrutura comum para `Ator` e `Diretor`

## Classes do Sistema

### Pessoa (Abstrata)
**Atributos:**
- `nome`: String
- `dataNascimento`: Date
- `nacionalidade`: String

**Métodos:**
- Getters e setters para todos os atributos
- `getDescricao()`: Método abstrato

### Ator
**Herda de:** Pessoa
**Métodos específicos:**
- `getDescricao()`: Retorna descrição específica do ator

### Diretor
**Herda de:** Pessoa
**Métodos específicos:**
- `getDescricao()`: Retorna descrição específica do diretor

### Filme
**Atributos:**
- `nome`: String
- `dataLancamento`: Date
- `orcamento`: double
- `descricao`: String
- `diretor`: Diretor
- `atores`: List<Ator>

**Métodos:**
- Getters e setters para todos os atributos
- `adicionarAtor(Ator)`: Adiciona ator ao filme
- `removerAtor(Ator)`: Remove ator do filme

### CatalogoFilmes (Serviço)
**Atributos:**
- `filmes`: List<Filme>
- `atores`: List<Ator>
- `diretores`: List<Diretor>

**Métodos:**
- `adicionarFilme(Filme)`: Cadastra filme
- `adicionarAtor(Ator)`: Cadastra ator
- `adicionarDiretor(Diretor)`: Cadastra diretor
- `pesquisarFilmes(String)`: Busca case-insensitive
- `buscarAtor(String)`: Busca ator por nome
- `buscarDiretor(String)`: Busca diretor por nome

## Funcionalidades do Sistema

1. **Cadastro de Atores**
   - Nome, data de nascimento, nacionalidade

2. **Cadastro de Diretores**
   - Nome, data de nascimento, nacionalidade

3. **Cadastro de Filmes**
   - Nome, data de lançamento, orçamento, descrição
   - Associação com diretor

4. **Associação Ator-Filme**
   - Vincula atores aos filmes

5. **Pesquisa de Filmes**
   - Busca case-insensitive por nome
   - Busca parcial (substring)

6. **Listagens**
   - Todos os filmes
   - Todos os atores
   - Todos os diretores

7. **Estatísticas**
   - Contadores de filmes, atores e diretores

## Dados de Exemplo
O sistema carrega automaticamente alguns dados de exemplo:
- **Atores:** Leonardo DiCaprio, Kate Winslet, Robert Downey Jr.
- **Diretores:** James Cameron, Christopher Nolan
- **Filmes:** Titanic, A Origem (Inception)

## Validações Implementadas
- Verificação de dados nulos
- Prevenção de duplicatas
- Validação de formato de data
- Validação de números para orçamento

## Tratamento de Erros
- Try-catch para parsing de datas
- Try-catch para conversão de números
- Validações de entrada do usuário
