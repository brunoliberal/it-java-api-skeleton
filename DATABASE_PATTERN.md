# Padrão de nomenclatura de Objetos de Banco de Dados

# 1. Objetivo

Estabelecer padrões de nomenclatura de objetos de banco de
dados

# 2. Definições

```
SGBD - Sistema de Gerência de Banco de Dados
OLTP - On-line Transactional Processing
```
# 3. Objetivo

## 3.2 Considerações gerais

Para o nome de qualquer objeto, as seguintes regras devem ser
seguidas:

- Deve começar com uma letra
- Deve conter apenas alfanuméricos (A-Z,0-9) e
“underscore” (_), considerando as limitações de tamanho
para nomes nos ambientes utilizados.

## 3.3 Objetos Estruturais do Ambiente de Dados

## 3.3.1 Sistema

```
<texto_significativo>, com até 10 caracteres
```
## 3.3.2 Banco de Dados

```
<texto_significativo>, considerando a limitação de tamanho
nos ambientes utilizados
```
## 3.3.3 Database Link

```
<banco de dados>_<texto significativo> , onde < texto
significativo > é opcional
```
Ex.: PEPRNCE, DEPWBA, BCP5_OG00_CONSULTA

## 3.3.4 Tablespace

O nome da Tablespace deve ser composto por:

**Owner_<tipo de objeto>_NN,** onde:

- <tipo de Objeto> (opcional) pode ser: DADOS, ÍNDICES ou LOBS

- NN = Número seqüencial (opcional)

Ex.: OG00_

## 3.4 Objetos de Modelo de Dados

## 3.4.1 Comentários

Os comentários de colunas e tabelas devem ser preenchidos

Ex.:
```sql
COMMENT ON TABLE OWN.CLIENTE 
IS 'Cliente que pode fazer uma compra na aplicação.'

COMMENT ON COLUMN OWN.CLIENTE.CLIE_CD_CLIENTE 
IS 'Codigo identificador do cliente.'
```

## 3.4.2 Owner

**<texto_significativo>,** com até 7 caracteres

## 3.4.3 Tabela

Texto livre e significativo, observando que o nome deve estar no
singular e, se composto por duas ou mais palavras, estas devem
estar separadas por “underscore”:

**_<_** **termo1>_<termo2>_..._<termoN** **_>_**

Deve ser um nome preferencialmente no masculino e em letras
maiúsculas

O termo deve possuir no mínimo 2 letras. Termo com 2 letras só
deve ser usado se o termo já possuir uma sigla conhecida com
este tamanho

Ex.: RG/UF

Não devem ser utilizados preposições e artigos na composição
do nome.

Evitar nomes técnicos e nomes próprios, exceto se for de grande
conhecimento da empresa

Ex.: SALDO_FGTS, FOLHA_FERIAS

## 3.4.4 Visão (View)

**VW_<termo1>_<termo2>_..._<termoN>**

As colunas da visão devem possuir o mesmo nome da coluna da
tabela de origem

## 3.4.4.1 Visão Materializada (Materialized View)

**MV_<termo1>_<termo2>_..._<termoN>**

As colunas da visão devem possuir o mesmo nome da coluna da
tabela de origem

## 3.4.5 Mnemônico de Tabela

Utilizado como prefixo do nome da coluna de uma tabela,
conforme citado no item 3.4.6 Coluna Deve conter até quatro 
caracteres alfanuméricos (A-Z,0-9)

Se o nome da tabela for formado por uma única palavra, usar os
quatro primeiros caracteres

Ex.: EMPREGADO EMPR

Se o nome da tabela for formado por duas palavras, usar os dois 
primeiros caracteres de cada uma

Ex.: DM_EMPREGADO DMEM

Se o nome da tabela for formado por três palavras, usar os dois
primeiros caracteres da primeira palavra, o primeiro caractere da
segunda e o primeiro da terceira palavra

Ex.: CT_CONTROLE_RELATORIO CTCR

Quando o nome da tabela for formado por quatro ou mais
palavras, usar os dois primeiros caracteres da primeira palavra,
e para os dois caracteres restantes utilizar os primeiros
caracteres das palavras mais significativas.

Ex.: MM_BASE_CONSULTA_ATRIBUTO_DIM MMBA

Caso em uma mesma base de dados o procedimento acima
gerar abreviaturas iguais, as duplicidades devem ser resolvidas
escolhendo-se outro modo de gerar as abreviaturas

## 3.4.5.1 Mnemônico de View

Para colunas de view, e materialized view, que são originadas de
uma expressão, será necessário criar um mnemônico para a
view (materialized view). Considerar a mesma regra para
mnemônico de tabela, desprezando o prefixo VW (MV). Ver item
5.4.5 Mnemônico de Tabela.

Ex.: VW_PONTO_OPER POOP

EX.: MV_PONTO_OPER POOP

## 3.4.6 Coluna

**<mnemônico tabela>_<código da classe>_<texto
significativo>**

Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de Tabela.

Para colunas de views, e também de 'materialized' views, 
originadas de uma expressão considerar “mnemônico view” no
lugar de “mnemônico tabela”. Ver o item 3.4.5.1 Mnemônico de View.

Quando a coluna fizer parte de uma chave estrangeira, seu
nome deve ser igual ao nome da coluna chave primária na
tabela pai, inclusive o mnemônico da tabela pai:

Ex.: EMPR_NR_MATRICULA (número da matrícula do empregado)

Os "códigos de classe", descritos a seguir, indicam o propósito
de uso da coluna

| Código da classe | Descrição   |
|------------------|-------------|
| CD               | Código      |
| IN               | Indicador   |
| NR               | Número      |
| SG               | Sigla       |
| TX               | Texto       |
| DS               | Descrição   |
| DT               | Data        |
| MD               | Medida      |
| PR               | Percentual  |
| MM               | Multimidia  |
| VL               | Valor       |
| NM               | Nome        |
| QN               | Quantidade  |
| SQ               | Sequencial  |

**CD –** Código propriamente dito representando uma
chave , identificador, tipo, classificação, categoria, nível e
tudo que requeira decodificação (CGC, alínea, CPF,
produto, etc.)

Ex.:
- Código/identificador/cargo
- Código/identificador/unidade-federação
- Código/tipo/contrato
- Código/classificação/item-serviço
- Código/categoria/veiculo
- Código/nível salarial/empregado
- Código/grau-escolaridade/empregado

**IN –** Indicação de domínio restrito, no sentido de apontar
(S, N), marcador (*), sinal (+,-), elemento de
distinção(conjunto alfanumérico)

Ex.: 
- Indicador/sinal-diferencial-pressão/canhoneio
- Indicador/status/fornecedor
- Indicador/aditivo/contrato

**NR –** Numeração cardinal livre que representa uma
seqüência ou constante

Ex.: 
- Número/identidade/empregado
- Número/anuênios/empregado

**SG –** Abreviação ou simples conjunto de caracteres (com
significado) que identifica objetos do mundo real

Ex.: 
- Sigla/estado/local-embarque
- Sigla/identificadora/órgão

**TX –** Comentário livre, observação livre, explicação,
exemplificação, significado, etc

Ex.: 
- Texto/observação/equipamento
- Texto/explicação/processo
- Texto/exemplificação/amostra
- Texto/significado-avaliação/contrato

**DS–** Descrição de alguma coisa ou ser, sem formato
pré-definido e sem regras rígidas de preenchimento

Ex.: 
- Descrição/tipo
- Descrição/status

**DT –** Qualquer data (completa ou não) que exprime a
data efetiva de um evento

Ex.: 
- Data/admissão/empregado
- Data/ano-mês-reajuste/contrato

**MD –** Número que exprime uma quantidade sujeita à
medição tal como peso, capacidade, área, profundidade,
distância, perímetro, vazão, pressão, densidade,
velocidade, comprimento, etc

Ex.: 
- Medida/peso/equipamento
- Medida/capacidade/tanque
- Medida/área/campo
- Medida/profundidade/poço
- Medida/distância/local-entrega
- Medida/perímetro/local
- Medida/vazão/equipamento
- Medida/pressão/equipamento
- Medida/densidade/produto
- Medida/velocidade/navio

**PR –** Número que exprime uma percentagem ou taxa

Ex.: 
- Percentual/participação-lucro/empregado
- Percentual/ipi/item-material

**MM –** Elementos multimídia como gráficos, imagens,
sons, filmes ou animações

Ex.: 
- Multimídia/foto/empregado
- Multimídia/gráfico/modelo
- Multimídia/filme/notícia
- Multimídia/som/mensagem

**VL –** Quantitativo exclusivamente monetário que exprime
custo, preço, pagamento, recebimento, etc

Ex.: 
- Valor/unitário/item-serviço
- Valor/fob/produto
- Valor/total/faturamento
- Valor/reembolso/contrato

**NM –** Nome completo ou abreviado de pessoa física/
jurídica ou "objeto"

Ex.: 
- Nome/completo/empregado
- Nome/razão-social/companhia
- Nome/estado-território/unidade-federação

**QN –** Número que exprime uma quantidade obtida
através de contagem do objeto tratado, exceto valores
monetários e medições, ou simplesmente um quantitativo 
acumulado

Ex.: 
- Quantidade/total/embarque
- Quantidade/estoque/produto

**SQ –** Exprime campo sequencial ou auto incremento

Em relação ao "texto_signifcativo", não usá-lo de forma
redundante com o "código da classe", como por exemplo:

Ex.1: AVFI_CD_CODIGO (Tabela: AVALIACAO_FISICA)

Ex.2: ATED_QN_QUANTIDADE (Tabela: ATIVIDADE_EDUCATIVA)

Ex.3: FUNC_NM_NOME_PAI (Tabela: FUNCIONARIO)

Ex.4: FUNC_DT_DATA_NASCIMENTO (Tabela: FUNCIONARIO)

Usar:

Ex.1: AVFI_CD_AVALIACAO (Tabela: AVALIACAO_FISICA)

Ex.2: ATED_QN_CONTRATADOS (Tabela: ATIVIDADE_EDUCATIVA)

Ex.3: FUNC_NM_PAI (Tabela: FUNCIONARIO)

Ex.4: FUNC_DT_NASCIMENTO (Tabela: FUNCIONARIO)

## 3.4.7 Restrições de Integridade (Constraints)

## 3.4.7.1 Chave Primária (Primary Key)

Coluna ou combinação de colunas que identifica uma única linha
em uma tabela e com os quais as demais colunas mantêm uma
relação de dependência

**PK_<mnemônico tabela>**

Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de
Tabela

As colunas pertencentes à chave primária não podem possuir
valor nulo

Ex.: PK_EMPR

## 3.4.7.2 Chave Estrangeira (Foreign Key)

Coluna ou combinação de colunas definida como chave
estrangeira, que estabelece relação com uma chave primária em
outra ou na mesma tabela

**FK_<mnemônico tabela pai>_<mnemônico tabela
filho>_<texto significativo opcional>**

Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de
Tabela

O “texto significativo opcional” deve ser utilizado como
diferenciador quando houver mais de um relacionamento entre
as duas tabelas.

As colunas pertencentes à chave primária não podem possuir
valor nulo

Ex.: FK_USUA_PARE_RESPONSAVEL

## 3.4.7.3 Unique

Coluna ou combinação de colunas que identifica uma única linha
em uma tabela. Diferentemente da chave primária, estas colunas
não possuem um relacionamento de dependência

As colunas pertencentes à “constraint unique” podem possuir
valor nulo

**UN_<mnemônico da tabela>_<texto significativo>**

Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de
Tabela

É preferível que o “texto significativo” contenha referência às
colunas envolvidas

Ex.: UN_EMPR_EMPR_NR_CGC

## 3.4.7.4 Check

Define valores válidos para uma ou mais colunas de uma tabela.

**CK_<mnemônico tabela>_<texto significativo>**

O nome significativo deve esclarecer o tipo de informação que a
check constraint está validando

Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de
Tabela

Ex.: CK_EMPR_NR_HORAS

## 3.4.8 Default

Define um valor padrão a ser associado a determinadas colunas
quando não são estabelecidos valores para elas

Uma alternativa para definir um default é a utilização da cláusula
DEFAULT no momento em que se cria a tabela

**DF_<texto significativo>**

É preferível que o “texto_significativo” contenha referência às
colunas envolvidas

Ex: DF_EMPR_DT_INCL

## 3.4.9 Índice

Estrutura associada a uma ou mais colunas com o objetivo de
otimizar consultas ou impor integridade. Ao ser definida a
constraint primary key ou unique, o SGBD cria automaticamente
um índice único e utiliza o mesmo nome da constraint para
nomeá-lo

Índice _constraint_ (chave primária, _unique_ e _foreing key_ )
O índice utiliza o mesmo nome da _constraint_.

Índice secundário
**IN_<mnemônico tabela>_<texto significativo>**

```
Sobre “mnemônico tabela” ver o item 3.4.
Mnemônico de Tabela
```

```
É preferível que o “texto significativo” contenha
referência às colunas envolvidas
```
Ex.: IN_EMPR_CPF

## 3.4.10 User Data Type

Tipos de dados definidos pelo usuário

**UDT_<texto significativo>**

Ex.: UDT_EMPR_DATA

## 3.4.11 Sequence (SGBD Oracle)

Objeto do banco de dados que gera números seqüenciais para
utilização em tabelas

**SQ_<nome da coluna>**

Ex.: SQ_STPR_CD_PROJ

## 3.4.12 Role

É um conjunto de permissões de acesso a objetos de um
determinado Banco de Dados. Deve ser nomeado em letras
maiúsculas

**R<texto significativo>**

## 3.4.13 Unidades de Programa

## 3.4.13.1 Gatilho (Trigger)

É um procedimento disparado automaticamente após cada
operação de _insert, update ou delete_ , específico para cada tipo
de operação

**TR<tipo>_<evento>_<mnemônico_tabela>_<função>_<sistema>,**
onde:

- Tipo pode ser:

```
G – Trigger de Integridade Referencial (tabela)
M – Trigger Mutante
V – Trigger de View
```
- Evento pode ser:

```
AS - After Statement
BS - Before Statement
AR - After Row
BR - Before Row
```

- Sobre “mnemônico tabela” ver o item 3.4.5 Mnemônico de Tabela

- Função pode ser:

```
INS - para trigger de inclusão
DEL - para trigger de exclusão
UPD - para trigger de update
IUD - combinação que indica os eventos de "Insert", "Update" e "Delete"
IU - combinação que indica os eventos de "Insert" e "Update"
ID - combinação que indica os eventos de "Insert" e "Delete"
DU - combinação que indica os eventos de "Delete" e "Update"
```

- Sistema é opcional

Ex.: TRG_AR_PESS_IU, TRG_AR_TERC_IU_OG

## 3.4.13.2 Função ( Function )

É uma função armazenada dentro do próprio banco de dados,
que é chamada por meio de _select_ e retorna um valor

**UFC_<sistema>_<texto significativo>**

Ex.: UFC_TC00_NIVEL_ACESSO

## 3.4.13.3 Procedimento Armazenado (Stored Procedure)

É uma rotina armazenada dentro do próprio banco de dados.
Alguns procedimentos podem ser retirados da aplicação e
transformados em stored procedures. O grau de complexidade
de uma stored procedure e a linguagem utilizada em sua
codificação dependem do SGBD utilizado

**USP_<sistema>_<texto significativo>_<operação>**

A operação executada pode ser:

```
UPD - procedimentos de UPDATE
INS - procedimentos de INSERT
DEL - procedimentos de DELETE
IUD - procedimentos INSERT, UPDATE e DELETE.
IU - combinação que indica os eventos de "Insert" e "Update"
ID - combinação que indica os eventos de "Insert" e "Delete"
DU - combinação que indica os eventos de "Delete" e "Update"
```

OBS: Quando for uma Stored Procedure somente de consulta,
colocar como padrão

**USP_<sistema>_<texto significativo>**

Não utilizar nada na parte de operação

Ex.: USP_TC00_LIBERA_RECURSO_IU

## 3.4.13.4 Package (SGBD Oracle)

São definições de dados e stored procedures armazenadas
dentro do próprio banco de dados ORACLE

**PCK_<sistema>_<texto significativo>**

Ex.: PCK_TC00_CONTROLE_ACESSO

## 3.4.13.5 Synonyms

O nome do sinônimo é o nome do objeto ao qual ele faz
referência
